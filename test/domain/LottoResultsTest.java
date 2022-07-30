package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultsTest {

    LottoResults lottoResults;

    @BeforeEach
    void setUp() {
        List<LottoResult> lottoRankList = new ArrayList<>();
        lottoRankList.add(LottoResult.of(Rank.FIFTH));
        lottoRankList.add(LottoResult.of(Rank.NO_MATCH));
        lottoRankList.add(LottoResult.of(Rank.NO_MATCH));
        lottoRankList.add(LottoResult.of(Rank.NO_MATCH));
        lottoRankList.add(LottoResult.of(Rank.NO_MATCH));
        lottoRankList.add(LottoResult.of(Rank.NO_MATCH));
        lottoResults = new LottoResults(lottoRankList);
    }
    @DisplayName("총 당첨금액을 구한다")
    @Test
    public void total_money(){
        assertThat(lottoResults.getTotalMoney()).isEqualTo(5_000);
    }

    @DisplayName("총 수익률을 구한다.")
    @Test
    public void yield(){
        assertThat(lottoResults.getTotalYield(5000)).isEqualTo(1);
    }
}

