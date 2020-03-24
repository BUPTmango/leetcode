package simple_level.coder_gold;

/**
 * ������ 17.16. ��Ħʦ
 * һ�������İ�Ħʦ���յ�ԴԴ���ϵ�ԤԼ����ÿ��ԤԼ������ѡ��ӻ򲻽ӡ���ÿ��ԤԼ����֮��Ҫ����Ϣʱ�䣬��������ܽ������ڵ�ԤԼ������һ��ԤԼ�������У��水Ħʦ�ҵ����ŵ�ԤԼ���ϣ���ԤԼʱ������������ܵķ�������
 *
 * ע�⣺�������ԭ�������Ķ�
 *
 * ?
 *
 * ʾ�� 1��
 *
 * ���룺 [1,2,3,1]
 * ����� 4
 * ���ͣ� ѡ�� 1 ��ԤԼ�� 3 ��ԤԼ����ʱ�� = 1 + 3 = 4��
 * ʾ�� 2��
 *
 * ���룺 [2,7,9,3,1]
 * ����� 12
 * ���ͣ� ѡ�� 1 ��ԤԼ�� 3 ��ԤԼ�� 5 ��ԤԼ����ʱ�� = 2 + 9 + 1 = 12��
 * ʾ�� 3��
 *
 * ���룺 [2,1,4,5,3,1,1,3]
 * ����� 12
 * ���ͣ� ѡ�� 1 ��ԤԼ�� 3 ��ԤԼ�� 5 ��ԤԼ�� 8 ��ԤԼ����ʱ�� = 2 + 4 + 3 + 3 = 12��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/24 8:23 ����
 */
public class Massage {
    /**
     * ���Ʒ��̣�dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
     * @param nums
     * @return
     */
    public int massage(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[length - 1];
    }
}
