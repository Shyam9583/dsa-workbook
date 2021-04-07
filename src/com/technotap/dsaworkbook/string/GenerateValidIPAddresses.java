package com.technotap.dsaworkbook.string;

import java.util.ArrayList;

public class GenerateValidIPAddresses {
    public static void main(String[] args) {
        String s = "25525511135";
        System.out.println(generate(s));
    }

//    private static ArrayList<String> generate(String s) {
//        ArrayList<String> validIps = new ArrayList<>();
//        int[] paths = new int[4];
//        compute(validIps, paths, s, 0, 0);
//        return validIps;
//    }
//
//    private static void compute(ArrayList<String> validIps, int[] paths, String s, int pointer, int segment) {
//        if(segment == 4 && pointer == s.length()) {
//            validIps.add(paths[0] + "." + paths[1] + "." + paths[2] + "." + paths[3]);
//            return;
//        }
//        else if(segment == 4 || pointer == s.length())
//            return;
//        for(int len = 1; len < 4 && pointer + len <= s.length(); len++) {
//            String snapshot = s.substring(pointer, pointer + len);
//            int value = Integer.parseInt(snapshot);
//            if(value > 255 || len > 1 && s.charAt(pointer) == '0')
//                break;
//            paths[segment] = value;
//            compute(validIps, paths, s, pointer + len, segment + 1);
//            paths[segment] = -1;
//        }
//    }

    private static ArrayList<String> generate(String s) {
        ArrayList<String> validIPs = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12)
            return validIPs;
        compute(s, "", validIPs, 0);
        return validIPs;
    }

    private static void compute(String s, String result, ArrayList<String> validIPs, int segment) {
        if (segment == 4 || s.length() == 0) {
            if (segment == 4 && s.length() == 0) {
                validIPs.add(result.substring(0, result.length() - 1));
            }
            return;
        }
        compute(s.substring(1), result + s.charAt(0) + ".", validIPs, segment + 1);
        if (s.length() > 1 && s.charAt(0) != '0') {
            compute(s.substring(2), result + s.substring(0, 2) + ".", validIPs, segment + 1);
            if (s.length() > 2 && Integer.parseInt(s.substring(0, 3)) < 256)
                compute(s.substring(3), result + s.substring(0, 3) + ".", validIPs, segment + 1);
        }
    }
}
