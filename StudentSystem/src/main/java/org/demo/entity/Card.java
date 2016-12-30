package org.demo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/12/26.
 */
@Entity
@Table(name = "card_info")
public class Card {

    private String cid;
    private String cardNum;
    // 关联学生
    private Student student;

   @Id
 @Column(name="c_id")
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Column(name = "card_num")
    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    //一对一关联学生
    //关系维护端需要使用@JoinColumn注解，指定关联表的外键列
    //@JoinColumn只需要在关系的维护端指定即可
    @OneToOne(mappedBy = "card")
    @JoinColumn(name="stu_id")

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


}

