package simple_level;

/**
 * ���ַ�
 * 744. Ѱ�ұ�Ŀ����ĸ�����С��ĸ
 * ����һ���������ַ��б� letters ���б���ֻ����СдӢ����ĸ�������һ��Ŀ����ĸtarget������Ѱ������һ�����б����Ŀ����ĸ�����С��ĸ��
 * <p>
 * �ڱȽ�ʱ����ĸ������ѭ�����ֵġ��ٸ����ӣ�
 * <p>
 * ���Ŀ����ĸ target = 'z' �����ַ��б�Ϊletters = ['a', 'b']����𰸷���'a'
 * <p>
 * ʾ����
 * <p>
 * ����:
 * letters = ["c", "f", "j"]
 * target = "a"
 * ���: "c"
 * <p>
 * ����:
 * letters = ["c", "f", "j"]
 * target = "c"
 * ���: "f"
 * <p>
 * ����:
 * letters = ["c", "f", "j"]
 * target = "d"
 * ���: "f"
 * <p>
 * ����:
 * letters = ["c", "f", "j"]
 * target = "g"
 * ���: "j"
 * <p>
 * ����:
 * letters = ["c", "f", "j"]
 * target = "j"
 * ���: "c"
 * <p>
 * ����:
 * letters = ["c", "f", "j"]
 * target = "k"
 * ���: "c"
 * <p>
 * ��ʾ��
 * <p>
 * letters���ȷ�Χ��[2, 10000]�����ڡ�
 * letters ����Сд��ĸ��ɣ����ٰ���������ͬ����ĸ��
 * Ŀ����ĸtarget ��һ��Сд��ĸ��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/2/18 10:39 ����
 */
public class NextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, h = letters.length - 1, mid;
        while (h >= l) {
            mid = (h + l) / 2;
            if (letters[mid] > target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return letters[l % letters.length];
    }
}
