package hard_level;

/**
 * 312. ������
 * �� n �����򣬱��Ϊ0 �� n-1��ÿ�������϶�����һ�����֣���Щ���ִ�������nums�С�
 *
 * ����Ҫ����������е����������������� i ���Ϳ��Ի��nums[left] * nums[i] * nums[right]��Ӳ�ҡ������left��right�����i���ڵ������������š�ע�⵱����������� i ������left������right�ͱ�������ڵ�����
 *
 * �����ܻ��Ӳ�ҵ����������
 *
 * ˵��:
 *
 * ����Լ���nums[-1] = nums[n] = 1����ע�����ǲ�����ʵ���ڵ����Բ����ܱ����ơ�
 * 0 �� n �� 500, 0 �� nums[i] �� 100
 * ʾ��:
 *
 * ����: [3,1,5,8]
 * ���: 167 
 * ����: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *     coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/1/13 4:37 ����
 */
public class MaxCoins {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        // ����������������
        int[] points = new int[n + 2];
        points[0] = points[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            points[i] = nums[i - 1];
        }
        // dp[i][j] = x ��ʾ ��������i������j֮�䣨�����䣩���������� ���Ի�õ���߷���x
        int[][] dp = new int[n + 2][n + 2];
        // base case �Ѿ���ʼ��Ϊ0
        // i == j��ʱ��Ϊ0
        // ���µ��� ������
        for (int i = n; i >= 0; i--) {
            for (int j = i + 1; j < n + 2; j++) {
                // �����Ƶ��������ĸ�������
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + points[i] * points[k] * points[j]);
                }
            }
        }
        return dp[0][n + 1];
    }
}
