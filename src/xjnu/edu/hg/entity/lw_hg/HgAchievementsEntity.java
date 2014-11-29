package xjnu.edu.hg.entity.lw_hg;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: 成果展示
 * @author zhangdaihao
 * @date 2014-11-29 15:17:14
 * @version V1.0   
 *
 */
@Entity
@Table(name = "hg_achievements", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class HgAchievementsEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**成果内容*/
	private java.lang.String descriptin;
//	/**学生外键*/
//	private java.lang.String studentId;
	/**时间*/
	private java.util.Date time;
	/**图片*/
	private java.lang.String img;
	/**成果名*/
	private java.lang.String achievementsName;
	
	
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
	 *@return: java.lang.String  成果内容
	 */
	@Column(name ="DESCRIPTIN",nullable=true,length=1000)
	public java.lang.String getDescriptin(){
		return this.descriptin;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  成果内容
	 */
	public void setDescriptin(java.lang.String descriptin){
		this.descriptin = descriptin;
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
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  时间
	 */
	@Column(name ="TIME",nullable=true)
	public java.util.Date getTime(){
		return this.time;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  时间
	 */
	public void setTime(java.util.Date time){
		this.time = time;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图片
	 */
	@Column(name ="IMG",nullable=true,length=255)
	public java.lang.String getImg(){
		return this.img;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图片
	 */
	public void setImg(java.lang.String img){
		this.img = img;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  成果名
	 */
	@Column(name ="ACHIEVEMENTS_NAME",nullable=true,length=80)
	public java.lang.String getAchievementsName(){
		return this.achievementsName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  成果名
	 */
	public void setAchievementsName(java.lang.String achievementsName){
		this.achievementsName = achievementsName;
	}
}
