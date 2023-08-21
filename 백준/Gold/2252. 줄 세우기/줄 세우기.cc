#include <iostream>
#include <vector>
#include <queue>

#define MAX 32001

using namespace std;

int inDegree[MAX];    // 각 정점의 진입차수 개수
vector<int> v[MAX];   // 각 정점이 가리키는 정점 기록

int main() {
	int n, m, a, b;

    cin >> n;
    cin >> m;

	for (int i = 0; i < m; i++) {
        cin >> a;
        cin >> b;
		inDegree[b]++;      //진입차수 증가
		v[a].push_back(b);  //정점 기록
	}

	queue<int> q;
    //진입차수가 없는 정점 q에 넣기
	for (int i = 1; i <= n; i++)
		if (inDegree[i] == 0) q.push(i);

    //순서에 맞게 출력
	while(!q.empty())	{
		int i = q.front(); q.pop();
		cout << i << " ";

        //v에 있는 정점 순서에 맞게 q에 push
		for(int j=0; j<v[i].size(); j++)
			if (--inDegree[v[i][j]] == 0)
				q.push(v[i][j]);
	}
    cout << endl;
}