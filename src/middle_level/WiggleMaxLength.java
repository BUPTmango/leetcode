package middle_level;

/**
 * ����ת�㷨������Ƶ���⡷��̬�滮 �����������
 * 376. �ڶ�����
 * �����������֮��Ĳ��ϸ���������͸���֮�佻�棬���������г�Ϊ�ڶ����С���һ���������ڵĻ���������������������������Ԫ�ص�����Ҳ�ǰڶ����С�
 *
 * ���磬[1,7,4,9,2,5] ��һ���ڶ����У���Ϊ��ֵ (6,-3,5,-7,3)������������ֵġ��෴, [1,4,7,2,5]��[1,7,4,5,5] ���ǰڶ����У���һ����������Ϊ����ǰ������ֵ�����������ڶ�����������Ϊ�������һ����ֵΪ�㡣
 *
 * ����һ���������У�������Ϊ�ڶ����е�������еĳ��ȡ� ͨ����ԭʼ������ɾ��һЩ��Ҳ���Բ�ɾ����Ԫ������������У�ʣ�µ�Ԫ�ر�����ԭʼ˳��
 *
 * ʾ�� 1:
 *
 * ����: [1,7,4,9,2,5]
 * ���: 6
 * ����: �������о�Ϊ�ڶ����С�
 * ʾ�� 2:
 *
 * ����: [1,17,5,10,13,15,10,5,16,8]
 * ���: 7
 * ����: ������а�����������Ϊ 7 �ڶ����У�����һ����Ϊ[1,17,10,13,10,16,8]��
 * ʾ�� 3:
 *
 * ����: [1,2,3,4,5,6,7,8,9]
 * ���: 2
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/20 6:51 ����
 */
public class WiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        // up[i] ��ʾ��i��β��������ϰڵ���󳤶�
        int[] up = new int[nums.length];
        // down[i] ��ʾ��i��β��������°ڵ���󳤶�
        int[] down = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // ����ľ�Ҫ��down�ı�
                    up[i] = Math.max(up[i],down[j] + 1);
                } else if (nums[i] < nums[j]) {
                    // �°ڵľ�Ҫ��up�ı�
                    down[i] = Math.max(down[i],up[j] + 1);
                }
            }
        }
        return 1 + Math.max(down[nums.length - 1], up[nums.length - 1]);
    }
}