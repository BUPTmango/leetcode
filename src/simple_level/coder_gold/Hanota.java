package simple_level.coder_gold;

import java.util.List;

/**
 * ������ 08.06. ��ŵ������
 * �ھ��人ŵ�������У��� 3 �����Ӽ� N ����ͬ��С�Ĵ���Բ�̣����ӿ��Ի�������һ�����ӡ�һ��ʼ�������������϶��°������������ڵ�һ��������(��ÿһ������ֻ�ܷ��ڸ������������)���ƶ�Բ��ʱ�ܵ���������:
 * (1) ÿ��ֻ���ƶ�һ������;
 * (2) ����ֻ�ܴ����Ӷ��˻����Ƶ���һ������;
 * (3) ����ֻ�ܵ��ڱ�����������ϡ�
 *
 * ���д������ջ���������Ӵӵ�һ�������Ƶ����һ�����ӡ�
 *
 * ����Ҫԭ���޸�ջ��
 *
 * ʾ��1:
 *
 *  ���룺A = [2, 1, 0], B = [], C = []
 *  �����C = [2, 1, 0]
 * ʾ��2:
 *
 *  ���룺A = [1, 0], B = [], C = []
 *  �����C = [1, 0]
 * ��ʾ:
 *
 * A�����ӵ���Ŀ������14����
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/24 9:15 ����
 */
public class Hanota {
    /**
     * n = 1 ʱ��ֱ�Ӱ����Ӵ� A �Ƶ� C��
     * n > 1 ʱ��
     * �Ȱ����� n - 1 �����Ӵ� A �Ƶ� B�������⣬�ݹ飩��
     * �ٽ��������Ӵ� A �Ƶ� C��
     * �ٽ� B �� n - 1 �����Ӵ� B �Ƶ� C�������⣬�ݹ飩��
     *
     * @param A
     * @param B
     * @param C
     */
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A.size(),A, B, C);
    }
    public void move(int n, List<Integer> A, List<Integer> B, List<Integer> C){
        if(n == 1){
            C.add(A.remove(A.size() - 1));
            //ע�⣺��Ŀ���������ǴӴ�С���ģ���������remove���ǡ�A.size() - 1��
            return;
        }
        move(n-1,A,C,B);
        C.add(A.remove(A.size() - 1));
        move(n - 1, B, A, C);
    }
}
