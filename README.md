# Validation DSL

## 사용 예시

### Integer, Long, Double 등의 Number 타입의 값 검증
```java
// 검증할 변수가 만족해야 하는 조건을 정의한 뒤 조건이 만족되면 아무 일도 일어나지 않는다.
// 모든 Number의 자식 타입에 대해 사용할 수 있는 조건은 아래와 같다.
int number = 30;
Validator.validate(number)
    .notNull()
    .greaterThan(10)
    .lessThan(50)
    .multipleOf(10)
    .greaterThanOrEqualTo(30)
    .lessThanOrEqualTo(30)
    .betweenExclusive(10,50)
    .betweenInclusive(10,30)
    .satisfies(n -> n == 30);
    
 
// multipleOf() 조건은 검증할 타입이 정수형(Integer, Long, Byte, Short)타입일 때만 가능하다.
int number = 30;
Validator.validate(number)
    .multipleOf(10);
    

// 조건이 만족되지 않으면 ValidationException이 반환된다.
// 조건이 하나라도 만족되지 않아도 ValidationException이 반환된다.
int number = 30;
Validator.validate(number)
    .notNull()
    .greaterThan(10)
    .multipleOf(29);  // throw ValidationException
```    

### String 타입의 값 검증
```java
// 검증할 변수가 만족해야 하는 조건을 정의한 뒤 조건이 만족되면 아무 일도 일어나지 않는다.
// String 타입에 대해 사용할 수 있는 조건은 아래와 같다.

String name = "name";
Validator.validate(name)
    .notNull()
    .notBlank()
    .notEmpty()
    .maxLength(8)
    .minLength(1)
    .satisfies(s -> s.equals(name));


// 조건이 만족되지 않으면 ValidationException이 반환된다.
// 조건이 하나라도 만족되지 않아도 ValidationException이 반환된다.
String name = "name";
Validator.validate(number)
    .notNull()
    .maxLength(2); // throw ValidationException
```

### 그 이외의 타입에 대한 검증
```java
// 검증할 변수가 만족해야 하는 조건을 정의한 뒤 조건이 만족되면 아무 일도 일어나지 않는다.
// 사용할 수 있는 조건은 아래와 같다.

User user = new User("name");
    Validator.validate(user)
        .notNull()
        .satisfies(u -> "name".equals(u.getName()));
```



### Collection(List, Set)에 대한 검증
```java
// 검증할 Collection이 만족해야 하는 조건을 정의한 뒤 조건이 만족되면 아무 일도 일어나지 않는다.
// 사용할 수 있는 조건은 아래와 같다.
// forEach 안에는 람다식으로 Collection안의 요소들에 대한 조건을 적을 수 있다.

// 1. Element가 String인 Collection일 때는 validateStrings()를 사용한다.

List<String> list = List.of("a", "b", "c");    
Validator.validateStrings(list)
    .notNull()
    .notEmpty()
    .sizeAtLeast(3)
    .sizeAtMost(5)
    .size(3)
    .forEach(e -> e
        .notNull()
        .maxLength(1)
    );

Set<String> set = List.of("a", "b", "c");    
Validator.validateStrings(set)
    .notNull()
    .notEmpty()
    .sizeAtLeast(3)
    .sizeAtMost(5)
    .size(3)
    .forEach(e -> e
       .notNull()
       .satisfies(s -> !s.isBlank())
    );

// 2. Element가 Number의 자식 클래스인 Collection일 때는 validateNumbers()를 사용한다.

List<Integer> list = List.of(1, 2, 3);    
Validator.validateNumbers(list)
    .notEmpty()
    .sizeAtMost(5)
    .forEach(e -> e
        .notNull()
        .greaterThan(0)
    );

Set<Integer> set = List.of(1, 2, 3);    
Validator.validateNumbers(set)
    .notEmpty()
    .sizeAtMost(5)
    .forEach(e -> e
        .notNull()
        .greaterThan(0)
    );

// 3. Element가 그 이외의 타입인 Collection일 때는 validateObjects()를 사용한다.

List<User> userList = new ArrayList<>();
userList.add(u1);
userList.add(u2);
Validator.validateObjects(users)
    .notEmpty()
    .sizeAtMost(5)
    .forEach(e -> e
        .notNull()
    );

Set<User> userSet = new HashSet<>();
userSet.add(u1);
userSet.add(u2);
Validator.validateObjects(users)
    .notEmpty()
    .sizeAtMost(5)
    .forEach(e -> e
        .notNull()
    );
```


- [x] 공통 검증
  - [x] notNull 조건
  - [x] 사용자 지정 조건
- [x] 값 검증
  - [x] 타입이 String일 때
    - [x] notBlank 조건
    - [x] notEmpty 조건
    - [x] 최대 길이 조건
    - [x] 최소 길이 조건
  - [x] 타입이 숫자일 때
    - [x] 최소 값 조건
    - [x] 최대 값 조건
    - [x] 사잇값 조건
    - [x] 특정 숫자로 나누어 떨어지는지 조건
    - [x] 인자가 null이라면 예외
- [x] 리스트 검증
  - [x] notEmpty 조건
  - [x] 리스트 최대 크기 조건
  - [x] 리스트 최소 크기 조건
  - [x] 리스트 특정 크기 조건
  - [x] 각 요소 검증
- [x] Set 검증
  - [x] notEmpty 조건
  - [x] Set 최대 크기 조건
  - [x] Set 최소 크기 조건
  - [x] Set 특정 크기 조건
  - [x] 각 요소 검증
