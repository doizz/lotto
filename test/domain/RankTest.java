package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    @DisplayName("로또 1등 당첨")
    public void first_place() {
        Rank rank = Rank.of(6);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("로또 2등 당첨")
    public void two_place() {
        Rank rank = Rank.of(5);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("로또 3등 당첨")
    public void three_place() {
        Rank rank = Rank.of(4);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("로또 4등 당첨")
    public void four_place() {
        Rank rank = Rank.of(3);
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("미당첨")
    public void no_match() {
        Rank rank = Rank.of(2);
        assertThat(rank).isEqualTo(Rank.NO_MATCH);
    }
}