## 필터링
스트림을 이용해서 처음 등장하는 두 고기 요리를 필터링하시오.

## 풀이
```java
List<Dish> dishes = specialMenu.stream()
                               .filter(dish -> dish.getType() == Dish.Type.MEAT)
							   .limit(2)
							   .collect(toList());
```