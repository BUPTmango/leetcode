//package middle_level.jianzhi_offer;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Random;
//
///**
// * @author Wang Guolong
// * @version 1.0
// * @date 2020/7/31 5:50 ����
// */
//public class GenerateWordBoard {
//
//    private static char[][] board;
//    private static char[] wordChar;
//    private static List<int[]> rightPath;
//
//    public static void main(String[] args) {
//        generateRandomMatrix("vocabulary", 5, 5);
//    }
//
//    /**
//     * ��������
//     *
//     * @param word ����
//     * @param m    ����
//     * @param n    ���
//     */
//    private static void generateRandomMatrix(String word, int m, int n) {
//        // ����Ϊ�� ֱ�ӷ���
//        if (word.isEmpty()) {
//            return;
//        }
//        // ���ʳ��ȴ������� �̲��� ֱ�ӷ���
//        if (word.length() > m * n) {
//            return;
//        }
//
//        // ��ʼ��
//        board = new char[m][n];
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                board[i][j] = '*';
//            }
//        }
//
//        wordChar = word.toCharArray();
//        // ���ѡȡһ��λ�ÿ�ʼ
//        Random random = new Random();
//        int randomX = random.nextInt(m);
//        int randomY = random.nextInt(n);
//
//    }
//
//    private static boolean dp(int index, int x, int y) {
//        board[x][y] = wordChar[index];
//        if (index == wordChar.length - 1) {
//            rightPath.add(new int[] {x, y});
//            return true;
//        }
//
//
//    }
//}
