package middle_level;

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
}
