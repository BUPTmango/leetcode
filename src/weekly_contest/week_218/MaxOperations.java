package weekly_contest.week_218;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 5618. K �����Ե������Ŀ
 * ����һ���������� nums ��һ������ k ��
 *
 * ÿһ�������У�����Ҫ��������ѡ����Ϊ k ���������������������Ƴ����顣
 *
 * ��������Զ�����ִ�е�����������
 *
 * ʾ�� 1��
 *
 * ���룺nums = [1,2,3,4], k = 5
 * �����2
 * ���ͣ���ʼʱ nums = [1,2,3,4]��
 * - �Ƴ� 1 �� 4 ��֮�� nums = [2,3]
 * - �Ƴ� 2 �� 3 ��֮�� nums = []
 * �����к�Ϊ 5 �����ԣ�������ִ�� 2 �β�����
 * ʾ�� 2��
 *
 * ���룺nums = [3,1,3,4,3], k = 6
 * �����1
 * ���ͣ���ʼʱ nums = [3,1,3,4,3]��
 * - �Ƴ�ǰ���� 3 ��֮��nums = [1,4,3]
 * �����к�Ϊ 6 �����ԣ�������ִ�� 1 �β�����
 *
 * ��ʾ��
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= k <= 109
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/6 10:56 ����
 */
public class MaxOperations {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int res = 0;
        while (i < j) {
            if (nums[i] + nums[j] == k) {
                res++;
                i++;
                j--;
            } else if (nums[i] + nums[j] < k) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaxOperations max = new MaxOperations();
        System.out.println(max.maxOperations(new int[]{1,2,3,4}, 8));
    }
}
