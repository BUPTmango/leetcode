package simple_level;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 *
 * @author mango
 * @create 2019-03-22 9:58 AM
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> big = new ArrayList<>();
        if (numRows <= 0) {
            return big;
        }
        for (int i = 0; i < numRows; i++) {
            List<Integer> small = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                //如果为该行的第一位或最后一位，值为 1，否则为其上一行的对应列数值与上一轮对应列数值前一列之和
                if (j == 0 || j == i) {
                    small.add(1);
                } else {
                    small.add(big.get(i - 1).get(j) + big.get(i - 1).get(j - 1));
                }
            }
            big.add(small);
        }
        return big;
    }
}