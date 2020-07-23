package 剑指Offer;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/23 17:52
 */
public class demo {

    public static String ReverseSentence(String str) {
        char[] chars = str.toCharArray();
        reverse(chars,0,chars.length - 1);
        int blank = -1;
        for(int i = 0;i < chars.length;i++){
            if(chars[i] == ' '){
                int nextBlank = i;
                reverse(chars,blank + 1,nextBlank - 1);
                blank = nextBlank;
            }
        }
        reverse(chars,blank + 1,chars.length - 1);//最后一个单词单独进行反转
        return new String(chars);

    }
    public static void reverse(char[] chars,int low,int high){
        while(low < high){
            char temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low++;
            high--;
        }
    }

    public static void main(String[] args) {
//        System.out.println(ReverseSentence("student. a am I"));
        System.out.println(ReverseSentence("      student. a am I"));
//        System.out.println(ReverseSentence("      student. a am I    "));
    }
}
