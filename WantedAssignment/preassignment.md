---
name: 프리온보딩 챌린지 사전과제 템플릿
about: 안드로이드 챌린지 1차
title: "[제출일] 안드로이드 사전 과제 - 김민규"
labels: ''
assignees: ''

---

### 1. NullPointerException은 무엇이며, 이를 방지할 수 있는 방법은 무엇인가요?

참조타입으로 선언된 변수를 참조할 때, 해당 변수가 null이면 발생하는 Exception입니다. 참조타입은 null로 초기화되거나 컴파일러가 null로 지정하면 참조타입으로써의 역할을 할수없기에 NPE가 발생합니다. 

방지할수 있는 방법은 다양한데,
if( != null)}{ 코드 실행 } else { null임을 알림 } <- 이렇게 null일때 분기를 해주는 방법이 하나 있습니다.

참조타입인 String은 메서드를 갖고 있습니다 문자열을 비교하는 A.equals(B)는 객체 A를 대상으로 B와 같은지 판단하기 때문에 A가 null이라면 NPE를 발생시킵니다. 따라서 A와 B의 위치를 바꾸거나 null참조를 하지 않는 편이 좋습니다. 

가장 좋은 방법은 null로 초기화를 하지 않는 것입니다.

### 2. List, Set, Map의 주요 특징을 학습하고 정리해주세요.

순서나 집합적인 특성이 있는 List, Set은 Collection에 들어가고, Map은 키와 값으로 맵핑되기때문에 Map에 들어갑니다. 이 Collection과 Map은 Collection프레임워크를 상속합니다.

List는 순서와 중복이 있습니다. 순서를 나타내는 인덱스로 값에 접근할 수 있습니다. List에는 ArrayList와 LinkedList가 있는데 ArrayList는 단방향포인터 배열구조로 검색에는 빠르지만 O(1) 삽입 삭제(O(1), O(n))에는 시간이 오래걸립니다. LinkedList는 검색이 노드 전체를 돌아야해서 O(n)으로 느린대신 삽입삭제가 O(1)로 빠릅니다.

Map은 Key-Value형식으로 구성되는 집합입니다. 키로 접근하기 때문에 중복이 없고, 순서도 보장하지않지만 검색속도가 매우 빠릅니다. index가 따로 없기 때문에 리스트를 순회할 수 있게 해주는 iterator객체를 사용해서 값 전체에 접근할 수 있습니다.

Set은 Map과 비슷하지만 Key로 접근하지않는 데이터만의 집합입니다. 순서와 중복이 없어 중복이 금지된 데이터를 만들 때 사용합니다. 빠른 검색속도를 갖고 있고 마찬가지로 index가 없어 iterator를 사용해 값에 접근합니다. Set을 상속하는 LinkedHashSet은 입력된 순서를 보장하는 Set인데 Set이기 때문에 데이터에 접근하려면 iterator를 사용해야하지만 순서가 보장되어있어 List로 변환해 index로 접근하는 방식도 사용가능합니다.

### 3. Java로 싱글톤 패턴을 구현해주세요.

```java
//kimmingyu(kimmandoo) 
public class Singleton {
    private static Singleton instance;
    
    private Singleton(){}
    
    public static synchronized Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
```

### 4. 아래는 JSON 포맷의 문자열이며, 함수의 인자로 전달됩니다.

- price가 높은 순으로 정렬된 List를 반환하는 함수를 Java로 작성해주세요.
- JSON 라이브러리는 자유롭게 사용하셔도 좋습니다.

```json
   {
       "items": [
         {
           "label": "캐시미어 100% 터틀넥 스웨터",
           "price": 70000
         },
         {
           "label": "반팔 스트라이프 스웨터",
           "price": 30000
         },
         {
           "label": "화이트 스포츠 점퍼",
           "price": 150000
         }
       ]
   }
```

```java
코드를 작성해주세요.
```