## 문제 요약
[평범한 배낭#12865](https://www.acmicpc.net/problem/12865)
- 최대한 가치 있게 싸려고 한다.
- 여행에 필요하다고 생각하는 N개의 물건이 있다.
- 각 물건은 무게 W와 가치 V를 가지는데, 해당 물건을 배낭에 넣어서 가면 준서가 V만큼 즐길 수 있다.
- 최대 K만큼의 무게만을 넣을 수 있는 배낭만 들고 다닐 수 있다.
- 배낭에 <u>넣을 수 있는 물건들의 **가치**의 최댓값</u> 출력

## 입력
- $N\, K$: 물품의 수 $N(1 ≤ N ≤ 100)$, 버틸 수 있는 무게 $K(1 ≤ K ≤ 100,000)$
- $N$개의 줄: 각 물건의 무게 $W(1 ≤ W ≤ 100,000)$와 해당 물건의 가치 $V(0 ≤ V ≤ 1,000)$

## 출력
- 배낭에 넣을 수 있는 물건들의 가치 합의 최댓값 출력

## 접근 방법
무한한 조건, 최적의 조건을 찾아 구현
- 동적 계획법
> 냅색 알고리즘으로 정해진 조건에 맞는 결과 도출
> - 최댓값을 구하는 문제, 이 경우는 탐색 for문의 index를 내림차순으로 탐색 ↔ 최솟값을 구하는 문제는 for문의 index를 오름차순으로 탐색
> - 개수가 아닌 <u>**가치**</u>를 요구하는 것이기 때문에, 가치를 합산해주는 로직을 작성해야 함