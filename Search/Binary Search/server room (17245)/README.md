## 문제 요약
- 서버실은 N×N 칸으로 구분되어 있고, 각 칸마다 서버 랙이 있어 컴퓨터를 여러 대 쌓을 수 있다.
- 서버가 과열되지 않도록 서버실에는 언제나 냉방기가 작동하고 있다. <u>서버실 내의 컴퓨터 중 **절반만** 정상적으로 관리</u>하기로 하였다.
- 차가운 공기는 서버실의 아래쪽부터 서서히 차오른다. 1분마다 컴퓨터 한 대의 높이만큼 방을 채운다.
- 서버 컴퓨터는 환경에 매우 민감하여 차가운 공기를 받아야만 동작하고 그렇지 못하면 장애를 일으킨다.
- 서버실의 컴퓨터 중 절반 이상이 켜지려면 몇 분이 필요할까?

## 입력
- $N$: 서버실 칸 $N\, (1 \le N \le 10^3)$
- $N$개의 줄: N×N개의 각 칸에 컴퓨터가 몇 대 쌓여있는지가 입력된다. 한 칸에는 최대 10,000,000대까지 쌓여있을 수 있다.

## 출력
- 몇 분이 지나야 전체 컴퓨터의 절반 이상이 장애를 일으키지 않고 동작할 수 있는지 출력

## 접근 방법
1분마다 컴퓨터 한대의 높이만큼 차가운 공기 채워짐 → 전체 컴퓨터 수를 파악하고, 시간값이 누적될 때 컴퓨터 수를 전체 컴퓨터 수 대비 절반 넘는지 판단 → 방대한 경우의 수, 최선의 해 찾기 어려우므르 이진 탐색으로 접근
- 이진 탐색

> 합계 변수의 자료형은 long을 써야 하는지 고려하기

> 참고: [나무 자르기#2805](https://github.com/KDEVCORE/self-study/tree/main/Search/tree%20cutting%20(2805))