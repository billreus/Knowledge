<!-- GFM-TOC -->
* [学习资料](#学习资料)
* [集中式与分布式](#集中式与分布式)
* [Git 的中心服务器](#git-的中心服务器)
* [Git 工作流](#git-工作流)
* [分支实现](#分支实现)
* [冲突](#冲突)
* [Fast forward](#fast-forward)
* [分支管理策略](#分支管理策略)
* [储藏（Stashing）](#储藏stashing)
* [SSH 传输设置](#ssh-传输设置)
* [.gitignore 文件](#gitignore-文件)
* [Git 命令一览](#git-命令一览)
<!-- GFM-TOC -->

# 学习资料

* [Git - 简明指南](http://rogerdudler.github.io/git-guide/index.zh.html)
* [图解 Git](http://marklodato.github.io/visual-git-guide/index-zh-cn.html)
* [廖雪峰 : Git 教程](https://www.liaoxuefeng.com/wiki/0013739516305929606dd18361248578c67b8067c8c017b000)
* [Learn Git Branching](https://learngitbranching.js.org/)

# SSH 传输设置

Git 仓库和 Github 中心仓库之间的传输是通过 SSH 加密。

如果工作区下没有 .ssh 目录，或者该目录下没有 id_rsa 和 id_rsa.pub 这两个文件，可以通过以下命令来创建 SSH Key：

```
$ ssh-keygen -t rsa -C "youremail@example.com"
```

然后把公钥 id_rsa.pub 的内容复制到 Github "Account settings" 的 SSH Keys 中。

# Git 命令一览

## 基础

### 创建版本库

打开文件目录后，首先通过`git init`命令把这个目录变成管理仓库

### 把文件添加版本库

* 第一步，用`git add`告诉Git要添加的文件

```
$ git add name.txt
```

* 第二步，用`git commit`告诉Git把文件提交给仓库

```
$ git commit -m "it show your speak"
```

## Github推送

按照github绑定，绑定后提交只需要`git push origin master`

* 常出现fatal: remote origin already exists.只需输入`git remote rm origin`

从github下载到本地，用`$ git pull --rebase origin master`即可