import java.util.Scanner;   // Receive user input

class SudokuMain{ 

    // Declare 9x9 empty sudoku puzzle '0' represents blank/unfilled cell
    private static int[][] sudoku = new int[9][9]; 

    // Set cell x,y of sudoku to value of num
    public static void setSudoku(int x, int y, int num){
        sudoku[x][y] = num;
    }

    // Return value in sudoku at cell x,y
    public static int getSudoku(int x, int y){
        return sudoku[x][y];
    }


    public static void main(String args[]){ 

        // Fill sudoku with all 0's (blanks)
        for(int j = 0; j < 9; j++){
            for(int i = 0; i < 9; i++){
                sudoku[i][j] = 0;
            }
        }
        
        Scanner scan = new Scanner(System.in);      // Create Scanner object

        System.out.println("For a randomly generated sudoku puzzle enter 1.");
        System.out.println("For a solution to your sudoku puzzle enter 2.");
        System.out.println("To quit press ctrl-c.");
        System.out.print("Enter:\t");

        int userInput = scan.nextInt();             // Store user integer input

        // Repeat question until a 1 or 2 is input
        while(userInput != 1 && userInput != 2){
            System.out.println("\nERROR: 1 or 2 was not entered.");
            System.out.println("For a randomly generated sudoku puzzle enter 1.");
            System.out.println("For a solution to your sudoku puzzle enter 2.");
            System.out.print("Enter:\t");
            userInput = scan.nextInt();
        }

        
        // Randomly generated sudoku selected
        if(userInput == 1){            
            SudokuGenerator.sudGen();       // Generate random 9x9 sudoku puzzle 
            SudokuDisplay.sudDis();         // Display unsolved generated sudoku     
        }

        // User inputted sudoku selected
        else{
            Scanner sc = new Scanner(System.in);    // Create Scanner object
            int[] rows = new int[9];                // Array to store currently entered row
            int entry;                              // Integer to store currently entered value

            System.out.println("\nEnter sudoku (for a blank square enter 0)");

            // Nested for loops to requested and enter sudoku values for 9x9 sudoku
            for(int j = 0; j < 9; j++){
                System.out.println("Press enter row " + (j+1) + " of sudoku one number at a time");

                for(int i = 0; i < 9; i++){
                    System.out.print("Next entry:\t");                    
                    entry = sc.nextInt();                       // Store next inputted integer value in entry

                    // Repeat requesting next entry until a valid number between 0-9 is entered
                    while(entry < 0 || entry > 9){
                        System.out.println("\nPress enter a entry between 0-9, where 0 is a blank square");
                        System.out.print("Retry entry:\t");
                        entry = sc.nextInt();                   // Store next inputted integer value in entry
                    }

                    // Display currently entered row
                    System.out.print("Row " + (j+1) + ": ");    
                    for(int k = 0; k <= i; k++){
                        if(k == i){
                            System.out.print(getSudoku(k,j) + "\n");
                        }else{
                            System.out.print(getSudoku(k,j) + ", ");
                        }                        
                    }
                    System.out.println();


                    setSudoku(i, j, entry);     // Set entry in correct location of sudoku
                }
            }

            System.out.println("\nSudoku entered:");
            SudokuDisplay.sudDis();                     // Display entered sudoku 
        }

        Scanner ans = new Scanner(System.in);           // Create Scanner object
        System.out.println("\nPress enter ANSWER for the solution or crtl-c to quit:");
        String answer = ans.nextLine();

        while(!answer.equals("ANSWER")){                // Repeat until 'ANSWER' entered
            System.out.println("\nPress enter ANSWER for the solution or crtl-c to quit:");
            answer = ans.nextLine();      
        } 
        
        System.out.println("\nThe solution to this sudoku is:");
        SudokuSolver.solveSudoku(0,0);   // Compute solution for given sudoku puzzle
        SudokuDisplay.sudDis();          // Display solved sudoku
    }
}