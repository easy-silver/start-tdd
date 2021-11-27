package start.tdd.practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * LocalDateUtils 클래스의
 * isIncludeInDays 메서드 검증 테스트 클래스
 */
public class LocalDateUtilsIsIncludeInDaysTest {

    @DisplayName("입력 요일이 타겟 요일 안에 포함되어 있음")
    @Test
    void isIncluded () {
        //given
        String targetDays = "토,일";

        DayOfWeek dayOfNow = LocalDate.now().getDayOfWeek();
        DayOfWeek dayOfTomorrow = LocalDate.now().plusDays(1).getDayOfWeek();

        //when
        boolean resultOfToday = LocalDateUtils.isIncludedInDays(dayOfNow, targetDays);
        boolean resultOfTomorrow = LocalDateUtils.isIncludedInDays(dayOfTomorrow, targetDays);

        //then
        assertTrue(resultOfToday);
        assertTrue(resultOfTomorrow);
    }

    @DisplayName("입력 요일이 타겟 요일 안에 포함되어 있지 않음")
    @Test
    void isNotIncluded() {
        //given
        String targetDays = "월,수,금";

        DayOfWeek dayOfToday = LocalDate.now().getDayOfWeek();

        //when
        boolean resultOfToday = LocalDateUtils.isIncludedInDays(dayOfToday, targetDays);

        //then
        assertFalse(resultOfToday);
    }

    @DisplayName("입력 요일이 Null인 경우")
    @Test
    void dayIsNull() {
        //given
        String stringOfDays = "월,화,수,목,금,토,일";
        DayOfWeek dayNull = null;

        //when
        boolean resultOfNull = LocalDateUtils.isIncludedInDays(dayNull, stringOfDays);

        //then
        assertFalse(resultOfNull);
    }

    @DisplayName("기준 요일 문자열이 Null인 경우")
    @Test
    void daysIsNull() {
        //given
        String stringOfDays = null;
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        
        //when
        boolean resultOfTargetNull = LocalDateUtils.isIncludedInDays(dayOfWeek, stringOfDays);

        //then
        assertFalse(resultOfTargetNull);
    }

    @DisplayName("오늘이 기준 요일 문자열에 포함")
    @Test
    void todayIsIncluded() {
        //given
        String stringOfDays = "월,화,수,목,금,토,일";

        //when
        boolean result = LocalDateUtils.isTodayIncludedInDays(stringOfDays);

        //then
        assertTrue(result);
    }

    @DisplayName("오늘이 기준 요일 문자열에 미포함")
    @Test
    void todayIsNotIncluded() {
        //given
        String stringOfDays = "월,화,수,목,금";

        //when
        boolean result = LocalDateUtils.isTodayIncludedInDays(stringOfDays);

        //then
        assertFalse(result);
    }

    @DisplayName("기준 요일 문자열이 Null인 경우")
    @Test
    void daysIsNullWhenCheckToday() {
        //given
        String stringOfDays = null;

        //when
        boolean resultOfTargetNull = LocalDateUtils.isTodayIncludedInDays(stringOfDays);

        //then
        assertFalse(resultOfTargetNull);
    }
}
