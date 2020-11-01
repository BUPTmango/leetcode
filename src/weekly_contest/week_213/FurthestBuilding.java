package weekly_contest.week_213;

/**
 * 5556. 可以到达的最远建筑
 * 给你一个整数数组 heights ，表示建筑物的高度。另有一些砖块 bricks 和梯子 ladders 。
 * <p>
 * 你从建筑物 0 开始旅程，不断向后面的建筑物移动，期间可能会用到砖块或梯子。
 * <p>
 * 当从建筑物 i 移动到建筑物 i+1（下标 从 0 开始 ）时：
 * <p>
 * 如果当前建筑物的高度 大于或等于 下一建筑物的高度，则不需要梯子或砖块
 * 如果当前建筑的高度 小于 下一个建筑的高度，您可以使用 一架梯子 或 (h[i+1] - h[i]) 个砖块
 * 如果以最佳方式使用给定的梯子和砖块，返回你可以到达的最远建筑物的下标（下标 从 0 开始 ）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：heights = [4,2,7,6,9,14,12], bricks = 5, ladders = 1
 * 输出：4
 * 解释：从建筑物 0 出发，你可以按此方案完成旅程：
 * - 不使用砖块或梯子到达建筑物 1 ，因为 4 >= 2
 * - 使用 5 个砖块到达建筑物 2 。你必须使用砖块或梯子，因为 2 < 7
 * - 不使用砖块或梯子到达建筑物 3 ，因为 7 >= 6
 * - 使用唯一的梯子到达建筑物 4 。你必须使用砖块或梯子，因为 6 < 9
 * 无法越过建筑物 4 ，因为没有更多砖块或梯子。
 * 示例 2：
 * <p>
 * 输入：heights = [4,12,2,7,3,18,20,3,19], bricks = 10, ladders = 2
 * 输出：7
 * 示例 3：
 * <p>
 * 输入：heights = [14,3,19,3], bricks = 17, ladders = 0
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= heights.length <= 105
 * 1 <= heights[i] <= 106
 * 0 <= bricks <= 109
 * 0 <= ladders <= heights.length
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/1 11:44 上午
 */
public class FurthestBuilding {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        return backtrack(heights, bricks, ladders, 1);
    }

    private int backtrack(int[] heights, int bricksRemain, int laddersRemain, int index) {
        // 走到最后了
        if (index == heights.length - 1) {
            return index;
        }
        // 砖头和梯子都用完了
        if (bricksRemain <= 0 && laddersRemain <= 0) {
            return index - 1;
        }

        int pre = heights[index - 1];
        int cur = heights[index];
        if (cur <= pre) {
            return backtrack(heights, bricksRemain, laddersRemain, index + 1);
        }
        // 使用砖头
        int brickWay = 0;
        if (bricksRemain - (cur - pre) >= 0) {
            brickWay = backtrack(heights, bricksRemain - (cur - pre), laddersRemain, index + 1);
        }
        // 使用梯子
        int ladderWay = 0;
        if (laddersRemain > 0) {
            ladderWay = backtrack(heights, bricksRemain, laddersRemain - 1, index + 1);
        }
        return Math.max(brickWay, ladderWay);
    }

    public static void main(String[] args) {
        FurthestBuilding building = new FurthestBuilding();
        int[] heights = new int[]{4,12,2,7,3,18,20,3,19};
        System.out.println(building.furthestBuilding(heights, 10, 2));
    }
}
