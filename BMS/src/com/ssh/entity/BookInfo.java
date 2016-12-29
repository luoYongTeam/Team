package com.ssh.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name="tb_book")
public class BookInfo implements Serializable{
	
	private int bid ;      		//图书的ID
	private String bname ; 		//图书的名称
	private String bcate ; 		//图书的类别号
	private String bauthor ;	//图书的作者
	private String bpress ;		//出版社
    private int bprice ; 	//图书的价格
    private int bnum ; 			//图书的数量
    
    private BookType type ;
    
    public BookInfo() {
	}
	public BookInfo(int bid, String bname, String bcate, String bauthor, String bpress, int bprice, int bnum,
			BookType type) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.bcate = bcate;
		this.bauthor = bauthor;
		this.bpress = bpress;
		this.bprice = bprice;
		this.bnum = bnum;
		this.type = type;
	}

	@Id
	@GeneratedValue()
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBcate() {
		return bcate;
	}
	public void setBcate(String bcate) {
		this.bcate = bcate;
	}
	public String getBauthor() {
		return bauthor;
	}
	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}
	public String getBpress() {
		return bpress;
	}
	public void setBpress(String bpress) {
		this.bpress = bpress;
	}
	public int getBprice() {
		return bprice;
	}
	public void setBprice(int bprice) {
		this.bprice = bprice;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	@ManyToOne()
	@JoinColumn(name="booktype")
	public BookType getType() {
		return type;
	}
	public void setType(BookType type) {
		this.type = type;
	}
}
