# 《Java 研发自测》源码和勘误说明

下面是各个章节使用的代码和命令说明。

## 第 1 章 研发自测基础

第一章没有相关代码，有两个实用的命令构造测试文件。

```shell
 dd if=/dev/zero of=ouput.txt bs=1M count=10
```
```shell
echo hello > test.txt
truncate -s 1024 test.txt
```
```bash
fsutil file createnew <输出的文件名> <文件大小（字节）>
```

## 第 2 章 代码评审

常用的静态代码分析工具，示例包名和代码路径如下：

- [Checkstyle](https://github.com/linksgo2011/java-self-testing-example/tree/main/checkstyle) 
- [ArchUnit](https://github.com/linksgo2011/java-self-testing-example/tree/main/archunit)
- [FindBugs](https://github.com/linksgo2011/java-self-testing-example/tree/main/findbugs)
- [OWASP Dependency-Check](https://github.com/linksgo2011/java-self-testing-example/tree/main/dependency-check)

选择这几个工具的原因是主流项目基本上都在使用，如果条件允许可以使用 SonarQube + 社区的一些插件。由于示例项目为多模块项目方便演示更多内容，进入模块执行相应命令。

书中示例的几个 FindBugs 是我们团队上最容易出现的几个问题，但是 FindBugs 不同的版本下无法全部找出来（让我也非常迷惑）。

使用 Maven 插件安装 Hooks 的代码片段如下：

```xml
<build>
    <plugins>
        <plugin>
            <groupId>com.rudikershaw.gitbuildhook</groupId>
            <artifactId>git-build-hook-maven-plugin</artifactId>
            <version>3.1.0</version>
            <configuration>
                <gitConfig>
                    <!-- 指定代码库中的 Hook 脚本位置，插件会帮助安装到 gitconfig 中 -->
                    <core.hooksPath>hooks-directory/</core.hooksPath>
                    <custom.configuration>true</custom.configuration>
                </gitConfig>
            </configuration>
            <executions>
                <execution>
                    <goals>
                        <!-- Maven 生命周期配置 -->
                        <goal>install</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

Gradle 安装 Hooks

```
task installGitHooks(type: Copy) {
    from new File(rootProject.rootDir, 'pre-commit')
    into {
        new File(rootProject.rootDir, '.git/hooks')
    }
    fileMode 0755
}
build.dependsOn installGitHooks
```

pre-commit 的一个示例

```shell
#!/bin/sh
# 需要运行的命令
mvn clean install
# 获取上一个命令的执行结果
RESULT=$?
# 使用上一个命令的执行结果来退出，这样做可以选择是否中断构建
exit $RESULT
```

## 第 3 章 单元测试基础

- [单元测试基础](https://github.com/linksgo2011/java-self-testing-example/tree/main/single) 

测试目录下的文件说明：

- HelloWorldTest.java 第一个测试示例
- AssertPractiseTest.java  断言示例
- CurrentSystemTimeMatcher.java 自定义的 Matcher
- CustomMatcherTest.java 自定义的 Matcher 的测试
- PreparationMethodsPractiseTest.java 测试准备示例
- UseCaseDesignPractiseTest.java 单元测试用例设计
- ParameterizedPractiseTest.java 参数化测试用例设计
- ExceptionPractiseTest.java 异常测试
- NameRuleTest.java NameRule 的使用
- GlobalTimeoutPractiseTest.java 计时器的使用
- SuitesPractiseTest.java 嵌套测试
- IPv4ServiceTest.java 补充示例
- StringUtilTest.java 补充示例

手写一个断言库的代码为 JavaScript：

```javascript
function assertEquals(description, expected, actual) {
    if (expected !== actual) {
        throw new Error("ComparisonFailure, Expected:" + expected + ",Actual:" + actual);
    } else {
        console.log(description + " : %c  pass", "color:#0f0;")
    }
}

function should_return_hello_world(){
    assertEquals("test hello world", "Hello", "Hello");
}
```

[Junit 5](https://github.com/linksgo2011/java-self-testing-example/tree/main/junit5)

- HelloWorldTest.java Junit 5 基本示例
- ExceptionPractiseTest.java 更方便的异常处理
- NestedTest.java 嵌套测试示例

## 第 4 章 测试替身

[Mock 和 Spy 的使用](https://github.com/linksgo2011/java-self-testing-example/tree/main/stubs) 

测试目录下的文件说明：

- UserServiceTest.java 包含了普通的 mock 方法使用、BDD 风格演示、Lambda 方式的验证、获取模拟信息
- UserServiceAnnotationTest.java 使用注解的方式注入模拟对象
- ArgumentMatchersExampleTest.java 参数匹配器的各种例子

[PowerMock](https://github.com/linksgo2011/java-self-testing-example/tree/main/powermock)

- UserServiceAnnotationTest.java 模拟静态方法
- ConstructorTest.java 模拟构造方法
- PrivateTest.java 模拟私有方法
- WhiteBoxTest.java 反射工具类

## 第 5 章 Spring 应用的测试

[Spring 应用的测试](https://github.com/linksgo2011/java-self-testing-example/tree/main/spring) 

测试目录下的文件说明：

- service/UserServiceTest.java 只有必要 Bean 的 Spring 测试
- ApplicationTest.java Spring Boot 测试示例
- ApplicationWithJdbcTemplateTest.java 使用 JdbcTemplate 的 Spring Boot 测试示例
- service/UserServiceMockBeanTest.java 使用 Bean 模拟的测试
- ApplicationTestOnlyController.java Spring Boot 切片测试 WebMvcTest 示例
- TestForMapper.java Mybatis Mapper 专用测试
- TestForJson.java JSON 专用测试
- controller/UserControllerTest.java 使用 MockMvc 的 API 测试
- ReflectionTestUtilsTest.java 反射工具箱
- PropertyTest.java Property 注入
- OutputCaptureTest.java 控制台输出的文本捕获
- embedded/SpringBaseTest 内嵌工具 Redis 的配置

## 第 6 章 RESTful API 测试

[RESTful API 测试](https://github.com/linksgo2011/java-self-testing-example/tree/main/api)

测试目录下的文件说明：

- config/MariaDB4jSpringConfiguration.java MariaDB4j的配置文件
- config/ResetDbListener.java 重置和恢复数据库的方法
- config/ResetDbService.java 重置和恢复的服务
- TestBase.java REST Assured 的主要配置方法
- controller/UserControllerTest.java REST Assured 基本使用
- FileTest.java 文件处理的示例

无法在一个项目中实现不同的鉴权例子，只贴了示例代码：

使用 Header

```java
given().header("Authorization", "Basic YWRtaW46MTIzNDU2")
```

使用 auth 方法

```java
given().auth().basic("admin", "123456")
```

使用全局拦截器

```java
RestAssured.authentication = basic("admin", "123456");
```

token 鉴权设置示意：

```java
@Autowired
private AuthorizeService authorizeService;
private String token;

...  

@BeforeEach
public void setup() {  
    // 调用父类的初始化方法  
    super.setup();  
    // 设置一个默认测试用户  
    ...   
    this.token = authorizeService.login(User user);
}

@Test
public void test() {    
    given().contentType("application/json").header("Authorization","Bearer " + token);
    ...
}
```

Cookie 鉴权设置示意：

```java
// 1. 登录并留存 Cookies
Map<String, String> cookies = given()
  .contentType("application/json")
  .body(Maps.of("email", "test@email.com", "password", "123456"))
  .when().post("/authorizes")
  .then().statusCode(201).extract().cookies();

// 2. 使用 cookies 获取用户个人信息
given()
  .contentType("application/json")
  .cookies(cookies)
  .when().post("/authorizes/me")
  .then().statusCode(200);
```

SessionFilter 示意：

```java
SessionFilter sessionFilter = new SessionFilter();
given()
  .contentType("application/json")
  .filter(sessionFilter)
  .body(Maps.of("email", "test@email.com", "password", "123456"))
  .when().post("/authorizes")
  .then().statusCode(201);
```

WireMock 的几个命令:

启动

```shell
java -jar wiremock-jre8-standalone-2.28.0.jar
```

写入数据

```shell
curl -X POST \
--data '{ "request": { "url": "/info.0.json", "method": "GET" }, "response": { "status": 200, "body": "{\"hello\":\"world\"}" }}' \
http://localhost:8080/__admin/mappings/new
```

验证

```shell
curl http://localhost:8080/info.0.json
```

## 第 7 章 性能和并发安全

生成 JMH 工程

```java
mvn archetype:generate \
     -DinteractiveMode=false \
     -DarchetypeGroupId=org.openjdk.jmh \
     -DarchetypeArtifactId=jmh-java-benchmark-archetype \
     -DgroupId=org.sample \
     -DartifactId=test \
     -Dversion=1.0
```

进入 test 目录后执行

```java
mvn clean install
```

运行测试
```shell
java -jar target/benchmarks.jar
```

MyBenchmark 文件

```java
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 3)
@Measurement(iterations = 5, time = 5, timeUnit = TimeUnit.SECONDS)
@Threads(8)
@Fork(1)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class MyBenchmark {
    @Benchmark
    public void test_simple_string() {
        String s = "Hello world!";
        for (int i = 0; i < 10; i++) {
            s += s;
        }
    }
    @Benchmark
    public void test_string_builder() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(i);
        }
    }
}
```

[JMH JUnit 示例](https://github.com/linksgo2011/java-self-testing-example/tree/main/jmh)


[使用 Maven 运行 Jmeter 的示例](https://github.com/linksgo2011/java-self-testing-example/tree/main/jmeter)

使用 Jar 启动 JMeter 

```shell
java -jar bin/ApacheJMeter.jar 
```

测试 API 的命令

```shell
curl http://localhost:8080/api/hello
```

JMeter

```shell
./bin/jmeter.sh -n -t hello.jmx -l output.jtl
```

使用 Maven 执行 JMeter 

```shell
mvn verify 
```

[并发问题的示例代码](https://github.com/linksgo2011/java-self-testing-example/tree/main/concurrence)

源码包目录下关键文件说明

- SynchronizationCount.java 全局变量的原子性问题
- ConcurrencyExample.java 使用 ArrayList 的一个并发问题
- DeadLockExample.java 死锁示例
- MemoryLeakExample.java 内存泄露的例子

测试目录下关键文件说明

- DeadLockTest.java 死锁测试
- RunConcurrentlyTest.java 浸泡测试

## 第 8 章 测试驱动开发

[测试驱动开发示例](https://github.com/linksgo2011/java-self-testing-example/tree/main/tdd)

测试目录文件说明

- AvatarServiceTest.java 组合生成文本和生成图像的组合类
- AvatarTextUtilTest.java 生成文本工具类 
- ImageUtilTest.java 生成图像类

## 第 9 章 测试工程化

下载 Jenkins 文件

```shell
wget http://mirrors.jenkins.io/war-stable/latest/jenkins.war
```

启动

```shell
java -jar jenkins.war --httpPort=8080
```

示例流水线代码

```jenkins
pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                echo 'Hello World'
            }
        }
    }
}

