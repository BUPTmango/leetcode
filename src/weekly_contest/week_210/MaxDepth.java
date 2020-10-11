package weekly_contest.week_210;

/**
 * 5535. ���ŵ����Ƕ�����
 * ����ַ�������һ������֮һ������Գ�֮Ϊ ��Ч�����ַ�����valid parentheses string�����Լ�дΪ VPS����
 *
 * �ַ�����һ�����ַ��� ""��������һ����Ϊ "(" �� ")" �ĵ��ַ���
 * �ַ�������дΪ AB��A �� B?�ַ������ӣ������� A �� B ���� ��Ч�����ַ��� ��
 * �ַ�������дΪ (A)������ A ��һ�� ��Ч�����ַ��� ��
 * ���Ƶأ����Զ����κ���Ч�����ַ���?S �� Ƕ����� depth(S)��
 *
 * depth("") = 0
 * depth(A + B) = max(depth(A), depth(B))������ A �� B ���� ��Ч�����ַ���
 * depth("(" + A + ")") = 1 + depth(A)������ A ��һ�� ��Ч�����ַ���
 * ���磺""��"()()"��"()(()())" ���� ��Ч�����ַ�����Ƕ����ȷֱ�Ϊ 0��1��2������ ")(" ��"(()" ������ ��Ч�����ַ��� ��
 *
 * ����һ�� ��Ч�����ַ��� s�����ظ��ַ����� s Ƕ����� ��
 *
 * ʾ�� 1��
 *
 * ���룺s = "(1+(2*3)+((8)/4))+1"
 * �����3
 * ���ͣ����� 8 ��Ƕ�׵� 3 �������С�
 * ʾ�� 2��
 *
 * ���룺s = "(1)+((2))+(((3)))"
 * �����3
 * ʾ�� 3��
 *
 * ���룺s = "1+(2*3)/(2-1)"
 * �����1
 * ʾ�� 4��
 *
 * ���룺s = "1"
 * �����0
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/11 10:43 ����
 */
public class MaxDepth {
    public int maxDepth(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int sum = 0;
        int max = sum;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                sum++;
                if (sum > max) {
                    max = sum;
                }
            }
            if (c == ')') {
                sum--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxDepth max = new MaxDepth();
        System.out.println(max.maxDepth("8*((1*(5+6))*(8/6))"));
    }
}
