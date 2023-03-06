# waffle-croffle-backend
와플 첫 번째 조각

## 프로젝트 소개

> 현재 속해있는 대학교 클럽인 GDSC(Google Developer School Clubs)를 들어가고 처음으로 사람들과 협업하며 만든 프로젝트
> 

***카테고리가 있는 할 일 목록 만들기!*** 

### 개발 기간 : 2022-10-06 ~ 2022-12-15

---

## 팀원 소개

총 4인 : Frontend 2명, Backend 2명

### Frontend ( [https://github.com/GDSC-Daejin/waffle-croffle-frontend/tree/new-master](https://github.com/GDSC-Daejin/waffle-croffle-frontend/tree/new-master))

- GDSC 멤버 Lucy, Rulu

### Backend

- GDSC 멤버 Als, Glenn(본인)

### Backend 역할 분담

- Glenn(본인)
    - 프로젝트 세팅 및 환경 설정
    - Github 선생님 ㅎㅅㅎ…
    - 카테고리를 제외한 TodoList API 구현
    - 오류 수정
    - ERD 작성
- Als
    - 카테고리 API 구현
    - Swagger 적용
    - ERD 작성

---

## 개발과정

첫 협업 프로젝트라 PR도 각자하고… 코드 리뷰도 없고 기능별 브랜치도 안지키고 엉망이였지만 **MVP를 3가지** 정해 먼저 구현할 것은 잘 지키며 구현헀다.

매주 1회 스크럼을 가졌다.

![Untitled](https://user-images.githubusercontent.com/86887824/223120888-2eeb37eb-7f0c-49a1-ad33-dc61d2fbf5f4.png)


처음에는 내가 뭘 할 수 있고 이 사람들이랑 어떻게 일을 분담하고…막 정말 정신없었다 그래서 1차 혼돈의 카오스..스크럼이 되었다

![Untitled 1](https://user-images.githubusercontent.com/86887824/223120904-744d8b9a-fed3-4cf5-a034-01894097d2d9.png)

---

그래도 점점 나아지면서 내가 뭘 하면 프론트가 데이터를 가져갈 수 있고 어디까지 해줘야하는지 이런 게 조금씩 보이면서 나아졌다.

---

## 배포 상태

- Heroku로 Backend 배포 했었으나 현재는 닫아놓은 상태

## 기술 스택

- Java
- Spring Boot
- H2 Databases
- MySQL
- Heroku
- JPA
- Restful API
- Swagger

## 개발 환경

- Git
- Github
- Intellij Ultimate

## 커뮤니케이션

- Notion
- Slack

## 버전

- Spring Boot : 2.7.4
- MySQL : 8.0.31
- H2 Databases : 1.4.200
- Java : 11

---

## API

<img width="1441" alt="Untitled 2" src="https://user-images.githubusercontent.com/86887824/223120991-05e64651-7ee1-46f6-97f5-8e8a631146aa.png">

## 스키마

![Untitled 3](https://user-images.githubusercontent.com/86887824/223120963-7fc2740c-963a-4311-a00b-6c1601111b5f.png)

카테고리엔티티 스키마

![Untitled 4](https://user-images.githubusercontent.com/86887824/223120980-47ff4892-e338-4dab-961d-19475afe223a.png)

투두엔터티 스키마
