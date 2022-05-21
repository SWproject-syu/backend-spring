# 프로젝트 백엔드 설계

## 개발 언어 및 프로젝트 구성
```
spring boot version : 2.6.7
project language :  java (Jar)
java verison: 11
group id : com.schoolproj2
의존성 라이브러리: Spring Boot DevTools / Spring Web 기반
```
### AWS 열기
```
(우분투일경우 권한 설정)chmod 400 syuproject_key.pem

ssh -i "syuproject_key.pem" ubuntu@ec2-15-165-197-35.ap-northeast-2.compute.amazonaws.com
```
### AWS RDS
```
DB: syuproject
End-Point(host): syuproject.c3vckukxi7cg.ap-northeast-2.rds.amazonaws.com
Port: 3306
Password: syuproject123$
DB System: MySQL
Region: ap-northeast-2c
```

### 실행
- VScode
1. Schoolproj2Application.java 선택 후 F5
2. Schoolproj2Application.java 마우스 우클릭 -> Run Java
3. `./gradlew bootRun` 또는 `yarn start`

### 기본세팅
- 초기개발설정 가이드
  1. [링크](https://tech.devgd.com/9?category=962554)
- REST API 설정 가이드
  1. [링크](https://tech.devgd.com/13?category=962554)
- VSCode Extention
  1. Spring Boot Extension Pack
  2. Extension Pack for Java

### ERD
![image](https://user-images.githubusercontent.com/23623248/164979214-06c04b63-e36b-4958-9be5-749df3fbcb66.png)

### 실행 주의사항
- 실행하려면 본인의 경로로 수정해주세요. package.json

```
git clone "git주소" && cd 프로젝트  && npm run install && npm run build
```
후 src/main/java/com/schoolproj2/schoolproj2/Schoolproj2Application.java 마우스 우클릭 -> Run Java
- 실행 접근 경로는 [8080포트](http://localhost:8080/)입니다.













### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.7/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.7/gradle-plugin/reference/html/#build-image)
* [Spring Web Services](https://docs.spring.io/spring-boot/docs/2.6.7/reference/htmlsingle/#boot-features-webservices)

### Guides
The following guides illustrate how to use some features concretely:

* [Producing a SOAP web service](https://spring.io/guides/gs/producing-web-service/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

