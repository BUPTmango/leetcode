package simple_level;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * 输入: 3
 * 输出: [1,3,3,1]
 * <p>
 * 进阶：
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 *
 * @author mango
 * @create 2019-03-22 10:40 AM
 */
public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>(rowIndex + 1);
        list.add(1);

        if (rowIndex == 0) {
            return list;
        }

        list.add(1);
        if (rowIndex == 1) {
            return list;
        }

        for (int i = 2; i <= rowIndex; i++) {
            list.add(1);
            for (int j = i - 1; j > 0; j--) {
                list.set(j, list.get(j) + list.get(j - 1));
            }
        }
        return list;
    }
}