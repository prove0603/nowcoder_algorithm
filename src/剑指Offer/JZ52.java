package 剑指Offer;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/22 16:09
 */
    /*
        题目描述
            请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
            而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
            例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配

            tips:可以用递归去解决 ‘*’ 只匹配当前 或者不匹配  或者匹配当前但是留着去匹配下一个

            1.第二个字符不是 '*'
                a.和第一个字符匹配  若匹配上 都往后移一位
                b.匹配不上  return false

            2.第二个字符是'*'
                a. 第一个字符不相同  表达式往后移动两位  字符串不动
                b. 第一个字符相同  '*'不匹配  表达式往后移动两位  字符串不动
                c. 第一个字符相同  '*'匹配  表达式移动两位  字符串移动一位
                d. 第一个字符相同  '*'匹配并和下一个字符匹配   表达式不动  字符串移动一位
    */
public class JZ52 {

    public boolean match(char[] str, char[] pattern) {
        if (str==null || pattern==null ) return false;
        boolean flag=match(str,0,pattern,0);
        return flag;
    }

    public static boolean match(char[] str, int strIndex, char[] pattern, int patternIndex){
        if (strIndex==str.length && patternIndex==pattern.length) return true;
        //字符串可以先走完   但是pattern 不行
        if (strIndex!=str.length && patternIndex==pattern.length ) return false;
        if (strIndex+1<str.length && str[strIndex+1] != '*'){

        }
    }
}
