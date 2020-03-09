package simple_level.jianzhi_offer;

import java.util.LinkedList;

/**
 * ������62. ԲȦ�����ʣ�µ�����
 * 0,1,,n-1��n�������ų�һ��ԲȦ��������0��ʼ��ÿ�δ����ԲȦ��ɾ����m�����֡�������ԲȦ��ʣ�µ����һ�����֡�
 *
 * ���磬0��1��2��3��4��5���������һ��ԲȦ��������0��ʼÿ��ɾ����3�����֣���ɾ����ǰ4������������2��0��4��1��������ʣ�µ�������3��
 * ?
 * ʾ�� 1��
 *
 * ����: n = 5, m = 3
 * ���:?3
 * ʾ�� 2��
 *
 * ����: n = 10, m = 17
 * ���:?2
 *
 * ���ƣ�
 *
 * 1 <= n?<= 10^5
 * 1 <= m <= 10^6
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/9 9:41 ����
 */
public class LastRemaining {
    /**
     * ͨ��������ģ��
     * ���ǳ���ʱ������
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining_linkedList(int n, int m) {
        if (n == 0 || m == 0) {
            return -1;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        // ��¼Ҫɾ��������
        int removeIndex = 0;
        while (list.size() > 1) {
            removeIndex = (removeIndex + m - 1) % list.size();
            list.remove(removeIndex);
        }
        return list.get(0);
    }

    /**
     * Լɪ������
     * ��ʽ�� f(n,m) = (f(n-1, m) + m) % n      �������n��һֱ�ڱ仯�ģ����ǳ���
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining_better(int n, int m) {
        if (n == 0 || m == 0) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }
}
