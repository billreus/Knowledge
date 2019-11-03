# 快捷键

## 注解

### 行注解

Ctrl+/

### 块注解

Ctrl+Shift+/

### 方法或类注解

/**加回车

## 运行

### 运行程序

Ctrl+Shift+F10

## 查找

### 文本查找

Ctrl+F

### 文件查找

Ctrl+N

### 方法调用查询

Ctrl+Alt+h

### 全工程检索

Ctrl+Alt+Shift+f

## 删除

### 删除行

Ctrl+Y

## 跳转

### 跳转到父类方法和接口

Ctrl+U

### 跳转方法和定义

Ctrl+左键

### 退回到上一个操作地方

Crtl+Alt+左

### 前进到上一个操作地方

Crtl+Alt+右

## 生成

1. Ø Top #10切来切去：``Ctrl+Tab
2. Ø Top #9选你所想【选中上下文相关联代码】：``Ctrl+W
3. Ø Top #8代码生成：``Template/Postfix +Tab
4. 查找所有Intellij的命令：``Ctrl+Shift+A
5. Ø Top #6无处藏身：``Shift+Shift
6. Ø Top #5自动完成：``Ctrl+Shift+Enter
7. 新建类、方法等任何东西：``Alt+Insert
8. Ø Top #1智能补全：``Ctrl+Shift+Space
9. Ø Top #1自我修复：``Alt+Enter
10. Ø Top #1重构一切：``Ctrl+Shift+Alt+T
11. 创建单元测试用例：``Ctrl+Alt+T。
12. 运行：``Alt+Shift+F10运行程序，Shift+F9启动调试，Ctrl+F2停止。
13. 调试：``F7/F8/F9分别对应Step into，Step over，Continue。

### 生成序列化ID

Preferences->IEditor->nspections->Serialization issues->Serializable class without ’serialVersionUID’，选中以上后，在你的class中：``光标定位在类名前，按 Alt+Enter 就会提示自动创建 serialVersionUID

# 设置

## 设置代码宽度

1. 在File->settings->Editor->Code Style
2. 第一种，在上述的“Right margin (columns)”的下方，有“Wrap when typing reaches right margin”选项，选中它，当代码宽度到达界线时，IDEA会自动将代码换行。
4. 第二种方式，在File->settings->Code Style->Java中，选中“Wrapping and Braces”选项卡
4. 在“Keep when reformatting”中有一个“Ensure rigth margin is not exceeded”，选中它，在格式化Java代码时，确保代码没有超过宽度界线。

## 提示不区分大小写

1. 首先打开File----->setting
2. 然后，输入：sensitive
3. 将右侧的 case sensitive completion 修改为NONE 

## 查找快捷键冲突

File -> Settings -> Keymap -> Main menu -> Edit ->Find =>修改Find...和Replace...分别改为Ctrl+F 和Ctrl+R