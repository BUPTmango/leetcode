package simple_level;

import java.util.Arrays;

/**
 * 204
 * 计算质数
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/23 10:39 上午
 */
public class CountPrimes {
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            boolean flag = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }

    /**
     * 如果一个数是素数 那么它的倍数就不可能是素数了
     *
     * @param n
     * @return
     */
    public int countPrimes_faster(int n) {
        if (n <= 1) {
            return 0;
        }
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        // 只需要 i * i < n 防止2 * 4 和 4 * 2 重复
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                // 每次从 i * i 开始  防止2 * 4 和 4 * 2 重复
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountPrimes cp = new CountPrimes();
        System.out.println(cp.countPrimes(1500000));
    }
}
