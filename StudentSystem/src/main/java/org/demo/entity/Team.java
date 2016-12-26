package org.demo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/12/26.
 */
@Entity
@Table(name = "team_info")
public class Team {
    private String tid;
    private String className;
    private Set<Student> students=new HashSet<>();

    @Id
    @GeneratedValue(generator="t_id")
    @GenericGenerator(name="t_id",strategy="uuid")
    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }
@Column(name = "class_name")
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
    //一对多关联
    //fetch属性设置加载策略（延迟LAZY或者是立即EAGER）
    //mappedBy指定维护关系交由给对方
    @OneToMany(fetch=FetchType.LAZY, mappedBy="team")
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
