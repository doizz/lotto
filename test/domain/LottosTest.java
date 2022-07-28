package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static domain.Lottos.autoLottoGenerate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottosTest {
    @DisplayName("금액에 맞는 로또가 구매되는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"10_000,10", "1_000,1", "5_000,5"})
    void test(int price , int lottoCount){
        Lottos lottos = Lottos.of(autoLottoGenerate(price));
        assertThat(lottoCount).isEqualTo(lottos.getLottoCount());
    }
}