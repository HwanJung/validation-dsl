# Validation DSL

### 사용 예시
Validator
    .value("email", email)
        .notBlank()
    .value("name", name)
        .notBlank()
        .maxLength(8);

- [x] 값 검증
  - [x] null일 때 검증
  - [x] 타입이 String일 때
    - [x] Blank일 때 검증
    - [x] Empty일 때 검증
    - [x] 최대 길이 검증
    - [x] 최소 길이 검증
  - [x] 타입이 숫자일 때
    - [x] 최소 값 검증
    - [x] 최대 값 검증
    - [x] 사잇값 검증
    - [x] 나누어 떨어지는지 검증

