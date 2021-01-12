package hard_level;

/**
 * 10. ������ʽƥ��
 * ����һ���ַ���s��һ���ַ�����p��������ʵ��һ��֧�� '.'��'*'��������ʽƥ�䡣
 * <p>
 * '.' ƥ�����ⵥ���ַ�
 * '*' ƥ���������ǰ�����һ��Ԫ��
 * ��νƥ�䣬��Ҫ���������ַ���s�ģ������ǲ����ַ�����
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "aa" p = "a"
 * �����false
 * ���ͣ�"a" �޷�ƥ�� "aa" �����ַ�����
 * ʾ�� 2:
 * <p>
 * ���룺s = "aa" p = "a*"
 * �����true
 * ���ͣ���Ϊ '*' �������ƥ���������ǰ�����һ��Ԫ��, ������ǰ���Ԫ�ؾ��� 'a'����ˣ��ַ��� "aa" �ɱ���Ϊ 'a' �ظ���һ�Ρ�
 * ʾ��3��
 * <p>
 * ���룺s = "ab" p = ".*"
 * �����true
 * ���ͣ�".*" ��ʾ��ƥ�����������'*'�������ַ���'.'����
 * ʾ�� 4��
 * <p>
 * ���룺s = "aab" p = "c*a*b"
 * �����true
 * ���ͣ���Ϊ '*' ��ʾ������������� 'c' Ϊ 0 ��, 'a' ���ظ�һ�Ρ���˿���ƥ���ַ��� "aab"��
 * ʾ�� 5��
 * <p>
 * ���룺s = "mississippi" p = "mis*is*p*."
 * �����false
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 0 <= s.length<= 20
 * 0 <= p.length<= 30
 * s����Ϊ�գ���ֻ������a-z��Сд��ĸ��
 * p����Ϊ�գ���ֻ������a-z��Сд��ĸ���Լ��ַ�.��*��
 * ��֤ÿ�γ����ַ�* ʱ��ǰ�涼ƥ�䵽��Ч���ַ�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/1/10 10:49 ����
 */
public class IsMatch {
    public boolean isMatch(String s, String p) {
        char[] str = s.toCharArray(), ptr = p.toCharArray();
        boolean[][] dp = new boolean[str.length + 1][ptr.length + 1];
        dp[0][0] = true;
        for (int i = 0; i <= str.length; i++) {
            for (int j = 1; j <= ptr.length; j++) {
                if (ptr[j - 1] != '*') {
                    if (i > 0 && (str[i - 1] == ptr[j - 1] || ptr[j - 1] == '.')) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else { //ptr[j - 1] == '*'
                    if (j > 1) {
                        dp[i][j] |= dp[i][j - 2];   //����
                    }
                    if (i > 0 && j > 1 && (str[i - 1] == ptr[j - 2] || ptr[j - 2] == '.')) {
                        dp[i][j] |= dp[i - 1][j];    //��
                    }
                }
            }
        }
        return dp[str.length][ptr.length];
    }
}
