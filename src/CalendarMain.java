import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;


public class CalendarMain {
    public static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static final int[] LEAF_MAX_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static final int STAND_YEAR = 2004;
    public static final String STAND_DAY = "목";
    public static HashMap<String, ArrayList<String >> map = new HashMap<>();

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
        System.out.println("   << "+year + "년  "+month+"월 >>");
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

    public static void registerTodo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("[일정 등록] 날짜를 입력하시오. ex)2021-07-13");
        System.out.print("> ");
        String date = sc.next();
        sc.nextLine();

        System.out.println("일정을 입력하세요.");
        System.out.print("> ");
        String schedule = sc.nextLine();

        ArrayList<String> scheduleList = new ArrayList<>();
        scheduleList.add(schedule);
        if (map.containsKey(date)) {
            ArrayList<String> tempList = map.get(date);
            tempList.add(schedule);
            map.put(date, tempList);
        } else {
            map.put(date, scheduleList);
        }


        System.out.println("일정이 등록되었습니다");
        return;
    }
    public static void showTodo() {
        Scanner sc = new Scanner(System.in);
//        [일정 검색] 날짜를 입력하세요.
//> 2016-06-05
//1개의 일정이 있습니다.
//1. 자바지기에게 밥 얻어먹기
        System.out.println("[일정 검색] 날짜를 입력하세요.");
        System.out.print("> ");
        String date = sc.next();
        if (map.containsKey(date)) {
            ArrayList<String> tempList = map.get(date);
            System.out.printf("%d개의 일정이 있습니다.\n", tempList.size());
            int i = 1;
            for (String s : tempList) {
                System.out.printf("%d. %s\n", i, s);
                i++;
            }
        }
    }

    public static void showCalendar() {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String date = simpleDateFormat.format(new Date());
        System.out.println(date);
        String[] dateArr = date.split("-");
        int[] dateArrInt = new int[dateArr.length];

        for (int i = 0; i < dateArr.length; i++) {
            dateArrInt[i] = Integer.parseInt(dateArr[i]);
        }
        print(dateArrInt[0], dateArrInt[1]);

    }
    public static void manager(char c) {
        switch (c) {
            case '1':
                registerTodo();
                break;
            case '2':
                showTodo();
                break;
            case '3':
                showCalendar();
                break;
            default:
                return;
        }
    }

    public static void start(Scanner sc) {
        while (true) {
            System.out.println("+----------------------+\n" +
                    "| 1. 일정 등록           \n" +
                    "| 2. 일정 검색           \n" +
                    "| 3. 달력 보기\n" +
                    "| h. 도움말 q. 종료\n" +
                    "+----------------------+\n" +
                    "명령 (1, 2, 3, h, q)");
            System.out.print("> ");
            char userInput = sc.next().charAt(0);

            if (userInput == 'q') {
                return;
            }
            manager(userInput);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        start(sc);
        System.out.println("행복 코딩하세요!");
    }
}
