一. 实例来自:
https://github.com/LuoLiangDSGA/spring-learning
https://github.com/LuoLiangDSGA/spring-learning/tree/master/boot-dubbo

博客:
https://luoliangdsga.github.io
spring-learning:项目中有其他的项目,需要用到的地方,可以去借鉴一下.

二. spring-boot 的学习.

https://github.com/WinterChenS/springboot-learning-experience 多数据源操作数据库.
https://www.jianshu.com/p/5cd772c07041

spring-boot 相关的支持包,查询地址是:
重要:
http://start.spring.io/


学习: springboot-cloud:
https://github.com/crossoverJie/springboot-cloud




三. 读写分离的实现:

多数据源使用要点:
1. DataSourceConfig.java 中注意改成项目中的包名.
2. DataSourceAspect.java 中的 aspect() 方法要注意修改包名.
3. 如果不需要读写分离的话,直接把com.application.base.dubbo.provider.common.config下的配置全部删除即可实现.




四. 分页自适应:
分页自适应来自github的:https://github.com/pagehelper/Mybatis-PageHelper
使用方式可见bootapi 或者base-dubbo项目.



五. 支付项目借鉴:
    龙果支付项目可以:
    https://gitee.com/roncoocom/roncoo-pay
    https://github.com/roncoo/roncoo-pay

