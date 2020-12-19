package hard_level;

/**
 * 水和容器相关
 * 42. 接雨水
 * 给定n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == height.length
 * 0 <= n <= 3 * 104
 * 0 <= height[i] <= 105
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/2 10:03 下午
 */
public class Trap {
    /**
     * 双指针 边走边算
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int n = height.length;
        int left = 0, right = n - 1;
        int ans = 0;

        int l_max = height[0];
        int r_max = height[n - 1];

        while (left <= right) {
            // 更新左右柱子的最大高度
            l_max = Math.max(l_max, height[left]);
            r_max = Math.max(r_max, height[right]);
            // 取左右较小的计算雨水
            if (l_max < r_max) {
                ans += l_max - height[left++];
            } else {
                ans += r_max - height[right--];
            }
        }

        return ans;
    }
}
