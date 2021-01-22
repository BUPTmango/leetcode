package hard_level.sword_offer;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ��ָ Offer 41. �������е���λ��
 * ��εõ�һ���������е���λ����������������ж�����������ֵ����ô��λ������������ֵ����֮��λ���м����ֵ��������������ж���ż������ֵ����ô��λ������������ֵ����֮���м���������ƽ��ֵ��
 * <p>
 * ���磬
 * <p>
 * [2,3,4]����λ���� 3
 * <p>
 * [2,3] ����λ���� (2 + 3) / 2 = 2.5
 * <p>
 * ���һ��֧���������ֲ��������ݽṹ��
 * <p>
 * void addNum(int num) - �������������һ�����������ݽṹ�С�
 * double findMedian() - ����Ŀǰ����Ԫ�ص���λ����
 * ʾ�� 1��
 * <p>
 * ���룺
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * �����[null,null,null,1.50000,null,2.00000]
 * ʾ�� 2��
 * <p>
 * ���룺
 * ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 * [[],[2],[],[3],[]]
 * �����[null,null,2.00000,null,2.50000]
 * <p>
 * ���ƣ�
 * <p>
 * �����addNum��findMedian ����50000�ε��á�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/1/22 5:51 ����
 */
public class MedianFinder {
    Queue<Integer> A, B;

    public MedianFinder() {
        // С���ѣ�����ϴ��һ��
        A = new PriorityQueue<>();
        // �󶥶ѣ������С��һ��
        B = new PriorityQueue<>((x, y) -> (y - x));
    }

    public void addNum(int num) {
        // ����Ŀ������ ����B
        if (A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
            // ����Ŀ��ż�� ����A
        } else {
            B.add(num);
            A.add(B.poll());
        }
    }

    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }
}
