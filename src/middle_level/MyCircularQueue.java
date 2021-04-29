package middle_level;

/**
 * 622. ���ѭ������
 * ������ѭ������ʵ�֡� ѭ��������һ���������ݽṹ����������ֻ��� FIFO���Ƚ��ȳ���ԭ���Ҷ�β�������ڶ���֮�����γ�һ��ѭ������Ҳ����Ϊ�����λ���������
 * ѭ�����е�һ���ô������ǿ��������������֮ǰ�ù��Ŀռ䡣��һ����ͨ�����һ��һ���������ˣ����ǾͲ��ܲ�����һ��Ԫ�أ���ʹ�ڶ���ǰ�����пռ䡣����ʹ��ѭ�����У�������ʹ����Щ�ռ�ȥ�洢�µ�ֵ��
 * ���ʵ��Ӧ��֧�����²�����
 * <p>
 * MyCircularQueue(k): �����������ö��г���Ϊ k ��
 * Front: �Ӷ��׻�ȡԪ�ء��������Ϊ�գ����� -1 ��
 * Rear: ��ȡ��βԪ�ء��������Ϊ�գ����� -1 ��
 * enQueue(value): ��ѭ�����в���һ��Ԫ�ء�����ɹ������򷵻��档
 * deQueue(): ��ѭ��������ɾ��һ��Ԫ�ء�����ɹ�ɾ���򷵻��档
 * isEmpty(): ���ѭ�������Ƿ�Ϊ�ա�
 * isFull(): ���ѭ�������Ƿ�������
 * <p>
 * ʾ����
 * <p>
 * MyCircularQueue circularQueue = new MyCircularQueue(3); // ���ó���Ϊ 3
 * circularQueue.enQueue(1); // ���� true
 * circularQueue.enQueue(2); // ���� true
 * circularQueue.enQueue(3); // ���� true
 * circularQueue.enQueue(4); // ���� false����������
 * circularQueue.Rear(); // ���� 3
 * circularQueue.isFull(); // ���� true
 * circularQueue.deQueue(); // ���� true
 * circularQueue.enQueue(4); // ���� true
 * circularQueue.Rear(); // ���� 4
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/4/29 11:24
 */
public class MyCircularQueue {
    private int[] queue;
    private int headIndex;
    private int count;
    private int capacity;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        this.capacity = k;
        this.queue = new int[k];
        this.headIndex = 0;
        this.count = 0;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (this.count == this.capacity) {
            return false;
        }
        this.queue[(this.headIndex + this.count) % this.capacity] = value;
        this.count++;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (this.count == 0) {
            return false;
        }
        this.headIndex = (this.headIndex + 1) % this.capacity;
        this.count--;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (this.count == 0) {
            return -1;
        }
        return this.queue[this.headIndex];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (this.count == 0) {
            return -1;
        }
        int tailIndex = (this.headIndex + this.count - 1) % this.capacity;
        return this.queue[tailIndex];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return (this.count == 0);
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return (this.count == this.capacity);
    }
}
