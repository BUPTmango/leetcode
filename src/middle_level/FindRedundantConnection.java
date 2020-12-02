package middle_level;


/**
 * 并查集
 * 684. 冗余连接
 * 在本问题中, 树指的是一个连通且无环的无向图。
 *
 * 输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 *
 * 结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v]，满足u < v，表示连接顶点u和v的无向图的边。
 *
 * 返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边[u, v] 应满足相同的格式u < v。
 *
 * 示例 1：
 *
 * 输入: [[1,2], [1,3], [2,3]]
 * 输出: [2,3]
 * 解释: 给定的无向图为:
 *   1
 *  / \
 * 2 - 3
 * 示例 2：
 *
 * 输入: [[1,2], [2,3], [3,4], [1,4], [1,5]]
 * 输出: [1,4]
 * 解释: 给定的无向图为:
 * 5 - 1 - 2
 *     |   |
 *     4 - 3
 * 注意:
 *
 * 输入的二维数组大小在 3 到 1000。
 * 二维数组中的整数在1到N之间，其中N是输入数组的大小。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/2 11:34 上午
 */
public class FindRedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i++) {
            // 初始化自己的父亲是自己
            parent[i] = i;
        }
        // 先union 遇到两个节点find的相同 直接返回
        for (int[] edge : edges) {
            if (union(parent, edge[0], edge[1])) {
                return edge;
            }
        }
        return null;
    }

    private int find(int[] parent, int num) {
        // 根节点的父亲等于自身 所以这样来判断是不是根节点
        while (num != parent[num]) {
            // 路径压缩
            parent[num] = parent[parent[num]];
            num = parent[num];
        }
        return num;
    }

    private boolean union(int[] parent, int a, int b) {
        int fa = find(parent, a);
        int fb = find(parent, b);
        if (fa == fb) {
            return true;
        }
        parent[fa] = fb;
        return false;
    }
}
