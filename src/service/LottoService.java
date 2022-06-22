package service;

import common.InputView;
import common.ResultView;
import domain.*;

public class LottoService {

    public void lottoStart() {
        Lottos lottoTickets = Lottos.lottoGenerate(InputView.BuyLottoTicketCount());
        ResultView.lottoNumberPrint(lottoTickets);
        Lotto winningNumber = WinningNumber.winningNumberGenerate(InputView.inputWinningNumber());
        System.out.println("winningNumber = " + winningNumber);
        LottoResults lr = lottoTickets.lottoNumberMatch(winningNumber);
        ResultView.printLottoResult(lr);
    }
}
