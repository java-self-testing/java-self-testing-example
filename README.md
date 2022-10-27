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

