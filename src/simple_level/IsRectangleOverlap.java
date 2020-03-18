package simple_level;

/**
 * 836. 矩形重叠
 * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
 *
 * 如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
 *
 * 给出两个矩形，判断它们是否重叠并返回结果。
 *
 * 示例 1：
 *
 * 输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * 输出：true
 * 示例 2：
 *
 * 输入：rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * 输出：false
 * 说明：
 *
 * 两个矩形 rec1 和 rec2 都以含有四个整数的列表的形式给出。
 * 矩形中的所有坐标都处于 -10^9 和 10^9 之间。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/18 9:03 上午
 */
public class IsRectangleOverlap {
    /**
     * 如果两个矩形重叠，那么它们重叠的区域一定也是一个矩形，
     * 那么这代表了两个矩形与 xx 轴平行的边（水平边）投影到 xx 轴上时会有交集，
     * 与 yy 轴平行的边（竖直边）投影到 yy 轴上时也会有交集。
     * 因此，我们可以将问题看作一维线段是否有交集的问题。
     *
     * @param rec1
     * @param rec2
     * @return
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) &&
                Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));
    }
}
