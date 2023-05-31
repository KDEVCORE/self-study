## 람다 문법
앞에서 설명한 람다 규칙에 맞지 않는 람다 표현식을 고르시오.
1. `() -> {}`
2. `() -> "Raoul"`
3. `() -> {return "Mario";}`
4. `(Integer i) -> return "Alan" + i;`
5. `(String s) -> {"Iron Man";}`

## 정답 및 이유
유효하지 않은 표현식은 '4, 5'번이다.
- 4번은 return은 흐름 제어문이므로 `{return "Alan" + i;}`가 유효한 표현식이다.
- 5번은 조건문이 아니라 표현식이다. `"Iron Man"` 또는 `{return "Iron Man";}`가 유효한 표현식이다.