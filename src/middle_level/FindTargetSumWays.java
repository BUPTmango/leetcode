package middle_level;

/**
 * 494. Ŀ���
 * ����һ���Ǹ��������飬a1, a2, ..., an, ��һ��Ŀ������S������������������?+?��?-�����������е�����һ���������㶼���Դ�?+?��?-��ѡ��һ�����������ǰ�档
 *
 * ���ؿ���ʹ���������ΪĿ���� S ��������ӷ��ŵķ�������
 *
 * ʾ�� 1:
 *
 * ����: nums: [1, 1, 1, 1, 1], S: 3
 * ���: 5
 * ����:
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * һ����5�ַ���������Ŀ���Ϊ3��
 * ע��:
 *
 * ����ǿգ��ҳ��Ȳ��ᳬ��20��
 * ��ʼ������ĺͲ��ᳬ��1000��
 * ��֤���ص����ս���ܱ�32λ�������¡�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/8 2:50 ����
 */
public class FindTargetSumWays {
    /**
     * ö��
     * ���Խ������ + �� -���ݹ���������������
     * @param nums
     * @param S
     * @return
     */
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        calculate(nums, 0, 0, S);
        return count;
    }
    public void calculate(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S)
                count++;
        } else {
            calculate(nums, i + 1, sum + nums[i], S);
            calculate(nums, i + 1, sum - nums[i], S);
        }
    }


    /**
     * ��̬�滮
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays_dp(int[] nums, int S) {
        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[i - 1][sum + 1000] > 0) {
                    dp[i][sum + nums[i] + 1000] += dp[i - 1][sum + 1000];
                    dp[i][sum - nums[i] + 1000] += dp[i - 1][sum + 1000];
                }
            }
        }
        return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
    }
}
