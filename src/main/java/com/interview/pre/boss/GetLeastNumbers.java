package com.interview.pre.boss;

import java.util.*;

/**
 * @Author: ZhangShiZhu
 * @Description:
 * @Date: create in 2021/8/15 15:57
 *
 * // 寻找K小的元素
 */
public class GetLeastNumbers {
    public List GetLeastNumbers(Integer[] array) {
        //若是1000W个数据，分成1000组，求每组的MIN10组合成新的大小为1W的数组，求最终大小为1W的数组MIN10
        //构建大顶堆，堆大于K的话将堆顶元素poll
        List<Integer> arrayList = Arrays.asList(array);
        int start = 0, step = 10000;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 1000; i++) {
            List<Integer> newArray = arrayList.subList(start, step * i);
            list.addAll(getMinK(newArray));
            start = step * i;
        }

        return getMinK(list);
    }

    public List<Integer> getMinK(List<Integer> array) {
        PriorityQueue<Integer> min = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : array) {
            min.add(num);
            if (min.size() > 10) {
                min.poll();
            }
        }
        return new ArrayList<>(min);
    }
}
