package middle_level;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 227. ���������� II
 * ����һ���ַ������ʽ s ������ʵ��һ�����������������㲢��������ֵ��
 * <p>
 * ���������������������֡�
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "3+2*2"
 * �����7
 * ʾ�� 2��
 * <p>
 * ���룺s = " 3/2 "
 * �����1
 * ʾ�� 3��
 * <p>
 * ���룺s = " 3+5 / 2 "
 * �����5
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= s.length <= 3 * 105
 * s ����������� ('+', '-', '*', '/') ��ɣ��м���һЩ�ո����
 * s ��ʾһ�� ��Ч���ʽ
 * ���ʽ�е������������ǷǸ����������ڷ�Χ [0, 231 - 1] ��
 * ��Ŀ���ݱ�֤����һ�� 32-bit ����
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/9/19 17:45
 */
public class Calculate {
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<Integer>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
