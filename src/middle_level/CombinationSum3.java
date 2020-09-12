package middle_level;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III
 * 找出所有相加之和为?n 的?k?个数的组合。组合中只允许含有 1 -?9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。?
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/12 10:30 上午
 */
public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), k, 1, n);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int k, int start, int n) {
        // 终止条件，如果满足这个条件，再往下找也没什么意义了
        if (list.size() == k || n <= 0) {
            // 如果找到一组合适的就把他加入到集合list中
            if (list.size() == k && n == 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            // 选择当前值
            list.add(i);
            // 递归
            dfs(res, list, k, i + 1, n - i);
            // 撤销选择
            list.remove(list.size() - 1);
        }
    }
}
