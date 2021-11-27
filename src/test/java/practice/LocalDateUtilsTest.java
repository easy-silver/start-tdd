package practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LocalDateUtilsTest {

    @DisplayName("입력 요일이 타겟 요일 안에 포함되어 있음")
    @Test
    void isIncludeDay () {
        //given
        String targetDays = "토,일";

        DayOfWeek dayOfNow = LocalDate.now().getDayOfWeek();
        DayOfWeek dayOfTomorrow = LocalDate.now().plusDays(1).getDayOfWeek();

        //when
        boolean resultOfToday = LocalDateUtils.isIncludeInDays(dayOfNow, targetDays);
        boolean resultOfTomorrow = LocalDateUtils.isIncludeInDays(dayOfTomorrow, targetDays);

        //then
        assertTrue(resultOfToday);
        assertTrue(resultOfTomorrow);
    }

    @DisplayName("입력 요일이 타겟 요일 안에 포함되어 있지 않음")
    @Test
    void isNotIncludeDay() {
        //given
        String targetDays = "월,수,금";

        DayOfWeek dayOfToday = LocalDate.now().getDayOfWeek();

        //when
        boolean resultOfToday = LocalDateUtils.isIncludeInDays(dayOfToday, targetDays);

        //then
        assertFalse(resultOfToday);
    }

    @DisplayName("입력 요일이 Null인 경우")
    @Test
    void dayIsNull() {
        //given
        String targetDays = "월,화,수,목,금,토,일";
        DayOfWeek dayNull = null;

        //when
        boolean resultOfNull = LocalDateUtils.isIncludeInDays(dayNull, targetDays);

        //then
        assertFalse(resultOfNull);
    }

}
