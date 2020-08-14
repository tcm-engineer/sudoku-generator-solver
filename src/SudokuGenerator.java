import java.util.Random;    // Generate random numbers

// 1. Create random list of cells to add number too --
// 2. Add random number to first cell of list
// 3. Use sudoku solver to determine if valid number
// 4. If not valid number randomise number and retry
// 5. Repeat for all remaing random cells in list

public class SudokuGenerator{

    // Method generates random 9x9 sudoku
    public static void sudGen(){          
        Random random = new Random();           // creating an object of Random class 

        int filledN = random.nextInt(11) + 10;  // Number of numbers filled in at start of puzzle (15-25)
        int[] randX = new int[filledN];         // Random x,y cell coordinates
        int[] randY = new int[filledN];
        int num;                                // Number to fill random x,y cell coordinates
 

        for(int i = 0; i < filledN; i++){            
            randX[i] = random.nextInt(9);       // Random number 0-8
            randY[i] = random.nextInt(9);                               
        }
  
        for(int i = 0; i < filledN; i++){       
            for(int j = 0; j < 9; j++){
                num = random.nextInt(9) + 1;    // Random sudoku number 1-9
                if(!sameRow(randY[i], num) && !sameColumn(randX[i], num) && !sameSquare(randX[i], randY[i], num)){
                    SudokuMain.setSudoku(randX[i], randY[i], num);    // Set number if valid for x,y location
                    break;
                }
            }            
        }
    }


    // If the row passed is the same num as column passed, return True otherwise False
    public static boolean sameColumn(int row, int num){
        for(int i = 0; i < 9; i++){
            if(SudokuMain.getSudoku(row,i) == num){
                return true;
            }
        }
        return false;
    }

    // If the column passed is the same num as row passed, return True otherwise False
    public static boolean sameRow(int col, int num){
        for(int i = 0; i < 9; i++){
            if(SudokuMain.getSudoku(i,col) == num){
                return true;
            }
        }
        return false;
    }

    // If the square passed is the same num as row passed, return True otherwise False
    public static boolean sameSquare(int row, int col, int num){
        
        // Determine which square the row value passed is in
        if(row < 3){
            row = 0;
        } else if(row < 6){
            row = 3;
        }else{
            row = 6;
        }

        // Determine which square the col value passed is in
        if(col < 3){
            col = 0;
        } else if(col < 6){
            col = 3;
        }else{
            col = 6;
        }

        // Determine if passed row, col values are in same square as num
        for(int i = row; i < row+3; i++){
            for(int j = col; j < col+3; j++){
                if(SudokuMain.getSudoku(i,j) == num){
                    return true;
                }
            }
        }
        return false;
    }
}