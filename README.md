# 백준 문제 풀이

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
-> DFS search는 깊이 우선 탐색으로 graph를 search하는 방법 중 한 가지이다. 먼저 root node를 stack에 push하고 visit했다고 체크한다. 그 다음 stack에서 node 하나를 pop하고 그 node의 neighbor node들을 stack에 push한다. push한 node들은 visit했다고 체크해준다. 이를 stack이 empty일 때까지 반복한다. <br>
-> 처음에는 edge를 입력받을 때 작은 수부터 입력되기 때문에 작은 수의 node에 있는 neighbor 배열에만 add해서 directed graph가 되도록 만들었다. 하지만 문제에서 필요한 graph는 undirected graph이기 때문에 큰 수의 node에 있는 neighbor 배열에도 edge를 추가해줘서 문제를 맞출 수 있었다. 
<br>

### # 2751
(https://www.acmicpc.net/problem/2751) <br>
-> 라이브러리를 이용해서 sorting할 수 있지만 그렇지 않고 직접 sorting 알고리즘을 짜보았다. 여러 가지 sorting 알고리즘이 있지만 시간 제한이 있기 때문에 평균 O(nlogn)이 걸리는 merge sort로 구현하였다. <br>
-> merge sort는 문제를 작은 2개의 문제로 분리하고 각각을 해결한 다음, 결과를 모아서 원래의 문제를 해결하는 방법이다. 재귀함수를 이용하여 구현하였다. <br>
-> merge sort로 구현했어도 시간 초과가 나왔는데 println()을 BufferedWriter의 write() method로 바꿨더니 시간 초과가 뜨지 않았다. 이에 대해서 찾아본 결과, 자바에서도 println()이 느리기 때문에 성능에 영향을 많이 준다는 것을 알 수 있었다. 다음 링크를 보면 1부터 10,000,000까지의 자연수를 한 줄에 하나씩 출력하는 시간을 측정했을 때 println()은 30초나 걸리는 것을 볼 수 있다. (참고 : https://www.acmicpc.net/blog/view/57)
<br>

### # 11650
(https://www.acmicpc.net/problem/11650) <br>
-> sort하는 것은 2751번 문제를 풀 때 사용한 merge sort 알고리즘으로 정렬하였다. 좌표이기 때문에 Pair class를 만들어서 x좌표와 y좌표를 가지고 있도록 구현하였다. <br>
-> sorting을 할 때 크기 비교를 해야되는데 class를 크기 비교하게 하기 위해서 인터페이스 Comparable을 implements하고 compareTo를 override해서 x좌표가 크면, x좌표가 같다면 y좌표가 큰 Pair가 크도록 구현하였다.
<br>

### # 1406
(https://www.acmicpc.net/problem/1406) <br>
-> 커서를 옮기면서 중간의 글자를 추가하거나 지울 수 있기 때문에 add, remove 하는데 걸리는 시간이 O(1)인 linkedlist를 이용해서 구현하려고 하였다. 처음에 구현했을 때는 index를 이용해서 add(index, char), removeAt(index)를 이용해서 중간의 글자를 추가하거나 지웠기 때문에 O(1)이 걸리는 것이 아니라 index까지 찾아가서 add나 remove를 하기 때문에 O(n)의 시간이 걸린다. 그래서 시간 초과로 문제를 풀 수 없었다. <br>
-> 이번에는 linkedlist의 listiterator를 이용해서 구현해보았다. (iterator도 있지만 iterator는 단방향으로만 갈 수 있기 때문에 양방향으로 이동할 수 있는 listiterator를 사용하였다.) iterator를 커서로 보고 명령을 수행하도록 구현하였지만 여전히 시간 초과가 떴다. 그래서 입출력의 시간을 최대한 줄이기 위해 Scanner 대신 BufferedReader로 입력을 받고, BufferedWriter로 출력을 했지만 그래도 시간 초과가 떴다. <br>
-> 문제에 대해 찾아보다가 stack으로도 풀 수 있다는 힌트를 얻었다. stack을 2개 만들어서 커서의 왼쪽에 있는 글자와 오른쪽의 글자를 나눠서 각각의 stack에 담았다. 그러면 add, remove를 O(1)만에 할 수 있다. 이렇게 구현하여 문제를 맞출 수 있었다.
<br>

### # 10824
(https://www.acmicpc.net/problem/10824) <br>
-> 처음에는 주어진 예시(10 20 30 40)만 생각하고 첫번째, 세번째 숫자에 100을 곱해서 뒤에 숫자에 더해주게 구현하여서 문제를 틀렸었다. 다른 경우(예를 들어, 1343 34 463 34)를 보면 100을 곱해서 더하는 것은 당연히 답이 될 수 없다. 그래서 각 숫자를 string으로 입력받고 + 연산을 이용해서 2개를 붙인 후 toInt()로 int로 바꿔준 후 더하도록 구현하였다. 하지만 이번에는 런타임 에러가 났다. <br>
-> 문제의 조건을 보니 입력받는 숫자의 범위는 1 ≤ A, B, C, D ≤ 1,000,000 이므로 A와 B가 모두 1,000,000인 경우 합쳤을 때 10,000,001,000,000이 되는데 이는 int의 범위인 -2,147,483,648 ~ 2,147,483,647를 넘어서게 된다. (int는 4 byte == 32 bit이기 때문에 sign bit인 1 bit를 제외하면 2^31까지 담을 수 있다.) 따라서 8 byte 자료형인 long으로 바꿔주었더니 문제를 맞출 수 있었다.
<br>
