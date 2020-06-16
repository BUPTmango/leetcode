package middle_level;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 406. 根据身高重建队列
 *
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 输入:
 [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

 输出:
 [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

 * @author Wang Guolong
 * @version 1.0
 * @date 2020/6/16 9:04 上午
 */
public class ReconstructQueue {
    /**
     * 算法：
     * 排序：
     * 按高度降序排列。
     * 在同一高度的人中，按 k 值的升序排列。
     * 逐个地把它们放在输出队列中，索引等于它们的 k 值。
     * 返回输出队列
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            // if the heights are equal, compare k-values
            return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
        });

        List<int[]> output = new LinkedList<>();
        for(int[] p : people){
            output.add(p[1], p);
        }

        int n = people.length;
        return output.toArray(new int[n][2]);

    }
}
