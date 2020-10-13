package simple_level;

import java.util.LinkedList;
import java.util.List;

/**
 * ����ת�㷨������Ƶ���⡷ �������� �����㷨 �������
 * 401. �������ֱ�
 * �������ֱ����� 4 �� LED ���� Сʱ��0-11�����ײ��� 6 �� LED ���� ���ӣ�0-59����
 * <p>
 * ÿ�� LED ����һ�� 0 �� 1�����λ���Ҳࡣ
 * <p>
 * <p>
 * ���磬����Ķ������ֱ��ȡ ��3:25����
 * <p>
 * ����һ���Ǹ����� n ����ǰ LED ���ŵ��������������п��ܵ�ʱ�䡣
 * <p>
 * <p>
 * ʾ����
 * <p>
 * ����: n = 1
 * ����: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/13 9:30 ����
 */
public class ReadBinaryWatch {
    private List<String> res = new LinkedList<>();

    public List<String> readBinaryWatch(int num) {
        res.clear();
        dfs(num, 0, 0, 1, 1, new LinkedList<>(), new LinkedList<>());
        return res;
    }

    // h��Сʱ����m��������
    // hstart��mstart����hstart��mstart��ʼ��������Сʱ�ͷ���
    // hours��ѡ�е�Сʱ��minutes��ѡ�еķ���
    private void dfs(int num, int h, int m, int hstart, int mstart, LinkedList<Integer> hours, LinkedList<Integer> minutes) {
        if (hours.size() + minutes.size() == num) {
            if (h < 12 && m < 60) {
                res.add(String.format("%d:%02d", h, m));
            }
            return;
        }
        for (int i = hstart; i <= 8; i <<= 1) {
            hours.addLast(i);
            dfs(num, h + i, m, i << 1, mstart, hours, minutes);
            hours.removeLast();
        }
        for (int i = mstart; i <= 32; i <<= 1) {
            minutes.addLast(i);
            // hstart ֱ������Ϊ16��>=12)�������ظ�����
            dfs(num, h, m + i, 16, i << 1, hours, minutes);
            minutes.removeLast();
        }
    }
}
