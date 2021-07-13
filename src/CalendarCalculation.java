public class CalendarCalculation {
    public static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static final int[] LEAF_MAX_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static final int STAND_YEAR = 2004;
    public static final String STAND_DAY = "목";

    public static int cal(int y, int m) {
        if (leafCal(y)) {
            return LEAF_MAX_DAYS[m - 1];
        } else {
            return MAX_DAYS[m - 1];
        }
    }

    public static boolean leafCal(int year) {
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    public static int getWeekDay(int year, int month) {
        int yearSum = 0;
        int monthSum = 0;
        if (year < STAND_YEAR) {
            for (int i = year; i < STAND_YEAR; i++) {
                if (leafCal(i)) {
                    yearSum -= 2;
                } else yearSum -= 1;
            }
            for (int i = 11; i > month; i--) {
                if (leafCal(year)) {
                    monthSum -= LEAF_MAX_DAYS[i];
                } else monthSum -= MAX_DAYS[i];
            }

        } else {
            for (int i = STAND_YEAR; i < year; i++) {
                if (leafCal(i)) {
                    yearSum += 2;
                } else yearSum += 1;
            }
            for (int i = 0; i < month-1; i++) {
                if (leafCal(year)) {
                    monthSum += LEAF_MAX_DAYS[i];
                } else monthSum += MAX_DAYS[i];
            }
        }
        return Math.abs(yearSum + monthSum + dayStringToInt(STAND_DAY)) % 7;

    }

    public static int dayStringToInt(String day) {
        switch (day) {
            case "일":
                return 0;
            case "월":
                return 1;
            case "화":
                return 2;
            case "수":
                return 3;
            case "목":
                return 4;
            case "금":
                return 5;
            case "토":
                return 6;
            default:
                return 0;
        }
    }
}
