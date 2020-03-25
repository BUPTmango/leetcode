package simple_level;

/**
 * 892. ��ά����ı����
 * ��?N?*?N?�������ϣ����Ƿ���һЩ?1 * 1 * 1??�������塣
 *
 * ÿ��ֵ?v = grid[i][j]?��ʾ?v?������������ڶ�Ӧ��Ԫ��?(i, j)?�ϡ�
 *
 * ���㷵����������ı������
 *
 * ?
 *
 * ʾ�� 1��
 *
 * ���룺[[2]]
 * �����10
 * ʾ�� 2��
 *
 * ���룺[[1,2],[3,4]]
 * �����34
 * ʾ�� 3��
 *
 * ���룺[[1,0],[0,2]]
 * �����16
 * ʾ�� 4��
 *
 * ���룺[[1,1,1],[1,0,1],[1,1,1]]
 * �����32
 * ʾ��?5��
 *
 * ���룺[[2,2,2],[2,1,2],[2,2,2]]
 * �����46
 * ?
 *
 * ��ʾ��
 *
 * 1 <= N <= 50
 * 0 <= grid[i][j] <= 50
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/25 9:12 ����
 */
public class SurfaceArea {
    /**
     * ������
     * @param grid
     * @return
     */
    public int surfaceArea(int[][] grid) {
        int n = grid.length, area = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // �Ȱ�grid[i][j]��ֵ��level��ʡ����bound check��������΢��΢��΢�Ż�һ�º�ʱ������
                int level = grid[i][j];
                if (level > 0) {
                    // һ�������У�2������ + ���е������嶼������4��������
                    area += (level << 2) + 2;
                    // ���� i �� i-1 ���������ݱ����
                    area -= i > 0? Math.min(level, grid[i - 1][j]) << 1: 0;
                    // ���� j �� j-1 ���������ݱ����
                    area -= j > 0? Math.min(level, grid[i][j - 1]) << 1: 0;
                }
            }
        }
        return area;
    }
}
