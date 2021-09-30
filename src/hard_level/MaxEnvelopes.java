package hard_level;

import java.util.Arrays;

/**
 * �����������
 * �൱�ڶ�ά�汾 Ҫ�����Զ�������Ԥ����
 * 354. ����˹�����ŷ�����
 * ����һЩ����˿�Ⱥ͸߶ȵ��ŷ⣬��Ⱥ͸߶�����������ʽ(w, h)���֡�����һ���ŷ�Ŀ�Ⱥ͸߶ȶ�������ŷ���ʱ������ŷ�Ϳ��ԷŽ���һ���ŷ����ͬ����˹����һ����
 *
 * �����������ж��ٸ��ŷ������һ�顰����˹���ޡ��ŷ⣨�����԰�һ���ŷ�ŵ���һ���ŷ����棩��
 *
 * ˵��:
 * ��������ת�ŷ⡣
 *
 * ʾ��:
 *
 * ����: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * ���: 3
 * ����: ����ŷ�ĸ���Ϊ 3, ���Ϊ: [2,3] => [5,4] => [6,7]��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/1/6 4:37 ����
 */
public class MaxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        // ����w�������� ���w��ͬ ����h����(��������򣬾ͻ��w��ȵ����Ҳ���ȥ�����ǲ��У���Ϊ��Ҫ�ϸ���ڣ������ǵ���)����
        Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        // ��ȡ�߶�����
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }
        // ��������������������еķ�������
        return lengthOfLIS(height);
    }

    private int lengthOfLIS(int[] nums) {
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
}
