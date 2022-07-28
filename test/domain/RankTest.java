
package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    static Stream<Arguments> lottoRankTest() {
        return Stream.of(
                Arguments.arguments(6, false, Rank.FIRST),
                Arguments.arguments(5, true, Rank.SECOND),
                Arguments.arguments(5, false, Rank.THIRD),
                Arguments.arguments(4, false, Rank.FOURTH),
                Arguments.arguments(3, false, Rank.FIFTH),
                Arguments.arguments(0, false, Rank.NO_MATCH)
        );
    }

    @ParameterizedTest
    @MethodSource("lottoRankTest")
    @DisplayName("맞춘개수에따라 등수를 정한다.")
    public void create(int matchCount, boolean bonusNumber, Rank expectedRank) {
        assertThat(Rank.matchOf(matchCount, bonusNumber)).isEqualTo(expectedRank);
    }

    @DisplayName("당첨 결과에 따른 당첨 금액을 구한다")
    @ParameterizedTest
    @CsvSource(value = {"4,false,50_000", "5,false,500_000", "5,true,15_000_000", "6,false,200_000_000"})
    public void findRank(int winningCount, boolean matchBonus, int expectedReward) {
        Rank lottoRank = Rank.matchOf(winningCount, matchBonus);
        assertThat(expectedReward).isEqualTo(lottoRank.getMoney());
    }


}

