package simple_level;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. ��������
 * ����һ�����ظ�Ԫ�ص������������� nums ��
 *
 * ���� ǡ�ø����������������� �� ��С���� ���䷶Χ�б�Ҳ����˵��nums ��ÿ��Ԫ�ض�ǡ�ñ�ĳ�����䷶Χ�����ǣ����Ҳ���������ĳ����Χ�������� nums ������ x ��
 *
 * �б��е�ÿ�����䷶Χ [a,b] Ӧ�ð����¸�ʽ�����
 *
 * "a->b" ����� a != b
 * "a" ����� a == b
 * ?
 *
 * ʾ�� 1��
 *
 * ���룺nums = [0,1,2,4,5,7]
 * �����["0->2","4->5","7"]
 * ���ͣ����䷶Χ�ǣ�
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * ʾ�� 2��
 *
 * ���룺nums = [0,2,3,4,6,8,9]
 * �����["0","2->4","6","8->9"]
 * ���ͣ����䷶Χ�ǣ�
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * ʾ�� 3��
 *
 * ���룺nums = []
 * �����[]
 * ʾ�� 4��
 *
 * ���룺nums = [-1]
 * �����["-1"]
 * ʾ�� 5��
 *
 * ���룺nums = [0]
 * �����["0"]
 *
 * ��ʾ��
 *
 * 0 <= nums.length <= 20
 * -231 <= nums[i] <= 231 - 1
 * nums �е�����ֵ�� ������ͬ
 * nums ����������
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/1/10 10:23 ����
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuilder temp = new StringBuilder(Integer.toString(nums[low]));
            // ���ֻ��һ��Ԫ�� ������Լ�������
            if (low < high) {
                temp.append("->");
                temp.append(nums[high]);
            }
            list.add(temp.toString());
        }
        return list;
    }
}
