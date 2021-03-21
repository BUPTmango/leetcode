package middle_level;

/**
 * 641. ���ѭ��˫�˶���
 * ���ʵ��˫�˶��С�
 * ���ʵ����Ҫ֧�����²�����
 * <p>
 * MyCircularDeque(k)�����캯��,˫�˶��еĴ�СΪk��
 * insertFront()����һ��Ԫ����ӵ�˫�˶���ͷ���� ��������ɹ����� true��
 * insertLast()����һ��Ԫ����ӵ�˫�˶���β������������ɹ����� true��
 * deleteFront()����˫�˶���ͷ��ɾ��һ��Ԫ�ء� ��������ɹ����� true��
 * deleteLast()����˫�˶���β��ɾ��һ��Ԫ�ء���������ɹ����� true��
 * getFront()����˫�˶���ͷ�����һ��Ԫ�ء����˫�˶���Ϊ�գ����� -1��
 * getRear()�����˫�˶��е����һ��Ԫ�ء����˫�˶���Ϊ�գ����� -1��
 * isEmpty()�����˫�˶����Ƿ�Ϊ�ա�
 * isFull()�����˫�˶����Ƿ����ˡ�
 * ʾ����
 * <p>
 * MyCircularDeque circularDeque = new MycircularDeque(3); // ����������СΪ3
 * circularDeque.insertLast(1);			        // ���� true
 * circularDeque.insertLast(2);			        // ���� true
 * circularDeque.insertFront(3);			        // ���� true
 * circularDeque.insertFront(4);			        // �Ѿ����ˣ����� false
 * circularDeque.getRear();  				// ���� 2
 * circularDeque.isFull();				        // ���� true
 * circularDeque.deleteLast();			        // ���� true
 * circularDeque.insertFront(4);			        // ���� true
 * circularDeque.getFront();				// ���� 4
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/3/21 9:59 ����
 */
public class MyCircularDeque {

    private int[] queue;
    private int front;
    private int rear;
    private int capacity;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        this.queue = new int[k + 1];
        this.capacity = k + 1;
        this.front = 0;
        this.rear = 0;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (!this.isFull()) {
            this.front = (this.front - 1 + this.capacity) % this.capacity;
            this.queue[this.front] = value;
            return true;
        }
        return false;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (!isFull()) {
            this.queue[this.rear] = value;
            this.rear = (this.rear + 1) % this.capacity;
            return true;
        }
        return false;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (!this.isEmpty()) {
            this.front = (this.front + 1) % this.capacity;
            return true;
        }
        return false;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (!this.isEmpty()) {
            this.rear = (this.rear - 1 + this.capacity) % this.capacity;
            return true;
        }
        return false;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (!this.isEmpty()) {
            return this.queue[this.front];
        }
        return -1;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (!this.isEmpty()) {
            return this.queue[(this.rear - 1 + this.capacity) % this.capacity];
        }
        return -1;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        if (this.front == this.rear) {
            return true;
        }
        return false;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        if ((this.rear + 1) % this.capacity == this.front) {
            return true;
        }
        return false;
    }
}
