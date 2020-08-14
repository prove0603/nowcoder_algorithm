package 笔试真题.腾讯2020校园招聘后台;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/8/13 17:40
 */
import java.util.*;
public class Demo{
    static class node{
        int x,y;
        node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    static class cmp implements Comparator<node>{
        public int compare(node o1,node o2) {
            if(o1.x == o2.x) {
                return o2.y - o1.y;
            }
            return o1.x - o2.x;
        }
    }
    static final int N = 100005;
    static node [] arr = new node[N];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int L = sc.nextInt();
        for(int i = 0;i < n;i ++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[i] = new node(x,y);
        }
        Arrays.sort(arr,0,n,new cmp());
        if(arr[0].x > 0) {
            System.out.println("-1");
            return;
        }
        for (int i = 0; i <n ; i++) {
            System.out.println(arr[i].x+"\t"+arr[i].y);
        }
        int ans = 1,idx = 0,r = arr[0].y,max = 0;
        while(r < L) {
            max = 0;
            boolean f = false;
            while(idx < n && arr[idx].x <= r) {
                f = true;
                max = Math.max(max,arr[idx].y);
                idx ++;
            }
            if(!f) {
                System.out.println("-1");
                return;
            }
            r = max;
            ++ ans;
        }
        System.out.println(ans);
    }
}




