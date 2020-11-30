package middle_level;

import java.util.PriorityQueue;

/**
 * 767. �ع��ַ���
 * ����һ���ַ���S������Ƿ��������Ų����е���ĸ��ʹ�������ڵ��ַ���ͬ��
 * <p>
 * �����У����������еĽ�����������У����ؿ��ַ�����
 * <p>
 * ʾ��1:
 * <p>
 * ����: S = "aab"
 * ���: "aba"
 * ʾ�� 2:
 * <p>
 * ����: S = "aaab"
 * ���: ""
 * ע��:
 * <p>
 * S ֻ����Сд��ĸ���ҳ�����[1, 500]�����ڡ�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/30 10:49 ����
 */
public class ReorganizeString {
    /**
     * �������ѵ�̰���㷨
     *
     * @param S
     * @return
     */
    public String reorganizeString(String S) {
        if (S.length() < 2) {
            return S;
        }
        int[] counts = new int[26];
        int maxCount = 0;
        int length = S.length();
        // ͳ��ÿ���ַ��ĳ��ִ���
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            counts[c - 'a']++;
            maxCount = Math.max(maxCount, counts[c - 'a']);
        }
        // �������һ����ĸ�ĳ��ִ�������(n+1)/2�����޷������Ų���ĸʹ�����ڵ���ĸ������ͬ�����ؿ��ַ���
        if (maxCount > (length + 1) / 2) {
            return "";
        }
        // �����ִ�������������
        PriorityQueue<Character> queue = new PriorityQueue<>((letter1, letter2) -> counts[letter2 - 'a'] - counts[letter1 - 'a']);
        for (char c = 'a'; c <= 'z'; c++) {
            if (counts[c - 'a'] > 0) {
                queue.offer(c);
            }
        }
        StringBuffer sb = new StringBuffer();
        while (queue.size() > 1) {
            // ÿ��ȡ��������ĸ ƴ�ӵ��ַ�����
            char letter1 = queue.poll();
            char letter2 = queue.poll();
            sb.append(letter1);
            sb.append(letter2);
            int index1 = letter1 - 'a', index2 = letter2 - 'a';
            counts[index1]--;
            counts[index2]--;
            if (counts[index1] > 0) {
                queue.offer(letter1);
            }
            if (counts[index2] > 0) {
                queue.offer(letter2);
            }
        }
        if (queue.size() > 0) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }
}
