package practice;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class LocalDateUtils {

    /**
     * 요일이 연결된 문자열과
     * 확인하고 싶은 특정 요일이 일치하는지 확인
     *
     * @param dayOfWeek 확인하고 싶은 요일
     * @param targetDays 기준 요일들(ex. "월,수,금")
     * @return
     */
    public static boolean isIncludeInDays(DayOfWeek dayOfWeek, String targetDays) {
        if (dayOfWeek == null || targetDays == null) {
            return false;
        }

        String dayOfWeekDisplayName = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.KOREA);

        List<String> listOfTargetDays = Arrays.asList(targetDays.split(","));

        return listOfTargetDays.contains(dayOfWeekDisplayName);
    }

}
