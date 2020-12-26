package hard_level;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为[2,1,5,6,2,3]。
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为10个单位。
 *
 * 示例:
 *
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/26 1:54 下午
 */
public class LargestRectangleArea {
    /**
     * 单调栈
     * https://www.bilibili.com/video/BV1eb411M7Gm
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        // 放-1进去 边界情况好处理
        stack.push(-1);
        int curIndex = 0;

        while (curIndex < n) {
            // 如果不满足递增 就把前面的拿出来算一下max
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[curIndex]) {
                max = Math.max(max, heights[stack.pop()] * (curIndex - stack.peek() - 1));
            }
            stack.push(curIndex++);
        }

        // 剩下的全部是递增的 更新一下max
        while (stack.peek() != -1) {
            max = Math.max(max, heights[stack.pop()] * (n - stack.peek() - 1));
        }

        return max;
    }
}
