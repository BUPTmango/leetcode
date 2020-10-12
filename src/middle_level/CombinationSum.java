package middle_level;

import java.util.ArrayList;
import java.util.List;

/**
 * 《玩转算法面试视频例题》 树形问题 回溯算法 组合问题
 * 39. 组合总和
 * 给定一个无重复元素的数组?candidates?和一个目标数?target?，找出?candidates?中所有可以使数字和为?target?的组合。
 *
 * candidates?中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括?target）都是正整数。
 * 解集不能包含重复的组合。?
 * 示例?1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例?2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 * ? [2,2,2,2],
 * ? [2,3,3],
 * ? [3,5]
 * ]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/6/22 9:15 上午
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
        // 递归的终止条件 因为题目上说的是正整数
        if (target < 0) {
            return;
        }
        // target==0也就是找到了目标结果
        if (target == 0) {
            lists.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < candidates.length; i++) {
                list.add(candidates[i]);
                // 注意！！！ 因为每个数字都可以使用无数次，所以递归还可以从当前元素开始
                process(i, candidates, target - candidates[i], list);
                // 进行回溯 要删除最后一个节点
                list.remove(list.size() - 1);
            }
        }

    }
}
