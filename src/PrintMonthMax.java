import java.util.Scanner;


public class PrintMonthMax {
    public static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31, 30};
    public static final int[] LEAF_MAX_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31, 30};

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

    public static void print(int year, int month) {

        System.out.println("  << "+year + "년\t"+month+"월 >>");
        System.out.println(" 일 월 화 수 목 금 토");
        System.out.println("--------------------");
        for (int i = 1; i <= cal(year,month); i++) {
            System.out.printf("%3d", i);
            if (i % 7 == 0) {
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
