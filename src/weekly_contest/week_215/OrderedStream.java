package weekly_contest.week_215;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 5601. ���������
 * �� n �� (id, value) �ԣ����� id �� 1 �� n ֮���һ��������value ��һ���ַ����������� id ��ͬ������ (id, value) �ԡ�
 *
 * ���һ�������� ���� ˳���ȡ n �� (id, value) �ԣ����ڶ�ε���ʱ �� id ������˳�� ����һЩֵ��
 *
 * ʵ�� OrderedStream �ࣺ
 *
 * OrderedStream(int n) ����һ���ܽ��� n ��ֵ������������ǰָ�� ptr ��Ϊ 1 ��
 * String[] insert(int id, String value) �����д洢�µ� (id, value) �ԡ��洢��
 * ������洢�� id = ptr �� (id, value) �ԣ����ҳ��� id = ptr ��ʼ�� � id ������������ ���� ��˳�� ��������Щ id ������ֵ���б�Ȼ�󣬽� ptr ����Ϊ����Ǹ�  id + 1 ��
 * ���򣬷���һ�����б�
 *
 *
 *
 * ʾ����
 *
 * ����
 * ["OrderedStream", "insert", "insert", "insert", "insert", "insert"]
 * [[5], [3, "ccccc"], [1, "aaaaa"], [2, "bbbbb"], [5, "eeeee"], [4, "ddddd"]]
 * ���
 * [null, [], ["aaaaa"], ["bbbbb", "ccccc"], [], ["ddddd", "eeeee"]]
 *
 * ����
 * OrderedStream os= new OrderedStream(5);
 * os.insert(3, "ccccc"); // ���� (3, "ccccc")������ []
 * os.insert(1, "aaaaa"); // ���� (1, "aaaaa")������ ["aaaaa"]
 * os.insert(2, "bbbbb"); // ���� (2, "bbbbb")������ ["bbbbb", "ccccc"]
 * os.insert(5, "eeeee"); // ���� (5, "eeeee")������ []
 * os.insert(4, "ddddd"); // ���� (4, "ddddd")������ ["ddddd", "eeeee"]
 *
 *
 * ��ʾ��
 *
 * 1 <= n <= 1000
 * 1 <= id <= n
 * value.length == 5
 * value ����Сд��ĸ���
 * ÿ�ε��� insert ����ʹ��һ��Ψһ�� id
 * ǡ�õ��� n �� insert
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/15 10:31 ����
 */
class OrderedStream {

    private int capacity;
    private int ptr;
    private Map<Integer, String> map;

    public OrderedStream(int n) {
        capacity = n;
        ptr = 1;
        map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, null);
        }
    }

    public List<String> insert(int id, String value) {
        List<String> res = new ArrayList<>();
        // �Ȳ���
        map.put(id, value);
        // id == ptr �����
        if (id == ptr) {
            for (int i = ptr; i <= capacity; i++) {
                String val = map.get(i);
                if (val == null) {
                    ptr = i;
                    break;
                } else {
                    res.add(val);
                }
            }
        }
        return res;
    }
}
