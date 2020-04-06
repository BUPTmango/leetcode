package middle_level;

/**
 * 300. �����������
 * ����һ��������������飬�ҵ���������������еĳ��ȡ�
 *
 * ʾ��:
 *
 * ����: [10,9,2,5,3,7,101,18]
 * ���: 4
 * ����: ���������������?[2,3,7,101]�����ĳ����� 4��
 * ˵��:
 *
 * ���ܻ��ж�������������е���ϣ���ֻ��Ҫ�����Ӧ�ĳ��ȼ��ɡ�
 * ���㷨��ʱ�临�Ӷ�Ӧ��Ϊ?O(n2) ��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/6 1:34 ����
 */
public class LengthOfLIS {
    /**
     * ������ dp[0 \ldots i-1]dp[0��i?1] ��������������к����ټ�һ�� \textit{nums}[i]nums[i]
     * ����ܴ� dp[j]dp[j] ���״̬ת�ƹ�������ô \textit{nums}[i]nums[i] ��ȻҪ���� \textit{nums}[j]nums[j]�����ܽ� \textit{nums}[i]nums[i] ���� \textit{nums}[j]nums[j] �������γɸ��������������С�
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
}
