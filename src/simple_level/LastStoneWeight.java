package simple_level;

import java.util.PriorityQueue;

/**
 * 1046. ���һ��ʯͷ������
 * ��һ��ʯͷ��ÿ��ʯͷ������������������
 *
 * ÿһ�غϣ�����ѡ������ ���ص� ʯͷ��Ȼ������һ����顣����ʯͷ�������ֱ�Ϊx ��y����x <= y����ô����Ŀ��ܽ�����£�
 *
 * ���x == y����ô����ʯͷ���ᱻ��ȫ���飻
 * ���x != y����ô����Ϊx��ʯͷ������ȫ���飬������Ϊy��ʯͷ������Ϊy-x��
 * ������ֻ��ʣ��һ��ʯͷ�����ش�ʯͷ�����������û��ʯͷʣ�£��ͷ��� 0��
 *
 * ʾ����
 *
 * ���룺[2,7,4,1,8,1]
 * �����1
 * ���ͣ�
 * ��ѡ�� 7 �� 8���õ� 1����������ת��Ϊ [2,4,1,1,1]��
 * ��ѡ�� 2 �� 4���õ� 2����������ת��Ϊ [2,1,1,1]��
 * ������ 2 �� 1���õ� 1����������ת��Ϊ [1,1,1]��
 * ���ѡ�� 1 �� 1���õ� 0����������ת��Ϊ [1]����������ʣ���ǿ�ʯͷ��������
 *
 * ��ʾ��
 *
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/30 9:07 ����
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        // �������ȶ��� ÿ��ȡ���������� �ٷ���һ�����߲���
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int stone : stones) {
            queue.add(stone);
        }
        while (queue.size() >= 2) {
            int stone1 = queue.poll();
            int stone2 = queue.poll();
            int diff = Math.abs(stone1 - stone2);
            if (diff > 0) {
                queue.add(diff);
            }
        }
        if (queue.size() == 0) {
            return 0;
        } else {
            return queue.poll();
        }
    }
}
