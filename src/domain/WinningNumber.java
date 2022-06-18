package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {

//    public static Rank match(List<Integer> userLotto, List<Integer> winningLotto){
//        return Rank.of(countMatch(userLotto, winningLotto));
//    }

//    public static int match(List<Integer> userLotto, List<Integer> winningLotto, int bonusNo){
//        return rank(match(userLotto, winningLotto), userLotto.contains(bonusNo));
//    }
//    public static int nmatch(Lottos userLotto , Lotto winningLotto){
//
//    }

//    private static int countMatch(List<Integer> userLotto, List<Integer> winningLotto) {
//        int count = 0;
//        for (Integer lottoNumber : userLotto) {
//            if (winningLotto.contains(lottoNumber)) {
//                count++;
//            }
//        }
//        return count;
//    }

    public static Lotto winningNumberGenerate(String winningNumber) {
        return Arrays.stream(winningNumber.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::of));
    }
}
