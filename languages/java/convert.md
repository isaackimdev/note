# convert

java List를 정수 배열로 만드는 방법.

```java
// 1. 리스트를 스트림으로 변환한 후, 각 요소를 int로 매핑하여 배열로 반환합니다.
int[] array = list.stream().mapToInt(Integer::intValue).toArray();
// 2. 리스트를 배열로 변환 후, 스트림으로 변환 후, 각 요소를 int로 매핑하여 배열로 반환합니다.
int[] array = list.toArray(new Integer[0]).stream().mapToInt(Integer::intValue).toArray();
// 3. 리스트를 스트림으로 변환하고, 각 요소를 int로 매핑하여 배열로 변환합니다.
int[] array = list.stream().mapToInt(i -> i).toArray();
// 4. for 사용
int[] array = new int[list.size()];
for (int i = 0; i < list.size(); i++) {
    array[i] = list.get(i);
}
```