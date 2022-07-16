package domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 200_000_000, false),
    SECOND(5, 15_000_000, true),
    THIRD(5, 500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NO_MATCH(0, 0, false);

    private int matchCount;
    private int money;
    private boolean hitBonusNumber;

    Rank(int matchCount, int money, boolean hitBonusNumber) {
        this.matchCount = matchCount;
        this.money = money;
        this.hitBonusNumber = hitBonusNumber;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getMoney() {
        return money;
    }

    public boolean getHitBonusNumber() {
        return hitBonusNumber;
    }

    ;

    public static Rank matchOf(int matchCount, boolean bonusNumber) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getMatchCount() == matchCount && rank.getHitBonusNumber() == bonusNumber)
                .findFirst()
                .orElse(NO_MATCH);
    }


}
