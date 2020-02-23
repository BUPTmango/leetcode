package simple_level;

import java.util.ArrayList;
import java.util.List;

/**
 * 448
 *  �ҵ�������������ʧ������
 *  ����һ����Χ��? 1 �� a[i] �� n (?n = �����С ) �� �������飬�����е�Ԫ��һЩ���������Σ���һЩֻ����һ�Ρ�
 *
 * �ҵ������� [1, n] ��Χ֮��û�г����������е����֡�
 *
 * �����ڲ�ʹ�ö���ռ���ʱ�临�Ӷ�ΪO(n)�������������������? ����Լٶ����ص����鲻���ڶ���ռ��ڡ�
 *
 * ʾ��:
 *
 * ����:
 * [4,3,2,7,8,2,3,1]
 *
 * ���:
 * [5,6]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/12 10:30 ����
 */
public class FindDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        // ��ֵ��������ʾ��û���ֹ�
        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0){
                // �������Ļ� ����ȡ����ֵ��֤ԭ��������ֵ����ʧ
                nums[index] = -nums[index];
            }
        }
        // ����û���ֹ�������
        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0){
                list.add(i + 1);
            }
        }
        return list;
    }

}
