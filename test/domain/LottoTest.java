package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    private static Stream<Arguments> LottoSizeValidationData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5)),
                Arguments.of(Arrays.asList(1, 1, 3, 4, 5, 6)),
                Arguments.of(Arrays.asList(10, 20, 21, 15, 24, 36, 1))
        );
    }

    @DisplayName("로또번호의 입력갯수와 중복을 테스트")
    @ParameterizedTest
    @MethodSource("LottoSizeValidationData")
    void lotto_number_size_validation(List<Integer> numbers) {
        assertThatThrownBy(() -> {
            Lotto.of(numbers);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @DisplayName("구매한 번호와 당첨번호와 일치하는 번호갯수 테스트")
    @Test
    void lotto_hit_count(){
        Lotto lotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winningNumber = Lotto.of(Arrays.asList(2,3,4,5,6,7));
        assertThat(lotto.getHitCount(winningNumber)).isEqualTo(5);
    }
}