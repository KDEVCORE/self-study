## 문제 요약
[수 정렬하기 3#10989](https://www.acmicpc.net/problem/10989)
- N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성

## 입력
- $N$: 숫자의 개수 N $(1 ≤ N ≤ 10000000)$
- $A_N$: 각 줄마다 N개의 숫자들 $(1 <= A_N <= 10000)$

## 출력
- N개의 줄에 오름차순으로 정렬한 결과 출력

## 접근 방법
숫자들의 정렬 구현
- 정렬 → 병합 정렬 → 메모리 초과 발생 → Arrays.sort() 사용
> 정렬 알고리즘보다 효율적인 입력 및 구현이 중요한 문제
