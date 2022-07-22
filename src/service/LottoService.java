package service;

import common.InputView;
import common.ResultView;
import domain.*;

import java.util.List;

public class LottoService {
    public void lottoStart() {
        Lottos lottos = Lottos.lottoGenerate(InputView.LottosOrder());
        int manualCount = InputView.inputManualCount();
        List<Lotto> manualLottoNumbers = InputView.inputManualNumber(manualCount);

        ResultView.lottoNumberPrint(lottos);
        Lotto winningNumber = Lotto.winningNumberGenerate(InputView.inputWinningNumber());
        LottoNumber bonusNumber = InputView.inputBonusNumber();
        LottoResults lottoResults = lottos.lottoNumberMatch(winningNumber, bonusNumber);
        ResultView.printLottoResult(lottoResults);
        ResultView.printYield(lottos.getLottoCount(), lottoResults);
    }
}








