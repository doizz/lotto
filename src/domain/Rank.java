package domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 200_000_000),
    SECOND(5, 15_000_000),
    THIRD(5, 500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NO_MATCH(0, 0);

    private int matchCount;
    private int money;

    Rank(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getMoney() {
        return money;
    }

    public static Rank matchOf(int matchCount, boolean bonusNumber) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getMatchCount() == matchCount)
                .findFirst()
                .orElse(NO_MATCH);
    }


}
