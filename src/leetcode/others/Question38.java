package leetcode.others;

/**
 * @Date 2021/2/10 0:42
 * @Created by ZhuangJie
 * @Description
 */
public class Question38 {
    public String countAndSay(int n) {
        String oldStr="1";
        StringBuilder builder=new StringBuilder();
        int counter=1;
        while (counter!=n){
            int head=0,tail=0;
            for (tail = 0; tail <oldStr.length() ; tail++) {
                if (oldStr.charAt(tail)==oldStr.charAt(head)){
                    continue;
                }else {
                    builder.append(tail-head);
                    builder.append(oldStr.charAt(head));
                    head=tail;
                }
            }
            builder.append(tail-head);
            builder.append(oldStr.charAt(head));
            oldStr=builder.toString();
            builder=new StringBuilder();
            counter++;
        }
        return oldStr;
    }
}
