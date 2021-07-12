public class CalendarMain {
    public static void print(int max) {
        if (max == 28) {
            System.out.println(" 일 월 화 수 목 금 토");
            System.out.println("--------------------");
            System.out.println(" 1  2  3  4  5  6  7");
            System.out.println(" 8  9 10 11 12 13 14");
            System.out.println(" 5 16 17 18 19 20 21");
            System.out.println("22 23 24 25 26 27 28");
        } else if (max == 30) {
            System.out.println(" 일 월 화 수 목 금 토");
            System.out.println("--------------------");
            System.out.println(" 1  2  3  4  5  6  7");
            System.out.println(" 8  9 10 11 12 13 14");
            System.out.println(" 5 16 17 18 19 20 21");
            System.out.println("22 23 24 25 26 27 28");
            System.out.println("29 30");
        } else {
            System.out.println(" 일 월 화 수 목 금 토");
            System.out.println("--------------------");
            System.out.println(" 1  2  3  4  5  6  7");
            System.out.println(" 8  9 10 11 12 13 14");
            System.out.println(" 5 16 17 18 19 20 21");
            System.out.println("22 23 24 25 26 27 28");
            System.out.println("29 30 31");
        }
    }
}
