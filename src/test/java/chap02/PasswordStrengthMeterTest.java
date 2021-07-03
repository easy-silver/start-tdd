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

    /**
     * 모든 규칙을 충족하는 경우
     * -> 강함
     */
    @Test
    void meetsAllCriteria_Then_Strong() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab12!@AB");
        assertEquals(STRONG, result);

        PasswordStrength result2 = meter.meter("abc1!Add");
        assertEquals(STRONG, result2);
    }

    /**
     * 길이만 8글자 미만이고, 나머지 조건은 충족하는 경우
     * -> 보통
     */
    @Test
    void meetsOtherCriteria_except_for_Length_Then_Normal() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab12!@A");
        assertEquals(NORMAL, result);

        PasswordStrength result2 = meter.meter("Ab12!c");
        assertEquals(NORMAL, result2);
    }

}