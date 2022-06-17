package common;

import java.util.Scanner;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);
    private InputView() {
    }
    public static int BuyLottoTicketCount() {
        System.out.println("구입 금액을 입력해주세요.");
        return sc.nextInt();
    }

    public static String inputWinningNumber() {
        sc.nextLine();
        System.out.println("지난주 당첨번호를 입력해주세요.");
        return sc.nextLine();
    }
}
