##### spring-mongo-rest-example

### 데모 설명
nosql을 경험하고 익히기 위한 데모<br>
spring &amp; mongoDB를 이용하여 간단한 게시판 rest api 개발

### 기능 구현
1. 사용자 조회,추가,수정,삭제<br>
   사용자 정보의 형태가 일정하지 않을 것<br>
   nosql의 특징을 잘 사용해보기
2. 게시글 조회,작성,수정,삭제<br>
   외래키가 존재하지 않는 특성을 이용해보기 (embedded, link)
3. 프로필 이미지 조회,등록,수정,삭제
   mysql의 blob 자료형이 있는지. 있다면 사용해보기 

### 궁금한 부분 정리

<details>
    <summary>@DataMongoTest에서 롤백하는 법</summary>
    <p>
   @Test + @Transactional일 경우, 롤백이 된다.<br>
   하지만 MongoDB에는 Transactional의 개념이 없고, 당연히 @DataMongoTest는 @Transactinal을 포함하지 않는데, @Transactional 애노테이션을 붙이면 오류가 나는 상황이다.<br>
    => 테스트 롤백할 수 있는 방법 찾아보기
   </p>
</details>

<details>
    <summary>MongoTemplate updateFirst</summary>
    <p>
   updateFirst 함수에 컬렉션 이름을 바로 넣었을 때는 제대로 수정이 되지 않는다.<br>
   클래스를 넣어주었더니 됐다...<br>
   쿼리 확인할 수 있는 환경 세팅하고 쿼리 확인하기
   </p>
</details>

<details>
    <summary>@Document에 @NotNull</summary>
    <p>
   Document에 직접 제약 조건을 주는 것 외에 다른 방법은 없는가?
   </p>
</details>


