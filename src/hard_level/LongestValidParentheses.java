package hard_level;

/**
 * 32. ���Ч����
 * ����һ��ֻ���� '('�� ')'���ַ������ҳ����Ч����ʽ��ȷ�������������Ӵ��ĳ��ȡ�
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "(()"
 * �����2
 * ���ͣ����Ч�����Ӵ��� "()"
 * ʾ�� 2��
 * <p>
 * ���룺s = ")()())"
 * �����4
 * ���ͣ����Ч�����Ӵ��� "()()"
 * ʾ�� 3��
 * <p>
 * ���룺s = ""
 * �����0
 * <p>
 * ��ʾ��
 * <p>
 * 0 <= s.length <= 3 * 104
 * s[i] Ϊ '(' �� ')'
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/3/21 9:03 ����
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        // dp[i]��ʾ��i��β�����Ч���ŵĳ���
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            // ��Ч���ŵ����һ���ַ��϶��������ţ��������������Ų��ùܣ����������ŲŽ��и���
            if (s.charAt(i) == ')') {
                // ǰһ���������ž�ֱ�����
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    // �ҵ���ǰ���������
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
}
