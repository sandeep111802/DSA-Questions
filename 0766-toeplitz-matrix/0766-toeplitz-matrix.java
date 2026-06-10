class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        boolean check=true;

        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                
                    if(matrix[i][j]!=matrix[i-1][j-1]){
                         return false;
                    }else
                    {
                        check=true;
                    }
                
            }
        }
        return check;
    }
}