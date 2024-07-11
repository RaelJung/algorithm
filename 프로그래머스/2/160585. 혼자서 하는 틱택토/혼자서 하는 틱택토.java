class Solution {
    public int solution(String[] board) {
        int oCount = 0;
        int xCount = 0;
        
        // 보드에서 'O'와 'X'의 개수를 셉니다.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'O') oCount++;
                if (board[i].charAt(j) == 'X') xCount++;
            }
        }
        
        // 'O'의 개수는 'X'의 개수보다 많거나 같아야 하고 최대 1개 더 많아야 합니다.
        if (oCount < xCount || oCount > xCount + 1) return 0;
        
        boolean oWin = checkWin(board, 'O');
        boolean xWin = checkWin(board, 'X');
        
        // 두 명이 동시에 승리할 수 없습니다.
        if (oWin && xWin) return 0;
        
        // 'O'가 승리한 경우 'O'의 개수는 'X'보다 하나 더 많아야 합니다.
        if (oWin && oCount != xCount + 1) return 0;
        
        // 'X'가 승리한 경우 'O'의 개수와 'X'의 개수는 같아야 합니다.
        if (xWin && oCount != xCount) return 0;
        
        return 1;
    }
    
    private boolean checkWin(String[] board, char player) {
        // 가로, 세로, 대각선에서 승리 조건을 확인합니다.
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == player && board[i].charAt(1) == player && board[i].charAt(2) == player) return true;
            if (board[0].charAt(i) == player && board[1].charAt(i) == player && board[2].charAt(i) == player) return true;
        }
        if (board[0].charAt(0) == player && board[1].charAt(1) == player && board[2].charAt(2) == player) return true;
        if (board[0].charAt(2) == player && board[1].charAt(1) == player && board[2].charAt(0) == player) return true;
        
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // 테스트 케이스
        String[] board1 = {"O.X", ".O.", "..X"};
        String[] board2 = {"OOO", "...", "XXX"};
        String[] board3 = {"...", ".X.", "..."};
        String[] board4 = {"...", "...", "..."};

        // 결과 출력
        System.out.println(solution.solution(board1)); // 1
        System.out.println(solution.solution(board2)); // 0
        System.out.println(solution.solution(board3)); // 0
        System.out.println(solution.solution(board4)); // 1
    }
}
