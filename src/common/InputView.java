package common;

import domain.Lotto;
import domain.LottoNumber;
import factory.LottoFactory;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    private InputView() {
    }

    public static int LottosOrder() {
        System.out.println("구입 금액을 입력해주세요.");
        return sc.nextInt();
    }

    public static String inputWinningNumber() {
        sc.nextLine();
        System.out.println("지난주 당첨번호를 입력해주세요.");
        return sc.nextLine();
    }

    public static LottoNumber inputBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");
        return new LottoNumber(sc.nextInt());
    }

    public static int inputManualCount() {
        System.out.println("수동으로 구입할 로또의 갯수를 입력하세요.");
        return sc.nextInt();
    }

    public static List<Lotto> inputManualNumber(int manualCount) {
        System.out.println("수동으로 구매할 로또 번호를 입력해주세요.");
        sc.nextLine();
        return Stream.generate(InputView::inputLottoNo)
                .limit(manualCount)
                .collect(toList());
    }

    private static Lotto inputLottoNo() {
        return LottoFactory.manualGenerateLotto(sc.nextLine());
    }


}
