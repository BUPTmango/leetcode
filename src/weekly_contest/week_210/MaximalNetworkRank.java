package weekly_contest.week_210;

/**
 * 5536. ���������
 * n �����к�һЩ������Щ���еĵ�· roads ��ͬ���һ��������ʩ���硣ÿ�� roads[i] = [ai, bi] ����ʾ�ڳ��� ai �� bi ֮����һ��˫���·��
 *
 * ������ͬ���й��ɵ� ���ж� �� ������ ����Ϊ�������������� ֱ�� �����ĵ�·�������������һ����·ֱ���������������У���������·ֻ���� һ�� ��
 *
 * ����������ʩ����� ��������� �����в�ͬ���ж��е� ��������� ��
 *
 * �������� n ������ roads����������������ʩ����� ��������� ��
 *
 * ʾ�� 1��
 *
 * ���룺n = 4, roads = [[0,1],[0,3],[1,2],[1,3]]
 * �����4
 * ���ͣ����� 0 �� 1 ���������� 4����Ϊ���� 4 ����·����� 0 �� 1 ������λ�� 0 �� 1 ֮��ĵ�·ֻ����һ�Ρ�
 * ʾ�� 2��
 *
 * ���룺n = 5, roads = [[0,1],[0,3],[1,2],[1,3],[2,3],[2,4]]
 * �����5
 * ���ͣ����� 5 ����·����� 1 �� 2 ������
 * ʾ�� 3��
 *
 * ���룺n = 8, roads = [[0,1],[1,2],[2,3],[2,4],[5,6],[5,7]]
 * �����5
 * ���ͣ�2 �� 5 ��������Ϊ 5��ע�Ⲣ�����еĳ��ж���Ҫ����������
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/11 10:52 ����
 */
public class MaximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        // ����ÿ����Ķ���
        int[] degree = new int[n];
        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }

        int max = 0;
        // �����ҵ����ֵ
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int deg = degree[i] + degree[j];
                if (include(roads, i, j)) {
                    deg--;
                }
                max = Math.max(max, deg);
            }
        }
        return max;
    }

    /**
     * ���������ڵ���û�б�ֱ������
     * @return
     */
    private boolean include(int[][] roads, int i, int j) {
        for (int[] road : roads) {
            if (road[0] == i && road[1] == j) {
                return true;
            }
            if (road[0] == j && road[1] == i) {
                return true;
            }
        }
        return false;
    }
}
