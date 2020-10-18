package middle_level;

import data_structure.linked_list.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 817. �������
 * ��������ͷ���head���������ϵ�ÿ����㶼��һ�� Ψһ������ֵ ��
 *
 * ͬʱ�����б�G�����б�����������������ֵ��һ���Ӽ���
 *
 * �����б�G������ĸ��������������Ķ���Ϊ��������һ�����������ֵ����ֵ�������б�G�У����ɵļ��ϡ�
 *
 * ʾ��1��
 *
 * ����:
 * head: 0->1->2->3
 * G = [0, 1, 3]
 * ���: 2
 * ����:
 * ������,0 �� 1 �������ӵģ��� G �в����� 2������ [0, 1] �� G ��һ�������ͬ�� [3] Ҳ��һ��������ʷ��� 2��
 * ʾ�� 2��
 *
 * ����:
 * head: 0->1->2->3->4
 * G = [0, 3, 1, 4]
 * ���: 2
 * ����:
 * �����У�0 �� 1 �������ӵģ�3 �� 4 �������ӵģ����� [0, 1] �� [3, 4] ������������ʷ��� 2��
 * 
 * ��ʾ��
 *
 * ���N�Ǹ�������head�ĳ��ȣ�1 <= N <= 10000��
 * ������ÿ������ֵ���ڷ�ΧΪ[0, N - 1]��
 * 1 <= G.length <= 10000
 * G �����������н���ֵ��һ���Ӽ�.
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/18 9:49 ����
 */
public class NumComponents {
    public int numComponents(ListNode head, int[] G) {
        // G -> set
        Set<Integer> set = new HashSet<>();
        for (int g : G) {
            set.add(g);
        }
        // ����Ƿ�Ϊ������Ŀ�ʼ
        boolean flag = false;
        int count = 0;
        // ��������
        ListNode pointer = head;
        while (pointer != null) {
            // ���� �����������Ŀ�ʼ count++
            if (set.contains(pointer.val)) {
                if (!flag) {
                    count++;
                    flag = true;
                }
            } else {
                // ������ ����Ѱ��������Ŀ�ʼ
                flag = false;
            }
            pointer = pointer.next;
        }
        return count;
    }
}
