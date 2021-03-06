package middle_level;

import java.util.ArrayList;
import java.util.List;

/**
 * 《玩转算法面试视频例题》 树形问题 回溯算法 排列问题
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/17 12:28 下午
 */
public class Permute {
    List<List<Integer>> res = new ArrayList<>();
    /**
     * 因为回溯的过程中nums数据结构有变化 所以用visited来记录访问过的元素
     */
    int[] visited;
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        // 用来记录是否访问过
        visited = new int[nums.length];
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
            if (visited[i] == 0) {
                visited[i] = 1;
                list.add(nums[i]);
                backtrack(nums);
                // 回溯
                list.remove(list.size() - 1);
                visited[i] = 0;
            }
        }
    }
}
