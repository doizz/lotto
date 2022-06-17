package domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public class WinningNumber {
    public static Lotto winningNumberGenerate(String winningNumber) {
        return Arrays.stream(winningNumber.split(","))
                     .map(Integer::parseInt)
                     .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::of));
    }
}
