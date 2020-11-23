package hard_level;

/**
 * ������Ʊ
 * 123. ������Ʊ�����ʱ�� III
 * ����һ�����飬���ĵ� i ��Ԫ����һ֧�����Ĺ�Ʊ�ڵ� i ��ļ۸�
 * <p>
 * ���һ���㷨�����������ܻ�ȡ�����������������������ʽ��ס�
 * <p>
 * ע��:�㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����
 * <p>
 * ʾ��1:
 * <p>
 * ����: [3,3,5,0,0,3,1,4]
 * ���: 6
 * ����: �ڵ� 4 �죨��Ʊ�۸� = 0����ʱ�����룬�ڵ� 6 �죨��Ʊ�۸� = 3����ʱ����������ʽ������ܻ������ = 3-0 = 3 ��
 * ����ڵ� 7 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 8 �� ����Ʊ�۸� = 4����ʱ����������ʽ������ܻ������ = 4-1 = 3 ��
 * ʾ�� 2:
 * <p>
 * ����: [1,2,3,4,5]
 * ���: 4
 * ����: �ڵ� 1 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 5 �� ����Ʊ�۸� = 5����ʱ������, ��ʽ������ܻ������ = 5-1 = 4 ��
 * ע���㲻���ڵ� 1 ��͵� 2 ����������Ʊ��֮���ٽ�����������
 * ��Ϊ��������ͬʱ�����˶�ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ��
 * ʾ�� 3:
 * <p>
 * ����: [7,6,4,3,1]
 * ���: 0
 * ����: ����������, û�н������, �����������Ϊ 0��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/22 11:01 ����
 */
public class MaxProfitIII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        //���г�ʼ������һ�� s1 ����Ʊ���룬����״̬ȫ����ʼ��Ϊ��Сֵ
        int s1 = -prices[0], s2 = Integer.MIN_VALUE, s3 = Integer.MIN_VALUE, s4 = Integer.MIN_VALUE;

        for (int i = 1; i < prices.length; ++i) {
            s1 = Math.max(s1, -prices[i]); //����۸���͵Ĺ�
            s2 = Math.max(s2, s1 + prices[i]); //������ǰ�ɣ����߲�����
            s3 = Math.max(s3, s2 - prices[i]); //�ڶ������룬���߲�����
            s4 = Math.max(s4, s3 + prices[i]); //�ڶ������������߲�����
        }
        return Math.max(0, s4);
    }

    public int maxProfit_state(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int max_k = 2;
        int n = prices.length;
        int[][][] dp = new int[n][max_k + 1][2];
        // base case
        for (int k = 1; k <= max_k; k++) {
            dp[0][k][1] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0][1] = Integer.MIN_VALUE;
        }
        for (int i = 1; i < n; i++) {
            for (int k = 1; k <= max_k; k++) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][max_k][0];
    }
}
