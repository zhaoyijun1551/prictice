package com.test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class demo1 {
    /**
     * * A:正则表达式
     * 是指一个用来描述或者匹配一系列符合某个语法规则的字符串的单个字符串。其实就是一种规则。有自己特殊的应用。
     * 作用:比如注册邮箱,邮箱有用户名和密码,一般会对其限制长度,这个限制长度的事情就是正则表达式做的
     * B:案例演示
     * 需求：校验qq号码.
     * 1:要求必须是5-15位数字
     * 2:0不能开头
     * 3:必须都是数字

     * a:非正则表达式实现
     * b:正则表达式实现
     */
    public static void main(String[] args) {
//        System.out.println(checkQQ("012345"));
//        System.out.println(checkQQ("a1b345"));
//        System.out.println(checkQQ("123456"));
//        System.out.println(checkQQ("1234567890987654321"));
//
//        String regex = "[1-9]\\d{4,14}";
//        System.out.println("2553868".matches(regex));
//        System.out.println("012345".matches(regex));
//        System.out.println("2553868abc".matches(regex));

        //检测身份证
//        String regexCard = "^\\d{15}|^\\d{17}([0-9]|X|x)$";
//        System.out.println("666666666666666666".matches(regexCard));
        System.out.println(getShenFenZhengBollean("622427199189265774"));

    }



    /**
     * 判断身份证号码是否合法
     *
     * @param number
     * @return true为合法 false为不合法
     */
    public static boolean getShenFenZhengBollean(String number) {
        //获取身份证长度除去最后一位的长度
        int length = number.length() - 1;
        Boolean trueOrFalse = true;
        if (17 != length) {
            System.out.println("您输入的身份证号格式有误（身份证位数不正确），请检查后重新输入！");
            trueOrFalse = false;
            return trueOrFalse;
        }
        int[] array = new int[length];
        //求和
        int sum = 0;
        //余数
        int residue = -1;
        //余数对应校验数字
        char check = ' ';
        //最后一位字符
        char lastChar = number.charAt(length);
        for (int i = 0; i < length; i++) {
            //  array[i] = Integer.parseInt(String.valueOf(number.charAt(i)));
            if (!Character.isDigit(number.charAt(i))) {
                System.out.println("您输入的身份证号格式有误(前17位中存在非数字类型字符)，请检查后重新输入！");
                trueOrFalse = false;
                return trueOrFalse;
            } else if (true == isSpecialChar(String.valueOf(lastChar))) {
                System.out.println("您输入的身份证号格式有误(第18位存在非法字符)，请检查后重新输入！");
                trueOrFalse = false;
                return trueOrFalse;
            }
            int[] array2 = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
            array[i] = Integer.parseInt(String.valueOf(number.charAt(i)));
            sum += array2[i] * array[i];
            //  System.out.println(sum);
        }
        residue = sum % 11;
        switch (residue) {
            case 0:
                check = '1';
                break;
            case 1:
                check = '0';
                break;
            case 2:
                check = 'X';
                break;
            case 3:
                check = '9';
                break;
            case 4:
                check = '8';
                break;
            case 5:
                check = '7';
                break;
            case 6:
                check = '6';
                break;
            case 7:
                check = '5';
                break;
            case 8:
                check = '4';
                break;
            case 9:
                check = '3';
                break;
            case 10:
                check = '2';
                break;
        }
        if (check != lastChar) {
            System.out.println("对不起，您查询的身份证号码非法！");
            trueOrFalse = false;
        } else {
            System.out.println("恭喜！您查询的身份证号码合法！");
        }
        //System.out.println(Arrays.toString(array));
        return trueOrFalse;
    }
    /**
     * 判断是否含有特殊字符
     *
     * @param str
     * @return true为包含，false为不包含
     */
    public static boolean isSpecialChar(String str) {
        String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }

    /*
     * 需求：校验qq号码.
     * 1:要求必须是5-15位数字
     * 2:0不能开头
     * 3:必须都是数字
     * 校验qq
     * 1,明确返回值类型boolean
     * 2,明确参数列表String qq
     */
    public static boolean checkQQ(String qq) {
        boolean flag = true;					//如果校验qq不符合要求就把flag置为false,如果符合要求直接返回

        if(qq.length() >= 5 && qq.length() <= 15) {
            if(!qq.startsWith("0")) {
                char[] arr = qq.toCharArray();	//将字符串转换成字符数组
                for (int i = 0; i < arr.length; i++) {
                    char ch = arr[i];			//记录每一个字符
                    if(!(ch >= '0' && ch <= '9')) {
                        flag = false;			//不是数字
                        break;
                    }
                }
            }else {
                flag = false;					//以0开头,不符合qq标准
            }
        }else {
            flag = false;						//长度不符合
        }
        return flag;
    }

}
