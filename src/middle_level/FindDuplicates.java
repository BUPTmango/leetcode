package middle_level;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. �������ظ�������
 * ����һ���������� a������1 �� a[i] �� n ��nΪ���鳤�ȣ�, ������ЩԪ�س������ζ�����Ԫ�س���һ�Ρ�
 * <p>
 * �ҵ����г������ε�Ԫ�ء�
 * <p>
 * ����Բ��õ��κζ���ռ䲢��O(n)ʱ�临�Ӷ��ڽ�����������
 * <p>
 * ʾ����
 * <p>
 * ����:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * ���:
 * [2,3]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/3 8:17 ����
 */
public class FindDuplicates {
    /**
     * �ҵ�����iʱ����λ��i-1�������ַ�תΪ������
     * ���λ��i-1 �ϵ������Ѿ�Ϊ������i�ǳ������ε����֡�
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                res.add(index + 1);
            }
            nums[index] = -nums[index];
        }
        return res;
    }
}
