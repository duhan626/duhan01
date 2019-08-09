##项目名称：
数巨牛基础框架平台
##技术实现
spring boot + mybatis + redis + mysql(...)

##项目目录结构
com.shujuniu目录包括：
1、cache -缓存数据包。用Redis进行管理系统登录会话周期设置等处理
2、common  通用包
     -been   实体属性设置
     －controller 状态码设置
     －enumtype 枚举类型
      -exception 异常处理构造
      -rest 分页
      -utils
 3、icinfo -DEMO 读删操作。
    controller-接收参数入口与返回数据控制 
    dto-事务数据传输需要用的到对象
    mapper -实体been与数据库字面映射。不需要手写，mybatis自动生成
    po -数据对象。实体对象与数据库entity对应。不需要手写，mybatis自动生成
    service-业务逻辑层
    vo    -展示层。需要接收参数对象与返回对象。
    
  4、log -操作与登录日志操作数据库
  
  5、permission 权限管理：客户管理、导航菜单列表、角色控制、用户操作、白名单列表等
  
  6、report -报表记录 excel处理。很方便的。
  
  7、system -系统管理
  
  8、web -拦截、监听、定时任务     
    
  9、mapper mybatis映射文件目录
 