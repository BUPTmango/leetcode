package weekly_contest.week_214;

import java.util.Arrays;

/**
 * 5561. ��ȡ���������е����ֵ
 * ����һ������ n ����������������һ������Ϊ n + 1 ������ nums ��
 *
 * nums[0] = 0
 * nums[1] = 1
 * �� 2 <= 2 * i <= n ʱ��nums[2 * i] = nums[i]
 * �� 2 <= 2 * i + 1 <= n ʱ��nums[2 * i + 1] = nums[i] + nums[i + 1]
 * ������������ nums �е� ��� ֵ��
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺n = 7
 * �����3
 * ���ͣ����ݹ���
 *   nums[0] = 0
 *   nums[1] = 1
 *   nums[(1 * 2) = 2] = nums[1] = 1
 *   nums[(1 * 2) + 1 = 3] = nums[1] + nums[2] = 1 + 1 = 2
 *   nums[(2 * 2) = 4] = nums[2] = 1
 *   nums[(2 * 2) + 1 = 5] = nums[2] + nums[3] = 1 + 2 = 3
 *   nums[(3 * 2) = 6] = nums[3] = 2
 *   nums[(3 * 2) + 1 = 7] = nums[3] + nums[4] = 2 + 1 = 3
 * ��ˣ�nums = [0,1,1,2,1,3,2,3]�����ֵ 3
 * ʾ�� 2��
 *
 * ���룺n = 2
 * �����1
 * ���ͣ����ݹ���nums[0]��nums[1] �� nums[2] ֮�е����ֵ�� 1
 * ʾ�� 3��
 *
 * ���룺n = 3
 * �����2
 * ���ͣ����ݹ���nums[0]��nums[1]��nums[2] �� nums[3] ֮�е����ֵ�� 2
 *
 *
 * ��ʾ��
 *
 * 0 <= n <= 100
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/8 10:50 ����
 */
public class GetMaximumGenerated {
    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] ans = new int[n + 1];
        Arrays.fill(ans, -1);
        ans[0] = 0;
        ans[1] = 1;
        int max = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                ans[i] = ans[i / 2];
            } else {
                ans[i] = ans[i / 2] + ans[i / 2 + 1];
            }
            max = Math.max(max, ans[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        GetMaximumGenerated get = new GetMaximumGenerated();
        System.out.println(get.getMaximumGenerated(7));
    }
}
