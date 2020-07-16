# 图书馆管理系统

### 概述
基于Spring + SpringBoot + MyBatis的图书馆管理系统，使用Maven进行包管理。主要功能包括：图书查询、日志记录等。

### 环境配置
#### 开发环境：Windows 10，IntelliJ IDEA 2018.3
#### 运行配置
1. 首先安装Mysql5.7，设置用户名为root，密码为123456，并保证其在运行状态，并执行t_books.sql文件导入数据。
2. 然后再配置Maven到环境变量中，在源代码目录下运行
```sh
# mvn jetty:run
```
3. 使用浏览器访问http://localhost:8080/swagger-ui.html即可进入系统。

### 逻辑设计
共有6个表：

#### 1. 图书书目表book_info
| 名           | 类型    | 长度 | 小数点 | NULL | 用途     | 键   |
| :----------- | :------ | ---- | ------ | ---- | -------- | ---- |
| book_id      | bigint  | 20   | 0      | 否   | 图书号   | ✔    |
| name         | varchar | 20   | 0      | 否   | 书名     |      |
| author       | varchar | 15   | 0      | 否   | 作者     |      |
| publish      | varchar | 20   | 0      | 否   | 出版社   |      |
| ISBN         | varchar | 15   | 0      | 否   | 标准书号 |      |
| introduction | text    | 0    | 0      | 是   | 简介     |      |
| language     | varchar | 4    | 0      | 否   | 语言     |      |
| price        | decimal | 10   | 2      | 否   | 价格     |      |
| pub_date     | date    | 0    | 0      | 否   | 出版时间 |      |
| class_id     | int     | 11   | 0      | 是   | 分类号   |      |
| number       | int     | 11   | 0      | 是   | 剩余数量 |      |

#### 2. 数据库管理员表admin
| 名       | 类型    | 长度 | 小数点 | NULL | 用途   | 键   |
| :------- | :------ | ---- | ------ | ---- | ------ | ---- |
| admin_id | bigint  | 20   | 0      | 否   | 账号   | ✔    |
| password | varchar | 15   | 0      | 否   | 密码   |      |
| username | varchar | 15   | 0      | 是   | 用户名 |      |

#### 3. 图书分类表class_info
| 名         | 类型    | 长度 | 小数点 | NULL | 用途   | 键   |
| :--------- | :------ | ---- | ------ | ---- | ------ | ---- |
| class_id   | int     | 11   | 0      | 否   | 类别号 | ✔    |
| class_name | varchar | 15   | 0      | 否   | 类别名 |      |

#### 4. 借阅信息表lend_list
| 名        | 类型   | 长度 | 小数点 | NULL | 用途     | 键   |
| :-------- | :----- | ---- | ------ | ---- | -------- | ---- |
| ser_num   | bigint | 20   | 0      | 否   | 流水号   | ✔    |
| book_id   | bigint | 20   | 0      | 否   | 图书号   |      |
| reader_id | bigint | 20   | 0      | 否   | 读者证号 |      |
| lend_date | date   | 0    | 0      | 是   | 借出日期 |      |
| back_date | date   | 0    | 0      | 是   | 归还日期 |      |

#### 5. 借阅卡信息表reader_card
| 名        | 类型    | 长度 | 小数点 | NULL | 用途     | 键   |
| :-------- | :------ | ---- | ------ | ---- | -------- | ---- |
| reader_id | bigint  | 20   | 0      | 否   | 读者证号 | ✔    |
| password  | varchar | 15   | 0      | 否   | 密码     |      |
| username  | varchar | 15   | 0      | 是   | 用户名   |      |

#### 6. 读者信息表reader_info
| 名        | 类型    | 长度 | 小数点 | NULL | 用途     | 键   |
| :-------- | :------ | ---- | ------ | ---- | -------- | ---- |
| reader_id | bigint  | 20   | 0      | 否   | 读者证号 | ✔    |
| name      | varchar | 10   | 0      | 否   | 姓名     |      |
| sex       | varchar | 2    | 0      | 否   | 性别     |      |
| birth     | date    | 0    | 0      | 否   | 生日     |      |
| address   | varchar | 50   | 0      | 否   | 地址     |      |
| phone     | varchar | 15   | 0      | 否   | 电话     |      |


##### 2.1 使用restfulAPi说明
1、权限方面需要使用admin表的账号调用登录获取token

2、调用books下的接口除了查询其他接口需要带上token才能调用成功

3、books的操作提供了简单的增删改查，有许多不完善的地方，需要后期改进

4、日志输出可以修改application.yml文件的配置

5. DB的连接使用的是mysql，在application.yml修改对应的地址DB地址

6. 关于缓存，可以使用本身的mybatis缓存，可以在application.yml配置中开启，最好是搭配使用redis，但是由于时间
有限，我的电脑没有安装redis，无法调试，后续有时间可以补上redis作为缓存的整合

7、分层采用的是包的空间来隔离，时间允许可以使用多模块来隔离，做成插件式模块


