package middle_level;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 1190. ��תÿ�����ż���Ӵ�
 * ����һ���ַ���s��������СдӢ����ĸ�����ţ���
 * ���㰴�մ������ڵ����˳����㷴תÿ��ƥ�������е��ַ��������������յĽ����
 * ע�⣬���Ľ���� ��Ӧ �����κ����š�
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "(abcd)"
 * �����"dcba"
 * ʾ�� 2��
 * <p>
 * ���룺s = "(u(love)i)"
 * �����"iloveu"
 * ʾ�� 3��
 * <p>
 * ���룺s = "(ed(et(oc))el)"
 * �����"leetcode"
 * ʾ�� 4��
 * <p>
 * ���룺s = "a(bcdefghijkl(mno)p)q"
 * �����"apmnolkjihgfedcbq"
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/5/26 10:52
 */
public class ReverseParentheses {
    public String reverseParentheses(String s) {
        Deque<String> stack = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // ����������ţ��� str ���뵽ջ�У����� str ��Ϊ�գ�������һ�㣻
            if (ch == '(') {
                stack.push(sb.toString());
                sb.setLength(0);
            // ����������ţ���˵���������˵�ǰ�㣬��Ҫ�� str ��ת�����ظ���һ�㡣
            // ����أ���ջ���ַ���������Ȼ�󽫷�ת��� str ƴ�ӵ�ջ���ַ���ĩβ���������ֵ�� str��
            } else if (ch == ')') {
                sb.reverse();
                sb.insert(0, stack.pop());
            // �����СдӢ����ĸ������ӵ� str ĩβ��
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
