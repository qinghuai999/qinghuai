package com.ssq.demo.base.datastructure.coursera.thirdweek;

import java.util.Scanner;

/**
 * @Author: 苏诗淇
 * @Date: 2022-02-20 20:27:41
 * @Description: 求最小加油次数
 *          总距离d, 一箱油最多行使m米, 一路共有n个加油站
 */
public class CarFueling {
    private static long minCarFuelingNum(int distance, int fullGasFastMeter, int gasNum, int[] gasStation) {
        // 若从起点到终点没有加油站
        if (gasNum == 0) {
            // 判断总距离是否大于一箱油能行驶的距离, 若可以覆盖,则返回0,代表最小加油次数为0
            if (distance < fullGasFastMeter) {
                return 0;
            }
            // 否则返回-1, 无法到达终点
            return -1;
        }
        // 需要加油的最远加油站距离, 初始值为0 (开始油箱是满的,不需要加油)
        int gasDis = 0;
        // 最小加油次数, 初始值为0次
        int minGasNum = 0;
        // 找出一桶油能行驶到最远距离的加油站
        // 难点: 怎么证明某点是这一轮循环的最后一个点
        for (int i = 0; i <= gasNum; i++) {
            // 如果一箱油能行使的距离大于当前加油站位置,进入下一次循环.
            if (fullGasFastMeter >= gasStation[i] - gasDis) {
                continue;
            } else {
                // 否则,说明一箱油无法到达位置为i的加油站,此时判断数组下标是否大于0(不然会数组下标越界)
                if (i >= 1) {
                    // 将前一个加油站的值赋给dasDis,为我们一箱油所能到达最远加油站的距离
                    gasDis = gasStation[i - 1];
                }
                // 如果一箱油的距离无法覆盖两加油站之间的距离,返回-1
                if (fullGasFastMeter < gasStation[i] - gasDis) {
                    return -1;
                }
                // 最小加油次数+1
                ++ minGasNum;
            }
        }
        return minGasNum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 起点到终点的距离
        int distance = scanner.nextInt();
        // 一箱油能行驶的最远距离
        int fullGasFastMeter = scanner.nextInt();
        // 加油站总数量
        int gasNum = scanner.nextInt();
        // 我们要把终点距离也放入数组内,因为有可能最后一个加油站到终点的距离超过一箱油能行驶的最远距离
        int[] gasStation = new int[gasNum + 1];
        gasStation[gasNum] = distance;
        // 设置从起点到每一个加油站的距离
        for (int i = 0; i < gasNum; i++) {
            gasStation[i] = scanner.nextInt();
        }
        // 输出最小加油次数
        System.out.println(minCarFuelingNum(distance, fullGasFastMeter, gasNum, gasStation));
    }
}
