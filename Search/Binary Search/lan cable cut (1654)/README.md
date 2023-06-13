## 문제 요약
[랜선 자르기#1654](https://www.acmicpc.net/problem/1654)
- N개의 랜선을 만들어야 할 때
- 자체적으로 K개의 랜선을 가지고 있다. 그러나 K개의 랜선은 길이가 제각각이다.
- 랜선을 모두 N개의 같은 길이로 만들고 싶었기 때문에, K개의 랜선을 잘라서 만들어야 한다.
    > 예를 들어 300cm 짜리 랜선에서 140cm 짜리 랜선을 두 개 잘라내면 20cm는 버려야 한다. (이미 자른 랜선은 붙일 수 없다.)
- 랜선을 자르거나 만들 때 손실되는 길이는 없다고 가정하며, 기존의 K개의 랜선으로 N개의 랜선을 만들 수 없는 경우는 없다고 가정하자.
- <u>자를 때는 항상 **센티미터(cm) 단위**로 정수길이만큼 자른다고 가정하자.</u>
- <u>N개보다 많이 만드는 것도 N개를 만드는 것에 포함</u>

## 입력
- $K N$: 이미 가지고 있는 랜선의 개수 정수 $K\,(1 ≤ K ≤ 10000)$, 필요한 랜선의 개수 정수 $N\,(1 ≤ N ≤ 1000000)$ (단, $K ≤ N$)
- $K$개의 줄: 이미 가지고 있는 랜선의 길이 $K_i$ 정수 (단, 랜선의 길이는 $2^{31}-1$보다 작거나 같은 자연수)

## 출력
- N개를 만들 수 있는 랜선의 최대 길이 정수 출력 (단, <u>출력 단위는 cm</u>)

## 접근 방법
방대한 경우의 수, 목표 최댓값 출력 → '그리디 알고리즘' 또는 '이진 탐색' → 해가 주어져 있지 않고 탐색하는 과정이 필요하므로 **이진 탐색**
- 이진 탐색
> 이진 탐색의 경우, 중간 계산에 사용되는 변수가 int형 범위를 넘는 경우가 빈번하기 때문에, long형으로 선언해주어야 한다.

> 참고 문제: [기타 레슨#2343](https://github.com/KDEVCORE/study-group/tree/main/common%20challenges/guitar%20lesson%20(2343))