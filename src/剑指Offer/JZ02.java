package 剑指Offer;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/28 10:36
 */

/*
    题目描述
        请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class JZ02 {
    public String replaceSpace(StringBuffer str) {
        String target=str.toString();
        return target.replaceAll(" ","%20");
    }

    public static void main(String[] args) {
        JZ02 jz02=new JZ02();
        System.out.println(jz02.replaceSpace(new StringBuffer("We Are Happy")));
    }
}
