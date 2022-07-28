package common;

import domain.LottoResult;
import domain.LottoResults;
import domain.Lottos;

public class ResultView {

    private ResultView() {
    }

    private static final String WINNINNG_STATISTICS_MESSAGE = "당첨 통계.\n---------";
    private static final String STATISTICS_STATUS = "%d개 일치 (%d원)- %d개";
    private static final String TOTAL_YEILD= "총 수익률은 %.2f 입니다";
    private static final String BUY_LOTTO_COUNT = "수동으로 %d장, 자동으로 %d장을 구매했습니다.\n";


    public static void resultMessage(Object message) {
        System.out.println(message);
    }

    public static void lottoNumberPrint(Lottos lottos, int manualLottoCount) {
        System.out.printf(BUY_LOTTO_COUNT, manualLottoCount, lottos.getLottoCount() - manualLottoCount);
        lottos.stream()
                .forEach(System.out::println);
    }
    public static void printLottoResult(LottoResults prizes) {
        resultMessage(WINNINNG_STATISTICS_MESSAGE);
        resultMessage(printLottoPrizes(prizes));
    }

    private static String printLottoPrizes(LottoResults prizes) {
        StringBuilder sb = new StringBuilder();
        for (LottoResult value : prizes.getLottoResults()) {
            sb.append(String.format(STATISTICS_STATUS, value.getMatchCount(), value.getMoney(), value.getWinCount()));
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void printYield(double yield) {
        System.out.printf((TOTAL_YEILD) + "%n", yield);
    }
}
