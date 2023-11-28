import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, min;
	static int map[][];
	// 출력
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			min = Integer.MAX_VALUE;

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			comb(0, 0, 0); // srcIdx, tgtIdx, mask

			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

	static void comb(int srcIdx, int tgtIdx, int mask) {
		// 기저조건
		if (tgtIdx == N / 2) {
			int selA[] = new int[N / 2];
			int selB[] = new int[N / 2];

			// 각 재료 구분
			int idxA = 0, idxB = 0;
			for (int i = 0; i < N; i++) {
				// 선택된 재료
				if ((mask & 1 << i) != 0) {
					selA[idxA++] = i;
				} // 아닌 재료
				else {
					selB[idxB++] = i;
				}
			}

			// 시너지 구하기
			int sumA = 0, sumB = 0;
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < N / 2; j++) {
					sumA += map[selA[i]][selA[j]];
					sumB += map[selB[i]][selB[j]];
				}
			}
			// 최소 구하기
			min = Math.min(min, Math.abs(sumA - sumB));
			return;
		}
		//기저조건 2
		if(srcIdx == N) return;
		
		comb(srcIdx + 1, tgtIdx + 1, mask | 1 << srcIdx); // 선택
		comb(srcIdx + 1, tgtIdx, mask); // 비선택
	}
}