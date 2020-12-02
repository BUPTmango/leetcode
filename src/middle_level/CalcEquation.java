package middle_level;

import java.util.HashMap;
import java.util.List;

/**
 * 并查集
 * 399. 除法求值
 * 给出方程式A / B = k, 其中A 和B 均为用字符串表示的变量，k 是一个浮点型数字。根据已知方程式求解问题，并返回计算结果。如果结果不存在，则返回-1.0。
 * <p>
 * 输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * 解释：
 * 给定：a / b = 2.0, b / c = 3.0
 * 问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * 返回：[6.0, 0.5, -1.0, 1.0, -1.0 ]
 * 示例 2：
 * <p>
 * 输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * 输出：[3.75000,0.40000,5.00000,0.20000]
 * 示例 3：
 * <p>
 * 输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * 输出：[0.50000,2.00000,-1.00000,-1.00000]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= equations[i][0].length, equations[i][1].length <= 5
 * values.length ==equations.length
 * 0.0 <values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= queries[i][0].length, queries[i][1].length <= 5
 * equations[i][0], equations[i][1],queries[i][0], queries[i][1] 由小写英文字母与数字组成
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/2 8:45 上午
 */
public class CalcEquation {
    private HashMap<String, String> parent = new HashMap<>();

    /**
     * quotient的value表示当前节点是直接父节点的多少倍
     */
    private HashMap<String, Double> quotient = new HashMap<>();

    private String find(String p) {
        if (parent.get(p) != p) {
            // 路径压缩
            // 需要先保存父亲的值,因为后面压缩后树只有两层,后面*的就是根节点的权值1,是不对的
            String f = parent.get(p);
            parent.put(p, find(f));
            // 压缩之后要变成 自己的倍数 * 自己父亲的倍数
            quotient.put(p, quotient.get(p) * quotient.get(f));
        }
        return parent.get(p);
    }

    private void init(String s) {
        if (!parent.containsKey(s)) {
            // 初始化parent 自己指向自己
            parent.put(s, s);
            // 初始化倍数为1
            quotient.put(s, 1.0);
        }
    }

    private void union(String a, String b, Double value) {
        init(a);
        init(b);
        // a/fa=val[a], b/fb=val[b]
        String fa = find(a);
        String fb = find(b);
        if (fa.equals(fb)) {
            return;
        }
        parent.put(fa, fb);
        // val[fa] = fa/fb = a/b * b/fb * fa/a = value * (val[b] / val[a])
        quotient.put(fa, value * (quotient.get(b) / quotient.get(a)));
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            // 将 / 连接的两个部分union起来并更新倍数
            union(equation.get(0), equation.get(1), values[i]);
        }
        double[] res = new double[queries.size()];
        int index = 0;
        for (List<String> query : queries) {
            String a = query.get(0);
            String b = query.get(1);
            if (!parent.containsKey(a) || !parent.containsKey(b)) {
                res[index++] = -1;
            } else {
                // 先做路径压缩
                res[index++] = find(a).equals(find(b)) ? quotient.get(a) / quotient.get(b) : -1;
            }
        }
        return res;
    }
}
