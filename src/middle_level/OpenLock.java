package middle_level;

import java.util.*;

/**
 * ˫��BFS
 * 752. ��ת����
 * ����һ�������ĸ�Բ�β��ֵ�ת������ÿ�����ֶ���10�����֣� '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' ��ÿ�����ֿ���������ת������� '9' ��Ϊ? '0'��'0' ��Ϊ '9' ��ÿ����ת��ֻ����תһ�����ֵ�һλ���֡�
 * <p>
 * ���ĳ�ʼ����Ϊ '0000' ��һ�������ĸ����ֵ����ֵ��ַ�����
 * <p>
 * �б� deadends ������һ���������֣�һ�����ֵ����ֺ��б�����κ�һ��Ԫ����ͬ����������ᱻ�����������޷��ٱ���ת��
 * <p>
 * �ַ��� target ������Խ��������֣�����Ҫ������С����ת���������������β��ܽ��������� -1��
 * <p>
 * ?
 * <p>
 * ʾ�� 1:
 * <p>
 * ���룺deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * �����6
 * ���ͣ�
 * ���ܵ��ƶ�����Ϊ "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"��
 * ע�� "0000" -> "0001" -> "0002" -> "0102" -> "0202" �����������ǲ��ܽ����ģ�
 * ��Ϊ�������� "0102" ʱ������ͻᱻ������
 * ʾ�� 2:
 * <p>
 * ����: deadends = ["8888"], target = "0009"
 * �����1
 * ���ͣ�
 * �����һλ������תһ�μ��� "0000" -> "0009"��
 * ʾ�� 3:
 * <p>
 * ����: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * �����-1
 * ���ͣ�
 * �޷���ת��Ŀ�������Ҳ���������
 * ʾ�� 4:
 * <p>
 * ����: deadends = ["0000"], target = "8888"
 * �����-1
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * �����б� deadends �ĳ��ȷ�ΧΪ [1, 500]��
 * Ŀ������ target ������ deadends ֮�С�
 * ÿ�� deadends �� target �е��ַ��������ֻ��� 10,000 �����ܵ���� '0000' �� '9999' �в�����
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/6 6:30 ����
 */
public class OpenLock {
    /**
     * �����������
     * ���ǿ��Խ� 0000 �� 9999 �� 10000 ״̬����ͼ�ϵ� 10000 ���ڵ㣬
     * �����ڵ�֮�����һ���ߣ����ҽ����������ڵ��Ӧ��״ֻ̬�� 1 λ��ͬ��
     * �Ҳ�ͬ����λ��� 1������ 0 �� 9 Ҳ��� 1 ��������������������ڵ���������� deadends �С�
     * ��ô���յĴ𰸼�Ϊ 0000 �� target �����·����
     * <p>
     * �����ù�������������ҵ����·������ 0000 ��ʼ������
     * ����ÿһ��״̬����������չ����� 8 ��״̬���������ĵ� i = 0, 1, 2, 3 λ���� 1 ����� 1��
     * ����Щ״̬��û�����������Ҳ��� deadends �е�״̬ȫ�����뵽�����У�����������������
     * ע�� 0000 �����п���Ҳ�� deadends �С�
     *
     * @param deadends
     * @param target
     * @return
     */
    public int openLock(String[] deadends, String target) {
        // ��deadends����set�� dead
        Set<String> dead = new HashSet();
        Collections.addAll(dead, deadends);

        Queue<String> queue = new LinkedList();
        // ��ӳ�ʼ״̬
        queue.offer("0000");

        // ��ʾ�Ѿ����ֹ�������
        Set<String> seen = new HashSet();
        seen.add("0000");

        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int m = 0; m < size; m++) {
                String node = queue.poll();
                // �������dead��������
                if (dead.contains(node)) {
                    continue;
                }
                if (node.equals(target)) {
                    return depth;
                }
                // �ĸ�����
                for (int i = 0; i < 4; ++i) {
                    // ÿ�����ӿ��Խ������²��� Ҳ����1������-1
                    for (int d = -1; d <= 1; d += 2) {
                        int y = ((node.charAt(i) - '0') + d + 10) % 10;
                        String nei = node.substring(0, i) + ("" + y) + node.substring(i + 1);
                        if (!seen.contains(nei)) {
                            seen.add(nei);
                            queue.offer(nei);
                        }
                    }
                }
            }
            depth++;
        }
        return -1;
    }


    /**
     * ˫��BFS
     * ��Ϊֱ���յ� ����ʹ��˫��BFS
     * @param deadends
     * @param target
     * @return
     */
    public int openLock_another(String[] deadends, String target) {
        // ��deadends����set�� dead
        Set<String> dead = new HashSet();
        Collections.addAll(dead, deadends);

        // �ü��ϲ��ö��� ���Կ����ж�Ԫ���Ƿ����
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        // һ�������� һ������յ� �����ֻ����� һ���������� һ���������� ��ͬѰ·
        q1.add("0000");
        q2.add(target);

        // ��ʾ�Ѿ����ֹ�������
        Set<String> seen = new HashSet();

        int step = 0;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            // set�ڱ����в����޸ģ�ʹ��temp�洢��ɢ���
            Set<String> temp = new HashSet<>();

            // ��q1�е����нڵ�����Χ��ɢ
            for (String cur : q1) {
                // �������dead��������
                if (dead.contains(cur)) {
                    continue;
                }
                if (q2.contains(cur)) {
                    return step;
                }
                seen.add(cur);

                // �ĸ�����
                for (int i = 0; i < 4; ++i) {
                    // ÿ�����ӿ��Խ������²��� Ҳ����1������-1
                    for (int d = -1; d <= 1; d += 2) {
                        int y = ((cur.charAt(i) - '0') + d + 10) % 10;
                        String nei = cur.substring(0, i) + ("" + y) + cur.substring(i + 1);
                        if (!seen.contains(nei)) {
                            temp.add(nei);
                        }
                    }
                }
            }
            step++;
            // ���ｻ��q1q2����һ�־�����ɢq2
            // temp���൱����q1
            q1 = q2;
            q2 = temp;
        }
        return -1;
    }
}
