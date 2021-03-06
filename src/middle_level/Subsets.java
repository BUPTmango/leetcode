package middle_level;

import java.util.ArrayList;
import java.util.List;

/**
 * 《玩转算法面试视频例题》 树形问题 回溯算法 组合问题
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

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int index) {
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
