package middle_level;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 给定一组不含重复元素的整数数组?nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
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
 * @date 2020/4/11 11:52 上午
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
            // 不合适就回退上一步
            tmp.remove(tmp.size() - 1);
        }
    }
}
