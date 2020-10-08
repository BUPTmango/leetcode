package middle_level;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 207. �γ̱�
 *
 * �����ѧ�ڱ���ѡ�� numCourse �ſγ̣���Ϊ0��numCourse-1 ��
 *
 * ��ѡ��ĳЩ�γ�֮ǰ��ҪһЩ���޿γ̡����磬��Ҫѧϰ�γ� 0 ������Ҫ����ɿγ� 1 ��������һ��ƥ������ʾ���ǣ�[0,1]
 *
 * �����γ������Լ����ǵ��Ⱦ������������ж��Ƿ����������пγ̵�ѧϰ��
 *
 *
 * ʾ�� 1:
 *
 * ����: 2, [[1,0]]
 * ���: true
 * ����:�ܹ��� 2 �ſγ̡�ѧϰ�γ� 1 ֮ǰ������Ҫ��ɿγ� 0���������ǿ��ܵġ�
 * ʾ�� 2:
 *
 * ����: 2, [[1,0],[0,1]]
 * ���: false
 * ����:�ܹ��� 2 �ſγ̡�ѧϰ�γ� 1 ֮ǰ������Ҫ����ɿγ� 0������ѧϰ�γ� 0 ֮ǰ���㻹Ӧ����ɿγ� 1�����ǲ����ܵġ�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/8 9:17 ����
 */
public class CanFinish {
    List<List<Integer>> edges;
    int[] indeg;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<>());
        }
        indeg = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            ++indeg[info[0]];
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        while (!queue.isEmpty()) {
            ++visited;
            int u = queue.poll();
            for (int v: edges.get(u)) {
                --indeg[v];
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return visited == numCourses;
    }
}
