package simple_level;

import java.util.Stack;

/**
 * ��������
 * ����ת�㷨������Ƶ���⡷ջ
 * 20. ��Ч������
 * ����һ��ֻ���� '('��')'��'{'��'}'��'['��']'?���ַ������ж��ַ����Ƿ���Ч��
 * <p>
 * ��Ч�ַ��������㣺
 * <p>
 * �����ű�������ͬ���͵������űպϡ�
 * �����ű�������ȷ��˳��պϡ�
 * ע����ַ����ɱ���Ϊ����Ч�ַ�����
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: "()"
 * ���: true
 * ʾ��?2:
 * <p>
 * ����: "()[]{}"
 * ���: true
 * ʾ��?3:
 * <p>
 * ����: "(]"
 * ���: false
 * ʾ��?4:
 * <p>
 * ����: "([)]"
 * ���: false
 * ʾ��?5:
 * <p>
 * ����: "{[]}"
 * ���: true
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/7 12:18 ����
 */
public class IsValid {
    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            }
            // pop�����ĺ�c����ͬ�͹�������Ч������
            // ע�⣡�������� ������һ��stack.isEmpty()������
            else if (stack.empty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.empty();
    }
}
