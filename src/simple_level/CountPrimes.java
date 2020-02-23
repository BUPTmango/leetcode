package simple_level;

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
     * 2��������2�ı���������Ϊfalse
     * 3��ָ����3�ı���������Ϊfalse
     * �Դ�����
     * @param n
     * @return
     */
    public int countPrimes_faster(int n) {
        if (n <= 1) {
            return 0;
        }
        int res = 0;
        boolean[] juge = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            juge[i] = true;
        }
        for (int i = 2; i < n; i++) {
            if (juge[i]) {
                for (int j = i + i; j < n; j += i) {
                    juge[j] = false;
                }
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountPrimes cp = new CountPrimes();
        System.out.println(cp.countPrimes(1500000));
    }
}
