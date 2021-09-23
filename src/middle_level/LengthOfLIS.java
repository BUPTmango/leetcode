package middle_level;

import hard_level.Solution;

import java.util.Arrays;

/**
 * �����������
 * ����ת�㷨������Ƶ���⡷��̬�滮 �����������
 * 300. �����������
 * ����һ��������������飬�ҵ���������������еĳ��ȡ�
 *
 * ʾ��:
 *
 * ����: [10,9,2,5,3,7,101,18]
 * ���: 4
 * ����: ���������������?[2,3,7,101]�����ĳ����� 4��
 * ˵��:
 *
 * ���ܻ��ж�������������е���ϣ���ֻ��Ҫ�����Ӧ�ĳ��ȼ��ɡ�
 * ���㷨��ʱ�临�Ӷ�Ӧ��Ϊ?O(n2) ��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/6 1:34 ����
 */
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // dp[i]��ʾ��nums[i]Ϊ��β������������еĳ���
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // ���ǰ������ȵ�ǰ��С �Ϳ��Ǹ��µ�ǰ����ΪС�����ĸ�����һ
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        int res = 1;
        // ע�⣡���� ���ﲻ�Ƿ������һ��Ԫ�� ����Ҫ����Ѱ��
        // ����dp��������λ�ý�β�������������
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    /**
     * ̰�� + ���ֲ���
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS_better(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            // ��� nums[i] > d[len] ����ֱ�Ӽ��뵽 d ����ĩβ��������len=len+1��
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            // ������ d �����ж��ֲ��ң��ҵ���һ���� nums[i] С���� d[k] �������� d[k+1]=nums[i]��
            } else {
                // ����Ҳ���˵�����е������� nums[i] �󣬴�ʱҪ���� d[1]���������ｫ pos ��Ϊ 0
                int l = 1, r = len, pos = 0;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }
}
