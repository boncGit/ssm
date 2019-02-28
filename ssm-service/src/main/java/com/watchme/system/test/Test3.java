package com.watchme.system.test;

public class Test3 {
    public static void main(String[] args){
        //至少包含一个小写字母  一个大写字母   一个数字   一个特殊符号
        String  str= "1qQ!";
        if (str.matches(".*[a-z]{1,}.*") && str.matches(".*[A-Z]{1,}.*") && str.matches(".*\\d{1,}.*") && str.matches(".*[~!@#$%^&*\\.?]{1,}.*")) {
            System.out.println("符合条件");
        }else{
            System.out.println("不符合条件");
        }
    }
}
