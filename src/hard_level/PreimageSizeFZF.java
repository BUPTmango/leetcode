package hard_level;

/**
 * �׳���
 * 793. �׳˺�����K����
 * f(x)��x!ĩβ��0��������������һ��x! = 1 * 2 * 3 * ... * x����0! = 1��
 *
 * ���磬f(3) = 0����Ϊ3! = 6��ĩβû��0����f(11) = 2����Ϊ11!= 39916800ĩ����2��0������K���ҳ����ٸ��Ǹ�����x����f(x) = K�����ʡ�
 *
 * ʾ�� 1:
 * ����:K = 0
 * ���:5
 * ����:0!, 1!, 2!, 3!, and 4!������ K = 0 ��������
 *
 * ʾ�� 2:
 * ����:K = 5
 * ���:0
 * ����:û��ƥ�䵽������ x!������K = 5 ��������
 * ע�⣺
 *
 * K�Ƿ�Χ��[0, 10^9]��������
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/18 11:08 ����
 */
public class PreimageSizeFZF {
    /**
     * ʹ�ö��ֲ���
     * @param K
     * @return
     */
    public int preimageSizeFZF(int K) {
        // ���ұ߽�֮���һ���ǽ��
        return (int)(rightBound(K) - leftBound(K) + 1);
    }

    /**
     * Ѱ�� trailingZeroes(n) == K ����߽�
     * @param target
     * @return
     */
    private long leftBound(int target) {
        long left = 0, right = Long.MAX_VALUE;
        while (left < right) {
            long mid = left + (right - left) / 2;
            long curr = trailingZeroes(mid);
            if (curr > target) {
                right = mid;
            } else if (curr < target) {
                left = mid + 1;
            } else {
                // Ѱ����߽� �����ҵ��󲻷��� �����ս��ұ߽�
                right = mid;
            }
        }
        return left;
    }

    /**
     * Ѱ�� trailingZeroes(n) == K ���ұ߽�
     * @param target
     * @return
     */
    private long rightBound(int target) {
        long left = 0, right = Long.MAX_VALUE;
        while (left < right) {
            long mid = left + (right - left) / 2;
            long curr = trailingZeroes(mid);
            if (curr > target) {
                right = mid;
            } else if (curr < target) {
                left = mid + 1;
            } else {
                // Ѱ���ұ߽� �����ҵ��󲻷��� �����ս���߽�
                left = mid + 1;
            }
        }
        return left - 1;
    }

    private long trailingZeroes(long n) {
        long res = 0;
        while (n >= 5) {
            n = n / 5;
            res += n;
        }
        return res;
    }
}
