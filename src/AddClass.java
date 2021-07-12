import java.util.Scanner;

public class AddClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("두 수를 입력하시오!");
        String[] str = sc.nextLine().split(" ");
        Integer a = Integer.parseInt(str[0]);
        Integer b = Integer.parseInt(str[1]);
        System.out.println("두 수의 합은 " + (a+b)+ "입니다");
    }
}
