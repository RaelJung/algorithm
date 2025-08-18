class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for (int i = 0; i < schedules.length; i++) {
            int sHour = schedules[i] / 100;
            int sMin = schedules[i] % 100 + 10;
            if (sMin >= 60) {
                sHour += 1;
                sMin -= 60;
            }
            int latest = sHour * 100 + sMin;

            boolean ok = true;
            for (int j = 0; j < 7; j++) {
                int dayOfWeek = (startday + j - 1) % 7 + 1; // 1=월 … 7=일
                if (dayOfWeek == 6 || dayOfWeek == 7) continue; // 토,일 스킵

                if (timelogs[i][j] > latest) {
                    ok = false;
                    break;
                }
            }
            if (ok) answer++;
        }

        return answer;
    }
}
