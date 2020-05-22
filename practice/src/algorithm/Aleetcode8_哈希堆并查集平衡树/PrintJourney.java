package algorithm.Aleetcode8_哈希堆并查集平衡树;

import java.util.HashMap;
import java.util.Map;

/**
 * 给出好几个火车票的起始点和终点信息，找出该旅客的旅程站点信息。旅客旅程不构成环。比如：
 * 火车票信息：西安-成都、北京-上海、大连-西安、上海-大连
 *
 * 那么该旅客的旅程站点为：北京-上海-大连-西安-成都
 *
 * 关键就在于旅程无环：也就是一定存在某一个城市只做起点，不做终点，还有个城市只做终点不做起点
 *
 * 这个寻找起点的思路很值得学习
 */
public class PrintJourney {
    public static String printJourney(Map<String, String> tickets) {
        // 先将终点起点反转，找到整个旅程的起点
        Map<String, String> reverseMap = new HashMap<>();
        for (Map.Entry<String, String> entry : tickets.entrySet()) {
            reverseMap.put(entry.getValue(), entry.getKey());
        }
        String startCity = null;
        for (String s : tickets.keySet()) {
            if (!reverseMap.containsKey(s)) {
                startCity = s;
                break;
            }
        }

        if (startCity == null) throw new IllegalArgumentException("参数不合理");

        StringBuilder sb = new StringBuilder();
        while (startCity != null) {
            sb.append(startCity).append("->");
            startCity = tickets.get(startCity);
        }
        sb.append("null");
        System.out.println(sb);
        return sb.toString();

    }

    public static void main(String[] args) {
        Map<String, String> tickets = new HashMap<>();
        tickets.put("xian","chengdu");
        tickets.put("beijing","shanghai");
        tickets.put("dalian","xian");
        tickets.put("shanghai","dalian");
        printJourney(tickets);
    }
}
