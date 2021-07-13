import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Prompt {
    public static void registerTodo(HashMap<String ,ArrayList<String>> map) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("[일정 등록] 날짜를 입력하시오. ex)2021-07-13");
        System.out.print("> ");
        String date = sc.next();
        sc.nextLine();

        FileWriter fw = new FileWriter("C:\\Users\\ChangJun.Choi\\Desktop\\자바\\Calendar\\일정저장소\\" + date + ".txt", true);

        System.out.println("일정을 입력하세요.");
        System.out.print("> ");
        String schedule = sc.nextLine();

        fw.write(schedule+"\n");
        fw.close();

        System.out.println("일정이 등록되었습니다");
        return;
    }

    public static void showTodo(HashMap<String ,ArrayList<String>> map) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("[일정 검색] 날짜를 입력하세요.");
        System.out.print("> ");
        String date = sc.next();

        FileReader fr = new FileReader("C:\\Users\\ChangJun.Choi\\Desktop\\자바\\Calendar\\일정저장소\\" + date + ".txt");
        BufferedReader br = new BufferedReader(fr);
        int i = 1;
        while (true) {
            String str = br.readLine();
            if (str == null) break;
            System.out.println(i + ". " + str);
            i++;
        }
        br.close();
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
