package hard_level;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 224. ����������
 * ����һ���ַ������ʽ s ������ʵ��һ�����������������㲢��������ֵ��
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "1 + 1"
 * �����2
 * ʾ�� 2��
 * <p>
 * ���룺s = " 2-1 + 2 "
 * �����3
 * ʾ�� 3��
 * <p>
 * ���룺s = "(1+(4+5+2)-3)+(6+8)"
 * �����23
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= s.length <= 3* 105
 * s �����֡�'+'��'-'��'('��')'���� ' ' ���
 * s ��ʾһ����Ч�ı��ʽ
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/9/19 17:18
 */
public class Calculate {
    /**
     * ����չ�� + ջ
     */
    public int calculate(String s) {
        Deque<Integer> ops = new LinkedList<Integer>();
        ops.push(1);
        int sign = 1;

        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }
}
