package 剑指Offer复习二刷;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/28 15:46    二刷成功
 */

    /*
        题目描述
            请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.
            则经过替换之后的字符串为We%20Are%20Happy。
    */
public class JZ02 {
    //  方法一使用replaceAll过于简单

    //  方法二
    public String replaceSpace(StringBuffer str) {
        if (str==null) return null;
        StringBuffer result=new StringBuffer();
        int index=0;
        while (index!=str.length()){
            if(str.charAt(index)==' '){
                result.append("%20");
                index++;
            }else {
                result.append(str.charAt(index));
                index++;
            }
        }
        return result.toString();
    }
}
