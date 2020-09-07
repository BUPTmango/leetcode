package middle_level;

/**
 * 209. ������С��������
 * ����һ������ n ���������������һ�������� s  ���ҳ���������������� �� s �ĳ�����С�� ���� �����飬�������䳤�ȡ���������ڷ��������������飬���� 0��
 *
 * ?
 *
 * ʾ����
 *
 * ���룺s = 7, nums = [2,3,1,2,4,3]
 * �����2
 * ���ͣ������� [4,3] �Ǹ������µĳ�����С�������顣
 *
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/7 9:03 ����
 */
public class MinSubArrayLen {
    /**
     * ������
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= s) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    /**
     * ˫ָ��
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen_two_pointer(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        // ����ָ���ͷ��ʼ��
        int start = 0, end = 0;
        int sum = 0;
        // endָ���ͷ������
        while (end < n) {
            sum += nums[end];
            // ����ʹ���s�� ������С���� sum��ȥstart��ֵ startָ�������
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            // ����endָ��
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
