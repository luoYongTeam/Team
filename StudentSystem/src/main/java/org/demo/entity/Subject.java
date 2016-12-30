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
    @Column(name="sub_id")
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

    @ManyToMany(mappedBy="subjects")
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

}

