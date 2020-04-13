package middle_level;

import data_structure.linked_list.ListNode;

/**
 * 725. �ָ�����
 * ����һ��ͷ���Ϊ root ������, ��дһ�������Խ�����ָ�Ϊ k �������Ĳ��֡�
 *
 * ÿ���ֵĳ���Ӧ�þ����ܵ����: ���������ֵĳ��Ȳ�಻�ܳ��� 1��Ҳ����˵������Щ����Ϊ null��
 *
 * ��k������Ӧ�ð����������г��ֵ�˳������������������ǰ��Ĳ��ֵĳ���Ӧ�ô��ڻ���ں���ĳ��ȡ�
 *
 * ����һ���������������������б�
 *
 * ������ 1->2->3->4, k = 5 // 5 ��� [ [1], [2], [3], [4], null ]
 *
 * ʾ�� 1��
 *
 * ����:
 * root = [1, 2, 3], k = 5
 * ���: [[1],[2],[3],[],[]]
 * ����:
 * ������������ֶ�Ӧ�����������������顣
 * ����, ����Ľ�� root �� val= 1, root.next.val = 2, \root.next.next.val = 3, �� root.next.next.next = null��
 * ��һ����� output[0] �� output[0].val = 1, output[0].next = null��
 * ���һ��Ԫ�� output[4] Ϊ null, �����������һ������Ϊ������
 * ʾ�� 2��
 *
 * ����:
 * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * ���: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 * ����:
 * ���뱻�ֳ��˼��������Ĳ��֣�����ÿ���ֵĳ���������1.ǰ�沿�ֵĳ��ȴ��ڵ��ں��沿�ֵĳ��ȡ�
 * ?
 *
 * ��ʾ:
 *
 * root �ĳ��ȷ�Χ��?[0, 1000].
 * �����ÿ���ڵ�Ĵ�С��Χ��[0, 999].
 * k?��ȡֵ��Χ��?[1, 50].
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/13 11:38 ����
 */
public class SplitListToParts {
    /**
     * ȷ��ÿһ��������Ľڵ����
     * ��ԭ�е������н��зָ�
     * �������µ�����洢�·ָ�õ�������
     * [note]�ؼ��������ȷ��ÿһ�����ָ�������ĳ���(�������ڵ�ĸ���)
     * @param root
     * @param k
     * @return
     */
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode cur = root;
        int N = 0;
        while (cur != null) {
            cur = cur.next;
            N++;
        }

        int width = N / k, rem = N % k;

        ListNode[] ans = new ListNode[k];
        cur = root;
        for (int i = 0; i < k; ++i) {
            ListNode head = cur;
            for (int j = 0; j < width + (i < rem ? 1 : 0) - 1; ++j) {
                if (cur != null) {
                    cur = cur.next;
                }
            }
            // ���������ĩβָ��Ϊnull
            if (cur != null) {
                ListNode prev = cur;
                cur = cur.next;
                prev.next = null;
            }
            ans[i] = head;
        }
        return ans;
    }
}
