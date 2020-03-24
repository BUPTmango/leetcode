package simple_level.coder_gold;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ������ 03.06. ����������
 * �������������мҶ���������ֻ���ݹ���è�����ϸ����ء��Ƚ��ȳ�����ԭ�����������������Ķ���ʱ��������ֻ���������ж����С����ϡ������������������ʱ�䳤�̶������Ķ�����߿�����ѡè�򹷣�ͬʱ�����������ද���С����ϡ��ģ�������֮�������˲���������ѡ�������Ķ����봴�����������ϵͳ�����ݽṹ��ʵ�ָ��ֲ�������������enqueue��dequeueAny��dequeueDog��dequeueCat������ʹ��Java���õ�LinkedList���ݽṹ��
 *
 * enqueue������һ��animal������animal[0]�������ţ�animal[1]���������࣬���� 0 ����è��1 ������
 *
 * dequeue*��������һ���б�[������, ��������]����û�п��������Ķ���򷵻�[-1,-1]��
 *
 * ʾ��1:
 *
 *  ���룺
 * ["AnimalShelf", "enqueue", "enqueue", "dequeueCat", "dequeueDog", "dequeueAny"]
 * [[], [[0, 0]], [[1, 0]], [], [], []]
 *  �����
 * [null,null,null,[0,0],[-1,-1],[1,0]]
 * ʾ��2:
 *
 *  ���룺
 * ["AnimalShelf", "enqueue", "enqueue", "enqueue", "dequeueDog", "dequeueCat", "dequeueAny"]
 * [[], [[0, 0]], [[1, 0]], [[2, 1]], [], [], []]
 *  �����
 * [null,null,null,null,[2,1],[0,0],[1,0]]
 * ˵��:
 *
 * ���������������Ϊ20000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/24 9:35 ����
 */
class AnimalShelf {

    Queue<int[]> dogQueue;
    Queue<int[]> catQueue;

    public AnimalShelf() {
        dogQueue = new LinkedList<>();
        catQueue = new LinkedList<>();
    }

    /**
     * �ֱ���animal[1]=0�Ľ�queue1��animal[1]=1�Ľ�queue2
     * @param animal
     */
    public void enqueue(int[] animal) {
        if (animal[1] == 0) {
            catQueue.offer(animal);
        } else {
            dogQueue.offer(animal);
        }
    }

    /**
     * ��queue1��queue2��Ϊ�գ���ֱ�ӷ���{-1,-1};
     * ��������һ��Ϊ�գ��򷵻���һ����ͷ��;
     * ������Ϊ����ֱ�ȡ��ͷ���Ƚ���ż���
     * @return
     */
    public int[] dequeueAny() {
        if(catQueue.isEmpty()&&dogQueue.isEmpty()) {
            return new int[]{-1,-1};
        }
        if(catQueue.isEmpty()||dogQueue.isEmpty())
        {
            return catQueue.isEmpty() ? dogQueue.poll():catQueue.poll();
        }
        int[] temp1=catQueue.peek();
        int[] temp2=dogQueue.peek();
        if(temp1[0]<temp2[0]) {
            return catQueue.poll();
        } else {
            return dogQueue.poll();
        }
    }

    /**
     * queue2Ϊ���򷵻�{-1,-1};���򷵻�ͷ��
     * @return
     */
    public int[] dequeueDog() {
        if(dogQueue.isEmpty()) {
            return new int[]{-1,-1};
        }
        return dogQueue.poll();
    }

    /**
     * queue1Ϊ���򷵻�{-1,-1};���򷵻�ͷ��
     * @return
     */
    public int[] dequeueCat() {
        if(catQueue.isEmpty()) {
            return new int[]{-1,-1};
        }
        return catQueue.poll();
    }
}