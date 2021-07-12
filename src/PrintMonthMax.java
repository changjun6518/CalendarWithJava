import java.util.Scanner;


public class PrintMonthMax {
    public static final int[] MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31, 30};

    public static int cal(int m) {
        return MONTH[m - 1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int checkContinue = 0;
        while (true) {
            System.out.println("달을 입력하시오");
            int m = sc.nextInt();
            if (m == -1) {
                break;
            }
            if (m > 12) {
                continue;
            }
            System.out.printf("%d월은 %d까지 있습니다", m, cal(m));
        }

        System.out.println("행복 코딩하세요!");
    }
}
