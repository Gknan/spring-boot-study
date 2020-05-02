官网地址：https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/reference/htmlsingle/



目录：

### 1、Spring Boot 文档

Spring Boot 文档的简要总览，相当于目录

1. 关于文档
   Spring Boot 参数指导有三种版本：

   * 多页 HTML 版
   * 单页 HTML 版
   * PDF 版

   最新的文档参考 https://docs.spring.io/spring-boot/docs/current/reference/

2. 获得帮助
   如果在使用 Spring Boot 过程中遇到问题，可通过下面方式获取帮助：

   * 在本文档第 9 部分找
   * 关于 Spring 的基本知识，或者 Spring Boot 和其他项目的整合，参考 https://spring.io/ 官网
   * 可以去 stackoverflow.com 的 spring-boot 标签下找答案或提问
   * 发现 bug 可以去 [github](https://github.com/spring-projects/spring-boot/issues) 上 PR

3. 开始学习
   如果你刚开始用 Spring Boot 或 Spring，可以从以下方面开始。

   * 简单尝试：[Overview]() [Requirements](https://docs.spring.io/spring-boot/docs/2.3.0.BUILD-SNAPSHOT/reference/htmlsingle/#getting-started-system-requirements) [Installation](https://docs.spring.io/spring-boot/docs/2.3.0.BUILD-SNAPSHOT/reference/htmlsingle/#getting-started-installing-spring-boot)
   * Tutorial：[Part1](https://docs.spring.io/spring-boot/docs/2.3.0.BUILD-SNAPSHOT/reference/htmlsingle/#getting-started-first-application)  [Part2](https://docs.spring.io/spring-boot/docs/2.3.0.BUILD-SNAPSHOT/reference/htmlsingle/#getting-started-first-application-code)
   * 运行案例：[Part1](https://docs.spring.io/spring-boot/docs/2.3.0.BUILD-SNAPSHOT/reference/htmlsingle/#getting-started-first-application-run)  [Part2](https://docs.spring.io/spring-boot/docs/2.3.0.BUILD-SNAPSHOT/reference/htmlsingle/#getting-started-first-application-executable-jar)

4. 使用 Spring Boot 工作
   经过上面的简单案例，接下来正式学习使用 Spring Boot。[建议你学习下面几个部分](https://docs.spring.io/spring-boot/docs/2.3.0.BUILD-SNAPSHOT/reference/htmlsingle/#using-boot)

   * 构建系统：Maven Gradle Ant Starters
   * 最佳实践：Code Structure @Configuration @EnableAutoConfiguration Bean 和依赖注入
   * 运行代码：IDE Packaged Maven Gradle
   * 打包应用：产品 jar 包
   * Spring Boot 命令行工具：Spring Boot CLI

5. 学习 Spring Boot 的特性
   如果需要了解更多的 Spring Boot 核心特性细节，[参考下面基本部分](https://docs.spring.io/spring-boot/docs/2.3.0.BUILD-SNAPSHOT/reference/htmlsingle/#boot-features)：

   * 核心特性：SpringApplication | External Configuration | Profiles | Logging
   * Web 应用：MVC | 嵌入式容器
   * 数据处理：SQL | NO-SQL
   * 消息：概览 | JMS
   * 测试：概览 | Boot 应用 | 工具
   * 扩展：自动配置 | @Condition

6. Spring Boot 产品化
   当你准备将 Spring Boot 应用部署上线，这里有一些你可能㤇到的技巧：

   * Management endpoints: Overview
   * 连接方式：HTTP | JMX
   * 监控：Metrics | 审计 | HTTP 链路追踪 | Process

7. 进阶部分
   这里提供一些进阶内容：

   * Spring Boot 应用部署：云部署 | 操作系统服务
   * 构建工具插件： Maven | Gradle
   * 附录



### 2、入门

回答 是什么？ 怎么用？为什么？的问题；简要介绍  Spring Boot；建立第一个 Spring Boot 项目。

1. 是什么
   Spring Boot 使得创建独立运行的产品级的 Spring 应用更加简单。Spring Boot 坚持约定终于配置的观点去整合 Spring 平台和第三方库，带来等的结果是你可以更方便的使用 Spring。大多数 Spring Boot 应用只需要极少的配置即可。

   你可以使用 Spring Boot 创建使用 `java -jar` 启动的或是 war 包部署的 Java 应用，同时我们也提供运行 “spring 脚本” 的命令行工具。
   我们的主要目标是：

   * 为所有的 Spring 应用部署提供一种本质上快速的无障碍的着手经验
   * 支持开箱即用，有支持差异化定制
   * 提供大量的通用的非函数式功能，如嵌入式服务器、安全、指标、健康检查、外部化配置。
   * 零 XML

2. 系统要求
   Spring Boot 2.3.0.BUILD-SNAPSHOT 需要 Java 8 及以上版本（最高支持 Java 14），Spring Frameword 5.2.6.RELEASE 或以后的版本。
   构建工具的版本要求：

   Maven 3.3+
   Gradle 6.3 or later

   1. Servlet 容器
      Spring Boot 支持下面内嵌的 Servlet 容器

      | Name         | Servlet Version |
      | ------------ | --------------- |
      | Tomcat 9.0   | 4.0             |
      | Jetty 9.4    | 3.1             |
      | Undertow 2.0 | 4.0             |

      可以部署 Spring Boot 应用到任何 3.1+ 的兼容的 Servlet 容器

3. 导入 Spring Boot
   Spring Boot 可以与经典的 Java 部署工具一起使用或者以命令行的方式导入。对 JDK 的版本要求是 8 或以上。使用下面命令查看 Java 版本：

   `java -version`
   或者可以使用 Spring Boot CLI 方式。

   1. Java 开发者的引入指导
      你可以和引入标准 Java 库一样的方式引入 Spring Boot。把 `spring-boot-*.jar` 文件加到 classpath 下。Spring Boot 不需要任何特殊的工具整合，所以你可以在任何 IDE 或者 文本编辑器使用。同时，你可以像 debug 其他的 Java 程序一样 debug Spring Boot 程序。
      尽管你可以拷贝 Spring Boot 的 jar 包，我们推荐你使用支持依赖管理的构建工具（如 Maven 或者 Gradle）


      **Maven 引入**

      Spring Boot 兼容 Apache Maven 3.3+。如果你没有导入 Maven，可以按照下面的方式导入 [maven.apache.org](https://maven.apache.org/)。
      Spring Boot 依赖使用 `org.springframework.boot ` `groupId`。注意，你的 Maven POM 文件继承自 `spring-boot-start-parent` 项目，并且声明依赖为 一个或多个 starters。Spring Boot 同时也支持可选的 Maven 插件生成可执行 jar 包。
      关于使用 Spring Boot 和 Maven 的更多细节可以在 Maven 插件的引用指导部分查看。

      

      **Gradle 引入**
      略

   2. 导入 Spring Boot CLI
      Spring Boot CLI(Command Line Interface) 是命令行工具，可以用来快速搭建 Spring 应用。可以使用 Groovy 脚本。
      不需要使用 CLI 开发 Spring Boot 应用，但是这是 Spring 应用落地的最快方法。

      **手动导入**
      你可以下载 Spring CLI 发行版从下面的 Spring 软件仓库：

      * [spring-boot-cli-2.3.0.BUILD-SNAPSHOT-bin.zip](https://repo.spring.i* o/snapshot/org/springframework/boot/spring-boot-cli/2.3.0.BUILD-SNAPSHOT/spring-boot-cli-2.3.0.BUILD-SNAPSHOT-bin.zip)

      * [spring-boot-cli-2.3.0.BUILD-SNAPSHOT-bin.tar.gz](https://repo.spring.io/snapshot/org/springframework/boot/spring-boot-cli/2.3.0.BUILD-SNAPSHOT/spring-boot-cli-2.3.0.BUILD-SNAPSHOT-bin.tar.gz)

      。。。

   3. 从 Spring Boot 的早期版本升级

4. 开发第一个 Spring Boot 应用
   这个部分描述了如何开发一个简单的 “Hello World!” web 应用。这个应用展示了 Spring Boot 的一些核心特性。我们使用 Maven 构建项目。

   1. 创建 POM
      Maven 的 pom.xm 文件内容如下：

      ```xml
      <?xml version="1.0" encoding="UTF-8"?>
      <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
          <modelVersion>4.0.0</modelVersion>
      
          <groupId>com.example</groupId>
          <artifactId>myproject</artifactId>
          <version>0.0.1-SNAPSHOT</version>
      
          <parent>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-starter-parent</artifactId>
              <version>2.3.0.BUILD-SNAPSHOT</version>
          </parent>
      
          <description/>
          <developers>
              <developer/>
          </developers>
          <licenses>
              <license/>
          </licenses>
          <scm>
              <url/>
          </scm>
          <url/>
      
          <!-- Additional lines to be added here... -->
      
          <!-- (you don't need this if you are using a .RELEASE version) -->
          <repositories>
              <repository>
                  <id>spring-snapshots</id>
                  <url>https://repo.spring.io/snapshot</url>
                  <snapshots><enabled>true</enabled></snapshots>
              </repository>
              <repository>
                  <id>spring-milestones</id>
                  <url>https://repo.spring.io/milestone</url>
              </repository>
          </repositories>
          <pluginRepositories>
              <pluginRepository>
                  <id>spring-snapshots</id>
                  <url>https://repo.spring.io/snapshot</url>
              </pluginRepository>
              <pluginRepository>
                  <id>spring-milestones</id>
                  <url>https://repo.spring.io/milestone</url>
              </pluginRepository>
          </pluginRepositories>
      </project>
      ```

      前面列出的项能够帮你定义 Maven 构建的配置。可以使用 `mvn package` 来测试 Maven 是否工作。

   2. 向 classpath 添加依赖
      Spring Boot 提供很多 starters，这些 starters 可以让你添加 jars 到 classpath 路径。我们的应用使用了 `spring-boot-starter-parent` 在 POM 的 父部分。`spring-boot-starter-parent` 是一个特殊的 starter，它提供了有用的 Maven 默认配置。同时他也提供了 `dependency-management` 标签使得你可以在子依赖中忽略 `version` 标签。
      其他的 starters 在开发特定应用是提供对应的依赖。由于我们开发的是一个 web 应用，所以需要 `spring-boot-starter-web` 依赖。可以通过下面的命令查看目前拥有的依赖。
      `mvn dependency:tree`

      上面的命令以树形打印项目依赖关系。结果显示 `spring-boot-starter-parent` 没有提供任何依赖。为了添加必要的依赖，向 pom.xml 文件中添加 `spring-boot-starter-web` 依赖

      ```xml
      <dependencies>
          <dependency>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-starter-web</artifactId>
              <version>2.1.11.RELEASE</version>
          </dependency>
      </dependencies>
      ```

      这时，运行 `mvn dependency:tree` ，可以看到很多额外的依赖，包括 Tomcat web 服务器和 Spring Boot 本身。

   3. 写代码

      创建 java 文件，默认情况下，Maven 编译的源文件来自于 src/main/java 包，所以，你需要创建这个层级目录，然后在该目录下创建 src/mian/java/Example.java 文件，java 文件的代码如下：

      ```java
      import org.springframework.boot.*;
      import org.springframework.boot.autoconfigure.*;
      import org.springframework.web.bind.annotation.*;
      
      @RestController
      @EnableAutoConfiguration
      public class Example {
      
          @RequestMapping("/")
          String home() {
              return "Hello World!";
          }
      
          public static void main(String[] args) {
              SpringApplication.run(Example.class, args);
          }
      
      }
      ```

      下面是重要的部分。
      

      **@RestController 和@RequestMapping 注解**

      Example 类上的`@RestController` 注解，这是一个 构造性注解(*stereotype*  刻板，铅刻)，这个注解表明了该类的作用。在这个案例中，我们的类是一个 web `@Controller`，所以 Spring 在处理 web 请求时使用这个类。
      `@RequestMapping` 注解提供了 路由 信息。它告诉 Spring 任何以 / 开头的路径的 HTTP 请求都应该映射到 `home` 方法上。`@RestController` 注解告诉 Spring 直接将结果字符串返回给请求者。


      **@EnableAutoConfiguration 注解**
      `@EnableAutoConfiguration` 注解告诉 Spring Boot 去猜你想怎么配置 Spring，依据你所添加的 jar 包依赖。由于 `spring-boot-stater-web` 添加了 Tomcat 和 Spring MVC，自动注解认为你正在开发一个 web 应用并 对 spring 做相应的 web 设置。

      **Staters 和 自动配置**
      自动配置可以和 staters 一起很好的工作，但是两个概念没有联系。你可以选择 starters 之前的 jar 包，Spring Boot 仍然可以对你的项目。

      **主方法**
      最后讨论的是 `main` 方法，这仅仅是一个Java 应用程序的入口点约定。我们的主方法中通过调用 `SpringApplication` 的 `run` 方法运行。`SpringApplication` 引导我们的应用开启 Spring，Spring 开启自动配置的 Tomcat 服务器。我们需要给 `run` 方法传递 `Example.class` 作为参数告诉 `SpringApplication` `Example` 类是主要的 Spring 组件。`args` 数组参数传递给 `run` 用于将命令行的参数传入到 `run` 中。

   4. 运行案例
      此时，你的应用应该可以工作了。由于使用了 `spring-boot-stater-parent` POM，你可以使用 `run` 开启应用。在项目的根目录开启终端执行 `mvn spring-boot:run` 去开启应用。（IDEA 中可以直接运行 main 所在的类）
      浏览器中输入  localhost:8080 ，回车可以看到结果：

      ```java
      Hello World!
      ```

      按 `ctrl + c` 可以停止应用。

   5. 创建可执行 jar 包
      我们通过创建一个可运行在生产环境的可执行 jar 包文件来完成我们的案例。可执行 jar 包（有时叫做 fat jars） 是一个编译好的类的合集，这些类包含了你的代码运行需要的素有的 jar 依赖。
      **可执行 jar 包和 Java**
      由于 java 没有提供载入嵌套的 jar 文件的方式。在你希望发布一个自容器的应用时将变得很困难。
      为了解决这个问题，很多开发者使用 uber jar 包。一个 uber jar 将程序的所用的依赖的类打包到一个文档中。这就使得查看到底哪个库时属于你的应用的哪个是属于你的应用依赖的变得很困难。同时，多个 jar 文件下同名不同内容的文件也会引发问题。
      Spring Boot 采取了不同于上面两种的方法，让你可以直接打包jar。

      在创建可执行 jar 之前，我们需要添加 `spring-boot-maven-plugin` 到我们的 `pom.xml` 中。在 `dependenies` 标签下插入下面的内容：

      ```xml
      <build>
          <plugins>
              <plugin>
                  <groupId>org.springframework.boot</groupId>
                  <artifactId>spring-boot-maven-plugin</artifactId>
              </plugin>
          </plugins>
      </build>
      ```

      `spring-boot-stater-parent` POM 包含 `<execution>` 配置。使用它绑定重新打包。如果不使用 parent POM，你需要声明这个配置。详见 [plugin ducumentation](https://docs.spring.io/spring-boot/docs/2.3.0.BUILD-SNAPSHOT/maven-plugin/reference/html/#getting-started)

      命令行执行 `mvn package` 

      ```java
      G:\learn-skills\springbootstudy\myproject>mvn package
      [INFO] Scanning for projects...
      [WARNING]
      [WARNING] Some problems were encountered while building the effective model for spring-boot-study:myproject:jar:1.0-SNAPSHOT
      [WARNING] 'build.plugins.plugin.version' for org.springframework.boot:spring-boot-maven-plugin is missing. @ spring-boot-study:myproject
      :[unknown-version], G:\learn-skills\springbootstudy\myproject\pom.xml, line 26, column 21
      [WARNING]
      [WARNING] It is highly recommended to fix these problems because they threaten the stability of your build.
      [WARNING]
      [WARNING] For this reason, future Maven versions might no longer support building such malformed projects.
      [WARNING]
      [INFO]
      [INFO] ------------------------------------------------------------------------
      [INFO] Building myproject 1.0-SNAPSHOT
      [INFO] ------------------------------------------------------------------------
      [INFO]
      [INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ myproject ---
      [WARNING] Using platform encoding (GBK actually) to copy filtered resources, i.e. build is platform dependent!
      [INFO] Copying 0 resource
      [INFO]
      [INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ myproject ---
      [INFO] Changes detected - recompiling the module!
      [WARNING] File encoding has not been set, using platform encoding GBK, i.e. build is platform dependent!
      [INFO] Compiling 1 source file to G:\learn-skills\springbootstudy\myproject\target\classes
      [INFO]
      [INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ myproject ---
      [WARNING] Using platform encoding (GBK actually) to copy filtered resources, i.e. build is platform dependent!
      [INFO] skip non existing resourceDirectory G:\learn-skills\springbootstudy\myproject\src\test\resources
      [INFO]
      [INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ myproject ---
      [INFO] Nothing to compile - all classes are up to date
      [INFO]
      [INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ myproject ---
      [INFO] No tests to run.
      [INFO]
      [INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ myproject ---
      [INFO] Building jar: G:\learn-skills\springbootstudy\myproject\target\myproject-1.0-SNAPSHOT.jar
      [INFO] ------------------------------------------------------------------------
      [INFO] BUILD SUCCESS
      [INFO] ------------------------------------------------------------------------
      [INFO] Total time: 4.525 s
      [INFO] Finished at: 2020-04-30T21:59:31+08:00
      [INFO] Final Memory: 23M/176M
      [INFO] ------------------------------------------------------------------------
      
      ```

      如果你查看 `target` 目录，你能看到 `myproject-1.0-SNAPSHOT.jar`。使用 `jar tvf target/myproject-1.0-SNAPSHOT.jar` 解压。你可以看到 `myproject-1.0-SNAPSHOT.jar.original` 在 target 目录中。这是 在 Spring Boot 再打包之前的 Maven 创建的 原始jar 文件。
      使用 `jar -jar` 命令，就可以运行应用程序。
      使用 `ctrl + c` 可以结束应用。

5. 后续
   这部分介绍了 Spring Boot 的一些基本姿势并写了一个自己的应用。如果你是任务导向型开发者，你或许调到 spring.io 网站上查看一些这部分涉及到的关于如何使用 Spring 的内容。关于 SpringBoot 的疑问可以查看本文档的第 9 个部分。
   另外，下一步是 使用 Spring Boot。如果你已经很熟悉这部分，可以直接阅读 第 4 部分。



### 3、使用 Spring Boot

更加详细介绍 Spring Boot 的使用。包含构建应用、自动配置和应用运行原理的介绍。
提供一些 Spring Boot 的最佳实践。虽然 Spring Boot 只是一个 Java 库，遵循一些建议将让你更容易的开发程序。

1. 构建系统
   建议你采用支持依赖管理和能够识别 Maven 中央仓库坐标的构建系统。Maven 和 Gradle 都是不错的选择。其他的构建系统如 Ant，可以用来构建，但是支持的不是很好。

   1. 依赖管理
      每一个 Spring Boot 发行版都提供了其支持的依赖清单。实际上，你不需要为所有的依赖提供版本红啊，因为 Spring Boot 可以帮你找到合适的版本。当你升级 Spring Boot 后，对应的依赖也会升级到对应的版本。
      当然，你可以指定版本去覆盖 Spring Boot 建议的版本。
      Spring Boot 给的依赖清单包含了所有 Spring Boot 自身和和第三方库的模块，这个清单是可以和 Maven Gradle 一起使用的标准清单（`spring-boot-dependencied`）
      每个 Spring Boot 的发行版都对应着一个 Spring Framework 的基本版本，所以强烈建议不要自定义 Spring 的版本。

   2. Maven
      学习通过 Maven 使用 Spring Boot，请移步 Spring Boot Maven 插件的文档部分。

      * Reference ([HTML](https://docs.spring.io/spring-boot/docs/2.3.0.BUILD-SNAPSHOT/maven-plugin/reference/html/) and [PDF](https://docs.spring.io/spring-boot/docs/2.3.0.BUILD-SNAPSHOT/maven-plugin/reference/pdf/spring-boot-maven-plugin-reference.pdf))
      * [API](https://docs.spring.io/spring-boot/docs/2.3.0.BUILD-SNAPSHOT/maven-plugin/api/)

   3. Gradle
      同..

   4. Ant
      ..

   5. Starters
      Starters 是可以引入到你的应用中的一个方便的依赖描述符集合。有了它，你能够一站式获取所有你需要的 Spring  和 相关的技术，从而不需要一个一个找实例代码并复制粘贴对应的依赖描述符。比如，如果你向使用 Spring 和 JPA 作为数据库连接，只需要你你的项目中引入 `spring-boot-starter-data-jpa` 依赖。
      starters 中包含了大量的依赖，包含构建项目、快速运行项目，这些依赖具备一致性并支持托管传递。
      **命名**
      官方的 starters 遵循 `spring-boot-starter-*` 的命名规范，其中，`*` 是具体的应用类型。这样的命名规范在找 starter 时很有用。大多数的 IDE 中的  Maven 支持根据名字查找依赖。比如，在 Eclipse 中使用了 STS 插件，你就可以在 POM 编辑器中通过 `ctrl+space` 并输入 “spring-boot-starter” 查找已经下载过的清单。
      在 “自定义自己的 Starter” 部分我们说道，第三方 starters 不应用以 `spring-boot` 开头，因为这是官方预留的描述符。第三方 starter 可以使用项目名命名。如，项目名为 `thirdpartyproject` ， 则对应的 stater 可以命名为 `thirdpartyproject-spring-bot-starter`。

      下面是一些 Spring Boot 的 `org.springframework.boot` 组下提供的 starters。

      **Table1 Spring Boot 应用级 staters**

      | 名字                                        | 描述                                                         |
      | ------------------------------------------- | ------------------------------------------------------------ |
      | spring-boot-starter                         | 核心 starter，包含了自动配置支持，日志，YAML                 |
      | spring-boot-starter-activemq                | ActiveMQ 的 JMS 消息                                         |
      | spring-boot-starter-amqp                    | 使用 Spring AMQP 和 Rabbit MQ                                |
      | spring-boot-starter-aop                     | 使用 Spring AOP 和 AspectJ 的面向切面编程支持                |
      | spring-boot-starter-artemis                 | Artemis 的 JMS 消息                                          |
      | spring-boot-starter-batch                   | Spring Batch 的 starter                                      |
      | spring-boot-starter-cache                   | 支持 Spring Framework 的缓存支持                             |
      | spring-boot-starter-data-cassandra          | Spring Data Cassandra 和 Cassandra 分布式数据库支持          |
      | spring-boot-starter-data-cassandra-reactive | Spring Data Cassandra Reactive 和 Cassandra 分布式数据库支持 |
      | spring-boot-starter-data-elasticsearch      | Spring Date Elasticsearch                                    |
      | spring-boot-starter-data-jdbc               | 使用 Spring Data JDBC 支持                                   |
      | spring-boot-starter-data-jpa                | 使用 Spring Data JPA 的支持，底层使用 Hibernate              |
      | spring-boot-starter-data-neo4j              | Neo4j 图数据库支持                                           |
      | spring-boot-starter-data-redis              | 使用 Spring Data Redis 和 Lettuce 客户端的 Redis 支持        |
      | spring-boot-starter-data-redis-reactive     | 使用 Spring Data Redis reactive 和 Lettuce 客户端的 Redis 支持 |
      | spring-boot-starter-data-rest               | 使用 Spring Data REST 暴露 Spring Data 仓库                  |
      | spring-boot-starter-data-solr               | Spring Data solr 至此 Solr 搜索平台                          |
      | spring-boot-starter-jdbc                    | 使用 HikariCP 连接池的 JDBC                                  |
      | spring-boot-starter-json                    | 读和写 json 支持                                             |
      | spring-boot-starter-mail                    | Java Mail 和 Spring Framework 的发送邮件支持                 |
      | spring-boot-starter-oauth2-client           | Spring Security 的 OAuth2/OpenID 连接支持                    |
      | spring-boot-starter-test                    | 测试 Spring Boot 应用，包含了 JUnit，Hamcrest 和 Mockito 等库 |
      | spring-boot-starter-thymeleaf               | 使用 Thymeleaf 视图构建 MVC web 应用支持                     |
      | spring-boot-starter-validation              | 基于 Hibernate 校验器的 Java Bean 校验                       |
      | spring-boot-starter-web                     | 构建 web 应用，支持 Spring MVC，包括 RESTful，使用 Tomcat 作为默认内嵌容器 |

      **Table2 Spring Boot 产品级 sta若已经ters**

      | 名称                         | 描述                                                         |
      | ---------------------------- | ------------------------------------------------------------ |
      | spring-boot-starter-actuator | Spring Boot 的 Actuator 支持，提供了产品级的特性帮助你监控和管理程序 |

      **Table3 Spring Boot 其他技术 starters**

      | 名称                              | 描述                                                         |
      | --------------------------------- | ------------------------------------------------------------ |
      | spring-boot-starter-jetty         | 使用 Jetty 作为内置 servlet 容器支持，可用来替换 `spring-boot-starter-tomcat` |
      | spring-boot-starter-log4j2        | Log4j2 作为日志工具。可替换 `spring-boot-strater-logging`    |
      | spring-boot-starter-logging       | 默认的日志 stater，使用 Logback 作为日志工具                 |
      | spring-boot-starter-reactor-netty | 使用 响应式 Netty 作为内置的响应式服务器                     |
      | spring-boot-starter-tomcat        | 使用 Tomcat 作为内置 web 容器，默认在 `spring-boot-starter-web` 中包含 |

      对于社区贡献的 staters，详见 GitHub 上 `spring-boot-starters` 部分的 README。

2. 结构化代码
   Spring  Boot 不强制要求特殊的代码层级结构。但是，还是有些最佳实践可供选择。

   1. 使用默认的 package
      当一个类不在任何 `package` 下是，该类被认为在默认的包下。默认包的方式不推荐并且最好避免使用。因为可能会导致你的 Spring Boto 应用在使用 `@ComponentScan` `@ConfigurationPropertiesScan` `@EntityScan` `@SpringBootApplication` 注解是出现问题，因为每个 jar 中的类都需要被扫描并读取。
      建议使用 Java 推荐的包命名规范，使用一个逆序的域名作为包名（如 `com.example.project`）。

   2. 定位 主应用类

      我们建议你把主应用类放在包的根下（也就是在所有其他类的上一层）。`@SpringBootApplication` 注解通过写在 主类上，该注解声明了一个搜索包用来找一些需要的项。比如，如果你在写一个 JPA 应用，`@SpringBootApplicaiont` 注解所在的类的包就是查找 `@Entity` 项的搜索位置。使用根包同样也支持组件扫描。
      如果你不适用 `@SpringBootApplication`，你可以可以使用 `@EnableAutoConfiguration` 和 `@ComponentScan` 注解来代替，本质上 `@SpringBootApplication` 包含了其他两个。

      下面是一个典型的代码层级结构

      ```
      com
       +- example
           +- myapplication
               +- Application.java
               |
               +- customer
               |   +- Customer.java
               |   +- CustomerController.java
               |   +- CustomerService.java
               |   +- CustomerRepository.java
               |
               +- order
                   +- Order.java
                   +- OrderController.java
                   +- OrderService.java
                   +- OrderRepository.java
      ```

      其中 ，`Application.java` 文件声明了 `main` 方法，并且使用 `@SpringBootApplication ` 标注，如下：

      ```java
      package com.example.myapplication;
      
      import org.springframework.boot.SpringApplication;
      import org.springframework.boot.autoconfigure.SpringBootApplication;
      
      @SpringBootApplication
      public class Application {
      
          public static void main(String[] args) {
              SpringApplication.run(Application.class, args);
          }
      
      }
      ```

   3. 配置类
      Spring Boot 倾向支持 基于 Java 的配置。虽然可以采取 XML 方式配置 `SpringApplication`，我们还是建议采用 `@Configuration` 配置类的方式。通常情况下，`main` 方法所在的类适合作为主 `@Configuration`。

      网络上有很多使用 XML配置的 Spring 配置案例。但是，最好还是使用 基于 Java 的配置。可通过查找 `Enable*` 相关的注解了解 Java 配置的内容。

      1. 引入额外的配置类
         你并不需要把所有的 `@Configuration` 放到一个类中。可以通过 `@Import` 注解引入其他的配置类。或者，你可以使用 `@ComponentScan` 注解自动选择所有的 Spring 组件，包括 `@Configuration` 类。
      2. 引入 XML 配置
         如果你必须使用基于 XML 的配置，我们建议你创建一个 `@Configuration` 类，使用 `@ImportResource ` 注解加载 XML 配置文件。

   4. 自动配置
      Spring Boot 的自动配置会根据你导入的 jar 依赖尝试去自动配置你的 Spring 应用。比如，如果 `HSQLDB` 在你的 classpath 下，你不需要手动配置任何的数据库连接 bean，Spring Boot 会自动配置一个驻在内存的数据库。
      你需要通过添加 `@EnableAutoConfiguration` 或者 `@SpringBootApplication` 注解到 一个你的 `@Configuration` 类上来开启 自动配置的支持。
      你应该只添加一个 `@SpringBootApplication` 或者 `EnableAutoConfiguration` 注解，建议将该注解添加在主配置类中。

      1. 渐渐替代 自动配置
         自动配置是非入侵式的。任何时刻，你都可以自定义配置类去替换自动配置中的部分内容。比如，如果你添加了自己的 `DataSouce` bean，默认的内置数据库将退出。
         如果你需要知道那些部分是自动配置的，为什么会自动配置，可以使用 debug （`--debug`）的方式运行程序。这样做可以启用调试日志，以选择核心记录器，并将条件报告记录到控制台。

      2. 取消特定的自动配置类
         如果你发现你不想要的自动配置类生效，你可使用 `@SpringBootApplicaion` 的 `exclude` 属性取消它，如下的案例：

         ```java
         import org.springframework.boot.autoconfigure.*;
         import org.springframework.boot.autoconfigure.jdbc.*;
         
         @SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
         public class MyApplication {
         }
         ```

         如果这个类不在 classpath 下，你可以使用注解的 `excludeName` 属性来指定全路径类名。如果你使用的是 `EnableAutoConfiguration` ，`exclude` 和 `excludeName` 均有效。最后，你也可以使用 `spring.autoconfigure.exclude` 属性控制排除的自动配置类列表。
         在注解上或者使用属性的方式均可以定义排除列表。
         尽管自动配置列是 `public` 修饰，该类提供 public 的 API，我们还是可以通过类型取消该类的自动配置。这些类的内容，如内置配置类或者 bean 方法仅供内部使用，不建议外部直接使用。

   5. Spring Beans 和 依赖注入
      你可以使用任何标准的 Spring Framework 技术定义你的 beans 和他们的依赖注入。比如，我们通常发现使用 `@ComponentScan`(找你的 beans) 和使用 `@Autowired` （构造函数注入） 方式很有效。
      如果你的代码层级结构是按照上面的建议方式构成（主类在package 包的根下），你可以添加 `@ComponentScan` 注解到主类。那么，你的应用中的所有组件 （`@Component` `@Service` `@Repository` `@Controller` 等等）将自动注册为 Spring Beans。

      下面的例子展示了一个使用 构建函数注入一个需要的 `RistAssessor` Bean 的 `@Service`  Bean。

      ```java
      package com.example.service;
      
      import org.springframework.beans.factory.annotation.Autowired;
      import org.springframework.stereotype.Service;
      
      @Service
      public class DatabaseAccountService implements AccountService {
      
          private final RiskAssessor riskAssessor;
      
          @Autowired
          public DatabaseAccountService(RiskAssessor riskAssessor) {
              this.riskAssessor = riskAssessor;
          }
      
          // ...
      
      }
      ```

      如果一个 bean 有 一个构造器，你可以忽略 `@Autowired` 注解，如下面的案例。

      ```java
      @Service
      public class DatabaseAccountService implements AccountService {
      
          private final RiskAssessor riskAssessor;
      
          public DatabaseAccountService(RiskAssessor riskAssessor) {
              this.riskAssessor = riskAssessor;
          }
      
          // ...
      
      }
      ```

      注意，使用构造器注入的方式使得 `riskAssessor` 属性标记为 `final` ，表明该属性在之后的使用过程中不可修改。

   6. 使用 `@SpringBootApplication` 注解
      很多 Spring Boot 开发者希望他们的应用能够使用自动配置，注解扫描，并且支持自定义配置类。`@SpringBootApplication` 注解可用来完成以上三个功能，分别是：

      * `@EnableAutoConfiguration` ：支持 Spring Boot 自动配置机制
      * `@ComponentScan`：支持扫描该注解所在的类所在的包下的类扫描
      * `@Configuration`：允许在上下文注册额外的 beans 或者导入其他的配置类。

      ```java
      package com.example.myapplication;
      
      import org.springframework.boot.SpringApplication;
      import org.springframework.boot.autoconfigure.SpringBootApplication;
      
      @SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
      public class Application {
      
          public static void main(String[] args) {
              SpringApplication.run(Application.class, args);
          }
      
      }
      ```

      `@SpringBootAplication`注解源码

      ```java
      @SpringBootConfiguration
      @EnableAutoConfiguration
      @ComponentScan(
          excludeFilters = {@Filter(
          type = FilterType.CUSTOM,
          classes = {TypeExcludeFilter.class}
      ), @Filter(
          type = FilterType.CUSTOM,
          classes = {AutoConfigurationExcludeFilter.class}
      )}
      )
      public @interface SpringBootApplication {
      ...
      }
      ```

      `@SpringBootApplication` 也提供别名去自定义 `@EnableAutoConfiguraion` 和 `@ComponentScan` 的属性
      上面的这些特征都不是强制性的，你依旧可以使用 Spring Boot 支持的其他特性替换这些注解。比如，如果你不想使用 `@ComponentScan` 或者 注解的属性扫描是，你可以这样做：

      ```java
      package com.example.myapplication;
      
      import org.springframework.boot.SpringApplication;
      import org.springframework.context.annotation.ComponentScan
      import org.springframework.context.annotation.Configuration;
      import org.springframework.context.annotation.Import;
      
      @Configuration(proxyBeanMethods = false)
      @EnableAutoConfiguration
      @Import({ MyConfig.class, MyAnotherConfig.class })
      public class Application {
      
          public static void main(String[] args) {
                  SpringApplication.run(Application.class, args);
          }
      
      }
      ```

      在上面的这个例子中，`Application` 同其他 Spring Boot 应用一样，唯一不同的是不包括 `@Component-` 注解类和 `@ConfigurationProperties-` 注解类，并且通过 `@Import` 注解引入了用户自定义的 beans。

   7. 运行程序
      把程序打包成 jar 和 使用内嵌 HTTP 服务器的最大好处是你可以运行你的程序。调试 Spring Boot 程序也很简单。你甚至不需要任何特殊的 IDE 插件。
      本节内容仅仅涵盖基于 jar 的打包。如果你打包为 war 的形式，你应该参数服务器或者 IDE 的文档。

      1. 在 IDE 上运行
         你可以以一个简单的 Java 应用的的方式在你的 IDE 上运行 Spring Boot 应用。首先，你需要导入你的项目，导入项目的步骤依赖于 I具体的 IDE 和 构建系统。大多数 IDEs 可以直接导入 Maven 项目。

      2. 以打包的应用运行
         如果你使用 Spring Boot Maven 或者 Gradle 创建一个可执行 jar，你可以使用 `java -jar` 的方式运行可执行程序， 如下的方式：

         ```
         $ java -jar target\myproject-1.0-SNAPSHOT.jar
         ```

         也支持远程调试的方式启动打包好的应用。

         ```java
         java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000
         ,suspend=n -jar target\myproject-1.0-SNAPSHOT.jar
         ```

      3. 使用  Maven 插件
         Spring Boot Maven 插件的 `run` 命令可以用来快速编译和运行你的应用。就像在 IDE 中运行一样的效果。如下案例展示 Maven 运行 Spring Boot 应用：

         ```
         mvn spring-boot:run
         ```

         你可以使用 `MAVEN_OPTS` 操作系统环境变量(Linux环境下适用)，如下：

         ```
         export MAVEN_OPTS=Xmx1024m
         ```

      4. 使用 Gradle 插件

         ...

      5. 热部署
         由于 Spring Boot 应用是普通的 Java 应用，JVM 热部署是可以使用的。JVM 热部署一种受限的字节码替换技术，可以使用 JRebel 来提供完成的解决方案。
         `spring-boot-devtools` 模块也提供程序快速重启的支持。

   8. 开发者工具
      Spring Boot 包含了大量的工具，这些工具将满足大多数开发者的需要。`spring-boot-devtools` 模块可以应用于任何项目中，提供热启动的功能。可通过在依赖中引入依赖使用该工具：
      Maven

      ```xml
      <dependencies>
          <dependency>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-devtools</artifactId>
              <optional>true</optional>
          </dependency>
      </dependencies>
      ```

      Gradle

      ```groovy
      dependencies {
          developmentOnly("org.springframework.boot:spring-boot-devtools")
      }
      ```

      开发者工具在运行一个大包号的程序时，将自动失效。如果你的应用以 `java -jar` 启动或者别一个特定的类加载器加载启动，那么该应用被认为是一个产品级应用。如果是其他方式启动（如通过容器方式启动），容器应该去掉 devtools 或者 设置 `-DSpring.devtools.restart.enabled=false` 系统属性。
      在 Maven 使用 `optional` 标记依赖，在 Gredle 中使用 `developmentOnly` 配置，能够避免 devtools 在项目中的其他模快被传递使用。
      默认情况下，重打包是不会包含 devtools，如果你往使用某个远程 devtools 特性，你需要手动加入。使用 Maven 插件打包是，设置 `excludeDevtools` 属性为 `false`。使用 Gradle 打包。。。

      1. 默认属性
         Spring Boot 支持的几个库都是使用缓存来提高性能的。比如，模板引擎缓存了编译好的模板，以避免重复的解析模板文件。同时，Spring MVC 在处理静态资源时会添加 HTTP 缓存头到响应中。
         虽然缓存再生产环境下很有用，但在开发过程中可能会适得其反，因为他可能使你看不到你刚才做的修改。因此，`spring-boot-devtools` 默认取消了缓存支持。
         缓存选项通常在配置文件 `application.properties` 中配置。比如，Thymeleaf 提供了 `sring.thymeleaf.cache` 属性。与其手动配置缓存相关属性，不如使用 `spring-boot-devtools` 模块自动配置适合开发环境的缓存配置。
         在开发 Spring MVC 和 Spring WebFlux 应用时，你需要更多的关于 web 请求的信息，开发者工具能够为 web 日志组设置 `DEBUD` 日志级别。这样将提供更详细的请求信息，包括哪个处理器处理该请求，相应信息等内容。如果你希望日志记录所有请求的细节，你可以开启 `spring.mvc.log-request-details` 或者 `spring-codec.log-request-details` 配置属性。 
         如果不希望使用 devtools 提供的默认配置，可以在 `application.properties` 文件中配置  `spring.devtools.add-properties`  `false`。
         devtools 提供的属性列表，查看 [DevToolsPropertyDefaultsPostProcessor](https://github.com/spring-projects/spring-boot/tree/master/spring-boot-project/spring-boot-devtools/src/main/java/org/springframework/boot/devtools/env/DevToolsPropertyDefaultsPostProcessor.java).

      2. 自动重启
         添加了 `spring-boot-devtools` 模块的应用当 classpath 下的文件发生变化时会自动重启。这在使用 IDE开发时很有用，能够很快的看到修改带来的变化。默认情况下，类路径下的文件夹下的文件都被监控着变化。注意某些资源，如静态资源和视图模板的变化，并不需要重启。
         由于 DevTools 监控着类路径下的资源，触发一次重启的唯一方式就是更新类路径。而造成 classpath 更新的操作是依赖于 IDE 的。在 Eclipse 中，保存修改会造成类路径 更新，从而触发重启。在 Intellij 中，`build project` 会导致类路径更新，引发重启。

          在使用 LiveReload 是自动重启很好用。
         DevTools 重启时依赖于应用上下问的关机钩子函数关闭项目。如果你做了如下的设置重启功能将无法使用。

         ```
         SpringApplication.setRegisterShutdownHook(false)
         ```

         DevTools 自动忽略 classpath 下命名为 `spring-boot` `spring-boot-devtolls` `spring-boot-autoconfigure` `spring-boot-actuator` 和 `spring-boot-stater` 开头的项目的变化，也就是这些文件发生变化不会导致项目重启。
         DevTools 需要自定义 `ResourceLoader`，该组件被 `ApplicationContext` 使用。如果你的应用已经提供了该组件，该组件将被包装。不支持直接覆盖 `ApplicationContext` 的 `getRessource` 方法。
         **重启和重新加载**
         Spring Boot 提供的 重启技术适用哦了两个类加载器。没有改变的类（如引入的第三方jars 中的类）使用 base 类加载器加载。自已写的类使用 restart 类加载器加载。当应用重启时，旧的 restart 类加载器取消使用，新建一个 restart 类加载器共偶作。这种方法意味着 应用重启快于一般的开启项目，因为 base 类加载器此时是可用的并且加在了部分类。
         如果你发现重启并没有明显快于普通启动引用或者你遇到了类加载的问题，你可以尝试像是 JRebel 等重新载入技术。这类技术的原理是在类被载入是重写类完成。
         **日志记录每次重启的变化**
         默认情况下，你的应用每次重启，日志将记录一个条件评估变化的报告。该报告记录了你的变动，如添加或者删除 beans，设置配置属性，这些变动对自动配置造成的变动。
         可以通过下面的方式取消变动报告日志：

         ```
         spring.devtools.restart.log-condition-evaluation-delta=false
         ```

         **排除一些资源**
         某些资源发生变化时不需要触发重启。比如，Thymeleaf 模板文件。默认下，在 `/META-INF/maven` `/META-INF/resources` `/resources` `/static` `/public` `/templates` 路径下的文件都不触发重启，但是会触发动态重载。如果你想自定义这些排除项，你可以使用 `spring.devtools.restart.exclude` 属性。例如，可以通过下面的方式仅仅排除 `/static` `/public`

         ```xml
         spring.devtools.restart.exclude=static/**,public/**
         ```

         如果想在保持原来的默认的基础上添加配出的选项，使用 `spring.devtools.restart.additional-exclude` 属性

         **监控另外的路径变化**
         如果你想在你修改了非 classpath 下的文件是依旧可以重启应用，可以使用 `spring.devtools.restart.addititional-paths` 属性配置额外的被监控的路径变化。你可以使用 `spring.devtools.restart.exclude` 属性控制监控路径的文件是否触发重启或者重载。
         **取消重启**
         如果你不想使用重启功能，你可以通过配置 `spring.devtools.restart.enabled` 属性来取消重启。大多数情况下，你可以在你的 `application.properties` 文件中设置（但是这样做依旧会初始化一个 restart 类加载器，尽管 devtools 此时没有监控任何变动）
         如果你需要完成取消 重启功能（比如在某些库冲突的情况下），你需要按照下面的方式，在调用 `SpringApplicaion.run()` 之前进行设置。

         ```java
         public static void main(String[] args) {
             System.setProperty("spring.devtools.restart.enabled", "false");
             SpringApplication.run(MyApp.class, args);
         }
         ```

         **使用触发文件**
         **自定义 restart 类加载器**

         **已知的局限**
         在使用 `ObjectInputStream` 反序列化对象是重启功能表现的并不好。如果你需要分序列化数据，你可以需要使用 Spring 的 `ConfigurationObjectInputStream` 和 `Thread.currentTrhead().getContextClassLoader()` 一起使用。

      3. 动态重载
         `spring-boot-devtools` 模块抱哈了一个内置的动态重载服务器，它在资源改变是可以被用来触发浏览器的刷新。该扩展插件可用于 Chrome，Firefox 和 Safari。
         你可以使用 `spring.debtools.livereload.enabled` 属性设置为 false 来关闭该功能。
         同时只能运行一个 LiveReload 服务器，如果你运行多个应用在 IDE 中，只有一个可使用 LiveReload 的服务。

      4. 全局设置
         你可以配置全局的 devtools 配置文件到 `$HOME/.confg/spring-boot` 文件夹：

         1. `spring-boot-devtools.properties`
         2. `spring-boot-devtools.yaml`
         3. `spring-boot-devtools.yml`

         文件中配置的属性将被用于你机器上的所有的 Spring Boot 应用。（同理，上面的这种方式还是适用于 linux 下的开发）
         **配置文件系统监控器**

      5. 远程应用
         Spring Boot 开发者工具 不仅局限于本地开发，远程运行应用时仍然可以使用。远程支持可供选择，因为开启远程支持可能有安全风险。当运行在可信的网络或是使用 SSL 安全保障的环境下可以选择。另外，不要在生产环境部署时使用 开发者工具。
         你可以通过下面的方式制定打包可执行文件时忽略开发者工具。
         你需要设置 `spring.devtools.remote.secret`  属性，类似于密码。
         DevTools 提供两方面的服务，接受连接的服务端和运行在你的 IDE 中的客户端应用。服务端组件在配置了 `spring.devtools.remote.secret` 后自动开启，客户端组件必须手动启动。
         **运行远程客户应用**
         **远程更新**

   9. 打包应用
      可执行 jar 包能够用于生产环境部署。由于他们是自容器的，他们也可以适用于基于云环境的部署。
      生产级别的特性，如 监控、审计、REST 或者 JMX ，参考 Spring Boot Actuator 部分（本文档第5部分）。

   10. 后续
       目前为止，你应用了解了如何使用 Spring Boot 和一些最佳实践。接下来，你可以更深入的了解 Spring Boot 特性了



### 4、Spring Boot 特性

更深入的讨论一些细节。这里你可以学到一些你可能需要使用或者自定制的核心特性。

1. SpringApplication
   `SpringApplicaion` 类提供了一种方便的引导 Spring 应用的方式。大多数情况加，你可以委派给静态方法 `SpringApplication.run` ，如下面的案例：

   ```java
   public static void main(String[] args) {
       SpringApplication.run(MySpringConfiguration.class, args);
   }
   ```

   运行程序可以看到日志

   ```javascript
   
     .   ____          _            __ _ _
    /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
   ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
    \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
     '  |____| .__|_| |_|_| |_\__, | / / / /
    =========|_|==============|___/=/_/_/_/
    :: Spring Boot ::       (v2.1.11.RELEASE)
   
   2020-05-01 16:03:12.603  INFO 20220 --- [  restartedMain] cn.hust.study.springboot.Example         : Starting Example on DESKTOP-8IPKGHU with PID 20220 (G:\learn-skills\springbootstudy\myproject\target\classes started by Gknan in G:\learn-skills\springbootstudy)
   2020-05-01 16:03:12.607  INFO 20220 --- [  restartedMain] cn.hust.study.springboot.Example         : No active profile set, falling back to default profiles: default
   2020-05-01 16:03:12.693  INFO 20220 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable
   2020-05-01 16:03:12.693  INFO 20220 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : For additional web related logging consider setting the 'logging.level.web' property to 'DEBUG'
   2020-05-01 16:03:14.662  INFO 20220 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
   ```

   默认下，`INFO` 级别的日志打印出来，主要是一些相关的启动细节，如启动程序的用户。如果你需要其他级别的日志，可以自定义打印的日志级别。使用主应用程序类包中的实现版本来确定应用程序版本。可以通过 `spring.main.log-startup-info` 设置为 `false` 关闭启动应用的日志信息。这也会导致应用配置文件日志记录的关闭。

   可以通过覆写 `SpringApplicaion` 的子类的 `logStartupInfo(boolean)` 方法添加新的日志信息。

   1. 启动失败
      如果你的应用启动失败，`FailureAnalyzers` 组件将展示错误信息并给出修改问题的方案。比如，如果你的 8080 端口已经被占用，此时你在 8080 端口启动应用， 你讲看到类似于下面的日志信息：

      ```
      ***************************
      APPLICATION FAILED TO START
      ***************************
      
      Description:
      
      Embedded servlet container failed to start. Port 8080 was already in use.
      
      Action:
      
      Identify and stop the process that's listening on port 8080 or configure this application to listen on another port.
      ```

      Spring Boot 提供了大量的 `FailureAnalyzer` 实现类，当前你也可以自己[定制](https://docs.spring.io/spring-boot/docs/2.3.0.BUILD-SNAPSHOT/reference/htmlsingle/#howto-failure-analyzer)。

      如果没有失败分析器可以处理异常，你仍然可以显示全部的信息以便于分析问题所在。所以你需要开启 `debug` 属性或者 允许 `DEBUG` 级别的日志记录，`org.springframework.boot.autoconfigure.logging.ConditionEvaluationReportLoggingListener`.

      例如，如果你使用 `jar -jar` 方法启动应用，你可以按照下面方式开启 `debug` 属性：

      ```
      java -jar myproject-1.0-SNAPSHOT.jar --debug
      ```

   2. 懒加载
      `SpringApplicaion` 允许懒加载启动应用。启动懒加载后，bean 在需要时才被创建，而不是程序已启动就创建。所以，使用懒加载能够减少程序启动的时间。在 web 应用中，使用懒加载将导致 web 相关的 beans 直接 HTTP 请求到来时才创建。
      懒加载的坏处是将延迟问题的暴露。如果一个 bean 配置错误，程序启动后并不会立即报错，而是等到该 bean 给初始化时才报错。同时我们也要关注 JVM 的内存应该是满足应用需要的所有的 beans 的内存，而不是程序刚启动时的 beans 的内存。综上，懒加载默认是不开启的，建议在开启懒加载前作为 JVM 堆内存的调整。
      懒加载支持编程式指定，如使用 `SpirngApplicationBuilder` 的 `lazyInitialization` 方法或者 `SpringApplication` 的 `setLazyInitialization` 方法。也可以通过配置文件开启懒加载

      ```properties
      spring.main.lazy-initialization=true
      ```

      如果你想对于某些 beans 取消懒加载，而对于其他 beans 使用懒加载，你可以 `@Lazy(false)` 注解设置这些 beans 的懒加载属性为 false。

   3. 自定义 banner(横幅，旗帜)
      程序启动时的 banner 符号可以通过添加 `banner.txt` 文件到 classpath 下进行改变，或者可以通过设置 `spring.banner.location` 属性值为一个文件的路径。如果该文件不是 UTF-8 编码，你可以设置 `spring.banner.charset` 来指定。同时，你也可以添加 `banner.git` `banner.jpg` `banner.png` 文件到类路径下，或者设置 `spring.banner.image.location` 属性。图像会被转成 ASCII 表示。
      在你的 `banner.txt` 文件中，你可以使用下面的占位符。

      Table4 Banner 变量
      。。。
      你也可以使用 `spring.main.banner-mode` 属性配置 banner 是否需要打印到 `System.out` 上(console)，或者记录到机制(log)，或者在生产级别关闭(off)。
      打印 Banner 使用的是 `SpringBootBanner` 的一个单例类。

   4. 自定义 `SpringApplication`

      可以通过创建一个`SpringApplication` 实例 ，然后来定制它。比如，可以通过下面的方式关闭打印 Banner。

      ```java
      
          public static void main(String[] args) {
              // 自定义 SpringApplication，实现关闭打印 Banner
              SpringApplication application = new SpringApplication(Example.class);
              application.setBannerMode(Banner.Mode.OFF);
              application.run(args);
      
          }
      ```

      传递给 `SpringApplication` 的构造器参数是 Spring Beans 的配置源。在大多数情况下，它们是对`@Configuration`类的引用，但它们也可以是对XML配置或应扫描的程序包的引用。
      可通过查看 `SpringApplication` 的 [Javadoc](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/api//org/springframework/boot/SpringApplication.html) 获取更多详细信息。

   5. 链式编程 API
      如果你需要构造一个 `ApplicationContext` 层次，或者你喜欢使用链式编程，你可以使用 `SpringApplicationBuilder`。
      `SpringApplicationBuilder` 让你将多个的方法链在一起调用。如下案例：

      ```java
          public static void main(String[] args) {
              // 链式编程 API
              new SpringApplicationBuilder()
                      .sources(Example.class)
                      .bannerMode(Banner.Mode.OFF)
                      .run(args);
      
      
          }
      ```

      在创建 `ApplicationContext` 链时有一些限制。比如，web 组件必须包含于子上下文，父子上下文使用同样的 `Environment`。详见[`SpringApplicationBuilder` Javadoc](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/api//org/springframework/boot/builder/SpringApplicationBuilder.html) 。

   6. 应用事件和监听器
      除了通常使用的 Spring Framework 事件，如 `ContextRefreshEvent`,`SpringApplicaion` 还发送一些其他的应用程序事件。
      有些事件实在 `ApplicationContext` 被创建之前就已经触发，因此你可以在这些事件上注册监听器，使之成为 `@Bean`。你可以通过 `SpringApplication.addListeners(...)` 方法或者 `SpringApplicationoBuilder.listeners(...)` 方法。
      如果你要监听器自动注册而不官应用创建方式，你可以添加一个 `META-INF/spring.factories` 文件到项目中，并且使用 `org.springframework.context.ApplicationListner` 主键引用你的 监听器，如下案例：

      ```properties
      org.springframework.context.ApplicationListener=com.example.project.MyListener
      ```

      应用中事件按照下面的顺序发送，

      1. 启动程序但是在除了监听器和初始化器的注册之外的其他任何部分执行之前，`ApplicationStartingEvent` 被发送。
      2. 在上下文创建之前，上下文中将要使用的环境确定后，`ApplicationEnvironmentPreparedEvent` 被发送。
      3. 在任何 bean 定义加载前，`ApplicationContext` 准备好并且 应用上下文初始化器被调用后，`ApplicationContextInitializedEvent` 被发送。
      4. 在 refresh 开启前 bean 定义被加载后，`ApplicationPreparedEvent` 被发送。
      5. 在上下文刷新后且任何应用或者命令行运行器调用之前，`ApplicationStartedEvent` 被发送。
      6. 在任何应用或者运行期调用之后，`ApplicationReadyEvent` 被发送。此时，表明应用程序准备好接收请求了。
      7. 若在启动过程中抛出异常 `ApplicationFailedEvent` 被触发。

      上面仅仅列出了与 `SpringApplication` 绑定的 `SpringApplicationEvent` ，除此之外，下面的事件将会在 `ApplicationPreparedEvent` 之后 `ApplicationStartedEvent` 之前被触发：

      1. 当`ApplicationContext` 准备好后，`ContextRefreshedEvent` 被触发。
      2. 在 `WebServer` 准备好后，`WebServerInitializedEvent` 被触发。
         `ServletWebServerInitializedEvent` 和 `ReactiveWebServerInitializedEvent` 分别是 servlet 和响应变量。

      通常情况下，你并不需要使用应用事件，但是需要知道他们的存在。Spring Boot 使用事件监听处理大量的任务。

      应用程序事件是通过使用Spring Framework的事件发布机制发送的。这个机制一定程度上保证了发布给子上下文监听器的事件将会被发布给祖先上下文的监听器。综上，如果你的程序使用了 `SpringApplication` 实例的层级结构，一个监听器可以收到同样类型的应用事件的多个实例。
      为了使得监听器能够分辨一个事件是来自自己的上下文还是后弦的上下文，需要注入应用上下文，然后比较注入的上下文和事件的上下文。如果监听器是一个 bena，可以通过实现 `ApplicationContextAware ` 的方式或者使用 `@Autowired` 注解注入。

   7. web 环境
      `SpringApplication` 会试着创建合适的 `ApplicationContext` 。用来决定 `WebApplicationType` 的算法很简单，如下：

      * 如果有 Spring MVC，将使用`AnnotationConfigServletWebServerApplicationContext` 。
      * 若没有 Spring MVC，但是有 Spring WebFlux，将使用`AnnotationConfigReactiveWebServerApplicationContext`
      * 以上都没有，将使用 `AnnotationConfigApplicationContext`

      算法的思路是如果你应用中同时使用 Spring MVC 和 Spring WebFlux，Spring MVC 将默认优先使用。但是，你可以通过调用 `setWebAplicationType(WebApplicationType)` 覆盖，从而选择你想使用的应用类型。

      也可以通过调用 `setApplicationContextClass(...)` 来选择应用上下文类型。

      在使用 JUnit 进行测试时，调用的是 `setWebApplicationType(WebAplicationType.NONE)`。

   8. 应用程序参数
      如果你需要访问传递给 `SpringApplication.run(...)` 的参数，你可以注入一个 `org.springframework.boot.ApplicationArguments` bean。

   











### 5、Spring Boot Actuator: 生产级别的特性

Spring Boot 提供监控和管理应用的功能。你可以使用 HTTP endpoints 或者  JMX 的方式管理和监控应用。
如审计、健康检查和数据汇总等功能。

### 6、部署 Spring Boot 应用

Spring Boot 提供灵活的打包方式，以满足应用可以部署在各种平台，如云平台、容器镜像（Docker），虚拟机或者物理机等。

### 7、Spring Boot CLI

Spring Boot CLI 是用来部署 Spring 应用的命令行工具。提供 Groovy 脚本的方式运行。同时，你可以引用一个新项目或者自己写命令实现部署。

### 8、构建工具插件

Spring Boot 为 Maven 和 Gradle 都提供了构建项目的插件。这些插件提供各种功能，包括构建可执行 jar 的功能。这部分介绍两种插件的更多细节。并且对于扩展暂时未支持的构建工具的介绍一些注意事项

### 9、关于 怎么做xxx 常见问题的汇总

这部分提供了一些常见的 怎样做xxx 问题的回答。
如果在这里没有找到你的问题的答案，可以去 [stackoverflow.com](https://stackoverflow.com/tags/spring-boot) 的 spring-boot 标签下找。

### 10、附录

附录A：通用应用属性
application.yml 文件中的 Spring Boot 通用属性和该属性对应的底层的类的引用。
附录B：配置元数据

Spring Boot jar 包中包含有 metadata 文件，这些文件提供了所有支持的配置属性。这些文件设计用来给 IDE 开发者提供语境帮助。
大多数 metadata 文件都是在标注 `@ConfigurationProperties` 的类执行过程中自动生成的。少数情况下手动生成。
附录C：自动配置类
这部分介绍了 Spring Boot 提供的所有的自动配置类及其细节，可通过连接直接到达对应的类的源代码。
附录D：测试自动配置注解
这部分提供 `@xxxTest` 自动配置注解来测试应用的部分功能

附录E：可执行 jar 格式
`spring-boot-loader` 模块为 Spring Boot 提供了 可执行 jar 和 war 文件的支持。如果使用 Maven 插件或者 Gradle 插件，可自动生成可执行 jar 包。这部分提供构建可执行文件的一些底层原理。

附录F：版本依赖
提供 Spring Boot 版本依赖的细节

