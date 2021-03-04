package leetcode.others;

/**
 * @Date 2021/2/4 1:50
 * @Created by ZhuangJie
 * @Description
 */
public class Question27 {

        public int removeElement(int[] nums, int val) {
            int ans = 0;
            for(int num: nums) {
                if(num != val) {
                    nums[ans] = num;
                    ans++;
                }
            }
            return ans;
        }

//    public int removeElement(int[] nums, int val) {
//        if (nums.length==0) {return 0;}
//        if (nums.length==1){
//            if(nums[0]==val){return 0;}
//            else{return 1;}
//        }
//        int p=0,q=1;
//        while (q<nums.length ){
//            if (nums[p]!=val ){
//                p++;
//                q++;
//            }else {
//                while (q<nums.length && nums[q]==val){q++;}
//                if (q==nums.length) {
//                    break;
//                }
//                int tmp=nums[p];
//                nums[p]=nums[q];
//                nums[q]=tmp;
//                q++;
//                p++;
//            }
//        }
//        if(nums[nums.length-1]!=val) {p++;}
//        return p-1+1;
//    }
}
