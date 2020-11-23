package middle_level;

/**
 * ������Ʊ
 * 714. ������Ʊ�����ʱ����������
 * ����һ����������prices�����е�i��Ԫ�ش����˵�i��Ĺ�Ʊ�۸� ���Ǹ�����fee �����˽��׹�Ʊ���������á�
 *
 * ��������޴ε���ɽ��ף�������ÿ�ʽ��׶���Ҫ�������ѡ�������Ѿ�������һ����Ʊ����������֮ǰ��Ͳ����ټ��������Ʊ�ˡ�
 *
 * ���ػ����������ֵ��
 *
 * ע�⣺�����һ�ʽ���ָ������в�������Ʊ���������̣�ÿ�ʽ�����ֻ��ҪΪ֧��һ�������ѡ�
 *
 * ʾ�� 1:
 *
 * ����: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * ���: 8
 * ����: �ܹ��ﵽ���������:
 * �ڴ˴�����prices[0] = 1
 * �ڴ˴����� prices[3] = 8
 * �ڴ˴����� prices[4] = 4
 * �ڴ˴����� prices[5] = 9
 * ������:((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * ע��:
 *
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000.
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/22 11:20 ����
 */
public class MaxProfitWithFee {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        // f[i]Ϊ��i�����ʱ���������
        int[][] f = new int[n][2];
        // f[i][0]����i�����֮�󲻳��й�Ʊ���������
        f[0][0] = 0;
        // f[i][1]����i�����֮����й�Ʊ���������
        f[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1] + prices[i] - fee);
            f[i][1] = Math.max(f[i - 1][1], f[i - 1][0] - prices[i]);
        }
        return f[n - 1][0];
    }

    /**
     * ״̬ת�Ʒ���
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit_state(int[] prices, int fee) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        // base case
        int dp_i_0 = 0;
        int dp_i_1 = -prices[0] - fee;
        for (int i = 1; i < n; i++) {
            int tmp = dp_i_0;
            // i��ʾi�����֮��
            // 0��ʾ�����й�Ʊ 1��ʾ���й�Ʊ
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, tmp - prices[i] - fee);
        }
        return dp_i_0;
    }
}
