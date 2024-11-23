
def compress(s, step):
    compressed = ""
    prev = s[:step]  # 첫 조각
    cnt = 1  # 반복 횟수

    # step 단위로 문자열 조회
    for i in range(step, len(s), step):
        # 이전 조각과 현재 조각이 같으면 count 증가
        if s[i:i+step] == prev:
            cnt += 1
        else:
            # 다르면 압축에 추가
            # 단, 개수가 있다면 개수도 추가
            compressed += str(cnt) + prev if cnt > 1 else prev
            prev = s[i:i+step] # 다음으로 넘어가기
            cnt = 1 # 초기화
    
    # 마지막 남은 부분 처리
    compressed += str(cnt) + prev if cnt > 1 else prev

    return compressed

def solution(s):
    min_length = len(s)

    for step in range(1, len(s) // 2 + 1):  
        compressed = compress(s, step)
        min_length = min(min_length, len(compressed))

    return min_length