```


[常见流水线配置文件](https://github.com/linksgo2011/java-self-testing-example/tree/main/pipeline)

流水线配置文件说明

- Jenkinsfile.groovy 流水线基本示例
- Jenkinsfile_parallel.groovy 并行流水线
- Jenkinsfile_test_report.groovy 测试报告

[测试报告示例](https://github.com/linksgo2011/java-self-testing-example/tree/main/test-report)

用来创建测试覆盖率的项目在另外一个仓库。

## 第 10 章 测试守护重构

Arthas 的使用

```shell
wget https://arthas.aliyun.com/arthas-boot.jara
```

```shell
java -jar arthas-boot.jar
```

[切面日志示例](https://github.com/linksgo2011/java-self-testing-example/tree/main/loggable)

文件说明

- HelloServiceTest.java 使用打印出来的日志文本进行测试

[契约测试](https://github.com/linksgo2011/java-self-testing-example/tree/main/contract-testing)

[Spring Batch 示例](https://github.com/linksgo2011/java-self-testing-example/tree/main/spring-batch)

测试目录文件说明

- BatchJobTest.java 
- BatchStepTest.java 

[简单的特性开关](https://github.com/linksgo2011/java-self-testing-example/tree/main/feature-toggles) 

源码目录文件说明

- BasicVersion.java 基本版本
- InterfaceVersion.java 接口版本
- ProviderVersion.java ProviderVersion 的版本

[Spring 体系中的特性开关](https://github.com/linksgo2011/java-self-testing-example/tree/main/feature-toggles-spring) 主要使用 Spring 的列表注入多个 Bean 实现以及使用 Togglz 来实现特性开关
