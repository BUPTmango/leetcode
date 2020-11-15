package middle_level;

import java.util.Stack;

/**
 * ����ջ
 * 1081. ��ͬ�ַ�����С������
 * �����ַ��� text�а��ֵ���������С�������У��������а���text�����в�ͬ�ַ�һ�Ρ�
 *
 * ʾ�� 1��
 *
 * ���룺"cdadabcc"
 * �����"adbc"
 * ʾ�� 2��
 *
 * ���룺"abcd"
 * �����"abcd"
 * ʾ�� 3��
 *
 * ���룺"ecbacba"
 * �����"eacb"
 * ʾ�� 4��
 *
 * ���룺"leetcode"
 * �����"letcod"
 * 
 * ��ʾ��
 *
 * 1 <= text.length <= 1000
 * text��СдӢ����ĸ���
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/15 4:15 ����
 */
public class SmallestSubsequence {
    public String smallestSubsequence(String s) {
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            Character c = s.charAt(i);
            // ���ջ���Ѿ����� ֱ������
            if (stack.contains(c)) {
                continue;
            }
            // ���滹�л�����ֵĲ���pop
            while (!stack.empty() && c < stack.peek() && s.indexOf(stack.peek(), i) != -1) {
                stack.pop();
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SmallestSubsequence s = new SmallestSubsequence();
        System.out.println(s.smallestSubsequence("cdadabcc"));
    }
}
