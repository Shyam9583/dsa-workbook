package java.string;

import java.util.*;

public class PrintAnagram {

    public static void main(String[] args) {
        String[] words = {"kptkwp", "czdvgr", "osbqrs", "shhqjd", "ydavzo", "bltcjf", "vuoswt", "gkgbjk", "hzfoyu", "tujlak", "wgmuab", "wtdeno", "cemizj", "dryfqd", "hxuzdd", "zpanxz", "lnakfa", "yovytp", "yqtjyd", "baoyal", "vbwgaf", "bmmdgq", "akmnxe", "koaaan", "jlarwn", "dbhapu", "bspgln"};
        System.out.println(anagrams(words));
    }

    private static List<List<String>> anagrams(String[] words) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (String word : words) {
            String group = root(word);
            map.putIfAbsent(group, new ArrayList<>());
            map.get(group).add(word);
        }
        for (String group : map.keySet()) {
            result.add(map.get(group));
        }
        return result;
    }

    private static String root(String word) {
        char[] arr = word.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
