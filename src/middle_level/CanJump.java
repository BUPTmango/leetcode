package middle_level;

/**
 * 55. 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例?1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例?2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/7 9:57 上午
 */
public class CanJump {
    /**
     * 从后向前找
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int len = nums.length;
        int[] check = new int[len];
        // 设置最后一个是肯定能到达的
        check[len - 1] = 1;
        // 0:unknown 1:reachable 2:unreachable
        for (int i = len - 1; i >= 0; i--) {
            int l = nums[i];
            for (int j = 0; j <= l; j++) {
                // 有一种方式可以到达即可
                if (check[i + j] == 1) {
                    check[i] = 1;
                    break;
                }
            }
        }
        return check[0] == 1 ? true : false;
    }

    public boolean canJump_better(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int len = nums.length;
        // 定义一个已经能到达的变量
        int lastPos = len - 1;
        for (int i = len - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0 ? true : false;
    }

}
