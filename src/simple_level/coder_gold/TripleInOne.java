package simple_level.coder_gold;

/**
 * 面试题 03.01. 三合一
 * 三合一。描述如何只用一个数组来实现三个栈。
 * <p>
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
 * <p>
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 * <p>
 * 示例1:
 * <p>
 * 输入：
 * ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
 * [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
 * 输出：
 * [null, null, null, 1, -1, -1, true]
 * 说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
 * 示例2:
 * <p>
 * 输入：
 * ["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
 * [[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
 * 输出：
 * [null, null, null, null, 2, 1, -1, -1]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/26 1:23 下午
 */
class TripleInOne {
    /*
    定义一个数组arr，数组的位置分配规则如下：
    数组的下标为[0, 0 + 3, ... , 0 + 3 * (stackSize - 1)][0,0+3,...,0+3?(stackSize?1)] 存放stack_0;
    数组的下标为[1, 1 + 3, ... , 1 + 3 * (stackSize - 1)][1,1+3,...,1+3?(stackSize?1)] 存放stack_1;
    数组的下标为[2, 2 + 3, ... , 2 + 3 * (stackSize - 1)][2,2+3,...,2+3?(stackSize?1)] 存放stack_2;
    然后，新建一个数组stackTop，用来标记每个栈的栈顶可插入元素的下标（在arr中的下标）。
    当执行push操作的时候，需要处理判满，当执行pop或peek操作的时候需要处理判空。其中判空和判满都是根据stackTop来判断。
     */

    private int[] arr;
    private int[] stackTop; // 每个栈当前可push的索引（对应到arr中的索引）
    private int stackSize;

    public TripleInOne(int stackSize) {
        this.stackSize = stackSize;
        arr = new int[stackSize * 3];
        stackTop = new int[]{0, 1, 2};
    }

    public void push(int stackNum, int value) {
        int curStackTop = stackTop[stackNum];
        if (curStackTop / 3 == stackSize) {
            // 栈已满
            return;
        }

        arr[curStackTop] = value;
        stackTop[stackNum] += 3;
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            return -1;
        }


        int value = arr[stackTop[stackNum] - 3];
        stackTop[stackNum] -= 3;
        return value;
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            return -1;
        }

        return arr[stackTop[stackNum] - 3];
    }

    public boolean isEmpty(int stackNum) {
        return stackTop[stackNum] < 3;
    }
}
