package com.watchme.system.test;

import net.sf.jsqlparser.expression.StringValue;

import java.awt.datatransfer.StringSelection;
import java.util.Random;

public class Test2 {

    public static void main(String[] args){
        String str = makeRandomPassword(9);
        System.out.println(str);
    }

    //随机密码生成
    public static String makeRandomPassword(int lenth){
        StringBuilder sb = new StringBuilder();
        char charr1[] = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char charr2[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char charr3[] = "~!@#$%^&*()_+.,?;'".toCharArray();
        char charr4[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890~!@#$%^&*()_+.,?;'".toCharArray();
        Random r = new Random();
        sb.append(charr1[r.nextInt(charr1.length)]);
        sb.append(charr2[r.nextInt(charr2.length)]);
        sb.append(charr3[r.nextInt(charr3.length)]);
        sb.append(String.valueOf(r.nextInt(9)));
        for(int i=0;i<lenth;i++){
            sb.append(charr4[r.nextInt(charr4.length)]);
        }
        return sb.toString();
    }

}
