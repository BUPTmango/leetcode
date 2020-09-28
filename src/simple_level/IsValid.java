package simple_level;

import java.util.Stack;

/**
 * ����ת�㷨������Ƶ���⡷ջ
 * 20. ��Ч������
 * ����һ��ֻ���� '('��')'��'{'��'}'��'['��']'?���ַ������ж��ַ����Ƿ���Ч��
 *
 * ��Ч�ַ��������㣺
 *
 * �����ű�������ͬ���͵������űպϡ�
 * �����ű�������ȷ��˳��պϡ�
 * ע����ַ����ɱ���Ϊ����Ч�ַ�����
 *
 * ʾ�� 1:
 *
 * ����: "()"
 * ���: true
 * ʾ��?2:
 *
 * ����: "()[]{}"
 * ���: true
 * ʾ��?3:
 *
 * ����: "(]"
 * ���: false
 * ʾ��?4:
 *
 * ����: "([)]"
 * ���: false
 * ʾ��?5:
 *
 * ����: "{[]}"
 * ���: true
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/7 12:18 ����
 */
public class IsValid {
    public boolean isValid(String s) {
        if(s.isEmpty())
            return true;
        Stack<Character> stack=new Stack<>();
        for(char c : s.toCharArray()){
            if(c=='(') {
                stack.push(')');
            } else if(c=='{') {
                stack.push('}');
            } else if(c=='[') {
                stack.push(']');
            }
            // pop�����ĺ�c����ͬ�͹�������Ч������
            else if(stack.empty()||c!=stack.pop()) {
                return false;
            }
        }
        if(stack.empty())
            return true;
        return false;
    }
}
