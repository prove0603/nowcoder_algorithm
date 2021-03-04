package leetcode.others;

/**
 * @Date 2021/2/4 0:10
 * @Created by ZhuangJie
 * @Description
 */
public class Question14 {
//    这样可以不用找最短字符串
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            int length = strs[0].length();
            int count = strs.length;
            for (int i = 0; i < length; i++) {
                char c = strs[0].charAt(i);
                for (int j = 1; j < count; j++) {
                    if (i == strs[j].length() || strs[j].charAt(i) != c) {
                        return strs[0].substring(0, i);
                    }
                }
            }
            return strs[0];
        }

//    public String longestCommonPrefix(String[] strs) {
//        if (strs.length==0) {return "";}
//        int min=Integer.MAX_VALUE,minIndex=-1;
//        for (int i = 0; i <strs.length ; i++) {
//            if (strs[i].length()<min){
//                min=strs[i].length();
//                minIndex=i;
//            }
//        }
//        if (min==0) {return "";}
//        String shortest=strs[minIndex];
//        StringBuilder prefix=new StringBuilder("");
//        for (int i = 0; i <shortest.length() ; i++) {
//            for (int j = 0; j <strs.length ; j++) {
//                if (shortest.charAt(i)!=strs[j].charAt(i)){
//                    return prefix.toString();
//                }
//            }
//            prefix.append(shortest.charAt(i));
//        }
//        return prefix.toString();
//    }
}
