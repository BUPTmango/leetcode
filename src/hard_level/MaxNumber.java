package hard_level;

import java.util.Arrays;
import java.util.Stack;

/**
 * ����ջ
 * 321. ƴ�������
 * �������ȷֱ�Ϊm��n���������飬��Ԫ����0-9���ɣ���ʾ������Ȼ����λ�ϵ����֡����ڴ�������������ѡ�� k (k <= m + n)������ƴ�ӳ�һ���µ�����Ҫ���ͬһ��������ȡ�������ֱ�������ԭ�����е����˳��
 * <p>
 * ���������������������������һ����ʾ��������ĳ���Ϊk�����顣
 * <p>
 * ˵��: �뾡���ܵ��Ż����㷨��ʱ��Ϳռ临�Ӷȡ�
 * <p>
 * ʾ��1:
 * <p>
 * ����:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * ���:
 * [9, 8, 6, 5, 3]
 * ʾ�� 2:
 * <p>
 * ����:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * ���:
 * [6, 7, 6, 0, 4]
 * ʾ�� 3:
 * <p>
 * ����:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * ���:
 * [9, 8, 9]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/2 10:13 ����
 */
public class MaxNumber {
    /**
     * 1����nums1��ȡi��Ԫ�����������飬��nums2��ȡk-i��Ԫ�����������顣
     * 2���ϲ�֮ǰ������õ�һ������Ϊk��������顣
     * 3�����ڲ�ͬ���ȷ����������Ƚ�ÿ�εõ��ĳ���Ϊk��������飬��������һ����
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[k];
        for (int i = Math.max(0, k - m); i <= k && i <= n; i++) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(candidate, 0, ans, 0)) {
                ans = candidate;
            }
        }
        return ans;
    }

    /**
     * ������������кϲ�
     */
    public int[] merge(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; r++) {
            ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return ans;
    }

    /**
     * �Ƚ���������Ĵ�С
     */
    public boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    /**
     * ȡ������������k��Ԫ��
     */
    public int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            // ��pop �ж�ʣ������Ԫ���ܲ��ܴչ�k
            while (!stack.isEmpty() && stack.peek() < nums[i] && n - i + stack.size() > k) {
                stack.pop();
            }
            // �����
            stack.push(nums[i]);
        }
        // stack��Ϊ����
        int length = stack.size();
        int[] array = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            array[i] = stack.pop();
        }
        return Arrays.copyOfRange(array, 0, k);
    }

    public static void main(String[] args) {
        MaxNumber number = new MaxNumber();
        System.out.println(Arrays.toString(number.maxArray(new int[]{3, 4, 6, 5}, 2)));
    }
}
