package bookapp;

import bookapp.constant.SystemCode;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        final BookManager bookManager = BookManager.getInstance();
        Scanner scanner = new Scanner(System.in);

        boolean run = true;
        int orderNo;
        while (run) {
            System.out.println("------------------------------------------------------------------------");
            System.out.println();
            System.out.println("1.도서등록 | 2.도서삭제 | 3.도서대여 | 4.도서반납 | 5.도서검색 | 6. 대여이력 | 7.종료");
            System.out.println();
            System.out.println("------------------------------------------------------------------------");
            System.out.print("선택> ");

            try {
                 orderNo = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("숫자가 아닌 다른 값을 입력하셨습니다. 다시 입력해주세요.");
                scanner = new Scanner(System.in);
                continue;
            }
            switch (orderNo) {
                case SystemCode.REGISTER:
                    bookManager.register();
                    break;
                case SystemCode.REMOVE:
                    bookManager.remove();
                    break;
                case SystemCode.RENTAL:
                    bookManager.rental();
                    break;
                case SystemCode.RETURN:
                    bookManager._return();
                    break;
                case SystemCode.LIST:
                    bookManager.search();
                    break;
                case SystemCode.LOG:
                    bookManager.printRentalLog();
                    break;
                case SystemCode.EXIT:
                    run = false;
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                    Thread.sleep(1000);
                    break;
            }
        }
        System.out.println("프로그램 종료");
    }

}
