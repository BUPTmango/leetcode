package middle_level.coder_gold;

import java.util.ArrayList;
import java.util.List;

/**
 * ������ 08.04. �ݼ�
 * �ݼ�����дһ�ַ���������ĳ���ϵ������Ӽ��������в������ظ���Ԫ�ء�
 *
 * ˵�����⼯���ܰ����ظ����Ӽ���
 *
 * ʾ��:
 *
 *  ���룺 nums = [1,2,3]
 *  �����
 * [
 *   [3],
 *  [1],
 *  [2],
 *  [1,2,3],
 *  [1,3],
 *  [2,3],
 *  [1,2],
 *  []
 * ]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/15 10:27 ����
 */
public class Subsets {

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int index) {
        res.add(new ArrayList<>(list));
        if (list.size() == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, index + 1);
            list.remove(list.size() - 1);
        }
    }
}
