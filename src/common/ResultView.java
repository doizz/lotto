package common;

import domain.LottoResult;
import domain.LottoResults;
import domain.Lottos;


public class ResultView {

    private ResultView() {}
    private static final String BUYING_FORMAT = "%d개를 구매했습니다.\n%s\n\n";
    private static final String WINNINNG_STATISTICS_MESSAGE = "당첨 통계.\n---------";
    private static final String STATISTICS_STATUS= "%d개 일치 (%d원)- %d개";
    private static final String TOTAL_REVENUS= "총 수익률은 %.2f 입니다";

    public static void resultMessage(Object message){System.out.print(message);}

    public static void lottoNumberPrint(Lottos lottos) {
        resultMessage(lottos.getLottoCount() +" 개를 구매했습니다.\n");
        lottos.stream()
              .forEach(System.out::println);
    }
    public static void printLottoResult(LottoResults prizes) {
        System.out.println(WINNINNG_STATISTICS_MESSAGE);
        System.out.println(printLottoPrizes(prizes));
    }
    private static String printLottoPrizes(LottoResults prizes) {
        StringBuilder sb = new StringBuilder();

        for (LottoResult value : prizes.getLottoResults()) {
            sb.append(String.format(STATISTICS_STATUS, value.getMatchCount(), value.getMoney(), 1));
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void printProfit(int purchaseAmount, LottoResults prizes) {
        System.out.printf((TOTAL_REVENUS) + "%n", (double)10/ purchaseAmount);
    }
}
