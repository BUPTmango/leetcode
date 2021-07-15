package middle_level;

import java.util.Arrays;

/**
 * ��������
 * 1049. ���һ��ʯͷ������ II
 * ��һ��ʯͷ������������?stones ��ʾ������?stones[i] ��ʾ�� i ��ʯͷ��������
 * <p>
 * ÿһ�غϣ�����ѡ����������ʯͷ��Ȼ������һ����顣����ʯͷ�������ֱ�Ϊ?x ��?y����?x <= y����ô����Ŀ��ܽ�����£�
 * <p>
 * ���?x == y����ô����ʯͷ���ᱻ��ȫ���飻
 * ���?x != y����ô����Ϊ?x?��ʯͷ������ȫ���飬������Ϊ?y?��ʯͷ������Ϊ?y-x��
 * ������ֻ��ʣ��һ�� ʯͷ�����ش�ʯͷ ��С�Ŀ������� �����û��ʯͷʣ�£��ͷ��� 0��
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺stones = [2,7,4,1,8,1]
 * �����1
 * ���ͣ�
 * ��� 2 �� 4���õ� 2����������ת��Ϊ [2,7,1,8,1]��
 * ��� 7 �� 8���õ� 1����������ת��Ϊ [2,1,1,1]��
 * ��� 2 �� 1���õ� 1����������ת��Ϊ [1,1,1]��
 * ��� 1 �� 1���õ� 0����������ת��Ϊ [1]�����������ֵ��
 * ʾ�� 2��
 * <p>
 * ���룺stones = [31,26,33,21,40]
 * �����5
 * ʾ�� 3��
 * <p>
 * ���룺stones = [1,2]
 * �����1
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/6/8 09:17
 */
public class LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        // �൱����+��-��ʯͷ��Ҫ�����߽ӽ�������Ҳ����-�ĺ�Ҫ�����ܽӽ�sum/2
        int sum = Arrays.stream(stones).sum();
        // sum / 2 �ı�������
        int m = sum / 2;
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        for (int stone : stones) {
            for (int i = m; i >= stone; i--) {
                dp[i] = dp[i] || dp[i - stone];
            }
        }
        for (int j = m; ; --j) {
            if (dp[j]) {
                return sum - 2 * j;
            }
        }
    }
}