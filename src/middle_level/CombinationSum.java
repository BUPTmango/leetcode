package middle_level;

import java.util.ArrayList;
import java.util.List;

/**
 * ����ת�㷨������Ƶ���⡷ �������� �����㷨 �������
 * 39. ����ܺ�
 * ����һ�����ظ�Ԫ�ص�����?candidates?��һ��Ŀ����?target?���ҳ�?candidates?�����п���ʹ���ֺ�Ϊ?target?����ϡ�
 *
 * candidates?�е����ֿ����������ظ���ѡȡ��
 *
 * ˵����
 *
 * �������֣�����?target��������������
 * �⼯���ܰ����ظ�����ϡ�?
 * ʾ��?1:
 *
 * ����: candidates = [2,3,6,7], target = 7,
 * ����⼯Ϊ:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * ʾ��?2:
 *
 * ����: candidates = [2,3,5], target = 8,
 * ����⼯Ϊ:
 * [
 * ? [2,2,2,2],
 * ? [2,3,3],
 * ? [3,5]
 * ]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/6/22 9:15 ����
 */
public class CombinationSum {

    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target < 0) {
            return lists;
        }

        List<Integer> list = new ArrayList<>();
        process(0, candidates, target, list);
        return lists;
    }

    private void process(int start, int[] candidates, int target, List<Integer> list) {
        // �ݹ����ֹ���� ��Ϊ��Ŀ��˵����������
        if (target < 0) {
            return;
        }
        // target==0Ҳ�����ҵ���Ŀ����
        if (target == 0) {
            lists.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < candidates.length; i++) {
                list.add(candidates[i]);
                // ע�⣡���� ��Ϊÿ�����ֶ�����ʹ�������Σ����Եݹ黹���Դӵ�ǰԪ�ؿ�ʼ
                process(i, candidates, target - candidates[i], list);
                // ���л��� Ҫɾ�����һ���ڵ�
                list.remove(list.size() - 1);
            }
        }

    }
}
