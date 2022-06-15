package com.ruoyi.common.config;

import java.util.HashMap;
import java.util.Map;

public class CodeConfig {

    public static Map<String, String> codeMap = new HashMap<>();
    public static Map<String, String> timeMap = new HashMap<>();
    public static Map<String,String> jsMap = new HashMap<>();
    static {
        codeMap.put("1", "c4");
        codeMap.put("2", "d4");
        codeMap.put("3", "e4");
        codeMap.put("4", "f4");
        codeMap.put("5", "g4");
        codeMap.put("6", "a4");
        codeMap.put("7", "b4");
        codeMap.put(".1", "c5");
        codeMap.put(".2", "d5");
        codeMap.put(".3", "e5");
        codeMap.put(".4", "f5");
        codeMap.put(".5", "g5");
        codeMap.put(".6", "a5");
        codeMap.put(".7", "b5");
        codeMap.put("..1", "c6");

        timeMap.put("*","1");
        timeMap.put("~","1");
        timeMap.put("-","1");
        timeMap.put(",","1");



        jsMap.put("c4();","c4");
        jsMap.put("d4();","d4");
        jsMap.put("e4();","e4");
        jsMap.put("f4();","f4");
        jsMap.put("g4();","g4");
        jsMap.put("a4();","a4");
        jsMap.put("b4();","b4");
        jsMap.put("c5();","c5");
        jsMap.put("d5();","d5");
        jsMap.put("e5();","e5");
        jsMap.put("f5();","f5");
        jsMap.put("g5();","g5");
        jsMap.put("a5();","a5");
        jsMap.put("b5();","b5");
        jsMap.put("c6();","c6");

        jsMap.put("t1();","*");
        jsMap.put("t1()","*");
        jsMap.put("t2();","-");
        jsMap.put("t3();",",");
        jsMap.put("t4();","~");
    }

}
