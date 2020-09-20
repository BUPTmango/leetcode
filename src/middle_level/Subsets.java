package middle_level;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. �Ӽ�
 * ����һ�鲻���ظ�Ԫ�ص���������?nums�����ظ��������п��ܵ��Ӽ����ݼ�����
 *
 * ˵�����⼯���ܰ����ظ����Ӽ���
 *
 * ʾ��:
 *
 * ����: nums = [1,2,3]
 * ���:
 * [
 *   [3],
 * ? [1],
 * ? [2],
 * ? [1,2,3],
 * ? [1,3],
 * ? [2,3],
 * ? [1,2],
 * ? []
 * ]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/11 11:52 ����
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<>());
        return res;

    }


    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            // �����ʾͻ�����һ��
            tmp.remove(tmp.size() - 1);
        }
    }
}
