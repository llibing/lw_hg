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
 * @Description: 导师信息
 * @author zhangdaihao
 * @date 2014-11-29 15:19:39
 * @version V1.0   
 *
 */
@Entity
@Table(name = "hg_teacher", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class HgTeacherEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**导师姓名*/
	private java.lang.String teacherName;
	/**职称*/
	private java.lang.String position;
	/**简介*/
	private java.lang.String description;
	
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
	 *@return: java.lang.String  职称
	 */
	@Column(name ="POSITION",nullable=true,length=50)
	public java.lang.String getPosition(){
		return this.position;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职称
	 */
	public void setPosition(java.lang.String position){
		this.position = position;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  简介
	 */
	@Column(name ="DESCRIPTION",nullable=true,length=500)
	public java.lang.String getDescription(){
		return this.description;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  简介
	 */
	public void setDescription(java.lang.String description){
		this.description = description;
	}
}
