# 架构文档
## package
 - command 命令的生成与发送 目前只制作了执行
 - dataBase 数据库的解析  字段分解 可加入动态类的解析
   - TODO ： 语句的转换 实际数据的采集
 - controller restful接口
 - exception 异常处理
 - util 帮助类

## 已经通过的单元测试
 - 命令的执行 （ping 命令测试通过）
 - 数据库元数据的获取 
 - 动态类的加载  在test类 MySQLGeneratorEntityUtil中