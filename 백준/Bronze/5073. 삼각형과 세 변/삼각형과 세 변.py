while True:
    length = list(map(int, input().split()))
    
    if length[0] == length[1] == length[2] == 0:
        break
        
    max_value = length.pop(length.index(max(length)))
    
    if max_value >= length[0] + length[1]:
        print("Invalid")     
        continue
        
    if max_value == length[0] == length[1]:
        print("Equilateral")
    elif (max_value == length[0]) | (max_value == length[1]) | (length[0] == length[1]):
        print("Isosceles")
    else:
        print("Scalene")