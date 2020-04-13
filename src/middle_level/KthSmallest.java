package middle_level;

import java.util.PriorityQueue;

/**
 * 378. ��������е�KС��Ԫ��
 * ����һ��?n x n?��������ÿ�к�ÿ��Ԫ�ؾ������������ҵ������е�kС��Ԫ�ء�
 * ��ע�⣬���������ĵ� k СԪ�أ������ǵ� k ����ͬ��Ԫ�ء�
 *
 * ʾ��:
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * ���� 13��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/13 12:06 ����
 */
public class KthSmallest {
    /**
     * min-heap --> priorityQueue
     * record coordinates
     * core:
     * offer the 1st of each line
     * offer the next one in the same line after poll one
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        PriorityQueue<Tuple> queue = new PriorityQueue<>();
        // offer the 1st of each line
        for (int i = 0; i < len; i++) {
            queue.offer(new Tuple(i, 0, matrix[i][0]));
        }
        // poll k-1 numbers
        for (int j = 0; j < k - 1; j++) {
            Tuple tuple = queue.poll();
            // if the last one of line, not need to offer any one
            if (tuple.y == len - 1) {
                continue;
            } else {
                // offer the next one in the same line after poll one
                queue.offer(new Tuple(tuple.x, tuple.y + 1, matrix[tuple.x][tuple.y + 1]));
            }
        }
        return queue.poll().val;
    }
    class Tuple implements Comparable<Tuple> {
        private int x;
        private int y;
        private int val;

        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple o) {
            if (this.val > o.val) {
                return 1;
            } else if (this.val < o.val) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
