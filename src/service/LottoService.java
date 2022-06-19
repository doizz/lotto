package service;

import common.InputView;
import common.ResultView;
import domain.Lotto;
import domain.WinningNumber;
import domain.Lottos;

public class LottoService {

    public void lottoStart() {
        Lottos lottoTickets = Lottos.lottoGenerate(InputView.BuyLottoTicketCount());
        ResultView.lottoNumberPrint(lottoTickets);
        Lotto winningNumber = WinningNumber.winningNumberGenerate(InputView.inputWinningNumber());
//        Lottos.lottoNumberMatch(winningNumber);

    }
}
