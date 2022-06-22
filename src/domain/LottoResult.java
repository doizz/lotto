package domain;

public class LottoResult {
    private final Rank rank;
//    private final WinCount winCount;

    private LottoResult(Rank rank) {
        this.rank = rank;
    }

    public static LottoResult of(Rank rank) {
        return new LottoResult(rank);
    }

    public void win(int hitNumber) {
        if (rank != Rank.matchOf(hitNumber)) {
            return;
        }
    }

    public int getMatchCount() {
        return rank.getMatchCount();
    }

    public int getMoney() {
        return rank.getMoney();
    }

//    public int winningProfit() {
//        return winCount.moneyCount(rank.getReward());
//    }
}
