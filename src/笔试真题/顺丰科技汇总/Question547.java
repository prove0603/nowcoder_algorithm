package 笔试真题.顺丰科技汇总;

import java.util.ArrayDeque;

/**
 * @Date 2021/3/4 22:10
 * @Created by ZhuangJie
 * @Description
 * 省份数量
 * https://leetcode-cn.com/problems/number-of-provinces/
 * https://leetcode-cn.com/problems/number-of-provinces/solution/dfshe-bfsliang-chong-fang-shi-jie-jue-by-kv9t/
 */
public class Question547 {
//    dfs
    public int findCircleNum_dfs(int[][] isConnected) {
        int n=isConnected.length;
        boolean visited[]=new boolean[n];
        int counter=0;
        for (int i = 0; i <n ; i++) {
            if (visited[i]){
                continue;
            }else {
                counter++;
                dfs(i,isConnected,visited);
            }
        }
        return counter;
    }
     public void dfs(int i,int[][] isConnected,boolean visited[]){
         for (int j = 0; j < isConnected.length ; j++) {
             if (j==i) {continue;}
             if (isConnected[i][j]==1 && visited[j]==false){
                 visited[j]=true;
                 dfs(j,isConnected,visited);
             }
         }
     }

     //bfs
     public int findCircleNum_bfs(int[][] isConnected) {
        int n= isConnected.length;
        boolean visited[]=new boolean[n];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int counter=0;
         for (int i = 0; i <n ; i++) {
             if (visited[i]){continue;}
             counter++;
             deque.addLast(i);
             while (!deque.isEmpty()){
                 int j=deque.pollFirst();
                 visited[j]=true;
                 for (int k = 0; k <n ; k++) {
                     if (isConnected[j][k]==1 && visited[k]==false){
                         deque.addLast(k);
                     }
                 }
             }
         }
         return counter;
     }

}
