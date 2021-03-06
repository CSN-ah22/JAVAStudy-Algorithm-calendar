import java.text.ParseException;
import java.util.Calendar;
import java.util.Scanner;

public class PROMPT {
        public void printMenu() {
            System.out.println("+---------------+");
            System.out.println("1.일정등록");
            System.out.println("2.일정검색");
            System.out.println("3.달력보기");
            System.out.println("h.도움말 q.종료");
            System.out.println("+---------------+");
        }
//     week 요일명
//     return 0 ~ 6 (0 =Sunday, 6 = Saturday)
/*    public int parseDay(String week) {
        if      (week.equals ("su")) { return 0; }
        else if (week.equals ("mo")) { return 1; }
        else if (week.equals ("tu")) { return 2; }
        else if (week.equals ("wd")) { return 3; }
        else if (week.equals ("th")) { return 4; }
        else if (week.equals ("fr")) { return 5; }
        else if (week.equals ("sa")) { return 6; }
            return 0;
    }*/

    public void runPrompt() throws ParseException {
        printMenu();

        Scanner scanner = new Scanner(System.in);
        calendarPractice cal = new calendarPractice();

        boolean isLoop = true;
        while (isLoop) {
            System.out.println("명령 ( 1, 2, 3, h, q)");
            String cmd = scanner.next();
            switch (cmd) {
                case "1":
                    cmdRegister(scanner,cal);
                    break;
                case "2":
                    cmdSearch(scanner,cal);
                    break;
                case "3":
                    cmdCal(scanner, cal);
                    break;
                case "h":
                    printMenu();
                    break;
                case "q":
                    isLoop = false;
                    break;
            }

        }

        System.out.println("Thank you, Bye~");
        scanner.close();
    }

    private void cmdCal(Scanner s, calendarPractice c) {

        int month;
        int year;

        while (true) {
            System.out.println("년도를 입력하세요");
            System.out.print("YEAR>");
            year = s.nextInt();
            if( year == -1)
                break;

            System.out.println("달을 입력하세요");
            System.out.print("MONTH>");
            month = s.nextInt();


            if (month > 12 || month < -1) {
                System.out.println("잘못된 입력값입니다.");
            }
            c.prints(year, month);


        }
    }

    private void cmdSearch(Scanner s, calendarPractice c) {
        System.out.println("[일정 검색]");
        System.out.println("[ 날짜를 입력해주세요 ( yyyy-MM--dd ).]");
        String date = s.next();
        String plan = "";
        try {
            plan = c.searchPlan(date);
        } catch (ParseException e) {
            e.printStackTrace();
            System.err.println("일정 검색중 오류가 발생했습니다");
        }
        System.out.println(plan);
    }

    private void cmdRegister(Scanner s, calendarPractice c) throws ParseException {
        System.out.println("[ 새 일정 등록 ]");
        System.out.println("[ 날짜를 입력해주세요 ( yyyy-MM--dd ).]");
        String date = s.next();
        String text = " ";
        System.out.println("일정을 입력해 주세요.(문장의 끝에 ;을 입력해 주세요.");
        while (true) {
            String word = s.next();
            text   = text + word;
            if (word.endsWith(";")) {
                break;
            }
        }
        c.registerPlan(date,text);
    }

    public static void main(String[] args) throws ParseException {
        PROMPT p = new PROMPT();
        p.runPrompt();
    }
}

