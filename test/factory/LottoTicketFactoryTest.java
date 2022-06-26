package factory;

import domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketFactoryTest {

    @DisplayName("금액에 맞는 로또 티켓을 사는 경우")
    @ParameterizedTest
    @CsvSource(value = {"1001 :1", "12780 :12", "1999 :1", "234567 : 234" }, delimiter = ':')
    void lotto_Ticket_Purchase_Test(int price, int ticketCount) {
        Lottos lottos = Lottos.lottoGenerate(price);
        assertThat(lottos.getLottoCount()).isEqualTo(ticketCount);
    }

    @DisplayName("금액 부족으로 로또를 구매할 수 없는 경우 Exception 테스트")
    @ParameterizedTest
    @ValueSource(ints = { 999,10, 888 })
    void invalid_Price(int price) {
        assertThatThrownBy(() -> {
            Lottos.lottoGenerate(price);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}