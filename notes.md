

https://www.bilibili.com/video/BV1nE411r7TF



## 介绍

博客功能

![image-20211009103530416](/Users/andyron/myfield/github/ARBlog/images/image-20211009103530416.png)

技术组合

后端：springboot + JPA + thymeleaf

数据库：MySQL

前端UI：[Semantic UI](https://semantic-ui.com/)

工具与环境

IDEA、Maven3、JDK8、Axure RP 8



## 1 需求与功能

### 1.1 用户故事

 用户故事模板：

作为一个（某个**角色**）使用者，我可以做（某个**功能**）事情，如此可以有（某个**商业价值**）的好处。

举例：

- 作为一个招聘网站**注册用户**，我想**查看最近3天发布的招聘信息**，以便于**了解最新的招聘信息**。



个人博客系统的用户故事：

角色：普通访客，管理员（我）



- 访客，可以分页查看所有的博客
- 访客，可以快速查看博客数最多的6个分类
- 访客，可以查看所有的分类
- 访客，可以查看某个分类下的博客列表
- 访客，可以快速查看标记博客最多的10个标签
- 访客，可以查看所有的标签
- 访客，可以查看某个标签下的博客列表
- 访客，可以根据年度时间线查看博客列表
- 访客，可以快速查看最新的推荐博客
- 访客，可以用关键字全局搜索博客
- 访客，可以查看单个博客内容
- 访客，可以对博客内容进行评论
- 访客，可以赞赏博客内容
- 访客，可以微信扫码阅读博客内容
- 访客，可以在首页扫描公众号二维码关注我
- 我，可以用户名和密码登录后台管理
- 我，可以管理博客
  - 我，可以发布新博客
  - 我，可以对博客进行分类
  - 我，可以对博客打标签
  - 我，可以修改博客
  - 我，可以删除博客
  - 我，可以根据标题，分类，标签查询博客

- 我，可以管理博客分类
  - 我，可以新增一个分类
  - 我，可以修改一个分类
  - 我，可以删除一个分类
  - 我，可以根据分类名称查询分类
- 我，可以管理标签
  - 我，可以新增一个标签工
  - 我，可以修改一个标签
  - 我，可以删除一个标签
  - 我，可以根据名称查询标签

### 1.2 功能规划



## 2 页面设计与开发

### 2.1 设计



### 2.2 页面开发

移动端预览设置：

```html
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

```

`stackable` 用户手机页面自适应



https://www.toptal.com/designers/subtlepatterns/



### 2.3 插件集成

[编辑器Markdown](https://pandao.github.io/editor.md/)

内容排版[typo.css](https://github.com/sofish/typo.css)

动画[animate.css]()

代码高亮[prism](https://prismjs.com/)

滚动侦测[waypoints](http://imakewebthings.com/waypoints/)

平滑滚动[jquery.scrollTo](https://github.com/flesler/jquery.scrollTo)

目录生成[Tocbot](http://tscanlin.github.io/tocbot/)

二堆码生成[qrcode.js](http://davidshimjs.github.io/qrcodejs/)



Animate.css使用有问题



## 3 框架搭建

