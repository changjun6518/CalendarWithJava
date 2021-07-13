import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Prompt {
    public static void registerTodo(HashMap<String ,ArrayList<String>> map) {
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

    public static void showTodo(HashMap<String ,ArrayList<String>> map) {
        Scanner sc = new Scanner(System.in);
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

    public static void print(int year, int month) {
//        int d = dayStringToInt(day);
        int d = CalendarCalculation.getWeekDay(year, month);
        System.out.println("   << "+year + "년  "+month+"월 >>");
        System.out.println(" SU MO TU WD TH FR SA");
        System.out.println("-----------------------");
        for (int i = 0; i < d; i++) {
            System.out.printf("   ");
        }
        for (int i = 1; i <= CalendarCalculation.cal(year,month); i++) {
            System.out.printf("%3d", i);
            if ((i +d) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }


}
