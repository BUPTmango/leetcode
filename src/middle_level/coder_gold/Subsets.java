package middle_level.coder_gold;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.04. 幂集
 * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 *  输入： nums = [1,2,3]
 *  输出：
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
 * @date 2020/10/15 10:27 上午
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
