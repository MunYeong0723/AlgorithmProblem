import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**5) # 파이썬에서는 재귀 횟수가 제한되어서 limit을 늘려준다.

def findParent(x):
    if tree[x] == 0: return x

    px = tree[x]
    tree[x] = findParent(tree[x])

    weight[x] += weight[px]
    return tree[x]

def union(a,b,w):
    pa = findParent(a)
    pb = findParent(b)

    if pa == pb : return

    weight[pa] = w - (weight[a]-weight[b])
    tree[pa] = pb


while True :
    N, M = map(int, input().split())
    if N == 0: break

    tree = [0 for i in range(N+1)]
    weight = [0 for i in range(N+1)]

    for _ in range(M):
        lst = list(input().split())

        if lst[0] == '!':
            a = int(lst[1])
            b = int(lst[2])
            w = int(lst[3])

            union(a,b,w)

        elif lst[0] == '?':
            a = int(lst[1])
            b = int(lst[2])

            pa = findParent(a)
            pb = findParent(b)

            if pa != pb : print("UNKNOWN")
            else: print(weight[a] - weight[b])
