# Description

A test project to get familiar with:
- Unit testing: JUnit5 + Mockito; how to mock static? How to test DAO with H2 DB?
- Lombok
- Layered Architecture
- Right way to write javadocs
- ...

What to do:
1. Optionally, extend with a business logic by your with
2. Cover all the code by unit tests. Configure Surefire and Jacoco plugins to see the coverage.
3. Example of a well-written unit test: org.example.service.customer.CustomerServiceImplTest
4. For DAO, use H2 in-memory database (If you use Hibernate. Otherwise, configure a separate instance of your DB for testing only)
5. Pay attention on how to mock static and why static is bad.
6. Learn about Lombok and how to use it. Play with its features
7. Learn how to write correct javadocs (look at org.example.service.customer.CustomerServiceImpl for an example)
8. Learn how to write good descriptive log messages (look at org.example.service.customer.CustomerServiceImpl for an example)
9. Potentially, you can use this project to utilize Spring and Hibernate. You can start with utilizing Spring's Dependency Injection