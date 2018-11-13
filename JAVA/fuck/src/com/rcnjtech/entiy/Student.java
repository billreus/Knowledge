package com.rcnjtech.entiy;

import java.util.Date;

/**
 * 公有的学生实体类Student，将映射到数据库表Student
 *
 * @author RCNJTECH
 */
public class Student {
    /**
     * 学生的属性，应为私有的属性，学生实体类主键为id
     */
    private int id;
    private String name;
    private String sex;
    //注意使用java.util.Date包下的日期类型
    private Date birthday;

    /**
     * 应提供无参构造函数
     */
    public Student() {
    }

    /**
     * 若提供了带有参数的构造函数，则必须显示提供无参构造函数
     */
    public Student(int id, String name, String sex, Date birthday) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
    }

    // 为属性提供公有的Getter/Setter方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}