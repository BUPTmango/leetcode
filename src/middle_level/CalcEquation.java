package middle_level;

import java.util.HashMap;
import java.util.List;

/**
 * ���鼯
 * 399. ������ֵ
 * ��������ʽA / B = k, ����A ��B ��Ϊ���ַ�����ʾ�ı�����k ��һ�����������֡�������֪����ʽ������⣬�����ؼ������������������ڣ��򷵻�-1.0��
 * <p>
 * ����������Ч�ġ�����Լ�����������в�����ֳ���Ϊ 0 ��������Ҳ������κ�ì�ܵĽ����
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * �����[6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * ���ͣ�
 * ������a / b = 2.0, b / c = 3.0
 * ���⣺a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * ���أ�[6.0, 0.5, -1.0, 1.0, -1.0 ]
 * ʾ�� 2��
 * <p>
 * ���룺equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * �����[3.75000,0.40000,5.00000,0.20000]
 * ʾ�� 3��
 * <p>
 * ���룺equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * �����[0.50000,2.00000,-1.00000,-1.00000]
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= equations[i][0].length, equations[i][1].length <= 5
 * values.length ==equations.length
 * 0.0 <values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= queries[i][0].length, queries[i][1].length <= 5
 * equations[i][0], equations[i][1],queries[i][0], queries[i][1] ��СдӢ����ĸ���������
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/2 8:45 ����
 */
public class CalcEquation {
    private HashMap<String, String> parent = new HashMap<>();

    /**
     * quotient��value��ʾ��ǰ�ڵ���ֱ�Ӹ��ڵ�Ķ��ٱ�
     */
    private HashMap<String, Double> quotient = new HashMap<>();

    private String find(String p) {
        if (parent.get(p) != p) {
            // ·��ѹ��
            // ��Ҫ�ȱ��游�׵�ֵ,��Ϊ����ѹ������ֻ������,����*�ľ��Ǹ��ڵ��Ȩֵ1,�ǲ��Ե�
            String f = parent.get(p);
            parent.put(p, find(f));
            // ѹ��֮��Ҫ��� �Լ��ı��� * �Լ����׵ı���
            quotient.put(p, quotient.get(p) * quotient.get(f));
        }
        return parent.get(p);
    }

    private void init(String s) {
        if (!parent.containsKey(s)) {
            // ��ʼ��parent �Լ�ָ���Լ�
            parent.put(s, s);
            // ��ʼ������Ϊ1
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
            // �� / ���ӵ���������union���������±���
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
                // ����·��ѹ��
                res[index++] = find(a).equals(find(b)) ? quotient.get(a) / quotient.get(b) : -1;
            }
        }
        return res;
    }
}
