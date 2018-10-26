多数据源使用要点:
1. DataSourceConfig.java 中注意改成项目中的包名.
2. DataSourceAspect.java 中的 aspect() 方法要注意修改包名.

3. 如果不需要读写分离的话,直接把config下的配置全部删除即可实现.

https://github.com/WinterChenS/springboot-learning-experience


