package hard_level;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 895. 最大频率栈
 * 实现 FreqStack，模拟类似栈的数据结构的操作的一个类。
 *
 * FreqStack有两个函数：
 *
 * push(int x)，将整数x推入栈中。
 * pop()，它移除并返回栈中出现最频繁的元素。
 * 如果最频繁的元素不只一个，则移除并返回最接近栈顶的元素。
 * 
 *
 * 示例：
 *
 * 输入：
 * ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
 * [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
 * 输出：[null,null,null,null,null,null,null,5,7,5,4]
 * 解释：
 * 执行六次 .push 操作后，栈自底向上为 [5,7,5,7,4,5]。然后：
 *
 * pop() -> 返回 5，因为 5 是出现频率最高的。
 * 栈变成 [5,7,5,7,4]。
 *
 * pop() -> 返回 7，因为 5 和 7 都是频率最高的，但 7 最接近栈顶。
 * 栈变成 [5,7,5,4]。
 *
 * pop() -> 返回 5 。
 * 栈变成 [5,7,4]。
 *
 * pop() -> 返回 4 。
 * 栈变成 [5,7]。
 * 
 *
 * 提示：
 *
 * 对FreqStack.push(int x)的调用中0 <= x <= 10^9。
 * 如果栈的元素数目为零，则保证不会调用 FreqStack.pop()。
 * 单个测试样例中，对FreqStack.push的总调用次数不会超过10000。
 * 单个测试样例中，对FreqStack.pop的总调用次数不会超过10000。
 * 所有测试样例中，对FreqStack.push和 FreqStack.pop的总调用次数不会超过150000。
 *
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/26 4:33 下午
 */
public class FreqStack {
    Map<Integer, Integer> freq;
    // 在具有相同的（最大）频率的元素中，怎么判断那个元素是最新的？
    // 我们可以使用栈来查询这一信息：靠近栈顶的元素总是相对更新一些。
    Map<Integer, Stack<Integer>> group;
    int maxfreq;

    public FreqStack() {
        freq = new HashMap();
        group = new HashMap();
        maxfreq = 0;
    }

    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);
        if (f > maxfreq) {
            maxfreq = f;
        }

        group.computeIfAbsent(f, z-> new Stack()).push(x);
    }

    public int pop() {
        int x = group.get(maxfreq).pop();
        freq.put(x, freq.get(x) - 1);
        if (group.get(maxfreq).size() == 0) {
            maxfreq--;
        }
        return x;
    }
}
