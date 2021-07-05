package chap02;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String s) {
        if(s == null) return PasswordStrength.INVALID;
        if (s.length() < 8) {
            return PasswordStrength.NORMAL;
        }

        boolean containsNum = meetContainingNumberCriteria(s);
        if(!containsNum) return PasswordStrength.NORMAL;

        return PasswordStrength.STRONG;
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

}
