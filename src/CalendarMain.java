import java.util.Scanner;


public class CalendarMain {
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

    public static void print(int year, int month) {
//        int d = dayStringToInt(day);
        int d = getWeekDay(year, month);
        System.out.println("d = " + d);
        System.out.println("  << "+year + "년\t"+month+"월 >>");
        System.out.println(" SU MO TU WD TH FR SA");
        System.out.println("-----------------------");
        for (int i = 0; i < d; i++) {
            System.out.printf("   ");
        }
        for (int i = 1; i <= cal(year,month); i++) {
            System.out.printf("%3d", i);
            if ((i +d) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
    public static void inputData(Scanner sc) {
        while (true) {
            System.out.println("년과 달을 입력하시오");
            System.out.print("YEAR > ");
            int y = Integer.parseInt(sc.next());
            System.out.print("MONTH > ");
            int m = Integer.parseInt(sc.next());
//            System.out.print("WEEKDAY > ");
//            String d = sc.next();
            if (y == -1 || m == -1) {
                break;
            }
            if (m > 12) {
                continue;
            }
//            System.out.printf("%d월은 %d까지 있습니다", m, cal(m));
            print(y, m);
        }
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        inputData(sc);
        System.out.println("행복 코딩하세요!");
    }
}
