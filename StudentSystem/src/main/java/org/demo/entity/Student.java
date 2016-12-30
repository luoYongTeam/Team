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

    @Column(name="s_id")
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

    @OneToOne(cascade = {CascadeType.REMOVE,CascadeType.PERSIST,CascadeType.MERGE})
    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
/*@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "clazzid")*/
// 多对一关联
@ManyToOne
@JoinColumn(name = "team_id")
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
    //多对多关联
    //mappedBy一方不需要指定@JoinColumn和@JoinTable注解
    @ManyToMany(fetch=FetchType.EAGER)
    //多对多关联需要指定中间表,需要使用@JoinTable
    //name指定中间表的名字,joinColumns指定自己在中间表对应的外键列
    //inverseJoinColumns指定对方在中间表的外键列
    @JoinTable(name="stu_sub",
            joinColumns = @JoinColumn(name="s_id"),
            inverseJoinColumns = @JoinColumn(name="sub_id"))
    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }
}
