package simple_level;

import java.util.Arrays;

/**
 * 204
 * ��������
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/23 10:39 ����
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
     * ���һ���������� ��ô���ı����Ͳ�������������
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
        // ֻ��Ҫ i * i < n ��ֹ2 * 4 �� 4 * 2 �ظ�
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                // ÿ�δ� i * i ��ʼ  ��ֹ2 * 4 �� 4 * 2 �ظ�
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
