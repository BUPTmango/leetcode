package middle_level.jianzhi_offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ������59 - II. ���е����ֵ
 * �붨��һ�����в�ʵ�ֺ��� max_value �õ�����������ֵ��Ҫ����max_value��push_back �� pop_front �ľ�̯ʱ�临�Ӷȶ���O(1)��
 *
 * ������Ϊ�գ�pop_front �� max_value?��Ҫ���� -1
 *
 * ʾ�� 1��
 *
 * ����:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * ���:?[null,null,null,2,1,2]
 * ʾ�� 2��
 *
 * ����:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * ���:?[null,-1,-1]
 * ?
 *
 * ���ƣ�
 *
 * 1 <= push_back,pop_front,max_value���ܲ�����?<= 10000
 * 1 <= value <= 10^5
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/6 11:57 ����
 */
class MaxQueue {
    Queue<Integer> que;
    Deque<Integer> deq;

    public MaxQueue() {
        que = new LinkedList<>();  //���У������ɾ��
        deq = new LinkedList<>();  //˫�˶��У���ȡ���ֵ
    }

    public int max_value() {
        return deq.size() > 0 ? deq.peek() : -1;  //˫�˶��еĶ���Ϊque�����ֵ
    }

    public void push_back(int value) {
        que.offer(value);  //value���
        while(deq.size() > 0 && deq.peekLast() < value){
            deq.pollLast();  //��deq��βС��value��Ԫ��ɾ��
        }
        deq.offerLast(value);  //��value����deq��β
    }

    public int pop_front() {
        int tmp = que.size() > 0 ? que.poll() : -1;  //��ö���Ԫ��
        if(deq.size() > 0 && tmp == deq.peek()){
            deq.poll();  //������ӵ�Ԫ���ǵ�ǰ���ֵ����deq�Ķ��׳���
        }
        return tmp;
    }
}
