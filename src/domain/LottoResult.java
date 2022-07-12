package domain;

public class LottoResult {
    private final Rank rank;
    private final Count count;

    private LottoResult(Rank rank, Count count) {
        this.rank = rank;
        this.count = count;
    }

    public static LottoResult of(Rank rank) {
        return new LottoResult(rank, new Count(0));
    }

    public void win(int hitNumber, boolean bonusNumber) {
        if (rank != Rank.matchOf(hitNumber, bonusNumber)) {
            return;
        }
        count.plus();
    }

    public int getWinCount() {
        return count.getCount();
    }

    public int getMatchCount() {
        return rank.getMatchCount();
    }

    public int getMoney() {
        return rank.getMoney();
    }

    public int winningProfit() {
        return count.moneyCount(rank.getMoney());
    }
}
