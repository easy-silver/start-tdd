package practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class LocalDateUtilsTest {

    @DisplayName("입력 요일이 타겟 요일 배열에 포함되어 있음")
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
        Assertions.assertTrue(resultOfToday);
        Assertions.assertTrue(resultOfTomorrow);
    }

    @DisplayName("입력 요일이 타겟 요일 배열에 포함되어 있지 않음")
    @Test
    void isNotIncludeDay() {
        //given
        String targetDays = "월,수,금";

        DayOfWeek dayOfToday = LocalDate.now().getDayOfWeek();

        //when
        boolean resultOfToday = LocalDateUtils.isIncludeInDays(dayOfToday, targetDays);

        //then
        Assertions.assertFalse(resultOfToday);
    }

}
