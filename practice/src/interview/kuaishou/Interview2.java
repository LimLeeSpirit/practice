package interview.kuaishou;

import java.util.*;

/**
 * 字符串的题，有点类似leetcode整理邮件那道题，可惜只通过了37.5%
 *
 * 应该是复杂度大了或者有些情况没有考虑到
 *
 */
public class Interview2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        Set<String> set = new HashSet<String>();
        // 域名：路径们
        // 将所有的路径们进行比较，相等的，将 域名key 放在一堆，并保存 域名key
        Map<String, TreeSet<String>> name2paths = new HashMap<String, TreeSet<String>>();
        for (int i = 0; i < k; i ++) {
            String url = in.next();
            if (set.contains(url)) {continue;}
            set.add(url);
            String[] name_path = url.substring(7).split("\\/");
            if (!name2paths.containsKey(name_path[0])) {
                name2paths.put(name_path[0], new TreeSet<String>());
            }
            if (name_path.length > 1) {
                name2paths.get(name_path[0]).add(name_path[1]);
            } else if (url.endsWith("/")) {
                name2paths.get(name_path[0]).add("");
            } else {
                name2paths.get(name_path[0]).add("None");
            }
        }
        int n = name2paths.size();

        List<String> names = new ArrayList<String>();
        List<TreeSet<String>> paths = new ArrayList<TreeSet<String>>();
        for (String name : name2paths.keySet()) {
            names.add(name);
            paths.add(name2paths.get(name));
            System.out.printf(name + ": " + name2paths.get(name));
            System.out.println();
        }

        List<Set<String>> ans = new ArrayList<Set<String>>();
        // 获取所有的 paths 集合，判断是否相等，
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i ++) {
            if (paths.get(i).size() == 0) {continue;}
            if (!visited[i]) {
                Set<String> tmp = new HashSet<String>();
                tmp.add(names.get(i));
                visited[i] = true;
                for (int j = i + 1; j < n; j ++) {
                    if (!visited[j] && paths.get(j).equals(paths.get(i))) {
                        visited[j] = true;
                        tmp.add(names.get(j));
                    }
                }
                if (tmp.size() > 1) {
                    ans.add(tmp);
                }
            }
        }
        System.out.println(ans.size());
        for (int i = 0; i < ans.size(); i ++) {
            for (String cur : ans.get(i)) {
                System.out.printf("http://" + cur + " ");
            }
            System.out.println();
        }
    }
}
