package io.vinson.server.test;

import org.junit.Test;

import java.util.*;

/**
 * 测试lambda和普通for循环遍历性能
 *
 * @author: jiangweixin
 * @date: 2019/4/8
 */
public class StreamTest {

    @Test
    public void testFind() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        int n = 10000;

        for(int i = 0; i < n; i++) {
            list1.add(i);
            list2.add(i + n - 1);
        }

        getEqualInListByLambda(list1, list2);
        getEqualInListByFor(list1, list2);
    }

    public <T> void getEqualInListByLambda(List<T> list1, List<T> list2) {
        long startTime = System.currentTimeMillis();
        Optional.ofNullable(list1)
                .orElse(Collections.emptyList())
                .stream()
                .forEach(item1 -> list2.stream()
                        .filter(item2 -> item1.equals(item2))
                        .findAny()
                        .ifPresent(item2 -> {
                            System.out.println("lambda sout: " + item1);
                        })
                );

        System.out.println("lambda cost time: " + (System.currentTimeMillis() - startTime));
    }
    public <T> void getEqualInListByFor(List<T> list1, List<T> list2) {
        long startTime = System.currentTimeMillis();
        for(T i : list1) {
            for(T j : list2) {
                if(i.equals(j)) {
                    System.out.println("for sout: " + i);
                    break;
                }
            }
        }
        System.out.println("for cycle cost time: " + (System.currentTimeMillis() - startTime));
    }


    @Test
    public void testCycleInDifJDK() {
        int n = 100000000;
        long sum = 0;
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < n; i++) {
            sum += i;
        }
        System.out.println("sum = " + sum);
        System.out.println("for cycle cost time: " + (System.currentTimeMillis() - startTime));

    }
}
