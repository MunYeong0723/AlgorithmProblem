# SW Expert Academy 문제 풀이

<details>
	<summary># 1859</summary>
	-> 처음에는 재귀를 이용하여 각 날에 물건을 사는 경우, 안 사는 경우 모두를 체크하여 이익의 최대를 찾도록 구현하였다. 하지만 시간 초과가 나서 다른 풀이 방법을 찾아야했다. <br>
-> 매매가를 뒤에서부터 보면서 지금까지 본 값 중 제일 큰 값이면 이 날 물건을 파는 날이므로 max를 갱신하고, 그렇지 않으면 물건을 사는 날로 보고 현재 최대값에서 그 날의 매매가를 뺀 값을 현재 이익에 더해준다. <br>
(https://github.com/MunYeong0723/AlgorithmProblem/blob/master/SW%20Expert%20Academy/_1859.java)
</details>
<br>

<details>
	<summary># 1204</summary>
	-> 1000개의 점수를 입력받고 그 중 개수가 제일 많은 점수를 출력하는 문제이다. search를 좀 더 빠르게 하기 위해 HashMap을 이용하여 구현하였고 100개의 score 중 학생 수가 제일 많은 점수를 출력하였다. <br>
-> 하지만 다른 사람들의 풀이를 보니 HashMap을 쓰지 않고 그냥 배열로도 풀 수 있었다. 점수는 0 이상 100 이하이기 때문에 크기가 101개인 배열을 선언한다. index를 score로 보고 해당 index 안의 값을 학생 수로 하여 1000개의 점수를 입력받고, 배열을 처음부터 보면서 학생 수가 제일 많은 점수를 출력하도록 구현할 수도 있었다. <br>
(https://github.com/MunYeong0723/AlgorithmProblem/blob/master/SW%20Expert%20Academy/_1204.java)
</details>
<br>

<details>
	<summary># 1206</summary>
	-> 처음에 입력받을 때 앞의 5개 중 최대값이 있는 index를 찾아 maxIndex에 넣어주었다. 그리고 현재 위치의 빌딩 높이가 왼쪽 2칸, 오른쪽 2칸 중 제일 큰 값이면 조망권이 확보되므로 현재 빌딩 높이에서 범위 내의 빌딩 높이를 뺀 값 중 제일 작은 값으로 count해준다. <br>
-> 범위 내에서 제일 높은 빌딩인지를 가지고 있기 위해 확보된 조망권을 계산하기 전, max값을 update해주었다. 새로 범위내로 들어온 빌딩의 높이가 제일 크다면 그 빌딩의 index로 update해주고, 현재 가지고 있던 max가 범위에서 벗어난다면 현재 범위에 들어온 빌딩 중 max값을 다시 찾아준다. <br>
(https://github.com/MunYeong0723/AlgorithmProblem/blob/master/SW%20Expert%20Academy/_1206.java)
</details>
<br>

<details>
	<summary># 1244</summary>
	-> 우선 제일 큰 숫자를 제일 앞으로 오게 하기 위해 맨 뒤부터 하나씩 보면서 현재 바꿔야할 index 뒤의 숫자들 중 제일 큰 숫자들 중 제일 뒤에 있는 숫자의 index를 찾는다. 그리고 바꿀 차례의 자리의 숫자보다 최대값이 더 크다면, 두 숫자의 자리를 바꾼다. 이렇게만 구현하면 (32888을 2번 교환하는 경우 & 456789을 10번 교환하는 경우) 이런 반례가 존재한다. <br>
-> 그래서 해당 반례에 대한 조건을 추가해주었다. 32888을 2번 교환하는 경우를 처리하기 위해 현재 max값이 있는 index 바로 앞의 숫자도 max값과 같다면 최대값이 있는 index 앞의 숫자들 중 제일 작은 수를 찾아 그 수와 자리를 바꾸도록 하였다. <br>
-> 456789을 10번 교환하는 경우는 이미 최대값이 나왔는데 교환횟수가 남은 경우이다. 이를 처리하기 위해 index를 끝까지 check하였는데 교환횟수가 남아있다면 남은 횟수가 짝수라면 그대로 돌아올 수 있기 때문에 바로 break를 하고, 그렇지 않다면 자리를 바꾸되 제일 작은 숫자들을 바꾸기 위해 맨 뒤에서 2개의 숫자 자리를 바꿔주고 break해주었다. <br>
(https://github.com/MunYeong0723/AlgorithmProblem/blob/master/SW%20Expert%20Academy/_1244.java)
</details>
<br>

<details>
	<summary># 1208</summary>
	-> 상자는 모두 100개이고, dump 횟수는 1000이하로 주어지므로 time complexity가 O(N)이어도 오래걸리지는 않겠다고 생각하였다. 그래서 dump 횟수만큼 while loop를 돌면서 배열을 하나씩 보면서 dump하기 전에 현재 상자 높이의 최소와 최대 높이를 찾아 dump하도록 구현하였다. dump횟수만큼 dump를 마치면 다시 한번 높이의 최소&최대 높이를 찾아 뺀 만큼을 답으로 출력하였다. <br>
	(https://github.com/MunYeong0723/AlgorithmProblem/blob/master/SW%20Expert%20Academy/_1208.java)
</details>
<br>

<details>
	<summary># 1926</summary>
	-> 1~N까지 for loop를 돌면서 해당 int를 String으로 바꾼 후 현재 숫자에 3,6,9가 있는지 체크하고, 없다면 숫자를 출력하고 다음으로 넘어간다. 3,6,9가 있다면 3,6,9가 있는만큼 -를 출력하도록 하고 다음으로 넘어간다. <br>
	(https://github.com/MunYeong0723/AlgorithmProblem/blob/master/SW%20Expert%20Academy/_1926.java)
</details>
<br>

<details>
	<summary># 1240</summary>
	-> 0~9 숫자 코드 모두 1로 끝나기 때문에 56자의 암호코드는 1로 끝난다는 것을 알 수 있다. 따라서 한 줄을 입력받아서 1이 포함되어 있다면 끝의 1부터 56글자를 받아오는 식으로 암호코드의 정보를 추출한다. <br>
-> 암호코드를 7글자씩 자르면서 해당되는 숫자로 바꾸고 검증코드가 맞는지 규칙에 맞게 계산해보고 맞다면 합을 출력하고, 그렇지 않으면 0을 출력하였다. <br>
(https://github.com/MunYeong0723/AlgorithmProblem/blob/master/SW%20Expert%20Academy/_1240.java)
</details>
<br>
