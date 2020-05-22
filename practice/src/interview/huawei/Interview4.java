package interview.huawei;

import java.util.*;

public class Interview4 {
    public static void main(String[] args) {
//        String s = "E:\\V1R2\\product\\fpgadrive.c 1325";
//        System.out.println(s.substring(s.lastIndexOf('\\') + 1));

        Map<String, Integer> map = new HashMap<>();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            String name_line = s.substring(s.lastIndexOf('\\') + 1);
            map.put(name_line, map.getOrDefault(name_line, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        int cnt = 0;
        Iterator<Map.Entry<String, Integer>> it = list.iterator();
        while (cnt < 8 && it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            if (entry.getKey().length() > 16) {
                System.out.println(entry.getKey().substring(entry.getKey().length() - 16) + " " +  entry.getValue());
            } else {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
            cnt ++;
        }
    }
}
