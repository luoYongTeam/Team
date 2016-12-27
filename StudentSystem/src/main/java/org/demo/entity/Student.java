package org.demo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/12/25.
 */
@Entity
@Table(name="stu_info")
public class Student {
    private String sid;
    private String stuName;
    private int age;
    private String sex;
    //关联身份证
    private Card card;
    //多对一关联班级
    private Team team;
    //多对多关联课程
    private Set<Subject> subjects=new HashSet<>();
    @Id
    @GeneratedValue(generator="s_id")
    @GenericGenerator(name="s_id",strategy="uuid")
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
@Column(name = "stu_name")
    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
@Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
@Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    // 一对一关联身份证
    // cascade设置级联操作
    // CascadeType.PERSIST级联保存
    // CascadeType.REMOVE级联删除
    // CascadeType.MERGE级联更新
    // CascadeType.REFRESH级联刷新
    // CascadeType.ALL所有级联操作

    // mappedBy属性指定将关联关系的维护全交由给对方，相当于hibernate中的inverse
    // 它的值是指定对方关联自己的属性名。
    // （注意：只有双向关联的情况才需要指定，且只需要在任意一遍指定即可）

    @OneToOne(cascade = {CascadeType.REMOVE,CascadeType.PERSIST,CascadeType.MERGE},mappedBy = "student")
  @JoinColumn(name = "card_id")
    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "clazzid")
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
    //多对多关联
    //mappedBy一方不需要指定@JoinColumn和@JoinTable注解
    @ManyToMany(fetch=FetchType.EAGER, mappedBy="students")
    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }
}
