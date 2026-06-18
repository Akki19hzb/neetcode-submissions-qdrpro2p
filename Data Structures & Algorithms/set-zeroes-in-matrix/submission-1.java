class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        //checking FirstRowCOl has zero
        for(int col=0; col<n; col++){
            if(matrix[0][col]==0){
                firstRowZero= true;
                break;
            }
        }

        for(int row=0; row <m; row++){
            if(matrix[row][0]==0){
                firstColZero = true;
                break;
            }
        }

        //marking matrix firstrow and firstcol to 0 for rest of matrix
        for(int row=1; row<m; row++){
            for(int col=1; col<n; col++){
                if(matrix[row][col]==0){
                    matrix[0][col] =0;
                    matrix[row][0] =0;
                }
            }   
        }
        //setting zero 
         for(int row=1; row<m; row++){
            for(int col=1; col<n; col++){
                if(matrix[row][0]==0 || matrix[0][col]==0){
                    matrix[row][col] =0;
                }
            }   
        }


        //Handling first row and first col
        for(int col=0; col<n; col++){
            if(firstRowZero){
                matrix[0][col] =0;
            }
        }

        for(int row=0; row <m; row++){
            if(firstColZero){
                matrix[row][0] =0;
            }
        }
    }
}
