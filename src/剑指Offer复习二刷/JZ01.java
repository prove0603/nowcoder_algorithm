package 剑指Offer复习二刷;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/28 15:35    二刷成功
 */
/*
    题目描述
        在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
        请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
     */
public class JZ01 {
    public boolean Find(int target, int [][] array) {
        int i=0,maxI=array.length,j=array[0].length-1;
        while (i<maxI && j>=0){
            if (array[i][j]==target) return true;
            else if (array[i][j]>target) j--;
            else i++;
        }
        return false;
    }
}
