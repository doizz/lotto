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

    public void win(int hitNumber) {
        if (rank != Rank.matchOf(hitNumber)) {
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
