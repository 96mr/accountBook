## 가계부
> Spring Framework 기반으로 진행한 개인 프로젝트입니다.

## 제작 기간
2022년 4월 18일 ~ 5월 26일

## 기술 스택
__Back-end__
![Java 8](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Framework 4](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Oracle](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=Oracle&logoColor=white)
+ Mybatis

## Notion & Blog
[Notion](https://spotty-gardenia-d4a.notion.site/75ec5ce7cea54fe7bb41c80ca8ffb10e?pvs=4)
[Blog](https://cookie9606.tistory.com/53)

## 주요 기능
<details>
  <summary>
    회원 관련 기능
  </summary>
  - 아이디 중복 확인 및 유효성 검사
  - 비밀번호 유효성 검사 및 BCryptPasswordEncoder로 암호화
</details>
<details>
  <summary>
    데이터 추가
  </summary>
  - 현금/카드, 수입/지출, 카테고리, 날짜, 금액 입력
  - 수입/지출 선택에 따라 카테고리 분류
</details>
<details>
  <summary>
    캘린더
  </summary>
  - FullCalender API 이용
  - 잔액, 수입, 지출 금액 조회
  - 해당 달의 (수입 또는 지출) 데이터 조회
</details>
<details>
  <summary>
    차트
  </summary>
    - Google Chart API 이용
    - 잔액, 수입, 지출 금액 조회
    - 해당 달의 (수입 또는 지출) 카테고리 별 비중을 원형차트로 표시
    - 수입 또는 지출 리스트 (날짜, 카테고리, 금액) 조회
</details>
