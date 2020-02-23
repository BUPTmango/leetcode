package simple_level;

import java.util.ArrayList;
import java.util.List;

/**
 * 412
 * Fizz Buzz
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 *
 * 1. 如果?n?是3的倍数，输出“Fizz”；
 *
 * 2. 如果?n?是5的倍数，输出“Buzz”；
 *
 * 3.如果?n?同时是3和5的倍数，输出 “FizzBuzz”。
 *
 * 示例：
 *
 * n = 15,
 *
 * 返回:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/18 9:38 上午
 */
public class FizzBuzz {
    /**
     * 注意起始点 是从1开始的
     * @param n
     * @return
     */
    public List<String> fizzBuzz(int n) {
        List<String> resultList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                resultList.add("FizzBuzz");
            } else if (i % 3 == 0) {
                resultList.add("Fizz");
            } else if (i % 5 == 0) {
                resultList.add("Buzz");
            } else {
                resultList.add(i + "");
            }
        }
        return resultList;
    }
}
