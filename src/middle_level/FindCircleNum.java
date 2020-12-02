package middle_level;

/**
 * 并查集
 * 547. 朋友圈
 * 班上有N名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B的朋友，B 是 C的朋友，那么我们可以认为 A 也是 C的朋友。所谓的朋友圈，是指所有朋友的集合。
 *
 * 给定一个N * N的矩阵M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 *
 * 示例 1：
 *
 * 输入：
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 * 输出：2
 * 解释：已知学生 0 和学生 1 互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回 2 。
 * 示例 2：
 *
 * 输入：
 * [[1,1,0],
 *  [1,1,1],
 *  [0,1,1]]
 * 输出：1
 * 解释：已知学生 0 和学生 1 互为朋友，学生 1 和学生 2 互为朋友，所以学生 0 和学生 2 也是朋友，所以他们三个在一个朋友圈，返回 1 。
 * 
 * 提示：
 *
 * 1 <= N <= 200
 * M[i][i] == 1
 * M[i][j] == M[j][i]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/2 3:00 下午
 */
public class FindCircleNum {
    private int[] parent;
    private int count;

    public int findCircleNum(int[][] M) {
        int n = M.length;
        parent = new int[n];
        // 注意！！！！ 千万别忘记了初始化
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        // 连通分量
        count = n;

        for (int i = 0; i < n; i++) {
            // 注意矩阵是对称的 所以这里只需要j < i就可以了
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        return count;
    }

    private int find(int num) {
        while (num != parent[num]) {
            // 路径压缩
            parent[num] = parent[parent[num]];
            num = parent[num];
        }
        return num;
    }

    private void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa == fb) {
            return;
        }
        parent[fa] = fb;
        count--;
    }
}
