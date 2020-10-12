package middle_level;

import java.util.ArrayList;
import java.util.List;

/**
 * ����ת�㷨������Ƶ���⡷ �������� �����㷨 �������
 * 77. ���
 * ������������ n �� k������ 1 ... n �����п��ܵ� k ��������ϡ�
 *
 * ʾ��:
 *
 * ����: n = 4, k = 2
 * ���:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/8 9:29 ����
 */
public class Combine {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        // �� 1 ��ʼ����Ŀ���趨
        backtrack(n, k, 1);
        return res;
    }

    private void backtrack(int n, int k, int index) {
        // ѡ����
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        // ��Ϊ��������� ÿ�δ��ϴ�ѡ��֮���λ�ÿ�ʼ��������
        // �������� ��֦    ԭ�� i <= n�� ���Խ��м�֦����Ϊ��ߵķ�֧�Ѿ�ȡ����ʣ�µ���ô��Ԫ����
        // ����k - list.size()����λ ����i <= n - (k - list.size()) + 1
        for (int i = index; i <= n - (k - list.size()) + 1; i++) {
            list.add(i);
            // ��һ�����������õ��������Ҫ�� 1����Ϊ���������������ظ���Ԫ��
            backtrack(n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
