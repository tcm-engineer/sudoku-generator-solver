public class SudokuDisplay{
    
    // Method displays current sudoku formatted to screen
    public static void sudDis(){

        for(int j = 0; j < 9; j++){

            // Display horizontal line of table            
            if(j%3 == 0){
                for(int i = 0; i < 27; i++){        
                    if((i < 7 || i > 18)){
                        System.out.print("_ ");
                    }else{
                        System.out.print("_");
                    }
                }
            }else{
                for(int i = 0; i < 41; i++){
                    System.out.print("_");
                }
            }
            
            // Display new row of sudoku table values
            System.out.print("\n|");
            for(int i = 0; i < 9; i++){
                if(i%3 == 0){
                    System.out.print("|");
                }

                // Replace 0 with blank space
                if(SudokuMain.getSudoku(i,j) == 0){     
                    System.out.print("   |");
                }else{
                    // Display value at cell i,j of sudoku
                    System.out.print(" " + SudokuMain.getSudoku(i,j) + " |");
                }              
            }
            System.out.println("|");
        }

        // Display bottom horizontal line of table
        for(int i = 0; i < 27; i++){        
            if((i < 7 || i > 18)){
                System.out.print("_ ");
            }else{
                System.out.print("_");
            }
        }
        System.out.println();
    }
}