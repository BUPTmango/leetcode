package weekly_contest.week_212;

/**
 * 5548. ��С��������·��
 * ��׼���μ�һ��Զ��������һ����ά rows x columns �ĵ�ͼ heights ������ heights[row][col] ��ʾ���� (row, col) �ĸ߶ȡ�һ��ʼ���������Ͻǵĸ��� (0, 0) ������ϣ��ȥ�����½ǵĸ��� (rows-1, columns-1) ��ע���±�� 0 ��ʼ��ţ�����ÿ�ο����� �ϣ��£����� �ĸ�����֮һ�ƶ�������Ҫ�ҵ��ķ� ���� ��С��һ��·����
 *
 * һ��·���ķѵ� ����ֵ ��·�������ڸ���֮�� �߶Ȳ����ֵ �� ���ֵ �����ġ�
 *
 * ���㷵�ش����Ͻ��ߵ����½ǵ���С ��������ֵ ��
 *
 *
 *
 * ʾ�� 1��
 *
 *
 *
 * ���룺heights = [[1,2,2],[3,8,2],[5,3,5]]
 * �����2
 * ���ͣ�·�� [1,3,5,3,5] �������ӵĲ�ֵ����ֵ���Ϊ 2 ��
 * ����·����·�� [1,2,2,2,5] ���ţ���Ϊ��һ��·����ֵ���ֵΪ 3 ��
 * ʾ�� 2��
 *
 *
 *
 * ���룺heights = [[1,2,3],[3,8,4],[5,3,5]]
 * �����1
 * ���ͣ�·�� [1,2,3,4,5] �����ڸ��Ӳ�ֵ����ֵ���Ϊ 1 ����·�� [1,3,5,3,5] ���š�
 * ʾ�� 3��
 *
 *
 * ���룺heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
 * �����0
 * ���ͣ���ͼ��ʾ·������Ҫ�����κ�������
 *
 *
 * ��ʾ��
 *
 * rows == heights.length
 * columns == heights[i].length
 * 1 <= rows, columns <= 100
 * 1 <= heights[i][j] <= 106
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/25 11:21 ����
 */
public class MinimumEffortPath {
    private int m = 0;
    private int n = 0;
    private int res = Integer.MAX_VALUE;
    private int[][] directions = new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
//    private boolean[][] visited;
//    public int minimumEffortPath(int[][] heights) {
//        m = heights.length;
//        n = heights[0].length;
//        visited = new boolean[m][n];
//        backtrack(heights, 0, 0, 0);
//        return res;
//    }
//
//    private void backtrack(int[][] heights, int i, int j, int strength) {
//        if (i == m - 1 && j == n - 1) {
//            res = Math.min(res, strength);
//            return;
//        }
//        visited[i][j] = true;
//        for (int[] direction : directions) {
//            int di = i + direction[0];
//            int dj = j + direction[1];
//            if (di >= 0 && dj >= 0 && di < m && dj < n && !visited[di][dj]) {
//                // ע�⣡�� ����Ҫʹ�þֲ�����
//                int tmpStrength = Math.max(strength, Math.abs(heights[di][dj] - heights[i][j]));
//                backtrack(heights, di, dj, tmpStrength);
//            }
//        }
//        visited[i][j] = false;
//    }


    /**
     * ���ַ� ͨ���������п��ܵ��������õ����
     * @param heights
     * @return
     */
    public int minimumEffortPath_better(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        int l = 0, r = 1_000_000, ans = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            boolean[][] visited = new boolean[m][n];
            if (dfs(heights, visited, 0, 0, mid)) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private boolean dfs(int[][] heights, boolean[][] visited, int i, int j, int limit) {
        if (i == m - 1 && j == n - 1) {
            return true;
        }
        visited[i][j] = true;
        for (int[] direction : directions) {
            int di = i + direction[0];
            int dj = j + direction[1];
            if (di >= 0 && dj >= 0 && di < m && dj < n && !visited[di][dj] && Math.abs(heights[di][dj] - heights[i][j]) <= limit) {
                if (dfs(heights, visited, di, dj, limit)) {
                    return true;
                }
            }
        }
        // ע�⣡���� ���ﲻ��Ҫ���� 
        // visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        MinimumEffortPath minimumEffortPath = new MinimumEffortPath();
        System.out.println(minimumEffortPath.minimumEffortPath_better(new int[][]{{1,2,1,1,1}, {1,2,1,2,1}, {1,2,1,2,1}, {1,
                2,1,2,1}, {1,1,1,2,1}}));
    }
}
