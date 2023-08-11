#include <iostream>

using namespace std;

// C1 3040 백설 공주와 일곱 난쟁이
int main() {
  int a[9];
  int sum=0, idx[2];
  // 1. 숫자 배열에 입력 받기
  for(int i=0; i<9; i++){
    cin >> a[i];
    sum += a[i];
  }
  // 2. 숫자 배열 돌리며 조합하기
  // 숫자들을 다 더한것에서 두개만 빼서 100이 되는 조합 찾기
  for(int i=0; i<9; i++){
    for(int j=0; j<9; j++){
      if(i!=j){
        if(sum - (a[i]+a[j]) == 100){
          idx[0] = i;
          idx[1] = j;
        }
      }
    }
  }
  // 3. 조합한 숫자 제외 출력
  for(int i=0; i<9; i++){
    if(i != idx[0] && i != idx[1])
      cout << a[i] << endl;
  }
}