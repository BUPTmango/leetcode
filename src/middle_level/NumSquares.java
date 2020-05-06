package middle_level;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 279. ��ȫƽ����
 * ����������?n���ҵ����ɸ���ȫƽ����������?1, 4, 9, 16, ...��ʹ�����ǵĺ͵��� n������Ҫ����ɺ͵���ȫƽ�����ĸ������١�
 * <p>
 * ʾ��?1:
 * <p>
 * ����: n = 12
 * ���: 3
 * ����: 12 = 4 + 4 + 4.
 * ʾ�� 2:
 * <p>
 * ����: n = 13
 * ���: 2
 * ����: 13 = 4 + 9.
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/30 1:58 ����
 */
public class NumSquares {

    /**
     * ��ǩ����̬�滮
     * ���ȳ�ʼ������Ϊn+1������dp��ÿ��λ�ö�Ϊ0
     * ���nΪ0������Ϊ0
     * ��������б������±�Ϊi��ÿ�ζ�����ǰ�����ȸ���Ϊ���Ľ������dp[i]=i������i=4������Ϊ4=1+1+1+1��Ϊ4������
     * ��̬ת�Ʒ���Ϊ��dp[i] = MIN(dp[i], dp[i - j * j] + 1)��i��ʾ��ǰ���֣�j*j��ʾƽ����
     * ʱ�临�Ӷȣ�O(n*sqrt(n))��sqrtΪƽ����
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1]; // Ĭ�ϳ�ʼ��ֵ��Ϊ0
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // ����������ÿ��+1
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // ��̬ת�Ʒ���
            }
        }
        return dp[n];
    }

    /**
     * �����������
     * ���ȣ�����׼��С�ڸ������� n ����ȫƽ�����б��� square_nums����
     * Ȼ�󴴽� queue �������ñ�������������ʣ������ÿ�������ö�١�
     * ����ѭ���У����ǵ��� queue ��������ÿ�ε����У����Ǽ�������Ƿ���һ����ȫƽ������
     * �����������һ����ȫƽ��������������һ����ȫƽ������ȥ�����õ�һ����������Ȼ����������ӵ� next_queue �У��Խ�����һ���ĵ�����
     * һ������һ����ȫƽ���������������Ǿͻ�����ѭ������Ҳ��ζ�������ҵ��˽⡣
     * @param n
     * @return
     */
    public int numSquares_BFS(int n) {

        // �����ܵ�ƽ�����ŵ�list��
        ArrayList<Integer> square_nums = new ArrayList<>();
        for (int i = 1; i * i <= n; ++i) {
            square_nums.add(i * i);
        }

        Set<Integer> queue = new HashSet<>();
        queue.add(n);

        int level = 0;
        while (queue.size() > 0) {
            level += 1;
            Set<Integer> next_queue = new HashSet<Integer>();

            for (Integer remainder : queue) {
                for (Integer square : square_nums) {
                    if (remainder.equals(square)) {
                        return level;
                    } else if (remainder < square) {
                        break;
                    } else {
                        next_queue.add(remainder - square);
                    }
                }
            }
            queue = next_queue;
        }
        return level;
    }
}
