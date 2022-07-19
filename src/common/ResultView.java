package common;

import domain.LottoResult;
import domain.LottoResults;
import domain.Lottos;


public class ResultView {

    private ResultView() {
    }

    private static final String WINNINNG_STATISTICS_MESSAGE = "당첨 통계.\n---------";
    private static final String STATISTICS_STATUS = "%d개 일치 (%d원)- %d개";
    private static final String BUY_LOTTO_COUNT = " 개를 구매했습니다.\n";
    private static final String TOTAL_YEILD= "총 수익률은 %.2f 입니다";


    public static void resultMessage(Object message) {
        System.out.println(message);
    }

    public static void lottoNumberPrint(Lottos lottos) {
        resultMessage(lottos.getLottoCount() + BUY_LOTTO_COUNT);
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

    public static void printYield(int lottoCount, LottoResults lottoResults) {
        System.out.printf((TOTAL_YEILD) + "%n", (double)lottoResults.getTotalMoney() / (lottoCount*1000));
    }
}
