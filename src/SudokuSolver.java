public class SudokuSolver{

    // Recursively compute sudoku solution
    public static boolean solveSudoku(int row, int col){
        int num = 1;      // 1 is minimum number a sudoku value can be
        int tempRow = 0;  // Temporary row, col table coordinate values
        int tempCol = 0;

        // Recursively find cell that is '0', which represents that it is unfilled
        if(SudokuMain.getSudoku(row, col) != 0){
            if(row == 8 && col == 8){
                return true;
            }

            if(row < 8){
                row++;
            }else{
                if(col < 8){
                    row = 0;
                    col++;
                }                
            }

            if(solveSudoku(row, col)){
                return true;
            }else{
                return false;
            }            
        }

        // When cell has value '0' it is blank and can fill it
        // If num is not in same square, row or column as cell can place value of num in it
        if(SudokuMain.getSudoku(row,col) == 0){
            
            // Valid sudoku values are 1-9
            while(num < 10){
                if(!SudokuGenerator.sameRow(col, num) && !SudokuGenerator.sameColumn(row, num) && !SudokuGenerator.sameSquare(row, col, num)){
                    SudokuMain.setSudoku(row, col, num);     // Place num in unfilled cell                    
                    
                    if(row == 8 && col == 8){
                        return true;
                    }

                    if(row < 8){
                        tempRow = row+1;
                    }else{
                        tempRow = 0;
                        tempCol = col+1;
                    }

                    if(solveSudoku(tempRow, tempCol)){
                        return true;
                    }
                }
                num++;
            }
            
            SudokuMain.setSudoku(row,col,0);
            return false;
        }
        return false;
    }
}