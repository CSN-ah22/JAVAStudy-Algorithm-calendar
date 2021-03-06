import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Arrays;
import java.util.Scanner;

public class Calendar {
    public static void main(String[] args) {
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        Scanner scanner = new Scanner(System.in);
        System.out.println("1.년도를 넣어주세요\n 2.달을 넣어주세요\n3.첫번째 요일을 입력하세요(SUN,MON,TUE,WEN,THU,FRI,SAT)\n4.0이하의 숫자를 넣으면 종료됩니다:");

        int year = 2016;
        int month = 1;
        String fday;
        int week = 0;
        int i = 0;
        int count;

        while (true) {
            System.out.print("year>");
            year = scanner.nextInt();
            System.out.print("month>");
            month = scanner.nextInt();
            System.out.print("fday>");
            fday = scanner.next();
            week=week(fday);

            if (month > -1 || year > -1 || week > -1) {  //0이하를 넣으면 종료될 수 있게 비교문을 넣었다

                System.out.println(" 일 월 화 수 목 금 토");
                System.out.println("-------------------");

                for (i=0; i<week; ++i) {
                    System.out.print("   ");
                }

                count = 7-week;

                for (i=1; i<=count; i++){
                    System.out.print(i + "  ");
                }
                System.out.println(" ");//첫 줄 엔터 용도


                int enter;
                enter = count+7;

                for (int j = count+1; j <= days[month]; j++) {

                    boolean OX = LeepyearOX(year,days);

                    if ((j % enter) == 0) {
                        if (OX==false && month == 2 && j == 28) {
                            System.out.print(j + "");
                        } else {
                            System.out.println(j + "");
                        } enter = enter+7;

                    } else if (j >= 10) { /*10부터 관리 영역*/
                        System.out.print(j + " ");
                    }

                    else { /*일의자리 영역*/
                        System.out.print(j + "  ");
                    }

                    if (j == days[month]) {
                        System.out.println(" ");
                    }

                }//for문 끝

            } else { //while문 탈출
                System.out.println("종료~!");
                break;
            }

        } //while문 끝

    }//메서드 끝

    public static int week(String fday){
        if (fday.equals("SUN")) return 0;
        else if (fday.equals("MON")) return 1;
        else if (fday.equals("TUE")) return 2;
        else if (fday.equals("WEN")) return 3;
        else if (fday.equals("THU")) return 4;
        else if (fday.equals("FRI")) return 5;
        else if (fday.equals("SAT")) return 6;
        else return 0;
    }

    public  static boolean LeepyearOX(int year, int[] days){
        /*윤년이면 29일 사용 아니면 28일 사용*/
        if ((year % 4) == 0 || (year % 400) == 0 && (year % 100) == 0) {
            days[2] = 29;
            return true;
        } else {
            days[2] = 28;
            return false;
        }
    }

}