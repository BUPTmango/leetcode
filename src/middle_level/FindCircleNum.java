package middle_level;

/**
 * ���鼯
 * 547. ����Ȧ
 * ������N��ѧ����������Щ�������ѣ���Щ���ǡ����ǵ���������Ǵ����ԡ������֪ A �� B�����ѣ�B �� C�����ѣ���ô���ǿ�����Ϊ A Ҳ�� C�����ѡ���ν������Ȧ����ָ�������ѵļ��ϡ�
 *
 * ����һ��N * N�ľ���M����ʾ�༶��ѧ��֮������ѹ�ϵ�����M[i][j] = 1����ʾ��֪�� i ���� j ��ѧ����Ϊ���ѹ�ϵ������Ϊ��֪����������������ѧ���е���֪������Ȧ������
 *
 * ʾ�� 1��
 *
 * ���룺
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 * �����2
 * ���ͣ���֪ѧ�� 0 ��ѧ�� 1 ��Ϊ���ѣ�������һ������Ȧ��
 * ��2��ѧ���Լ���һ������Ȧ�����Է��� 2 ��
 * ʾ�� 2��
 *
 * ���룺
 * [[1,1,0],
 *  [1,1,1],
 *  [0,1,1]]
 * �����1
 * ���ͣ���֪ѧ�� 0 ��ѧ�� 1 ��Ϊ���ѣ�ѧ�� 1 ��ѧ�� 2 ��Ϊ���ѣ�����ѧ�� 0 ��ѧ�� 2 Ҳ�����ѣ���������������һ������Ȧ������ 1 ��
 * 
 * ��ʾ��
 *
 * 1 <= N <= 200
 * M[i][i] == 1
 * M[i][j] == M[j][i]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/2 3:00 ����
 */
public class FindCircleNum {
    private int[] parent;
    private int count;

    public int findCircleNum(int[][] M) {
        int n = M.length;
        parent = new int[n];
        // ע�⣡������ ǧ��������˳�ʼ��
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        // ��ͨ����
        count = n;

        for (int i = 0; i < n; i++) {
            // ע������ǶԳƵ� ��������ֻ��Ҫj < i�Ϳ�����
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
            // ·��ѹ��
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
