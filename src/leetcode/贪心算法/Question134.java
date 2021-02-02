package leetcode.贪心算法;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Date 2021/1/27 1:00
 * @Created by ZhuangJie
 * @Description 加油站
 * https://leetcode-cn.com/problems/gas-station/
 */
public class Question134 {

    /**
     * 通过空间换时间改进  参考题解  思路很重要
     * https://leetcode-cn.com/problems/gas-station/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--30/
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int lastArrived[] = new int[len];
        int lastArrivedOil[] = new int[len];
        Arrays.fill(lastArrived, -1);
        Arrays.fill(lastArrivedOil, -1);
        for (int i = 0; i < len; i++) {
            if (isOk(gas, cost, lastArrived, lastArrivedOil, i, i)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isOk(int[] gas, int[] cost, int[] lastArrived, int[] lastArrivedOil, int cur, int start) {
        int len = gas.length;
        int startOil = 0;
        do {
            if (lastArrived[cur] != -1) {
                startOil += lastArrivedOil[cur];
                cur = lastArrived[cur];
            }
            startOil += gas[cur] - cost[cur];
            if (startOil < 0) {
                lastArrived[start] = cur - 1 == -1 ? len - 1 : cur - 1;
                lastArrivedOil[start] = startOil -= gas[cur] - cost[cur];
                return false;
            }
            cur = (cur + 1) % len;
        } while (cur != start);
        return true;
    }
//    未改进
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        for (int i = 0; i < gas.length; i++) {
//            if (isOk(gas, cost, i)) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    public boolean isOk(int[] gas, int[] cost, int start) {
//        int len = gas.length;
//        int startOil = 0;
//        for (int i = 0; i < len; i++) {
//            startOil += gas[start] - cost[start];
//            if (startOil < 0) {
//                return false;
//            }
//            start = (start + 1) % len;
//        }
//        return true;
//    }
}
