package leetcode.深度优先;

/**
 * @Date 2021/1/31 2:43
 * @Created by ZhuangJie
 * @Description
 */
public class Question109 {
//    public TreeNode sortedListToBST(ListNode head) {
//        if(head==null) {return null;}
//        ArrayList<Integer> list=new ArrayList();
//        while(head!=null){
//            list.add(head.val);
//            head=head.next;
//        }
//        if(list.size()==0){return new TreeNode(list.get(0));}
//        return f(list,0,list.size()-1);
//
//    }
//    public TreeNode f(ArrayList<Integer> list,int start,int end){
//        if(start>end){return null;}
//        int middle=0;
//        if((end-start+1)%2==0){
//            middle=((end+start)>>1)+1;
//        }else{
//            middle=((end+start)>>1);
//        }
//        TreeNode node=new TreeNode(list.get(middle));
//        node.left=f(list, start, middle-1);
//        node.right=f(list, middle+1, end);
//        return node;
//    }

}
