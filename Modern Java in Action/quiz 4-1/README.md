## 외부 반복 vs 내부 반복
외부 반복을 참고해서 어떤 스트림 동작을 사용해 다음 코드를 리팩터링할 수 있을 지 생각해보자.
```java
List<String> highCaloricDishes = new ArrayList<>();
Iterator<String> iterator = menu.iterator();
while(iterator.hasNext()) {
    Dish dish = iterator.next();
    if(dish.getCalories() > 300) {
        highCaloricDishes.add(d.getName());
    }
}
```

```java
List<String> highCaloricDishes = menu.stream().filter(dish -> dish.getCalories() > 300).map(Dish::getName).collect(toList());
```