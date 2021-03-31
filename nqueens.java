import java.util.ArrayList;

public class Solution {
    public static ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>> ();
    public static ArrayList<ArrayList<Integer>> solveNQueens(int n)
    {

        int matrix[][]=new int[n][n];
        findNqueens(matrix,0);
        

        return arr;
    }
    public static void findNqueens(int matrix[][],int row)
    {
         if(row>=matrix.length)
         {
             ArrayList<Integer> ar=new ArrayList<>();
             for(int i=0;i<matrix.length;i++)
             {
                 for(int j=0;j<matrix.length;j++)
                 {
                     ar.add(matrix[i][j]);
                 }
             }
             arr.add(ar);
             return ;
         }
        for(int i=0;i<matrix.length;i++)
        {
            if(issafe(matrix,row,i))
            {
                matrix[row][i]=1;
                
                findNqueens(matrix,row+1);
                
                matrix[row][i]=0;
            }
        }
      
    }
    public static boolean issafe(int [][]matrix,int i,int j)
    {
        for(int k=0;k<matrix.length;k++)
        {
            if(matrix[i][k]==1)
            {
                return false;
            }
        }
        for(int k=0;k<matrix.length;k++)
        {
            if(matrix[k][j]==1)
            {
                return false;
            }
        }
        for(int k=i,l=j;k>=0&&l>=0;k--,l--)
        {
            if(matrix[k][l]==1)
                return false;
            
        }
         for(int k=i,l=j;k>=0&&l<matrix.length;k--,l++)
         {
            if(matrix[k][l]==1)
                return false;
            
         }
        return true;
    }
}
