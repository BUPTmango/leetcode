package middle_level;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 316. ȥ���ظ���ĸ
 * ����һ���ַ��� s ������ȥ���ַ������ظ�����ĸ��ʹ��ÿ����ĸֻ����һ�Ρ��豣֤ ���ؽ�����ֵ�����С��Ҫ���ܴ��������ַ������λ�ã���
 * ʾ�� 1��
 *
 * ���룺s = "bcabc"
 * �����"abc"
 * ʾ�� 2��
 *
 * ���룺s = "cbacdcbc"
 * �����"acdb"
 *
 * ��ʾ��
 *
 * 1 <= s.length <= 104
 * s ��СдӢ����ĸ���
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/20 11:19 ����
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int len = s.length();
        char[] charArray = s.toCharArray();
        // ���ÿ���ַ������ֵ�λ��
        int[] lastIndex = new int[26];
        for (int i = 0; i < len; i++) {
            lastIndex[charArray[i] - 'a'] = i;
        }

        Deque<Character> stack = new ArrayDeque<>();
        // ���ÿ���ַ��ǲ����Ѿ����ʹ�
        boolean[] visited = new boolean[26];
        for (int i = 0; i < len; i++) {
            // ����Ѿ����ʹ�����ַ� ����
            if (visited[charArray[i] - 'a']) {
                continue;
            }
            // ��������Ԫ�ر�ջ��С ���� ջ��Ԫ����֮�󻹳��ֹ� ��pop
            while (!stack.isEmpty() && stack.peekLast() > charArray[i] && lastIndex[stack.peekLast() - 'a'] > i) {
                Character top = stack.removeLast();
                visited[top - 'a'] = false;
            }
            stack.addLast(charArray[i]);
            visited[charArray[i] - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
