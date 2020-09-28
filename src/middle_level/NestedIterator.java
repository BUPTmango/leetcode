package middle_level;

import data_structure.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ����ת�㷨������Ƶ���⡷ջ �ݹ�
 * 341. ��ƽ��Ƕ���б������
 * ����һ��Ƕ�׵������б��������һ����������ʹ���ܹ�������������б��е�����������
 *
 * �б��е�ÿһ�����Ϊһ����������������һ���б������б��Ԫ��Ҳ�������������������б�
 *
 * 
 *
 * ʾ�� 1:
 *
 * ����: [[1,1],2,[1,1]]
 * ���: [1,1,2,1,1]
 * ����: ͨ���ظ�����next ֱ��hasNext ���� false��next���ص�Ԫ�ص�˳��Ӧ����: [1,1,2,1,1]��
 * ʾ�� 2:
 *
 * ����: [1,[4,[6]]]
 * ���: [1,4,6]
 * ����: ͨ���ظ�����nextֱ��hasNext ���� false��next���ص�Ԫ�ص�˳��Ӧ����: [1,4,6]��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/28 8:53 ����
 */
public class NestedIterator implements Iterator<Integer> {

    private List<Integer> list;
    private int index;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = integerIterator(nestedList);
        index = -1;
    }

    @Override
    public Integer next() {
        if (this.hasNext()) {
            return list.get(++index);
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return index + 1 < list.size();
    }

    /**
     * �ݹ�����б��е����ݣ��������ͷ���List���������ٵݹ����
     * @param nestedIntegerList
     * @return
     */
    private static List<Integer> integerIterator(List<NestedInteger> nestedIntegerList) {
        ArrayList<Integer> list = new ArrayList<>();
        for (NestedInteger tmp : nestedIntegerList) {
            if (tmp.isInteger()) {
                list.add(tmp.getInteger());
            } else {
                list.addAll(integerIterator(tmp.getList()));
            }
        }
        return list;
    }
}
