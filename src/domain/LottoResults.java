package domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResults {
    private final List<LottoResult> lottoResults;

    public LottoResults(List<LottoResult> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public static LottoResults from() {
        return new LottoResults(Arrays.stream(Rank.values())
                .map(LottoResult::of)
                .collect(Collectors.toList()));
    }

    public void win(int hitCount, boolean bonusNumber) {
        for (LottoResult result : lottoResults) {
            result.win(hitCount, bonusNumber);
        }
    }

    public List<LottoResult> getLottoResults() {
        return Collections.unmodifiableList(this.lottoResults);
    }

    public int getTotalMoney() {
        return lottoResults.stream()
                .map(LottoResult::winningMoney)
                .reduce(0, Integer::sum);
    }
    public double getTotalYield(int lottoCount){
        return (double) getTotalMoney() / (lottoCount * 1000);
    }
}
