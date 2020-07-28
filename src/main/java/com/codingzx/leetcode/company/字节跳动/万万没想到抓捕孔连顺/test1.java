package com.codingzx.leetcode.company.字节跳动.万万没想到抓捕孔连顺;

import java.util.Scanner;

/**
 * @author created by zhangxin27695
 * @Classname test1
 * @Description 我叫王大锤，是一名特工。我刚刚接到任务：在字节跳动大街进行埋伏，抓捕恐怖分子孔连顺。和我一起行动的还有另外两名特工，我提议
 * <p>
 * 1. 我们在字节跳动大街的N个建筑中选定3个埋伏地点。
 * 2. 为了相互照应，我们决定相距最远的两名特工间的距离不超过D。
 * <p>
 * 我特喵是个天才! 经过精密的计算，我们从X种可行的埋伏方案中选择了一种。这个方案万无一失，颤抖吧，孔连顺！
 * ……
 * 万万没想到，计划还是失败了，孔连顺化妆成小龙女，混在cosplay的队伍中逃出了字节跳动大街。只怪他的伪装太成功了，就是杨过本人来了也发现不了的！
 * <p>
 * 请听题：给定N（可选作为埋伏点的建筑物数）、D（相距最远的两名特工间的距离的最大值）以及可选建筑的坐标，计算在这次行动中，大锤的小队有多少种埋伏选择。
 * 注意：
 * 1. 两个特工不能埋伏在同一地点
 * 2. 三个特工是等价的：即同样的位置组合(A, B, C) 只算一种埋伏方法，不能因“特工之间互换位置”而重复使用
 * <p>
 * <p>
 * 输入描述:
 * 第一行包含空格分隔的两个数字 N和D(1 ≤ N ≤ 1000000; 1 ≤ D ≤ 1000000)
 * <p>
 * 第二行包含N个建筑物的的位置，每个位置用一个整数（取值区间为[0, 1000000]）表示，从小到大排列（将字节跳动大街看做一条数轴）
 * <p>
 * 输出描述:
 * 一个数字，表示不同埋伏方案的数量。结果可能溢出，请对 99997867 取模
 * <p>
 * 输入例子1:
 * 4 3
 * 1 2 3 4
 * <p>
 * 输出例子1:
 * 4
 * <p>
 * 例子说明1:
 * 可选方案
 * (1, 2, 3),
 *
 * (1, 2, 4),
 * (1, 3, 4),
 * (2, 3, 4)
 * <p>
 * 输入例子2:
 * 5 19
 * 1 10 20 30 50
 * <p>
 * 输出例子2:
 * 1
 * <p>
 * 例子说明2:
 * 可选方案 (1, 10, 20)
 * @Date 2020-07-27 14:12
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {


            int N = sc.nextInt();   // 给定N（可选作为埋伏点的建筑物数）
            int D = sc.nextInt();   // D（相距最远的两名特工间的距离的最大值）
            int count = 0; // 记载符合条件的次数
            int[] n = new int[N];
            int[] dp = new int[N];
            for (int i = 0; i < N; i++) {
                n[i] = sc.nextInt();
            }
            int right = 2;
            /**      1 2 3 4
             * 滑动窗口 左 i 0 ~ n-2
             *         右 j 2 ~ n
             * 比较滑动窗口两端大于阈值/右端移到最后退出
             * 当退出 tmp保存当前滑动窗口元素大小
             *
             */
            for (int i = 0; i < N - 2; i++) {
                long temp = 0L;   // 保存滑动窗口里面有几个元素
                for (int j = right; j < N; j++) {
                    if (n[j] - n[i] > D) {  // 如果滑动窗口两端差值大于阈值，退出
                        break;
                    } else {
                        temp = (long) (j - i);
                        right = j; // 保存右端固定端点
                    }
                }
                if (temp >= 2)
                    count += temp * (temp - 1) / 2 % 99997867; // Cn2 组合数 = （n*n-1）/2
            }
            System.out.println(count % 99997867);


        }
        sc.close();
    }

}
