package middle_level;

import java.util.ArrayDeque;
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

    /**
     * ���֧�ּӼ��˳�������
     */
    public int solve(String s) {
        s = s.trim();
        Deque<Integer> stack = new ArrayDeque<>();
        int number = 0;
        char sign = '+';
        char[] charArray = s.toCharArray();
        for (int i = 0, n = charArray.length; i < n; i++) {
            char c = charArray[i];
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                number = number * 10 + c - '0';
            }
            if (c == '(') {
                int j = i + 1;
                int counterPartition = 1;
                while (counterPartition > 0) {
                    if (charArray[j] == '(') {
                        counterPartition++;
                    }
                    if (charArray[j] == ')') {
                        counterPartition--;
                    }
                    j++;
                }
                number = solve(s.substring(i + 1, j - 1));
                i = j - 1;
            }
            if (!Character.isDigit(c) || i == n - 1) {
                if (sign == '+') {
                    stack.push(number);
                } else if (sign == '-') {
                    stack.push(-1 * number);
                } else if (sign == '*') {
                    stack.push(stack.pop() * number);
                } else if (sign == '/') {
                    stack.push(stack.pop() / number);
                }
                number = 0;
                sign = c;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
