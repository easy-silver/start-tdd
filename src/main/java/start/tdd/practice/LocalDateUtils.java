package start.tdd.practice;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class LocalDateUtils {

    /**
     * '오늘'이 요일이 연결된 문자열에 포함되는 요일인지 확인
     *
     * @param targetDays 기준 요일들(ex. "토,일")
     * @return
     */
    public static boolean isTodayIncludedInDays(String targetDays) {
        DayOfWeek dayOfToday = LocalDate.now().getDayOfWeek();

        return isIncludedInDays(dayOfToday, targetDays);
    }

    /**
     * 요일이 연결된 문자열과
     * 확인하고 싶은 특정 요일이 일치하는지 확인
     *
     * @param dayOfWeek 확인하고 싶은 요일
     * @param targetDays 기준 요일들(ex. "월,수,금")
     * @return
     */
    public static boolean isIncludedInDays(DayOfWeek dayOfWeek, String targetDays) {
        if (dayOfWeek == null || targetDays == null) {
            return false;
        }

        String dayOfWeekDisplayName = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.KOREA);

        List<String> listOfTargetDays = Arrays.asList(targetDays.split(","));

        return listOfTargetDays.contains(dayOfWeekDisplayName);
    }
}
