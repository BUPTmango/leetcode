package hard_level;

/**
 * 188. ������Ʊ�����ʱ�� IV
 * ����һ����������prices �����ĵ� i ��Ԫ��prices[i] ��һ֧�����Ĺ�Ʊ�ڵ� i ��ļ۸�
 *
 * ���һ���㷨�����������ܻ�ȡ�������������������� k �ʽ��ס�
 *
 * ע�⣺�㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����
 *
 * ʾ�� 1��
 *
 * ���룺k = 2, prices = [2,4,1]
 * �����2
 * ���ͣ��ڵ� 1 �� (��Ʊ�۸� = 2) ��ʱ�����룬�ڵ� 2 �� (��Ʊ�۸� = 4) ��ʱ����������ʽ������ܻ������ = 4-2 = 2 ��
 * ʾ�� 2��
 *
 * ���룺k = 2, prices = [3,2,6,5,0,3]
 * �����7
 * ���ͣ��ڵ� 2 �� (��Ʊ�۸� = 2) ��ʱ�����룬�ڵ� 3 �� (��Ʊ�۸� = 6) ��ʱ������, ��ʽ������ܻ������ = 6-2 = 4 ��
 *      ����ڵ� 5 �� (��Ʊ�۸� = 0) ��ʱ�����룬�ڵ� 6 �� (��Ʊ�۸� = 3) ��ʱ������, ��ʽ������ܻ������ = 3-0 = 3 ��
 * 
 *
 * ��ʾ��
 *
 * 0 <= k <= 109
 * 0 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/23 11:57 ����
 */
public class maxProfitIV {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int max_k = k;
        int n = prices.length;
        int[][][] dp = new int[n][max_k + 1][2];
        // base case
        for (int j = 1; j <= max_k; j++) {
            dp[0][j][1] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0][1] = Integer.MIN_VALUE;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= max_k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][max_k][0];
    }
}
