package service;

import common.InputView;
import common.ResultView;
import domain.*;

public class LottoService {

    public void lottoStart() {
        Lottos lottos = Lottos.lottoGenerate(InputView.BuyLottoTicketCount());
        ResultView.lottoNumberPrint(lottos);
        Lotto winningNumber = WinningNumber.winningNumberGenerate(InputView.inputWinningNumber());
        LottoResults lottosResults = lottos.lottoNumberMatch(winningNumber);
        ResultView.printLottoResult(lottosResults);
    }
}
