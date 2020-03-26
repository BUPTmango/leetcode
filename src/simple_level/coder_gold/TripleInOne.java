package simple_level.coder_gold;

/**
 * ������ 03.01. ����һ
 * ����һ���������ֻ��һ��������ʵ������ջ��
 * <p>
 * ��Ӧ��ʵ��push(stackNum, value)��pop(stackNum)��isEmpty(stackNum)��peek(stackNum)������stackNum��ʾջ�±꣬value��ʾѹ���ֵ��
 * <p>
 * ���캯���ᴫ��һ��stackSize����������ÿ��ջ�Ĵ�С��
 * <p>
 * ʾ��1:
 * <p>
 * ���룺
 * ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
 * [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
 * �����
 * [null, null, null, 1, -1, -1, true]
 * ˵������ջΪ��ʱ`pop, peek`����-1����ջ��ʱ`push`��ѹ��Ԫ�ء�
 * ʾ��2:
 * <p>
 * ���룺
 * ["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
 * [[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
 * �����
 * [null, null, null, null, 2, 1, -1, -1]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/26 1:23 ����
 */
class TripleInOne {
    /*
    ����һ������arr�������λ�÷���������£�
    ������±�Ϊ[0, 0 + 3, ... , 0 + 3 * (stackSize - 1)][0,0+3,...,0+3?(stackSize?1)] ���stack_0;
    ������±�Ϊ[1, 1 + 3, ... , 1 + 3 * (stackSize - 1)][1,1+3,...,1+3?(stackSize?1)] ���stack_1;
    ������±�Ϊ[2, 2 + 3, ... , 2 + 3 * (stackSize - 1)][2,2+3,...,2+3?(stackSize?1)] ���stack_2;
    Ȼ���½�һ������stackTop���������ÿ��ջ��ջ���ɲ���Ԫ�ص��±꣨��arr�е��±꣩��
    ��ִ��push������ʱ����Ҫ������������ִ��pop��peek������ʱ����Ҫ�����пա������пպ��������Ǹ���stackTop���жϡ�
     */

    private int[] arr;
    private int[] stackTop; // ÿ��ջ��ǰ��push����������Ӧ��arr�е�������
    private int stackSize;

    public TripleInOne(int stackSize) {
        this.stackSize = stackSize;
        arr = new int[stackSize * 3];
        stackTop = new int[]{0, 1, 2};
    }

    public void push(int stackNum, int value) {
        int curStackTop = stackTop[stackNum];
        if (curStackTop / 3 == stackSize) {
            // ջ����
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
