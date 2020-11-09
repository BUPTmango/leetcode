package middle_level;

import java.util.*;

/**
 * 973. 最接近原点的 K 个点
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 *
 * （这里，平面上两点之间的距离是欧几里德距离。）
 *
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 *
 * 示例 1：
 *
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 * 示例 2：
 *
 * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 *
 * 提示：
 *
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/9 8:59 上午
 */
public class KClosest {
    public int[][] kClosest(int[][] points, int K) {
        // 定义一个优先队列 注意这里是降序
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> {
            int distance1 = o1[0] * o1[0] + o1[1] * o1[1];
            int distance2 = o2[0] * o2[0] + o2[1] * o2[1];
            return distance2 - distance1;
        });

        for (int[] point : points) {
            heap.add(point);
            if (heap.size() > K) {
                heap.poll();
            }
        }

        int[][] res = new int[heap.size()][2];
        int index = 0;
        while (!heap.isEmpty()) {
            res[index] = heap.poll();
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        KClosest k = new KClosest();
        int[][] points = new int[][]{{1,3}, {-2,2}};
        int K = 1;
        int[][] res = k.kClosest(points, K);
        Arrays.stream(res).forEach(System.out::println);
    }
}
