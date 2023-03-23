#프로그래머스 코딩테스트 연습 > 깊이/너비 우선 탐색(DFS/BFS) > 게임 맵 최단거리
#게임 맵의 상태 maps가 매개변수로 주어질 때, 캐릭터가 상대 팀 진영에 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값을 return 하도록 solution 함수를 완성해주세요. 
#단, 상대 팀 진영에 도착할 수 없을 때는 -1을 return 해주세요.

#제한사항
#-maps는 n x m 크기의 게임 맵의 상태가 들어있는 2차원 배열로, n과 m은 각각 1 이상 100 이하의 자연수입니다.
#   -n과 m은 서로 같을 수도, 다를 수도 있지만, n과 m이 모두 1인 경우는 입력으로 주어지지 않습니다.
#-maps는 0과 1로만 이루어져 있으며, 0은 벽이 있는 자리, 1은 벽이 없는 자리를 나타냅니다.
#-처음에 캐릭터는 게임 맵의 좌측 상단인 (1, 1) 위치에 있으며, 상대방 진영은 게임 맵의 우측 하단인 (n, m) 위치에 있습니다.

from collections import deque

def solution(maps):
    # 상하좌우
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    def bfs(x,y):
        queue = deque()
        queue.append((x,y))
        
        while queue:
            x,y=queue.popleft()
            
            #상하좌우 이동
            for i in range(4):
                nx = x+dx[i]
                ny = y+dy[i]
                
                #범위 벗어나지 않도록
                if nx<0 or nx>=len(maps) or ny<0 or ny>=len(maps[0]):
                    continue
                
                #벽 무시
                if maps[nx][ny] == 0:
                    continue
                
                #처음 지나가는 길이면 거리 계산 후, 다시 상하좌우 확인
                if maps[nx][ny] == 1:
                    maps[nx][ny] = maps[x][y]+1
                    queue.append((nx,ny))   #재귀
            
        # 상대 팀 진영(제일 오른쪽 아래 칸)까지의 거리 반환
        return maps[len(maps)-1][len(maps[0])-1]

    answer = bfs(0, 0)
    return -1 if answer == 1 else answer    # 상대 팀 진영에 도착할 수 없을 때 -1


#Q1. 왜 deque를 쓰는가?
#BFS
#1. 탐색 시작 노드를 큐에 삽입하고 방문 처리한다.
#2. 큐에서 노드를 꺼낸 뒤에 해당 노드의 인접 노드 중에서 방문하지 않은 노드를 처리한다.
#3. 더 이상 2번의 과정을 수행할 수 없을 때까지 반복한다.
