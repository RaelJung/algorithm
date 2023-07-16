for i in range(1, int(input())+1):
    _ = input()
    grades = list(map(int, input().split()))
    freq = [0] * 101
    idx = 0
    for grade in grades:
        freq[grade] += 1
        if freq[grade] >= freq[idx]: idx = grade
    print(f"#{i} {idx}")