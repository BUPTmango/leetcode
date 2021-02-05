package hard_level;

/**
 * 45. 跳跃游戏 II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *     从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/2/5 7:52 下午
 */
public class Jump {
    public int jump(int[] nums) {
        int n = nums.length;
        // 站在索引i 最多能跳到索引end
        int end = 0;
        // 从索引[i..end]起跳 最远能到的距离
        int farthest = 0;
        // 记录跳跃次数
        int jumps = 0;
        // 如果访问最后一个元素，在边界正好为最后一个位置的情况下，我们会增加一次「不必要的跳跃次数」，因此我们不必访问最后一个元素。
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(nums[i] + i, farthest);
            // 我们从左到右遍历数组，到达边界时，更新边界并将跳跃次数增加 1。
            if (end == i) {
                jumps++;
                end = farthest;
            }
        }
        return jumps;
    }
}
