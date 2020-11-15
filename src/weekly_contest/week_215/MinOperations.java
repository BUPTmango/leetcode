package weekly_contest.week_215;

import java.util.Arrays;

/**
 * 5602. �� x ���� 0 ����С������ ��ʾӢ������
 * ͨ�����û���462
 * ���Թ����û���1051
 * �û���ͨ������463
 * �û����ύ����2276
 * ��Ŀ�Ѷ�Medium
 * ����һ���������� nums ��һ������ x ��ÿһ�β���ʱ����Ӧ���Ƴ����� nums ����߻����ұߵ�Ԫ�أ�Ȼ��� x �м�ȥ��Ԫ�ص�ֵ����ע�⣬��Ҫ �޸� �����Թ��������Ĳ���ʹ�á�
 *
 * ������Խ� x ǡ�� ���� 0 ������ ��С������ �����򣬷��� -1 ��
 *
 *
 * ʾ�� 1��
 *
 * ���룺nums = [1,1,4,2,3], x = 5
 * �����2
 * ���ͣ���ѽ���������Ƴ�������Ԫ�أ��� x ���� 0 ��
 * ʾ�� 2��
 *
 * ���룺nums = [5,6,7,8,9], x = 4
 * �����-1
 * ʾ�� 3��
 *
 * ���룺nums = [3,2,20,1,1,3], x = 10
 * �����5
 * ���ͣ���ѽ���������Ƴ�������Ԫ�غ�ǰ����Ԫ�أ��ܹ� 5 �β��������� x ���� 0 ��
 *
 * ��ʾ��
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 * 1 <= x <= 109
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/15 11:22 ����
 */
public class MinOperations {
    private int res;
    private boolean[][] visited;
    public int minOperations(int[] nums, int x) {
        res = nums.length + 1;
        // �����ڴ����� ����visited����ʱ������
        visited = new boolean[nums.length][nums.length];
        int left = 0, right = nums.length - 1;
        backtrack(nums, left, right, x, 0);
        if (res == nums.length + 1) {
            res = -1;
        }
        return res;
    }

    private void backtrack(int[] nums, int left, int right, int x, int count) {
        if (left < 0 || right >= nums.length || left > right || x < 0 || visited[left][right]) {
            return;
        }
        if (x == 0) {
            res = Math.min(res, count);
            return;
        }
        if (left == right) {
            if (x == nums[left]) {
                res = Math.min(res, count + 1);
            }
            return;
        }
        visited[left][right] = true;
        backtrack(nums, left + 1, right, x - nums[left], count + 1);
        backtrack(nums, left, right - 1, x - nums[right], count + 1);
    }

    public static void main(String[] args) {
        MinOperations min = new MinOperations();
        int[] nums = new int[]{3,2,20,1,1,3};
        int x = 10;
        System.out.println(min.minOperations(nums, x));
    }
}
