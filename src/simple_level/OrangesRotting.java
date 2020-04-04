package simple_level;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * 994. ���õ�����
 *�ڸ����������У�ÿ����Ԫ���������������ֵ֮һ��
 *
 * ֵ?0?����յ�Ԫ��
 * ֵ?1?�����������ӣ�
 * ֵ?2?�����õ����ӡ�
 * ÿ���ӣ��κ��븯�õ����ӣ��� 4 ���������ϣ����ڵ��������Ӷ��ḯ�á�
 *
 * ����ֱ����Ԫ����û����������Ϊֹ�����뾭������С����������������ܣ�����?-1��
 *
 * ʾ�� 1��
 *
 * ���룺[[2,1,1],[1,1,0],[0,1,1]]
 * �����4
 * ʾ�� 2��
 *
 * ���룺[[2,1,1],[0,1,1],[1,0,1]]
 * �����-1
 * ���ͣ����½ǵ����ӣ��� 2 �У� �� 0 �У���Զ���ḯ�ã���Ϊ����ֻ�ᷢ���� 4 �������ϡ�
 * ʾ�� 3��
 *
 * ���룺[[0,2]]
 * �����0
 * ���ͣ���Ϊ 0 ����ʱ�Ѿ�û�����������ˣ����Դ𰸾��� 0 ��
 * ?
 *
 * ��ʾ��
 *
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] ��Ϊ?0��1?��?2
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/4 11:02 ����
 */
public class OrangesRotting {
    // dr,dc ���ʹ�õõ� grid[r][c] ��grid[r-1][c]��grid[r][c-1]��grid[r+1][c]��grid[r][c+1]��Ԫ��
    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};

    /**
     * �ڹ������������ʱ�����ǽ���Щ�������Ӷ��Ž���������й�������������ɣ�
     * ���ÿ���������ӱ����õ����ʱ�� dis[x][y]dis[x][y]
     * ��ʵ�����������Դ��ĸ�������Ϊ���Ĺ�����������õ��Ľ����
     *
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        // ��ȡ��ά���������row �� ���� column
        int R = grid.length, C = grid[0].length;

        // queue : all starting cells with rotten oranges
        Queue<Integer> queue = new ArrayDeque();
        Map<Integer, Integer> depth = new HashMap();
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                if (grid[r][c] == 2) {
                    int code = r * C + c;  // ת��Ϊ����Ψһ��һά����
                    queue.add(code); //�洢��������
                    depth.put(code, 0); //�洢���ӱ�Ϊ����ʱ��ʱ��,keyΪ���ӵ�һά�����±꣬valueΪ�丯�õ�ʱ��
                }
            }
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            int code = queue.remove();
            int r = code / C, c = code % C;
            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    int ncode = nr * C + nc;
                    queue.add(ncode);
                    // �ƴεĹؼ� Ԫ�� grid[r][c] ����������Ԫ�صø���ʱ��Ӧ��һ��
                    depth.put(ncode, depth.get(code) + 1);
                    ans = depth.get(ncode);
                }
            }
        }

        //���grid����ʱ��grid�ܱ���Ⱦ�Ѿ��������ˣ���ʱ�����ʵ������޷�����Ⱦ
        for (int[] row: grid) {
            for (int v: row) {
                if (v == 1) {
                    return -1;
                }
            }
        }
        return ans;

    }
}
