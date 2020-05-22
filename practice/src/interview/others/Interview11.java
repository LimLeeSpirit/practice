package interview.others;

import java.util.Arrays;

/**
 * 给出主机分别执行一个任务所需的时间，给定任务数，求出总时间最小的任务分配方案
 * 【10，5，3，1】, missions = 100
 *
 * 贪心，
 */
public class Interview11 {
    public static void main(String[] args) {
        int[] hosts = {2,5,8,10};
        distribute(hosts, 10);
        System.out.println(a(666));
    }
    //  hosts 由小到大
    public static int[] distribute(int[] hosts, int missions) {
        Arrays.sort(hosts);
        int[] ans = new int[hosts.length];
        while(missions > 0) {
            int idx = 0;
            for (int i = 1; i < hosts.length; i ++) {
                idx = hosts[i] * (ans[idx] + 1) > hosts[i] * (ans[i] + 1) ? i : idx;
            }
            ans[idx] ++;
            missions --;
        }
        for (int a : ans) System.out.print(a + " ");
        return ans;
    }
    public static int a(int tab){
        int n=tab-1;
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        return n;
    }
}
