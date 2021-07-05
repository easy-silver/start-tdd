package chap02;

import org.junit.jupiter.api.Test;

import static chap02.PasswordStrength.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 암호 검사기 테스트
 *
 * - 길이가 8글자 이상
 * - 0부터 9 사이의 숫자를 포함
 * - 대문자 포함
 *
 * 1. 세 규칙을 모두 충족하면 강함
 * 2. 2개의 규칙을 충족하면 보통
 * 3. 1개 이하의 규칙을 충족하면 약함
 */
class PasswordStrengthMeterTest {

    private PasswordStrengthMeter meter = new PasswordStrengthMeter();

    private void assertStrength(String password, PasswordStrength expStr) {
        PasswordStrength result = meter.meter(password);
        assertEquals(expStr, result);
    }

    /**
     * 모든 규칙을 충족하는 경우
     * -> 강함
     */
    @Test
    void meetsAllCriteria_Then_Strong() {
        assertStrength("ab12!@AB", STRONG);
        assertStrength("abc1!Add", STRONG);
    }

    /**
     * 길이만 8글자 미만이고, 나머지 조건은 충족하는 경우
     * -> 보통
     */
    @Test
    void meetsOtherCriteria_except_for_Length_Then_Normal() {
        assertStrength("ab12!@A", NORMAL);
        assertStrength("Ab12!c", NORMAL);
    }

    /**
     * 숫자를 포함하지 않고, 나머지 조건은 충족하는 경우
     * -> 보통
     */
    @Test
    void meetsOtherCriteria_except_for_number_Then_Normal() {
        assertStrength("ab!@ABqwer", NORMAL);
    }

    /**
     * 값이 없는 경우
     * -> INVALID 리턴
     */
    @Test
    void nullInput_Then_Invalid() {
        assertStrength(null, INVALID);
        assertStrength("", INVALID);
    }

    /**
     * 대문자를 포함하지 않고, 나머지 조건은 충족하는 경우
     * -> 보통
     */
    @Test
    void meetsOtherCriteria_except_for_Uppercase_Then_Normal() {
        assertStrength("ab12!@df", NORMAL);
    }

    /**
     * 길이가 8글자 이상인 조건만 충족하는 경우
     * -> 약함
     */
    @Test
    void meetsOnlyLengthCriteria_Then_Weak() {
        assertStrength("adbefghi", WEAK);
    }

    /**
     * 숫자 포함 조건만 충족하는 경우
     * -> 약함
     */
    @Test
    void meetsOnlyNumCriteria_Then_Weak() {
        assertStrength("12345", WEAK);
    }

    /**
     * 대문자 포함 조건만 충족하는 경우
     * -> 약함
     */
    @Test
    void meetsOnlyUpperCriteria_Then_Weak() {
        assertStrength("ABZEF", WEAK);
    }

}