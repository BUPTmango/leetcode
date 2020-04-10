package middle_level.jianzhi_offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ������13. �����˵��˶���Χ
 * ������һ��m��n�еķ��񣬴����� [0,0] ������ [m-1,n-1] ��һ�������˴����� [0, 0] �ĸ��ӿ�ʼ�ƶ�����ÿ�ο��������ҡ��ϡ����ƶ�һ�񣨲����ƶ��������⣩��Ҳ���ܽ�������������������λ֮�ʹ���k�ĸ��ӡ����磬��kΪ18ʱ���������ܹ����뷽�� [35, 37] ����Ϊ3+5+3+7=18���������ܽ��뷽�� [35, 38]����Ϊ3+5+3+8=19�����ʸû������ܹ�������ٸ����ӣ�
 *
 * ʾ�� 1��
 *
 * ���룺m = 2, n = 3, k = 1
 * �����3
 * ʾ�� 1��
 *
 * ���룺m = 3, n = 1, k = 0
 * �����1
 * ��ʾ��
 *
 * 1 <= n,m <= 100
 * 0 <= k?<= 20
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/10 12:30 ����
 */
public class MovingCount {
    /**
     * BFS
     * ��¼�»������ܴﵽ�ĸ���
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        // �����ĸ�����
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        // ������� ����ʼ(0,0)�Ž�ȥ
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        // ��visited��������ʾ���ʹ��ĸ���
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        int result = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = cur[0] + dx[i];
                int y = cur[1] + dy[i];
                if (x < 0 || x >= m || y < 0 || y >= n) {
                    continue;
                }
                int value = solve(x) + solve(y);
                if (value > k || visited[x][y]) {
                    continue;
                }
                visited[x][y] = true;
                queue.offer(new int[]{x, y});
                result++;
            }
        }
        return result;
    }

    /**
     * ������λ��
     * @param num
     * @return
     */
    private int solve(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}
