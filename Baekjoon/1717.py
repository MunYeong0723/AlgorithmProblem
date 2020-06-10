import sys
input = sys.stdin.readline

n, m = map(int, input().split())
lst = [-1 for i in range(0, n+1)] # size가 n인 list를 선언하고 0으로 초기화함.
depth = [0 for i in range(0, n+1)] # 최적화를 위해 tree의 depth를 저장하기 위한 list 선언함.

def find(x) :
    if lst[x] == -1 : return x
    return find(lst[x])

def union(a,b) :
    parent_a = find(a)
    parent_b = find(b)

    if parent_a == parent_b : return # 이미 같은 집합인 경우

    if depth[parent_a] > depth[parent_b]:
        lst[parent_b] = parent_a # parent_a를 대표값으로 한다.
    else:
        lst[parent_a] = parent_b # parent_b를 대표값으로 한다.

        if(depth[parent_a] == depth[parent_b]):
            depth[parent_b] += 1


while m > 0:
    doit, a, b = map(int, input().split())

    if doit == 0:
        union(a, b)
    else:
        parent_a = find(a)
        parent_b = find(b)

        if(parent_a == parent_b):
            print("yes")
        else :
            print("no")

    m -= 1