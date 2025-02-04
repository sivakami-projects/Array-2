/*
Time Complexity - O(M * N)
Space Complexity - O(M * N)
*/
class Solution {
    public int getLiveNeighbors(int[][] board, int row, int col) {
        int rows = board.length;
        int cols = board[0].length;  
        int[] neighbors = {0, 1, -1};
        int liveNeighbors = 0;

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                    int r = (row + neighbors[i]);
                    int c = (col + neighbors[j]);
                    // Check the validity of the neighboring cell and whether it was originally a live cell.
                    if ((r < rows && r >= 0) && (c < cols && c >= 0) && (Math.abs(board[r][c]) == 1))
                        liveNeighbors += 1;
                }
        return liveNeighbors;

    }
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        int liveNeighbors = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                liveNeighbors = getLiveNeighbors(board, row, col);

                if ((board[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) // Rule 1 or 3
                    // -1 signifies the cell is now dead but originally was live.
                    board[row][col] = -1;

                else if (board[row][col] == 0 && liveNeighbors == 3)                    // Rule 4
                    // 2 signifies the cell is now live but was originally dead.
                    board[row][col] = 2;
            }
        }    
        // Get the final representation for the newly updated board.
        for (int row = 0; row < rows; row++)
            for (int col = 0; col < cols; col++)
                board[row][col] = board[row][col] > 0 ? 1 : 0;
    }
}
