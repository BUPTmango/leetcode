package hard_level;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 407. ����ˮ II
 * ����һ�� m x n �ľ������е�ֵ��Ϊ�Ǹ������������ά�߶�ͼÿ����Ԫ�ĸ߶ȣ������ͼ����״����ܽӶ����������ˮ��
 * <p>
 * ʾ�� 1:
 * ����: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
 * ���: 4
 * ����: �������ˮ���ᱻ��ͼ��ɫ�ķ����С��ܵĽ���ˮ��Ϊ1+2+1=4��
 * <p>
 * ʾ��2:
 * ����: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
 * ���: 10
 * <p>
 * ��ʾ:
 * <p>
 * m == heightMap.length
 * n == heightMap[i].length
 * 1 <= m, n <= 200
 * 0 <= heightMap[i][j] <= 2 * 104
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/9/16 21:21
 */
public class TrapRainWater {
    public int trapRainWater(int[][] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int n = heights.length;
        int m = heights[0].length;
        // ��һ��vis������������λ����û�б����ʹ�
        boolean[][] vis = new boolean[n][m];
        // ���ȶ����д����Ԫ�� [x,y,h] ����͸߶�
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));

        // �Ȱ�����һȦ�Ž�ȥ
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    pq.offer(new int[]{i, j, heights[i][j]});
                    vis[i][j] = true;
                }
            }
        }
        int res = 0;
        // �������飬��dx��dyѹ����һά����
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            // ��һ����Χ�ĸ�����û���ʹ��Ļ��ܲ��������ˮ
            for (int k = 0; k < 4; k++) {
                int nx = poll[0] + dirs[k];
                int ny = poll[1] + dirs[k + 1];
                // ���λ�úϷ���û���ʹ�
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !vis[nx][ny]) {
                    // �����Χ��һȦ����С�ıȵ�ǰ������ߣ��Ǿ�˵�����������ˮ
                    if (poll[2] > heights[nx][ny]) {
                        res += poll[2] - heights[nx][ny];
                    }
                    // �����ˮ�߶ȵ������ˮ��ĸ߶��ˣ����û��ˮҲҪȡ�ߵ�
                    pq.offer(new int[]{nx, ny, Math.max(heights[nx][ny], poll[2])});
                    vis[nx][ny] = true;
                }
            }
        }
        return res;
    }
}
