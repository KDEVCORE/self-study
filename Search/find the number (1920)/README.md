## 문제 요약
[수 찾기#1920](https://www.acmicpc.net/problem/1920)
 - N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램 작성

## 입력
- $N$: $N$개의 정수 $(1 \le N \le 10^5)$
- $N$개의 정수: A[1], A[2], …, A[N]
- $M$: $M$개의 정수 $(1 \le M \le 10^5)$
- $M$개의 수: A안에 존재하는지 알아내야할 수들
> 모든 정수의 범위는 $-2^{31}$ 보다 크거나 같고 $2^{31}$보다 작다.

## 출력
- $M$개의 줄에 답 출력 (존재하면 1, 존재하지 않으면 0)

## 접근 방법
방대한 데이터 범위와 경우의 수, '그리디' 또는 '이진 탐색'으로 접근
- 이진 탐색