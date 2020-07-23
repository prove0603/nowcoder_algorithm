package 剑指Offer;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/23 16:46
 */

/*
    题目描述
        牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
        同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，
        这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？

 */
public class JZ44 {

    //使用工具类
//    public String ReverseSentence(String str) {
//        if (str=="" ||str==null) return null;
//        String arr[]=str.split(" ");
//        if (arr.length==0) return str;
//        StringBuilder result=new StringBuilder();
//        for (int i = arr.length-1; i>-1 ; i--) {
//            result.append(arr[i]);
//            if (i!=0) result.append(" ");
//        }
//        return result.toString();
//    }

//    题目本意
//    1.旋转每个字符串
//    2.旋转整个字符串
//    3.转换为数组是因为方法里对string 改变是没有用的

    public String ReverseSentence(String str) {
        if (str==null || str.trim()=="") return str;
        char arr[]=str.toCharArray();
        reverseString(arr,0,arr.length-1);
        int pre=0,last=-1;
        for (int i = 0; i <arr.length; i++) {
            if (arr[i]==' '){
                last=i;
            }
            if (i==arr.length-1) last=arr.length;
            reverseString(arr,pre,last-1);
            pre=last+1;
        }
        return new String(arr);
    }

    public static void reverseString (char arr[],int start ,int end){
        int middle=start+((end-start)>>1);
        while (start<=middle){
            char tmp=arr[start];
            arr[start]=arr[end];
            arr[end]=tmp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        JZ44 jz44=new JZ44();
        System.out.println(jz44.ReverseSentence("student. a am I"));
//        System.out.println(jz44.ReverseSentence(" ")+1);
//        String a="student. a am I";
//        String a="    student. a am I";
//        char arr[]=a.toCharArray();
//        reverseString(arr,0,arr.length-1);
//        for (int i = 0; i <arr.length ; i++) {
//            System.out.print(arr[i]);
//        }
//        System.out.println(a);
    }
}
