package domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 200000000),
    SECOND(5, 15000000),
    THIRD(4, 500000),
    FOURTH(3, 5000),
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

    public static Rank matchOf(int matchCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getMatchCount() == matchCount)
                .findFirst()
                .orElse(NO_MATCH);
    }

    public int sumMoney(int totalMoney) {
        return money + totalMoney;
    }

}
