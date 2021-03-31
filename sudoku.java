public class Solution {

	public static boolean isItSudoku(int matrix[][]) {

		// Write your code here
          return find(matrix,0,0);
	}
    public static boolean find(int [][]matrix,int row,int col)
    {
        if(row==8&&col==9)
        {
            return true;
        }
        if(col==9)
        {
            row++;
            col=0;
        }
        if(matrix[row][col]!=0)
        {
           return find(matrix,row,col+1);
        }
        for(int i=1;i<10;i++)
        {
            if(issafe(matrix,row,col,i))
            {
                matrix[row][col]=i;
                if(find(matrix,row,col+1))
                {
                    return true;
                }
            }
            matrix[row][col]=0;
        }
        return false;
    }
    public static boolean issafe(int[][] matrix,int row,int col,int num)
    {
        for(int i=0;i<9;i++)
        {
            if(matrix[row][i]==num)
            {
                return false;
            }
        }
        for(int i=0;i<9;i++)
        {
            if(matrix[i][col]==num)
            {
                return false;
            }
        }
        int rows=row-row%3;
        int cols=col-col%3;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(matrix[i+rows][i+cols]==num)
                {
                    return false;
                }
            }
        }
        return true;
    }
}
