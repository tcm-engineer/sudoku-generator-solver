# Sudoku Generator/Solver

Implementation of a 9x9 Sudoku generator and solver written in Java. 
A puzzle can be randomly generated or input by the user in rows. 
The solution to the puzzle is calculated through a recursive backtracking algorithm. <br/><br/>


<strong> Sudoku Solver Recursive Backtracking Algorithm: </strong> 
1. Solve Sudoku by one-by-one assigning numbers to empty cells.
2. Before assigning a number, ensure it is valid by confirming that the same number is not present in the current row, current column and current 3x3 subgrid.
3. If number is not present in respective row, column or 3x3 subgrid, we can assign the number, and recursivey check if this assignment leads to a solution or not. If this assignment doesn't lead to a solution, then we try next number for current empty cell. And if none of number (1-9) lead to solution, we return false.<br/><br/>
  
  
<strong>To Run: </strong> <br/>
  <i style="margin-left 4rem">java -cp classes SudokuMain</i> <br/>
  
<strong>Todo: </strong> 
<ul>
  <li>Create GUI with Java Foundation Classes/Swing</li>
</ul>
