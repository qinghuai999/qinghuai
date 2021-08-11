package com.ssq.demo.base.datastructure.sort;
/**
 * @Author 苏诗淇
 * @Date 2021-08-11 23:41:02
 * @Description: 排序复习类
 */
public class SortTest {
    /**
     * 希尔排序
     */
    public void shellTest(int[] data) {
        if (data.length == 1) {
            return;
        }
        int temp = data.length / 2;
        while (temp >= 1) {
            // i从中间处往后遍历到数组末尾
            for (int i = temp; i < data.length; ++i) {
                int value = data[i];
                int j = i - temp;
                for (; j >= 0; j -= temp) {
                    if (data[j] > value) {
                        data[j+temp] = data[j];
                    } else {
                        break;
                    }
                }
                data[j+temp] = value;
            }
        }
    }

    /**
     * 插入排序
     */
    public void insertTest(int[] data) {
        if (data.length == 1) {
            return;
        }
        for (int i = 0; i < data.length; ++i) {
            int j = i - 1;
            for (; j >= 0; --j) {
                if (data[j] > data[i]) {
                    data[j+1] = data[j];
                } else {
                    break;
                }
            }
            // TODO 理解不透彻,默写代码时写成了data[j] = data[i].请在重点理解该行
            data[j+1] = data[i];
        }
    }
}
