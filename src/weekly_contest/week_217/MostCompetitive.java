package weekly_contest.week_217;

import java.util.Arrays;
import java.util.Stack;

/**
 * ����ջ
 * 5614. �ҳ���߾�������������
 * ����һ���������� nums ��һ�������� k �����س���Ϊ k ����� ������ �� nums �����С�
 *
 * ������������Ǵ�������ɾ��һЩԪ�أ����ܲ�ɾ��Ԫ�أ��õ������С�
 *
 * �������� a �������� b ��һ������ͬ��λ���ϣ���� a �е�����С�� b �ж�Ӧ�����֣���ô���ǳ������� a �������� b����ͬ�����£����� ������ �� ���磬[1,3,4] �� [1,3,5] ���߾��������ڵ�һ������ͬ��λ�ã�Ҳ�������һ��λ���ϣ� 4 С�� 5 ��
 *
 * ʾ�� 1��
 *
 * ���룺nums = [3,5,2,6], k = 2
 * �����[2,6]
 * ���ͣ������п��ܵ������м��� {[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]} �У�[2,6] ��߾�������
 * ʾ�� 2��
 *
 * ���룺nums = [2,4,3,3,5,4,9,6], k = 4
 * �����[2,3,3,4]
 *
 * ��ʾ��
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * 1 <= k <= nums.length
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/29 10:36 ����
 */
public class MostCompetitive {
    public int[] mostCompetitive(int[] nums, int k) {
        int[] res = new int[k];
        boolean isIncre = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]){
                isIncre = false;
                break;
            }
        }
        if (isIncre) {
            res = Arrays.copyOfRange(nums, 0, k);
            return res;
        }

        // k������ Ѱ��k��
        int start = 0, end = nums.length - k;
        for (int i = 0; i < k; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = start; j <= end; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    // ����start����
                    start = j + 1;
                }
            }
            res[i] = min;
            // ����end����
            end++;
        }
        return res;
    }

    /**
     * ����ջ �Ƽ�
     * @param nums
     * @param k
     * @return
     */
    public int[] mostCompetitive_better(int[] nums, int k) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            // ��pop �ж�ʣ������Ԫ���ܲ��ܴչ�k
            while (!stack.isEmpty() && stack.peek() > nums[i] && n - i + stack.size() > k) {
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
        MostCompetitive most = new MostCompetitive();
        System.out.println(Arrays.toString(most.mostCompetitive_better(new int[]{2, 4, 3, 3, 5, 4, 9, 6}, 4)));
    }
}
