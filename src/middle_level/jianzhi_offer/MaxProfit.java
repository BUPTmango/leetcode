package middle_level.jianzhi_offer;

/**
 * ������Ʊ
 * ��ָ Offer 63. ��Ʊ���������
 * �����ĳ��Ʊ�ļ۸���ʱ���Ⱥ�˳��洢�������У����������ù�Ʊһ�ο��ܻ�õ���������Ƕ��٣�
 *
 * ʾ�� 1:
 *
 * ����: [7,1,5,3,6,4]
 * ���: 5
 * ����: �ڵ� 2 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 5 �죨��Ʊ�۸� = 6����ʱ��������������� = 6-1 = 5 ��
 *      ע���������� 7-1 = 6, ��Ϊ�����۸���Ҫ��������۸�
 * ʾ�� 2:
 *
 * ����: [7,6,4,3,1]
 * ���: 0
 * ����: �����������, û�н������, �����������Ϊ 0��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/13 12:46 ����
 */
public class MaxProfit {
    /**
     * ǰ ii ��������� dp[i]dp[i] ����ǰ i - 1i?1 ��������� dp[i-1]dp[i?1] �͵� ii ����������������е����ֵ
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for(int price : prices) {
            // ���´ӿ�ʼ�����ڵ���ͼ�
            cost = Math.min(cost, price);
            // ȡ���������������֮ǰ����������ֵ
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}
