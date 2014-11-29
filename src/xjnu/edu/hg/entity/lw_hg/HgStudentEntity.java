package xjnu.edu.hg.entity.lw_hg;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: 学生列表
 * @author zhangdaihao
 * @date 2014-11-29 15:18:51
 * @version V1.0   
 *
 */
@Entity
@Table(name = "hg_student", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class HgStudentEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**学号*/
	private java.lang.String studentid;
	/**密码*/
	private java.lang.String password;
	/**真实姓名*/
	private java.lang.String realname;
	/**导师姓名*/
	private java.lang.String teacherName;
	/**身份证号*/
	private java.lang.String idcard;
	/**身份*/
	private java.lang.String status;
	/**系别*/
	private java.lang.String department;
	/**手机*/
	private java.lang.String telphone;
	/**电子邮件*/
	private java.lang.String email;
//	/**课题外键*/
//	private java.lang.String titleId;
	
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
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学号
	 */
	@Column(name ="STUDENTID",nullable=true,length=15)
	public java.lang.String getStudentid(){
		return this.studentid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学号
	 */
	public void setStudentid(java.lang.String studentid){
		this.studentid = studentid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  密码
	 */
	@Column(name ="PASSWORD",nullable=true,length=20)
	public java.lang.String getPassword(){
		return this.password;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  密码
	 */
	public void setPassword(java.lang.String password){
		this.password = password;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  真实姓名
	 */
	@Column(name ="REALNAME",nullable=true,length=20)
	public java.lang.String getRealname(){
		return this.realname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  真实姓名
	 */
	public void setRealname(java.lang.String realname){
		this.realname = realname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  导师姓名
	 */
	@Column(name ="TEACHER_NAME",nullable=true,length=20)
	public java.lang.String getTeacherName(){
		return this.teacherName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  导师姓名
	 */
	public void setTeacherName(java.lang.String teacherName){
		this.teacherName = teacherName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证号
	 */
	@Column(name ="IDCARD",nullable=true,length=20)
	public java.lang.String getIdcard(){
		return this.idcard;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证号
	 */
	public void setIdcard(java.lang.String idcard){
		this.idcard = idcard;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份
	 */
	@Column(name ="STATUS",nullable=true,length=10)
	public java.lang.String getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份
	 */
	public void setStatus(java.lang.String status){
		this.status = status;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  系别
	 */
	@Column(name ="DEPARTMENT",nullable=true,length=50)
	public java.lang.String getDepartment(){
		return this.department;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  系别
	 */
	public void setDepartment(java.lang.String department){
		this.department = department;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  手机
	 */
	@Column(name ="TELPHONE",nullable=true,length=20)
	public java.lang.String getTelphone(){
		return this.telphone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  手机
	 */
	public void setTelphone(java.lang.String telphone){
		this.telphone = telphone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  电子邮件
	 */
	@Column(name ="EMAIL",nullable=true,length=20)
	public java.lang.String getEmail(){
		return this.email;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  电子邮件
	 */
	public void setEmail(java.lang.String email){
		this.email = email;
	}
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
