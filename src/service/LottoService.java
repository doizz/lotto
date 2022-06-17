package service;

import common.InputView;
import common.ResultView;
import domain.Lotto;
import domain.WinningNumber;
import factory.LottoTicketFactory;
import domain.Lottos;

public class LottoService {

    public void lottoStart() {
        Lottos lottoTickets = LottoTicketFactory.buyLotto(InputView.BuyLottoTicketCount());
        ResultView.lottoNumberPrint(lottoTickets);
        Lotto winningNumber = WinningNumber.winningNumberGenerate(InputView.inputWinningNumber());
    }
}
