package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Wang Guolong
 * @version 1.0
 * @date 2019/10/12 2:59 下午
 */
public class ArrayEqualTest {
    public static List<Long> getAll(List<Long> listA, List<Long> listB) {
        listA.removeAll(listB);
        listA.addAll(listB);
        return listA;
    }
    public static void main(String[] args) {
        List<Long> listA = new ArrayList<>();
        List<Long> listB = new ArrayList<>();
        listA.add(new Long(1111));
        listA.add(new Long(2222));
        listA.add(new Long(5555));
        listB.add(new Long(6666));
        listB.add(new Long(5555));
        listB.add(new Long(2222));
        listB.add(new Long(7777));
        getAll(listA, listB).forEach(item -> System.out.println(item));

    }
}
