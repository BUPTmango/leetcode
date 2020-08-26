package middle_level;

import java.util.ArrayList;
import java.util.List;

/**
 * 491. 递增子序列
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 *
 * 示例:
 *
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/8/26 9:33 上午
 */
public class FindSubsequences {
    hahahahahahahaha
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0, Integer.MIN_VALUE, nums);
        return ans;
    }

    public void dfs(int cur, int last, int[] nums) {
        // 指针遍历完当前数组之后 添加一条记录
        if (cur == nums.length) {
            // 递增子序列的长度至少是2
            if (temp.size() >= 2) {
                ans.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        // 如果选择当前元素，那么把当前元素加入到 temp 中，然后递归下一个位置，在递归结束后，应当把 temp 的最后一个元素删除进行回溯
        if (nums[cur] >= last) {
            temp.add(nums[cur]);
            dfs(cur + 1, nums[cur], nums);
            temp.remove(temp.size() - 1);
        }
        // 不选当前元素 直接跳到下一步
        // 只有当当前的元素不等于上一个选择的元素的时候，才考虑不选择当前元素，直接递归后面的元素   防止重复
        if (nums[cur] != last) {
            dfs(cur + 1, last, nums);
        }
    }
}
