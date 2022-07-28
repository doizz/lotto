package service;

import common.InputView;
import common.ResultView;
import domain.*;

import java.util.List;

public class LottoService {
    public void lottoStart() {
        int payment = InputView.LottosOrder();
        int manualCount = InputView.inputManualCount();
        List<Lotto> manualLottoNumbers = InputView.inputManualNumber(manualCount);
        Lottos lottos = Lottos.lottoGenerate(payment, manualLottoNumbers);
        ResultView.lottoNumberPrint(lottos, manualCount);
        Lotto winningNumber = Lotto.winningNumberGenerate(InputView.inputWinningNumber());
        LottoNumber bonusNumber = InputView.inputBonusNumber();
        LottoResults lottoResults = lottos.lottoNumberMatch(winningNumber, bonusNumber);
        ResultView.printLottoResult(lottoResults);
        ResultView.printYield(lottoResults.getTotalYield(lottos.getLottoCount()));
//        ResultView.printYield(lottos.getLottoCount(), lottoResults);
    }
}








