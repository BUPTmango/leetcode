package middle_level;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. ����ܺ� III
 * �ҳ��������֮��Ϊ?n ��?k?��������ϡ������ֻ������ 1 -?9 ��������������ÿ������в������ظ������֡�
 *
 * ˵����
 *
 * �������ֶ�����������
 * �⼯���ܰ����ظ�����ϡ�?
 * ʾ�� 1:
 *
 * ����: k = 3, n = 7
 * ���: [[1,2,4]]
 * ʾ�� 2:
 *
 * ����: k = 3, n = 9
 * ���: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/12 10:30 ����
 */
public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), k, 1, n);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int k, int start, int n) {
        // ��ֹ������������������������������Ҳûʲô������
        if (list.size() == k || n <= 0) {
            // ����ҵ�һ����ʵľͰ������뵽����list��
            if (list.size() == k && n == 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            // ѡ��ǰֵ
            list.add(i);
            // �ݹ�
            dfs(res, list, k, i + 1, n - i);
            // ����ѡ��
            list.remove(list.size() - 1);
        }
    }
}
