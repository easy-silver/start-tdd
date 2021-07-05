package chap02;

import static chap02.PasswordStrength.*;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String s) {
        if(s == null || s.isEmpty()) return INVALID;

        int metCounts = 0;

        if(s.length() >= 8) metCounts++;
        if(meetContainingNumberCriteria(s)) metCounts++;
        if(meetsContainingUppercaseCriteria(s)) metCounts++;

        if(metCounts <= 1) return WEAK;
        if(metCounts == 2) return NORMAL;

        return STRONG;
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
