package li.bing.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;
import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * TIllegal entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_illegal")


public class TIllegal extends IdEntity implements java.io.Serializable {

	// Fields

	@Excel(exportName="违章代码")
	private String illegalcode;
	private TDriveruser TDriveruser;
	
//	@Excel(exportName="现场图片",exportFieldWidth=30)
	private String image;
	
	@Excel(exportName="违章地址",exportFieldWidth=30)
	private String illegaladdress;
	
	@Excel(exportName="违章内容",exportFieldWidth=50)
	private String illegalcontent;
	@Excel(exportName="违章日期",exportFieldWidth=20)
	private String illegaldate;
	@Excel(exportName="罚款金额")
	private String illegalfine;
	@Excel(exportName="分数")
	private String score;
	@Excel(exportName="处理结果",exportFieldWidth=20)
	private String handle;
	// Constructors

	/** default constructor */
	public TIllegal() {
	}

	/** minimal constructor */
	

	/** full constructor */
	public TIllegal( TDriveruser TDriveruser,String illegalcode,String image,
			String illegaladdress,  String illegalcontent,
			String illegaldate, String illegalfine, String score, String handle) {
		
		this.TDriveruser = TDriveruser;
		this.illegalcode = illegalcode;
		this.illegaladdress = illegaladdress;
		
		this.illegalcontent = illegalcontent;
		this.illegaldate = illegaldate;
		this.illegalfine = illegalfine;
		this.score = score;
		this.handle = handle;
		this.image=image;
	}

	// Property accessors
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "driver_id")
	public TDriveruser getTDriveruser() {
		return this.TDriveruser;
	}

	public void setTDriveruser(TDriveruser TDriveruser) {
		this.TDriveruser = TDriveruser;
	}

	@Column(name = "illegalcode", length = 20)
	public String getIllegalcode() {
		return this.illegalcode;
	}

	public void setIllegalcode(String illegalcode) {
		this.illegalcode = illegalcode;
	}
	
	


	
	
	
	@Column(name = "image", length = 255)
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	
	

	@Column(name = "illegaladdress")
	public String getIllegaladdress() {
		return this.illegaladdress;
	}

	public void setIllegaladdress(String illegaladdress) {
		this.illegaladdress = illegaladdress;
	}

	

	@Column(name = "illegalcontent")
	public String getIllegalcontent() {
		return this.illegalcontent;
	}

	public void setIllegalcontent(String illegalcontent) {
		this.illegalcontent = illegalcontent;
	}

	
	@Column(name = "illegaldate")
	public String getIllegaldate() {
		return this.illegaldate;
	}

	public void setIllegaldate(String illegaldate) {
		this.illegaldate = illegaldate;
	}

	@Column(name = "illegalfine", length = 11)
	public String getIllegalfine() {
		return this.illegalfine;
	}

	public void setIllegalfine(String illegalfine) {
		this.illegalfine = illegalfine;
	}

	@Column(name = "score", length = 10)
	public String getScore() {
		return this.score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	@Column(name = "handle")
	public String getHandle() {
		return this.handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}

}