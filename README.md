### # 8979
(https://www.acmicpc.net/problem/8979) <br>
-> 처음에는 Map class를 만들어서 멤버 변수에 key, value를 두고 key에는 국가를 나타내는 정수를, value에는 해당 나라의 메달 개수를 배열로 담는 class를 만들었다. 그리고 main()에서 Map class를 담기 위한 ArrayList를 만들어서 N개 나라의 메달 개수를 담아놓았다.
그리고 Map class에서 compareTo()를 override하여 sorting하려고 하였다. <br>
-> 하지만 이렇게 하면 "1번 국가가 금메달 1개, 은메달 1개를 얻었고, 2번 국가와 3번 국가가 모두 은메달 1개를 얻었으며, 4번 국가는 메달을 얻지 못하였다"라는 경우일 때 2등이 2개의 나라이고 3등은 없는데 이에 대해 처리하기가 어려워졌다. <br>
-> 따라서 compareTo()를 override하지 않고 "(국가 K보다 잘한 나라의 수)+1"이 등수이기 때문에 if문을 통해 국가 K보다 잘한 나라의 수를 세는 방법으로 구현하였다.
<br>

### # 1764
(https://www.acmicpc.net/problem/1764) <br>
 -> 처음에는 듣도 못한 사람 N명을 입력받아 Array에 담고, 보도 못한 사람 M명을 입력받으면서 Array에서 같은 이름이 있는지 처음부터 끝까지 보면서 search하도록 구현하였다. <br>
 -> 하지만 이렇게 구현하면 계속 시간초과가 나왔다. 어떻게 하면 search하는 시간을 줄일 수 있을지 찾아보다가 search하는데 logN만큼 걸리는 binary search를 이용하여 구현하였더니 문제를 맞출 수 있었다.
<br>

### # 3101
(https://www.acmicpc.net/problem/3101) <br>
-> 토끼가 이동하는 board의 숫자를 while문을 돌면서 미리 채워넣고 토끼가 이동하는 칸의 숫자를 더하도록 구현하였다. 하지만 이렇게 구현하였더니 '메모리 초과'가 떠서 다른 방법으로 구현해야 했다. <br>
-> 이번에는 칸에 숫자를 채워넣지 않고 좌표를 이용해서 해당 칸의 숫자를 알아내도록 구현하였다. 해당 칸의 숫자를 계산하는 method를 따로 만들어서 현재 토끼가 있는 좌표를 parameter로 넘겨주어서 이를 가지고 숫자를 계산하였다. 하지만 이번에는 '틀렸습니다'는 결과가 나왔다. <br>
-> 문제에서 32비트가 넘는 정수가 나올 수도 있다고 했는데 이를 간과하고 자료형을 Int로 구현하고 있었다. 따라서 칸의 숫자를 담는 변수와 숫자를 더한 값을 담는 변수의 자료형을 Long으로 바꿔주었다. 이번에는 '시간 초과'라는 결과가 나왔다. 이전에는 칸의 숫자를 계산하는 method에서 while문을 이용해서 숫자를 찾았는데 계산하는 시간을 줄이기 위해 간단한 수식으로 바꿨더니 문제를 맞출 수 있었다.
<br>

### # 5567
(https://www.acmicpc.net/problem/5567) <br>
-> graph를 이용해서 depth가 1이거나 2인 node를 찾아서 그 개수를 세도록 구현하였다. Node class를 만들어서 각 node의 number, depth, search했을 때 visit했는지, neighbor node에 대한 정보를 가지고 있도록 하였다. 그리고 stack을 이용하여 DFS search를 하고, depth가 2보다 크면 stack에 들어가지 않게 구현하였다. <br>
-> 처음에는 edge를 입력받을 때 작은 수부터 입력되기 때문에 작은 수의 node에 있는 neighbor 배열에만 add해서 directed graph가 되도록 만들었다. 하지만 문제에서 필요한 graph는 undirected graph이기 때문에 큰 수의 node에 있는 neighbor 배열에도 edge를 추가해줘서 문제를 맞출 수 있었다. 
<br>

