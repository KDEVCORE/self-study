## 문제 요약
[Minions master#11262](https://www.acmicpc.net/problem/11262)
- 파워 미터를 사용하여 마을에 있는 모든 사람의 파워를 측정, 그런 다음 해당 마을의 모든 사람들의 평균 권력과 평균 권력보다 큰 권력을 가진 마을 사람들의 비율 계산
> 예를 들어 타운 A는 5명으로 구성되어 있습니다. 파워미터는 다음과 같은 결과를 보여줍니다: 50, 150, 70, 180, 100. 따라서 평균 파워는 110입니다. 그리고 110<u>보다 큰(=초과)</u> 파워를 가진 사람이 2명 있습니다. 따라서 대답은 110 40%입니다. 여기서 110 는 평균 파워이고 40%는 110(평균 파워)보다 큰 파워를 가진 사람들의 비율입니다.


## 입력
- T: 테스트 케이스 $(1 <= T <= 1000)$
- $N X_N$: 마을 사람 수 $N\, (1 <= N <= 1000)$, 각 마을 사람의 파워 $X_N\, (0 <= X_N <= 1000)$

## 출력
- 각 테스트케이스마다 평균 파워와 평균 파워보다 큰 사람들의 비율 출력 (소수점 세 자리 반올림)
> 반올림은 "반올림" 규칙을 사용하여 수행해야 합니다. 많은 언어에서 기본적으로 이 규칙을 사용하지 않을 수 있습니다.

## 접근 방법
다량의 테스트 케이스 존재
- 자료 구조