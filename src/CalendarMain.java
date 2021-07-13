import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;


public class CalendarMain {

    public static HashMap<String, ArrayList<String >> map = new HashMap<>();

    public static void manager(char c) {
        switch (c) {
            case '1':
                Prompt.registerTodo(map);
                break;
            case '2':
                Prompt.showTodo(map);
                break;
            case '3':
                Prompt.showCalendar();
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
            } else if (userInput == 'h') {
                continue;
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
