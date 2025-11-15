# Validation DSL

### 사용 예시
    int number = 15;
    Validator.validate(number)
        .greaterThan(10);

    String name = "name";
    Validator.validate(name)
        .notBlank()
        .maxLength(8);
        .satisfies(s -> s.equals(name));

    User user = new User("name");
    Validator.validate(user)
        .notNull()
        .satisfies(u -> "name".equals(u.getName()));

    List<String> list = List.of("a", "b", "c");    
    Validator.validateStrings(list)
        .notNull()
        .notEmpty()
        .sizeAtMost(5)
        .forEach(e -> e
            .notNull()
            .maxLength(1)
        );

    Set<String> set = List.of("a", "b", "c");    
    Validator.validateStrings(set)
        .notNull()
        .notEmpty()
        .sizeAtMost(5)
        .forEach(e -> e
            .notNull()
            .satisfies(s -> !s.isBlank())
        );

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

