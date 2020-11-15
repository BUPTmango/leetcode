package middle_level;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * ����ջ
 * 402. �Ƶ�Kλ����
 * ����һ�����ַ�����ʾ�ķǸ�����num���Ƴ�������е� k λ���֣�ʹ��ʣ�µ�������С��
 *
 * ע��:
 *
 * num �ĳ���С�� 10002 �ҡ� k��
 * num ��������κ�ǰ���㡣
 * ʾ�� 1 :
 *
 * ����: num = "1432219", k = 3
 * ���: "1219"
 * ����: �Ƴ����������� 4, 3, �� 2 �γ�һ���µ���С������ 1219��
 * ʾ�� 2 :
 *
 * ����: num = "10200", k = 1
 * ���: "200"
 * ����: �Ƶ���λ�� 1 ʣ�µ�����Ϊ 200. ע������������κ�ǰ���㡣
 * ʾ�� 3 :
 *
 * ����: num = "10", k = 2
 * ���: "0"
 * ����: ��ԭ�����Ƴ����е����֣�ʣ��Ϊ�վ���0��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/15 2:53 ����
 */
public class RemoveKdigits {
    /**
     * ���õ���ջ˼·���
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        char[] chars = num.toCharArray();
        for (char c : chars) {
            // �Ƴ�������ӵ�����С��
            while (!deque.isEmpty() && deque.peekLast() > c && k > 0) {
                deque.removeLast();
                k--;
            }
            // ���Ԫ��
            deque.offerLast(c);
        }
        // ���k����ʣ�� �Ӻ����Ŀ�ʼɾ
        while (k-- > 0 && !deque.isEmpty()) {
            deque.removeLast();
        }
        if (deque.isEmpty()) {
            return "0";
        }
        // ���� ����
        char[] res = new char[deque.size()];
        int index = 0;
        // ���ɾ����ͷΪ0������
        boolean zeroHead = true;
        while (!deque.isEmpty()) {
            char c = deque.removeFirst();
            if (c == '0' && zeroHead) {
                continue;
            }
            zeroHead = false;
            res[index++] = c;
        }
        return index == 0 ? "0" : new String(Arrays.copyOf(res, index));
    }
}
