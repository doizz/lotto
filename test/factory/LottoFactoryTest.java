package factory;

import domain.Lotto;
import domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoFactoryTest {

    @DisplayName("로또를 구매할 수 없는 경우테스트")
    @ParameterizedTest
    @ValueSource(ints = {999, 10, 888})
    void invalid_Price(int price) {
        assertThatThrownBy(() -> {
            Lottos.of(Lottos.autoLottoGenerate(price));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}