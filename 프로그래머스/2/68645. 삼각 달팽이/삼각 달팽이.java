class Solution {
    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int[] answer = new int[n*(n+1)/2]; // 크기만큼 할당
        int num = 1; // 채울 숫자
        int x = 0, y = -1; // 저장할 배열 index
        
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                // 3의 배수: 아래
                if (i % 3 == 0) {
                    y++;
                } 
                // 3의 배수 + 1: 오른쪽
                else if (i % 3 == 1) {
                    x++;
                }
                // 3의 배수 + 2: 대각선 위
                else {
                    x--; y--;
                }
                triangle[y][x] = num++;
            }
        }
        
        // 2차원 배열 -> 1차원 배열 변환
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = triangle[i][j];
            }
        }
        
        return answer;
    }
}
