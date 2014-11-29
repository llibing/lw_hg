package xjnu.edu.hg.entity.lw_hg;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: 学生选题信息
 * @author zhangdaihao
 * @date 2014-11-29 16:16:08
 * @version V1.0   
 *
 */
@Entity
@Table(name = "hg_student_title", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class HgStudentTitleEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
//	/**学生外键*/
//	private java.lang.String studentId;
//	/**课题外键*/
//	private java.lang.String titleId;
	
	/**关联学生*/
	private HgStudentEntity hgStudentEntity;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id")
	public HgStudentEntity getHgStudentEntity() {
		return hgStudentEntity;
	}
	public void setHgStudentEntity(
			HgStudentEntity hgStudentEntity) {
		this.hgStudentEntity = hgStudentEntity;
	}
	/**关联课题*/
	private HgTitleEntity hgTitleEntity;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "title_id")
	public HgTitleEntity getHgTitleEntity() {
		return hgTitleEntity;
	}
	public void setHgTitleEntity(
			HgTitleEntity hgTitleEntity) {
		this.hgTitleEntity = hgTitleEntity;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=36)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  id
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
//	/**
//	 *方法: 取得java.lang.String
//	 *@return: java.lang.String  学生外键
//	 */
//	@Column(name ="STUDENT_ID",nullable=true,length=36)
//	public java.lang.String getStudentId(){
//		return this.studentId;
//	}
//
//	/**
//	 *方法: 设置java.lang.String
//	 *@param: java.lang.String  学生外键
//	 */
//	public void setStudentId(java.lang.String studentId){
//		this.studentId = studentId;
//	}
//	/**
//	 *方法: 取得java.lang.String
//	 *@return: java.lang.String  课题外键
//	 */
//	@Column(name ="TITLE_ID",nullable=true,length=36)
//	public java.lang.String getTitleId(){
//		return this.titleId;
//	}
//
//	/**
//	 *方法: 设置java.lang.String
//	 *@param: java.lang.String  课题外键
//	 */
//	public void setTitleId(java.lang.String titleId){
//		this.titleId = titleId;
//	}
}
