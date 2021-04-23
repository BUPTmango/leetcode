package middle_level;

import java.util.*;

/**
 * 368. ��������Ӽ�
 *
 * ��Ϊ�����д����� ������dp
 * �롸300. ����������С�������֮��
 *
 * ����һ���� ���ظ� ��������ɵļ��� nums �������ҳ��������������������Ӽ� answer ���Ӽ���ÿһԪ�ض� (answer[i], answer[j]) ��Ӧ�����㣺
 * answer[i] % answer[j] == 0 ����
 * answer[j] % answer[i] == 0
 * ������ڶ����Ч���Ӽ������������κ�һ�����ɡ�
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [1,2,3]
 * �����[1,2]
 * ���ͣ�[1,3] Ҳ�ᱻ��Ϊ��ȷ�𰸡�
 * ʾ�� 2��
 * <p>
 * ���룺nums = [1,2,4,8]
 * �����[1,2,4,8]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/4/23 09:00
 */
public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);

        // �� 1 ������̬�滮�ҳ�����Ӽ��ĸ���������Ӽ��е��������
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int maxSize = 1;
        int maxVal = dp[0];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                // ��Ŀ��˵��û���ظ�Ԫ�ء�����Ҫ
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxVal = nums[i];
            }
        }

        // �� 2 �������ƻ������Ӽ�
        List<Integer> res = new ArrayList<>();
        if (maxSize == 1) {
            res.add(nums[0]);
            return res;
        }

        for (int i = len - 1; i >= 0 && maxSize > 0; i--) {
            if (dp[i] == maxSize && maxVal % nums[i] == 0) {
                res.add(nums[i]);
                maxVal = nums[i];
                maxSize--;
            }
        }
        return res;
    }
}
