package middle_level;


/**
 * ���鼯
 * 684. ��������
 * �ڱ�������, ��ָ����һ����ͨ���޻�������ͼ��
 *
 * ����һ��ͼ����ͼ��һ������N���ڵ� (�ڵ�ֵ���ظ�1, 2, ..., N) ������һ�����ӵı߹��ɡ����ӵıߵ��������������1��N�м䣬�������ӵı߲����������Ѵ��ڵıߡ�
 *
 * ���ͼ��һ���Ա���ɵĶ�ά���顣ÿһ���ߵ�Ԫ����һ��[u, v]������u < v����ʾ���Ӷ���u��v������ͼ�ıߡ�
 *
 * ����һ������ɾȥ�ıߣ�ʹ�ý��ͼ��һ������N���ڵ����������ж���𰸣��򷵻ض�ά�����������ֵıߡ��𰸱�[u, v] Ӧ������ͬ�ĸ�ʽu < v��
 *
 * ʾ�� 1��
 *
 * ����: [[1,2], [1,3], [2,3]]
 * ���: [2,3]
 * ����: ����������ͼΪ:
 *   1
 *  / \
 * 2 - 3
 * ʾ�� 2��
 *
 * ����: [[1,2], [2,3], [3,4], [1,4], [1,5]]
 * ���: [1,4]
 * ����: ����������ͼΪ:
 * 5 - 1 - 2
 *     |   |
 *     4 - 3
 * ע��:
 *
 * ����Ķ�ά�����С�� 3 �� 1000��
 * ��ά�����е�������1��N֮�䣬����N����������Ĵ�С��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/2 11:34 ����
 */
public class FindRedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i++) {
            // ��ʼ���Լ��ĸ������Լ�
            parent[i] = i;
        }
        // ��union ���������ڵ�find����ͬ ֱ�ӷ���
        for (int[] edge : edges) {
            if (union(parent, edge[0], edge[1])) {
                return edge;
            }
        }
        return null;
    }

    private int find(int[] parent, int num) {
        // ���ڵ�ĸ��׵������� �����������ж��ǲ��Ǹ��ڵ�
        while (num != parent[num]) {
            // ·��ѹ��
            parent[num] = parent[parent[num]];
            num = parent[num];
        }
        return num;
    }

    private boolean union(int[] parent, int a, int b) {
        int fa = find(parent, a);
        int fb = find(parent, b);
        if (fa == fb) {
            return true;
        }
        parent[fa] = fb;
        return false;
    }
}
