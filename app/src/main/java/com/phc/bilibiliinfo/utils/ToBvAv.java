package com.phc.bilibiliinfo.utils;

import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 版权：没有版权 看得上就用
 *
 * @author peng
 * 创建日期：2020/5/11 11
 * 描述：将bv号转换为av号
 */
public class ToBvAv {
    private static String table = "fZodR9XQDSUm21yCkr6zBqiveYah8bt4xsWpHnJE7jL5VG3guMTKNPAwcF";
    private static HashMap<String, Integer> mp = new HashMap<>();
    private static HashMap<Integer, String> mp2 = new HashMap<>();
    static int ss[] = {11, 10, 3, 8, 4, 6, 2, 9, 5, 7};
    static long xor = 177451812;
    static long add = 8728348608L;


    public static long power(int a, int b) {
        long power = 1;
        for (int c = 0; c < b; c++){
            power *= a;
        }
        return power;
    }

    public  String bv2av(String s) {
        long r = 0;
        for (int i = 0; i < 58; i++) {
            String s1 = table.substring(i, i + 1);
            mp.put(s1, i);
        }
        for (int i = 0; i < 6; i++) {
            r = r + mp.get(s.substring(ss[i], ss[i] + 1)) * power(58, i);
        }
        return String.valueOf((r - add) ^ xor);
    }

    public  String av2bv(String st) {
        long s = Long.valueOf(st.split("av")[1]);
        StringBuffer sb = new StringBuffer("BV1  4 1 7  ");
        s = (s ^ xor) + add;
        for (int i = 0; i < 58; i++) {
            String s1 = table.substring(i, i + 1);
            mp2.put(i, s1);
        }
        for (int i = 0; i < 6; i++) {
            String r = mp2.get((int) (s / power(58, i) % 58));
            sb.replace(ss[i], ss[i] + 1, r);
        }
        return sb.toString();
    }
}
