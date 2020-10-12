package middle_level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����ת�㷨������Ƶ���⡷ �������� �����㷨 �������
 * 40. ����ܺ� II
 * ����һ������candidates��һ��Ŀ����target���ҳ�candidates�����п���ʹ���ֺ�Ϊtarget����ϡ�
 *
 * candidates�е�ÿ��������ÿ�������ֻ��ʹ��һ�Ρ�
 *
 * ˵����
 *
 * �������֣�����Ŀ������������������
 * �⼯���ܰ����ظ�����ϡ�
 * ʾ��1:
 *
 * ����: candidates =[10,1,2,7,6,1,5], target =8,
 * ����⼯Ϊ:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * ʾ��2:
 *
 * ����: candidates =[2,5,2,1,2], target =5,
 * ����⼯Ϊ:
 * [
 *  [1,2,2],
 *  [5]
 * ]
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/combination-sum-ii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/12 9:08 ����
 */
public class CombinationSum2 {
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target < 0) {
            return lists;
        }

        List<Integer> list = new ArrayList<>();
        // �������� �����ж��ظ����м�֦
        Arrays.sort(candidates);
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
                // ���֦����ȥ candidates[i] С�� 0����ȥ����� candidates[i + 1]��candidates[i + 2] �϶�ҲС�� 0������� break
                if (target - candidates[i] < 0) {
                    break;
                }
                // �����ظ�����ļ�֦����
                // С��֦��ͬһ����ͬ��ֵ�Ľ�㣬�ӵ� 2 ����ʼ����ѡ�����٣����һ�������ظ�������������� continue
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                list.add(candidates[i]);
                // ע�⣡���� ���ֲ��ظ�
                process(i + 1, candidates, target - candidates[i], list);
                // ���л��� Ҫɾ�����һ���ڵ�
                list.remove(list.size() - 1);
            }
        }
    }
}
