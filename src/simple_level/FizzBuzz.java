package simple_level;

import java.util.ArrayList;
import java.util.List;

/**
 * 412
 * Fizz Buzz
 * дһ����������� 1 �� n ���ֵ��ַ�����ʾ��
 *
 * 1. ���?n?��3�ı����������Fizz����
 *
 * 2. ���?n?��5�ı����������Buzz����
 *
 * 3.���?n?ͬʱ��3��5�ı�������� ��FizzBuzz����
 *
 * ʾ����
 *
 * n = 15,
 *
 * ����:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/18 9:38 ����
 */
public class FizzBuzz {
    /**
     * ע����ʼ�� �Ǵ�1��ʼ��
     * @param n
     * @return
     */
    public List<String> fizzBuzz(int n) {
        List<String> resultList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                resultList.add("FizzBuzz");
            } else if (i % 3 == 0) {
                resultList.add("Fizz");
            } else if (i % 5 == 0) {
                resultList.add("Buzz");
            } else {
                resultList.add(i + "");
            }
        }
        return resultList;
    }
}
