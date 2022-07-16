package service;

import common.InputView;
import common.ResultView;
import domain.*;

public class LottoService {
    public void lottoStart() {
        Lottos lottos = Lottos.lottoGenerate(InputView.LottosOrder());
        ResultView.lottoNumberPrint(lottos);
        Lotto winningNumber = Lotto.winningNumberGenerate(InputView.inputWinningNumber());
        LottoNumber bonusNumber = InputView.inputBonusNumber();
        LottoResults lottoResults = lottos.lottoNumberMatch(winningNumber, bonusNumber);
        ResultView.printLottoResult(lottoResults);
    }
}








