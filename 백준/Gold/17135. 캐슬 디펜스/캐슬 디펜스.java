import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 조합 + 시물레이션
// PriorityQueue 사용 X <= Queue 안에 있는 전체 객체를 heap 으로 유지 비용
// 직접 가장 가까운 거리의 적 계산
// 거리를 직접 계산하므로 Enemy 의 d 멤버는 삭제
public class Main {

    static int N, M, D, max;
    static int[] archer = new int[3]; // 조합으로 선택된 궁수의 x 좌표
    // 최초 테케입력으로부터 조합 완성 후 시물레이션을 시작할 때마다 사용 (원본)
    // enmyCopy -> enemy 로 복사 후 시물레이션 진행
    static List<Enemy> enemyCopy = new ArrayList<>();  
    static List<Enemy> enemy = new ArrayList<>();  // 시물레이션 과정에서 사용되는 (변하는 Enemy 를 관리 )
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken()); // 열
        D = Integer.parseInt(st.nextToken()); // 사정거리
        
        // 적군
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                if( n == 1 ) enemyCopy.add(new Enemy(i, j));
            }
        }
        
        // 풀이
        comb(0, 0); // M 개 x 자리 ( y 는 맾 바로 밑 ) 에서 3개를 뽑아서 archer[] (tgt) 에 담고 처리
        System.out.println(max);
    }

    static void check() {
        // 시물레이션 진행
        // 적군 초기화
        enemy.clear();
        for (Enemy e : enemyCopy) {
            enemy.add(new Enemy(e.y, e.x)); // 객체를 공유하지 않고, 내용만 복사해서 새로운 객체 생성 
        }
        // while() 시물레이션 진행
        int dead = 0; // 죽인 적군의 수
        while(true) {
            // 궁수 3명이 한명씩 적군 쏜다.
            for (int i = 0; i < 3; i++) {
                // 가장 가까운 적??                
                int ac = archer[i]; // 현재 궁수의 x좌표
                int size = enemy.size(); // 현재 적군의 크기
                
                int minD = Integer.MAX_VALUE;
                int minX = Integer.MAX_VALUE;
                int minIdx = -1; // 가장 가까운 거리에 있는 적의 index
                
                for (int j = 0; j < size; j++) { // 현재 모든 적군에 대해서
                    Enemy e = enemy.get(j);
                    int d = Math.abs(ac - e.x) + Math.abs(N - e.y);
                    
                    if( d > D ) continue; // 사정거리 밖의 적은 skip
                    
                    // 사정거리안의 적이라면
                    if( minD == d ) {
                        if( minX > e.x ) {
                            minX = e.x;
                            minIdx = j; // 적의 index
                        }
                    }else if( minD > d) {
                        minD = d;
                        minX = e.x;
                        minIdx = j; // 적의 index
                    }
                }
                
                // minIdx 가 유효하면 (있으면)
                if( minIdx != -1 ) {
                    enemy.get(minIdx).dead = true;
                }                
            }
            
            // 죽은 적군을 enemy 제거, 남은 적군 한 칸 아래로 이동, 경계선을 벗어나면 enemy 에서 제거
            for (int i = enemy.size() - 1; i >= 0; i--) {
                Enemy e = enemy.get(i);
                if( e.dead ) {
                    enemy.remove(i);
                    dead++;
                }else if(e.y == N - 1) {
                    enemy.remove(i);
                }else {
                    e.y++;
                }
            }
            
            // 시물레이션 종료 조건
            if( enemy.size() == 0 ) break;
        }
        
        max = Math.max(max, dead);
    }
    
    static void comb(int srcIdx, int tgtIdx) {
        // 기저조건
        if( tgtIdx == 3 ) {
            // complete code 
            // simulation
            check();
            return;
        }
        
        if( srcIdx == M ) return;
        
        archer[tgtIdx] = srcIdx; // 궁수의 자리를 선택
        
        comb(srcIdx + 1, tgtIdx + 1); // 선택
        comb(srcIdx + 1, tgtIdx); // 비선택
    }
    
    static class Enemy{
        int y, x;
        boolean dead; // 사망 여부
        
        Enemy(int y, int x){ // d, dead <= 시물레이션을 진행하면서 setting
            this.y = y;
            this.x = x;
        }
    }
}