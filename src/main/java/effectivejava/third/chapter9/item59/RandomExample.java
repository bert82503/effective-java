package effectivejava.third.chapter9.item59;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Random number generation is hard! - Page 215
 * 随机数生成。
 *
 * @author dannong.lihg
 * @see java.util.concurrent.ThreadLocalRandom
 */
public class RandomExample {

    public static int nextInt(int bound) {
        return ThreadLocalRandom.current().nextInt(bound);
    }

    // ------
    /**
     * Common but deeply flawed!
     * 常见但有很大缺陷！
     */
    private static final Random rnd = new Random();

    private static int random(int bound) {
        // Common but deeply flawed!
//        return Math.abs(rnd.nextInt()) % bound;

        return rnd.nextInt(bound);
    }

    public static void main(String[] args) {
        int bound = 2 * (Integer.MAX_VALUE / 3);
        int low = 0;
        for (int i = 0; i < 1_000_000; i++) {
            if (random(bound) < bound/2) {
                low++;
            }
        }
        System.out.println(low);
    }

}
