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
    private static final String TAG = "ToBvAv";
    //bv的格式记录
    static String table = "fZodR9XQDSUm21yCkr6zBqiveYah8bt4xsWpHnJE7jL5VG3guMTKNPAwcF";
    static ArrayList<Map<String, Object>> tr = new ArrayList<>();
    static int s[] = {11, 10, 3, 8, 4, 6};
    static double xor = 177451812.0;
    static double add = 8728348608.0;


    //将av转换为bv
    public static String toBv(String av) {
        //提前准备 ,将字符串的每一个解为char数组
        char[] a = table.toCharArray();
        //循环table的lenght
        for (int i = 0; i < 58; i++) {
            //创建一个键值对对象
            Map<String, Object> map = new HashMap<>();
            //向着键值对对象添加数据，
            map.put(String.valueOf(a[i]), i);
            //键值对添加到集合中
            tr.add(map);
        }
        //开始处理 将传递进入的参数转换为 int
        char arr[]={'B','V','1',' ',' ','4',' ','1',' ','7',' ',' '};
        double r=(Integer.valueOf(av)^(int)(xor))+add;
        for(int i=0;i<6;i++){
            arr[s[i]]=a[(int) (Math.floor(r/(Math.pow(58,i))) %58)];
        }
        return String.valueOf(arr);
    }

    //将bv转换为av
    public static String toAv(String bv) {
        //提前准备
        char[] a = table.toCharArray();
        for (int i = 0; i < 58; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put(String.valueOf(a[i]), i);
            tr.add(map);
        }
        //开始转换
        double r = 0;
        char xe[] = bv.toCharArray();
        for (int i = 0; i < 6; i++) {
            for (Map c : tr) {
                for (Object key : c.keySet()) {
                    if (key.equals(String.valueOf(xe[s[i]]))) {
                        Object value = c.get(key);
                        r += Integer.valueOf(value.toString()) * Math.pow(58, i);
                    }
                }
            }
        }
        double av1 =(int) (r - add) ^ (int) (xor);
        String av = String.valueOf(av1);
        String replace = av.replace(".", "");
        CharSequence charSequence = replace.subSequence(0, replace.length() - 2);
        String return_ = charSequence.toString();
        return return_;
    }
}
