package middle_level;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 841. Կ�׺ͷ���
 * �� N �����䣬��ʼʱ��λ�� 0 �ŷ��䡣ÿ�������в�ͬ�ĺ��룺0��1��2��...��N-1�����ҷ����������һЩԿ����ʹ�������һ�����䡣
 *
 * ����ʽ�ϣ�����ÿ������ i ����һ��Կ���б� rooms[i]��ÿ��Կ�� rooms[i][j] �� [0,1��...��N-1] �е�һ��������ʾ������ N = rooms.length�� Կ�� rooms[i][j] = v ���Դ򿪱��Ϊ v �ķ��䡣
 *
 * ������� 0 �ŷ�������������з��䶼����ס��
 *
 * ��������ɵ��ڷ���֮�������߶���
 *
 * ����ܽ���ÿ�����䷵�� true�����򷵻� false��
 *
 * ʾ�� 1��
 *
 * ����: [[1],[2],[3],[]]
 * ���: true
 * ����:
 * ���Ǵ� 0 �ŷ��俪ʼ���õ�Կ�� 1��
 * ֮������ȥ 1 �ŷ��䣬�õ�Կ�� 2��
 * Ȼ������ȥ 2 �ŷ��䣬�õ�Կ�� 3��
 * �������ȥ�� 3 �ŷ��䡣
 * ���������ܹ�����ÿ�����䣬���Ƿ��� true��
 * ʾ�� 2��
 *
 * ���룺[[1,3],[3,0,1],[2],[0]]
 * �����false
 * ���ͣ����ǲ��ܽ��� 2 �ŷ��䡣
 * ��ʾ��
 *
 * 1 <= rooms.length <=?1000
 * 0 <= rooms[i].length <= 1000
 * ���з����е�Կ�������ܼƲ�����?3000��
 *
 * ������
 * ����ͱ���˸���һ������ͼ��ѯ�ʴ� 0 �Žڵ�����Ƿ��ܹ��������еĽڵ㡣
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/29 8:58 ����
 */
public class CanVisitAllRooms {
    boolean[] vis;
    int num;

    /**
     * �����������
     * ʹ��������������ķ�ʽ��������ͼ��ͳ�ƿ��Ե���Ľڵ���������������� vis ��ǵ�ǰ�ڵ��Ƿ���ʹ����Է�ֹ�ظ�����
     * @param rooms
     * @return
     */
    public boolean canVisitAllRooms_DFS(List<List<Integer>> rooms) {
        int n = rooms.size();
        num = 0;
        vis = new boolean[n];
        dfs(rooms, 0);
        return num == n;
    }

    public void dfs(List<List<Integer>> rooms, int x) {
        vis[x] = true;
        num++;
        for (int it : rooms.get(x)) {
            if (!vis[it]) {
                dfs(rooms, it);
            }
        }
    }

    /**
     * �����������
     * ʹ�ù�����������ķ�ʽ��������ͼ��ͳ�ƿ��Ե���Ľڵ���������������� vis ��ǵ�ǰ�ڵ��Ƿ���ʹ����Է�ֹ�ظ�����
     * @param rooms
     * @return
     */
    public boolean canVisitAllRooms_BFS(List<List<Integer>> rooms) {
        int n = rooms.size(), num = 0;
        boolean[] vis = new boolean[n];
        Queue<Integer> que = new LinkedList<>();
        vis[0] = true;
        que.offer(0);
        while (!que.isEmpty()) {
            int x = que.poll();
            num++;
            for (int it : rooms.get(x)) {
                if (!vis[it]) {
                    vis[it] = true;
                    que.offer(it);
                }
            }
        }
        return num == n;
    }
}
