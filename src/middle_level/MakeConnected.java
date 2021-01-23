package middle_level;

/**
 * 1319. ��ͨ����Ĳ�������
 * ����̫�����½�n̨��������ӳ�һ�����磬������ı�Ŵ�0��n-1��������connections��ʾ������connections[i] = [a, b]�����˼����a��b��
 * �����е��κ�һ̨�����������ͨ������ֱ�ӻ��߼�ӷ���ͬһ����������������һ̨�������
 * ����������������ĳ�ʼ����connections������԰ο�������ֱ̨�������֮������£�����������һ��δֱ���ļ������������㲢����ʹ���м��������ͨ��������ٲ�����������������ܣ��򷵻�-1 ��
 *
 * ʾ�� 1��
 *
 * ���룺n = 4, connections = [[0,1],[0,2],[1,2]]
 * �����1
 * ���ͣ����¼���� 1 �� 2 ֮������£��������嵽����� 1 �� 3 �ϡ�
 * ʾ�� 2��
 *
 * ���룺n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
 * �����2
 * ʾ�� 3��
 *
 * ���룺n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
 * �����-1
 * ���ͣ������������㡣
 * ʾ�� 4��
 *
 * ���룺n = 5, connections = [[0,1],[0,2],[3,4],[2,3]]
 * �����0
 *
 * ��ʾ��
 *
 * 1 <= n <= 10^5
 * 1 <= connections.length <= min(n*(n-1)/2, 10^5)
 * connections[i].length == 2
 * 0 <= connections[i][0], connections[i][1]< n
 * connections[i][0] != connections[i][1]
 * û���ظ������ӡ�
 * ��̨���������ͨ�������������ӡ�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/1/23 9:35 ����
 */
public class MakeConnected {

    private int[] parent;
    private int count;
    private int part;

    public int makeConnected(int n, int[][] connections) {
        parent = new int[n];
        // ��ʼ��
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        count = 0;
        part = n;

        for (int[] connection : connections) {
            union(connection[0], connection[1]);
        }
        if (count < part - 1) {
            return -1;
        } else {
            return part - 1;
        }
    }

    private int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    private void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);
        if (root1 == root2) {
            count++;
            return;
        }
        parent[root1] = root2;
        part--;
    }

}
