package middle_level;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 210. �γ̱� II
 * �������ܹ��� n �ſ���Ҫѡ����Ϊ?0?��?n-1��
 *
 * ��ѡ��ĳЩ�γ�֮ǰ��ҪһЩ���޿γ̡�?���磬��Ҫѧϰ�γ� 0 ������Ҫ����ɿγ�?1 ��������һ��ƥ������ʾ����: [0,1]
 *
 * �����γ������Լ����ǵ��Ⱦ�������������Ϊ��ѧ�����пγ������ŵ�ѧϰ˳��
 *
 * ���ܻ��ж����ȷ��˳����ֻҪ����һ�־Ϳ����ˡ����������������пγ̣�����һ�������顣
 *
 * ʾ��?1:
 *
 * ����: 2, [[1,0]]
 * ���: [0,1]
 * ����:?�ܹ��� 2 �ſγ̡�Ҫѧϰ�γ� 1������Ҫ����ɿγ� 0����ˣ���ȷ�Ŀγ�˳��Ϊ [0,1] ��
 * ʾ��?2:
 *
 * ����: 4, [[1,0],[2,0],[3,1],[3,2]]
 * ���: [0,1,2,3] or [0,2,1,3]
 * ����:?�ܹ��� 4 �ſγ̡�Ҫѧϰ�γ� 3����Ӧ������ɿγ� 1 �Ϳγ� 2�����ҿγ� 1 �Ϳγ� 2 ��Ӧ�����ڿγ� 0 ֮��
 * ?    ��ˣ�һ����ȷ�Ŀγ�˳����?[0,1,2,3] ����һ����ȷ��������?[0,2,1,3] ��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/15 9:04 ����
 */
public class FindOrder {
    // �洢����ͼ
    List<List<Integer>> edges;
    // �洢ÿ���ڵ�����
    int[] indeg;
    // �洢��
    int[] result;
    // ���±�
    int index;

    /**
     * �����������
     * �������ʵ����������
     * ÿ�η������Ϊ0�Ľڵ㲢�Ҽ������ڽڵ�����
     * ���Ϊ0�Ϳ��Ա�����
     * �ö��м�¼���Ա����ʵĽڵ�
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<>());
        }
        indeg = new int[numCourses];
        result = new int[numCourses];
        index = 0;
        // �������ݴ�������ͼ
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            ++indeg[info[0]];
        }

        Queue<Integer> queue = new LinkedList<>();
        // ���������Ϊ 0 �Ľڵ���������
        for (int i = 0; i < numCourses; ++i) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            // �Ӷ���ȡ��һ���ڵ�
            int u = queue.poll();
            // �������
            result[index++] = u;
            for (int v: edges.get(u)) {
                --indeg[v];
                // ������ڽڵ� v �����Ϊ 0���Ϳ���ѡ v ��Ӧ�Ŀγ���
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        // ���ֻ���(res��û�������е�, idxû����)
        if (index != numCourses) {
            return new int[0];
        }
        return result;
    }
}
