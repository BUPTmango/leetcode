
package middle_level.jianzhi_offer;

import java.util.*;

/**
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/31 5:50 ����
 */
public class GenerateWordBoard {

    private static char[][] board;

    public static void main(String[] args) {
        GenerateWordBoard g = new GenerateWordBoard();
        g.generateCharBoard("vocabulary", 5, 5);
    }

    private void generateCharBoard(String word, int m, int n) {
        // ����Ϊ�� ֱ�ӷ���
        if (word.isEmpty()) {
            return;
        }
        // ���ʳ��ȴ������� �̲��� ֱ�ӷ���
        if (word.length() > m * n) {
            return;
        }
        // ��ʼ������ ȫΪ*
        initBoard(m, n);

        char[] wordChar = word.toCharArray();
        // ���ѡȡһ��λ�ÿ�ʼ
        Random random = new Random();
        int randomX = random.nextInt(m);
        int randomY = random.nextInt(n);
        // ��ʼ�����λ��dfs�̵��� ��index 0 ��ʼ
        boolean result = generateDfs(board, wordChar, randomX, randomY, 0);
        // ���û���ҵ�·�� ��ô���ĸ��ǿ�ʼ �����ҵ�һ��·
        if (!result) {
            List<int[]> starts = Arrays.asList(new int[]{0, 0}, new int[]{0, n - 1}, new int[]{m - 1, 0},
                    new int[]{m - 1, n - 1});
            // ����ĸ��ǵ�һ��
            Collections.shuffle(starts);
            // ��ʼ������
            initBoard(m, n);
            // dfs�̵���
            generateDfs(board, wordChar, starts.get(0)[0], starts.get(0)[1], 0);
        }
        // �鿴���
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }

    private void initBoard(int m, int n) {
        // ��ʼ��
        board = new char[m][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = '*';
            }
        }
    }

    /**
     * ����true��Ϊ�ҵ�һ��· ����falseΪ��·
     */
    private boolean generateDfs(char[][] board, char[] wordChar, int i, int j, int index) {
        // ������ ���������Ѿ��߹���λ�� �������� ��·
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] == '/') {
            return false;
        }

        // �ڷ�һ����ĸ
        board[i][j] = wordChar[index];

        //����Ѿ��ﵽ���ʳ�����ֱ�ӷ��� �ҵ�һ��·
        if (index == wordChar.length - 1) {
            return true;
        }

        // ��¼��ǰ����Ԫ��
        char tmp = board[i][j];
        // �޸�Ϊ/ ��ʾ�Ѿ����ʹ�
        board[i][j] = '/';

        // �����������ĸ��������ݹ�
        // �鿴���߼������� ���ѡ��һ��
        List<int[]> directions = Arrays.asList(new int[]{-1, 0}, new int[]{1, 0}, new int[]{0, -1}, new int[]{0, 1});
        Collections.shuffle(directions);

        boolean res = false;
        for (int k = 0; k < directions.size(); k++) {
            int di = i + directions.get(k)[0], dj = j + directions.get(k)[1];
            boolean partialRes = generateDfs(board, wordChar, di, dj, index + 1);
            if (k == 0) {
                res = partialRes;
            } else {
                res = res || partialRes;
            }
            // ���resΪtrue ˵���ҵ�һ��· �Ͳ��ٱ����� ��ԭ�󷵻�true
            if (res) {
                // ��ԭ����Ԫ��
                board[i][j] = tmp;
                return true;
            }
        }
        // ��ԭ����Ԫ��
        board[i][j] = '*';
        return false;
    }
}
