package simple_level.coder_gold;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题 03.06. 动物收容所
 * 动物收容所。有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则。在收养该收容所的动物时，收养人只能收养所有动物中“最老”（由其进入收容所的时间长短而定）的动物，或者可以挑选猫或狗（同时必须收养此类动物中“最老”的）。换言之，收养人不能自由挑选想收养的对象。请创建适用于这个系统的数据结构，实现各种操作方法，比如enqueue、dequeueAny、dequeueDog和dequeueCat。允许使用Java内置的LinkedList数据结构。
 *
 * enqueue方法有一个animal参数，animal[0]代表动物编号，animal[1]代表动物种类，其中 0 代表猫，1 代表狗。
 *
 * dequeue*方法返回一个列表[动物编号, 动物种类]，若没有可以收养的动物，则返回[-1,-1]。
 *
 * 示例1:
 *
 *  输入：
 * ["AnimalShelf", "enqueue", "enqueue", "dequeueCat", "dequeueDog", "dequeueAny"]
 * [[], [[0, 0]], [[1, 0]], [], [], []]
 *  输出：
 * [null,null,null,[0,0],[-1,-1],[1,0]]
 * 示例2:
 *
 *  输入：
 * ["AnimalShelf", "enqueue", "enqueue", "enqueue", "dequeueDog", "dequeueCat", "dequeueAny"]
 * [[], [[0, 0]], [[1, 0]], [[2, 1]], [], [], []]
 *  输出：
 * [null,null,null,null,[2,1],[0,0],[1,0]]
 * 说明:
 *
 * 收纳所的最大容量为20000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/24 9:35 上午
 */
class AnimalShelf {

    Queue<int[]> dogQueue;
    Queue<int[]> catQueue;

    public AnimalShelf() {
        dogQueue = new LinkedList<>();
        catQueue = new LinkedList<>();
    }

    /**
     * 分别让animal[1]=0的进queue1，animal[1]=1的进queue2
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
     * 若queue1，queue2均为空，则直接返回{-1,-1};
     * 若其中有一个为空，则返回另一个的头部;
     * 若均不为空则分别取出头部比较序号即可
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
     * queue2为空则返回{-1,-1};否则返回头部
     * @return
     */
    public int[] dequeueDog() {
        if(dogQueue.isEmpty()) {
            return new int[]{-1,-1};
        }
        return dogQueue.poll();
    }

    /**
     * queue1为空则返回{-1,-1};否则返回头部
     * @return
     */
    public int[] dequeueCat() {
        if(catQueue.isEmpty()) {
            return new int[]{-1,-1};
        }
        return catQueue.poll();
    }
}