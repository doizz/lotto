package service;

import common.InputView;
import common.ResultView;
import domain.*;

public class LottoService {

    public void lottoStart() {
        Lottos lottos = Lottos.lottoGenerate(InputView.LottosOrder());
        ResultView.lottoNumberPrint(lottos);
        Lotto winningNumber = Lotto.winningNumberGenerate(InputView.inputWinningNumber());
        LottoResults lottoResults = lottos.lottoNumberMatch(winningNumber);
        ResultView.printLottoResult(lottoResults);
    }
}
