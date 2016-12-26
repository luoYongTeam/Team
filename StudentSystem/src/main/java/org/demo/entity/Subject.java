package org.demo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/12/26.
 */
@Entity
@Table(name = "subject_info")
public class Subject {

    private String subid;
    private String subName;
    // 多对多关联学生
    private Set<Student> students = new HashSet<>();

    @Id
    @GeneratedValue(generator="sub_id")
    @GenericGenerator(name="sub_id",strategy="uuid")
    public String getSubid() {
        return subid;
    }

    public void setSubid(String subid) {
        this.subid = subid;
    }

    @Column(name = "sub_name")
    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    //多对多关联
    @ManyToMany(fetch=FetchType.LAZY)
    //多对多关联需要指定中间表,需要使用@JoinTable
    //name指定中间表的名字,joinColumns指定自己在中间表对应的外键列
    //inverseJoinColumns指定对方在中间表的外键列
    @JoinTable(name="stu_sub",
            joinColumns = @JoinColumn(name="sub_id"),
            inverseJoinColumns = @JoinColumn(name="stu_id"))
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

}

