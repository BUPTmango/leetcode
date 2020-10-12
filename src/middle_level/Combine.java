package middle_level;

import java.util.ArrayList;
import java.util.List;

/**
 * 《玩转算法面试视频例题》 树形问题 回溯算法 组合问题
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/8 9:29 上午
 */
public class Combine {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        // 从 1 开始是题目的设定
        backtrack(n, k, 1);
        return res;
    }

    private void backtrack(int n, int k, int index) {
        // 选完了
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        // 因为是组合问题 每次从上次选完之后的位置开始遍历即可
        // ！！！！ 剪枝    原来 i <= n， 可以进行剪枝，因为后边的分支已经取不到剩下的那么多元素了
        // 还有k - list.size()个空位 所以i <= n - (k - list.size()) + 1
        for (int i = index; i <= n - (k - list.size()) + 1; i++) {
            list.add(i);
            // 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
            backtrack(n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
