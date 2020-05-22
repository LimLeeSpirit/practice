package interview.others;

import java.util.Collections;

/**
 * 实现一个负载均衡算法，给出主机接受请求的概率，判断一个请求到来，应该交由哪个主机进行处理
 */
public class Interview10 {
    public static void main(String[] args) {
        int[] hosts = {30, 30, 20, 10};
        System.out.println(loadBalance(hosts, 66));
    }

    public static int loadBalance(int[] hosts, int mission) {
        int total = getSum(hosts);
        int n = hosts.length;
//        Object o = new Object();
//        int h =  ((Integer)mission).hashCode() % total;
        int h = mission;
        for (int i = 0; i < n; i ++) {
            if (h < hosts[i]) {
                return i;
            }
            h -= hosts[i];
        }
        return -1;
    }

    public static int getSum(int[] hosts) {
        int sum = 0;
        for (int a : hosts) {
            sum += a;
        }
        return sum;
    }

}
