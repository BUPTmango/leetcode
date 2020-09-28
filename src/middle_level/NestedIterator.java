package middle_level;

import data_structure.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 《玩转算法面试视频例题》栈 递归
 * 341. 扁平化嵌套列表迭代器
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 *
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 *
 * 
 *
 * 示例 1:
 *
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用next 直到hasNext 返回 false，next返回的元素的顺序应该是: [1,1,2,1,1]。
 * 示例 2:
 *
 * 输入: [1,[4,[6]]]
 * 输出: [1,4,6]
 * 解释: 通过重复调用next直到hasNext 返回 false，next返回的元素的顺序应该是: [1,4,6]。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/28 8:53 下午
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
     * 递归遍历列表中的数据，是整数就放入List，不是则再递归遍历
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
