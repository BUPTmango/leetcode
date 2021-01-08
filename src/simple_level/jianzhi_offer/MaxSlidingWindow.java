package simple_level.jianzhi_offer;


/**
 * ������59 - I. �������ڵ����ֵ
 * ����һ������ nums �ͻ������ڵĴ�С k�����ҳ����л�������������ֵ��
 *
 * ʾ��:
 *
 * ����: nums = [1,3,-1,-3,5,3,6,7], �� k = 3
 * ���: [3,3,5,5,6,7]
 * ����:
 *
 *   �������ڵ�λ��                ���ֵ
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * ?
 * ��ʾ��
 *
 * ����Լ��� k ������Ч�ģ����������鲻Ϊ�յ�����£�1 �� k ��?��������Ĵ�С��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/12 10:23 ����
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int length = nums.length - k + 1;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int max = nums[i];
            for (int j = 1; j < k; j++) {
                max = Math.max(max, nums[i + j]);
            }
            result[i] = max;
        }
        return result;
    }

    public static void main(String[] args) {
        MaxSlidingWindow msw = new MaxSlidingWindow();
        int[] result = msw.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        for (int num : result) {
            System.out.println(" " + num);
        }
    }
}

