# Validation DSL

### 사용 예시
  Validator.validate("number", number)
    .greaterThan(10);

  Validator.validate("name", name)
    .notBlank()
    .maxLength(8);
    .satisfies(s -> s.equals(name));

  Validate.validate("listName", list)
    .notNull()
    .notEmpty()
    .sizeAtMost(5)
    .forEach(e -> e
      .notNull()
      .satisfies(s -> !s.isBlank())
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

