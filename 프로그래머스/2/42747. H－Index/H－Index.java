import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        // 1. 인용 횟수 배열 정렬 (내림차순)
        Arrays.sort(citations);
        
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            int hIndex = n - i; // 남은 논문의 수
            if (citations[i] >= hIndex) {
                return hIndex;
            }
        }

        // 모든 논문의 인용 횟수가 H-Index 조건을 만족하지 않으면 0 반환
        return 0;
    }
}
