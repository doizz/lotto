package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {
    @DisplayName("1이상45이하 숫자 체크")
    @ParameterizedTest
    @ValueSource(ints = { 0,46 })
    void numberValidation(int number) {
        assertThatThrownBy(() -> {
            LottoNumber.numberValidation(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}