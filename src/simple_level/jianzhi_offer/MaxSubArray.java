package simple_level.jianzhi_offer;

/**
 * ������42. ���������������
 * ����һ���������飬������������Ҳ�и����������е�һ������������������һ�������顣������������ĺ͵����ֵ��
 *
 * Ҫ��ʱ�临�Ӷ�ΪO(n)��
 *
 * ʾ��1:
 *
 * ����: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * ���: 6
 * ����:?����������?[4,-1,2,1] �ĺ����Ϊ?6��
 *
 * ��ʾ��
 *
 * 1 <=?arr.length <= 10^5
 * -100 <= arr[i] <= 100
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/7 9:01 ����
 */
public class MaxSubArray {
    /**
     * �� dp[i?1]��0 ��˵�� dp[i?1] �� dp[i] ���������ף��� dp[i?1]+nums[i] ������ nums[i] �����
     *
     * �� dp[i?1]>0 ʱ��ִ�� dp[i]=dp[i?1]+nums[i] ��
     * �� dp[i?1]��0 ʱ��ִ�� dp[i]=nums[i] ��
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
