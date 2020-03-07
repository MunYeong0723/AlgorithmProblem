# For Studying Kotlin
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
 -> 하지만 이렇게 구현하면 계속 시간초과가 나왔다. 어떻게 하면 search하는 시간을 줄일 수 있을지 찾아보다가 search하는데 logN만큼 걸리는 binary search를 이용하여 구현하였더니 문제를 맞출 수 있었다. <br>
 <br>
