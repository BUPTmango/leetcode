package middle_level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 《玩转算法面试视频例题》 树形问题 回溯算法 排列问题
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/12 7:50 下午
 */
public class PermuteUnique {
    List<List<Integer>> res = new ArrayList<>();
    /**
     * 因为回溯的过程中nums数据结构有变化 所以用visited来记录访问过的元素
     */
    int[] visited;
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        // 用来记录是否访问过
        visited = new int[nums.length];
        // 进行排序 方便剪枝
        Arrays.sort(nums);
        backtrack(nums);
        return res;
    }

    private void backtrack(int[] nums) {
        // 全部取走了 终止条件
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        // 只要没访问过就遍历 递归逻辑
        for (int i = 0; i < nums.length; i++) {
            // 注意！！！！ 区别！！ 如果选择的元素是刚刚上次被撤销的回溯回来的 跳过
            if (i > 0 && nums[i - 1] == nums[i] && visited[i - 1] == 0) {
                continue;
            }
            // 已经访问过 不再选择
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            list.add(nums[i]);
            backtrack(nums);
            // 回溯
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
    }
}
