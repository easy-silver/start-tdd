package chap02;

import static chap02.PasswordStrength.*;

/**
 * 암호 강도 검사 클래스
 */
public class PasswordStrengthMeter {

    /**
     * 입력 받은 암호의 보안 강도를 반환한다.
     *
     * @param password
     * @return
     */
    public PasswordStrength meter(String password) {
        if(password == null || password.isEmpty()) return INVALID;

        int metCounts = getMetCriteriaCounts(password);
        if(metCounts <= 1) return WEAK;
        if(metCounts == 2) return NORMAL;

        return STRONG;
    }

    /* 조건을 만족하는 횟수 확인 */
    private int getMetCriteriaCounts(String password) {
        int metCounts = 0;

        if(password.length() >= 8) metCounts++;
        if(meetContainingNumberCriteria(password)) metCounts++;
        if(meetsContainingUppercaseCriteria(password)) metCounts++;

        return metCounts;
    }

    /* 숫자 포함 여부 확인 */
    private boolean meetContainingNumberCriteria(String s) {
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                return true;
            }
        }
        return false;
    }

    /* 대문자 포함 여부 확인 */
    private boolean meetsContainingUppercaseCriteria(String s) {
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }

}
