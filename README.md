# MetaFlink

改项目是基于flink的异构数据处理平台 SmartBase的子项目，主要负责flink的各种数据源的存储，并提供web端的ssh页面用于Flink的SQL-Clinet的使用

## 部署方法
### 编译
编译环境 
 - java 1.8
 - maven ^3.6.3





1. 在主目录下执行命令

 (linux & macos)

 ```bash
 ./mvnw clean package
 ```
 (win)
 ```cmd
 mvnw clean package
 ```



2. 查看一下路径中是否成功生成Jar包

   `/target/metaflink-0.0.1-SNAPSHOT.jar`

3. 将生成的Jar包上传至服务器（或直接在服务器端进行编译）

4. 生成基础SQL库

   将SQL脚本`src\main\resources\SQL\table.sql`在数据库中执行.

5. 启动SpringBoot

   在Jar包目录下执行命令 

   ````bash
   nohup java -jar *.jar >nohup.log 2>&1 &
   ````

   其中* 为Jar包名称

   启动后可在相同目录下的nohup.log文件中查看日志

   

