# personnelmanage
人事管理系统

该项目目前只实现了系统管理员/人事管理员的登录功能、员工管理功能、导表功能、图片上传功能  

具体的开发需求请参考：某985高校饮食服务中心人事管理系统.pdf  
相关的建表请参考：person_manage.sql  
相关的开发流程及知识点讲解请参考：人事管理系统开发规约.docx  


### 1、该项目作为Spring Boot2.0.6项目，没有使用内置Tomcat,需要自行配置，且版本需8.0以上  

### 2、数据持久层使用到了Mybatis-Plus,集了Spring JPA和Mybatis两者的优点的国内优秀开源框架  

### 3、前端页面使用到了Layui，模板引擎则采用Thymeleaf

### 4、接口设计风格为Restful，且有统一的异常管理机制

### 5、系统效果图  

系统管理员/人事管理员登录  

<img src="https://github.com/ningxiaojian31/personnelmanage/blob/master/src/document/img/21.png" width="800px"></img>  

系统管理员管理页面

<img src="https://github.com/ningxiaojian31/personnelmanage/blob/master/src/document/img/22.png" width="800px"></img> 

人事管理员管理页面

<img src="https://github.com/ningxiaojian31/personnelmanage/blob/master/src/document/img/23.png" width="800px"></img> 

添加员工

<img src="https://github.com/ningxiaojian31/personnelmanage/blob/master/src/document/img/24.png" width="800px"></img> 

修改员工

<img src="https://github.com/ningxiaojian31/personnelmanage/blob/master/src/document/img/25.png" width="800px"></img> 
