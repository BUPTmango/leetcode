package middle_level;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1162. ��ͼ����
 * ������������һ�ݴ�СΪ?N x N �ġ���ͼ��������?grid�������ÿ�������򡻣���Ԫ�񣩶���?0?��?1?��Ǻ��ˡ�����?0?������1?����½�أ���֪������½��������Զ�ĺ�������������һ�����뷵�ظú����������������½������ľ��롣
 * <p>
 * ��������˵�ľ����ǡ������پ��롻��?Manhattan Distance����(x0, y0) ��?(x1, y1)?����������֮��ľ�����?|x0 - x1| + |y0 - y1|?��
 * <p>
 * ������ǵĵ�ͼ��ֻ��½�ػ��ߺ����뷵��?-1��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺[[1,0,1],[0,0,0],[1,0,1]]
 * �����2
 * ���ͣ�
 * �������� (1, 1) ������½������֮��ľ��붼�ﵽ���������Ϊ 2��
 * ʾ�� 2��
 * <p>
 * <p>
 * <p>
 * ���룺[[1,0,0],[0,0,0],[0,0,0]]
 * �����4
 * ���ͣ�
 * �������� (2, 2) ������½������֮��ľ��붼�ﵽ���������Ϊ 4��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= grid.length == grid[0].length?<= 100
 * grid[i][j]?����?0?����?1
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/29 11:56 ����
 */
public class MaxDistance {
    /**
     * ������
     * https://leetcode-cn.com/problems/as-far-from-land-as-possible/solution/jian-dan-java-miao-dong-tu-de-bfs-by-sweetiee/
     *
     * @param grid
     * @return
     */
    public int maxDistance(int[][] grid) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Queue<int[]> queue = new ArrayDeque<>();
        int m = grid.length, n = grid[0].length;
        // �Ȱ����е�½�ض���ӡ�
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // �Ӹ���½�ؿ�ʼ��һȦһȦ�ı����������������ĺ��������½����Զ�ĺ���
        boolean hasOcean = false;
        int[] point = null;
        while (!queue.isEmpty()) {
            point = queue.poll();
            int x = point[0], y = point[1];
            // ȡ�����е�Ԫ�أ��������ܵĺ�����ӡ�
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] != 0) {
                    continue;
                }
                grid[newX][newY] = grid[x][y] + 1; // ������ֱ���޸���ԭ���飬��˾Ͳ���Ҫ�������������־�Ƿ����
                hasOcean = true;
                queue.offer(new int[]{newX, newY});
            }
        }

        // û��½�ػ���û�к��󣬷���-1��
        if (point == null || !hasOcean) {
            return -1;
        }

        // �������һ�α������ĺ���ľ��롣
        return grid[point[0]][point[1]] - 1;

    }
}
