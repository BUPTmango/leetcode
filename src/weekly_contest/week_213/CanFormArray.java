package weekly_contest.week_213;

import java.util.Arrays;

/**
 * ͬ ���ʲ��
 * 5554. �ܷ������γ�����
 * ����һ���������� arr �������е�ÿ������ ������ͬ ������һ�����������鹹�ɵ����� pieces�����е�����Ҳ ������ͬ �������� ����˳�� ���� pieces �е��������γ� arr �����ǣ������� ��ÿ������ pieces[i] �е�������������
 *
 * ����������� pieces �е������γ� arr ������ true �����򣬷��� false ��
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺arr = [85], pieces = [[85]]
 * �����true
 * ʾ�� 2��
 *
 * ���룺arr = [15,88], pieces = [[88],[15]]
 * �����true
 * ���ͣ��������� [15] �� [88]
 * ʾ�� 3��
 *
 * ���룺arr = [49,18,16], pieces = [[16,18,49]]
 * �����false
 * ���ͣ��������������Ҳ������������ pieces[0]
 * ʾ�� 4��
 *
 * ���룺arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
 * �����true
 * ���ͣ��������� [91]��[4,64] �� [78]
 * ʾ�� 5��
 *
 * ���룺arr = [1,3,5,7], pieces = [[2,4,6,8]]
 * �����false
 *
 *
 * ��ʾ��
 *
 * 1 <= pieces.length <= arr.length <= 100
 * sum(pieces[i].length) == arr.length
 * 1 <= pieces[i].length <= arr.length
 * 1 <= arr[i], pieces[i][j] <= 100
 * arr �е����� ������ͬ
 * pieces �е����� ������ͬ��Ҳ����˵������� pieces ��ƽ����һά���飬�����е���������������ͬ��
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/1 10:31 ����
 */
public class CanFormArray {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        // dp[i] ��ʾ�ַ��� arr ǰ i ��Ԫ����ɵ����� s[0..i-1] �Ƿ��ܱ��ո��ֳ����ɸ�pieces�г��ֵ�����
        boolean[] dp = new boolean[arr.length + 1];
        dp[0] = true;
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 0; j < i; j++) {
                // j֮ǰ�Ĵ��� �������һ��Ҳ���� ����iΪ����
                if (dp[j] && judgeInPieces(Arrays.copyOfRange(arr, j, i), pieces)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[arr.length];
    }

    /**
     * �ж�target�Ƿ���pieces��
     * @param target
     * @param pieces
     * @return
     */
    private boolean judgeInPieces(int[] target, int[][] pieces) {
        String targetStr = Arrays.toString(target);
        for (int[] piece : pieces) {
            String pieceStr = Arrays.toString(piece);
            if (pieceStr.equals(targetStr)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CanFormArray can = new CanFormArray();
        int[] arr = new int[]{49,18,16};
        int[][] pieces = new int[][]{{16,18,49}};
        System.out.println(can.canFormArray(arr, pieces));
    }
}
