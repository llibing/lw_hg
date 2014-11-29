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
 * @Description: 课题列表
 * @author zhangdaihao
 * @date 2014-11-29 15:20:26
 * @version V1.0   
 *
 */
@Entity
@Table(name = "hg_title", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class HgTitleEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**课题名字*/
	private java.lang.String titleName;
	/**课题人数*/
	private java.lang.String titleNum;
//	/**导师外键*/
//	private java.lang.String teacherId;
	
	
	/**关联导师*/
	private HgTeacherEntity hgTeacherEntity;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "teacher_id")
	public HgTeacherEntity getHgTeacherEntity() {
		return hgTeacherEntity;
	}
	public void setHgTeacherEntity(
			HgTeacherEntity hgTeacherEntity) {
		this.hgTeacherEntity = hgTeacherEntity;
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
	 *@return: java.lang.String  课题名字
	 */
	@Column(name ="TITLE_NAME",nullable=true,length=50)
	public java.lang.String getTitleName(){
		return this.titleName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  课题名字
	 */
	public void setTitleName(java.lang.String titleName){
		this.titleName = titleName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  课题人数
	 */
	@Column(name ="TITLE_NUM",nullable=true,length=10)
	public java.lang.String getTitleNum(){
		return this.titleNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  课题人数
	 */
	public void setTitleNum(java.lang.String titleNum){
		this.titleNum = titleNum;
	}
//	/**
//	 *方法: 取得java.lang.String
//	 *@return: java.lang.String  导师外键
//	 */
//	@Column(name ="TEACHER_ID",nullable=true,length=36)
//	public java.lang.String getTeacherId(){
//		return this.teacherId;
//	}
//
//	/**
//	 *方法: 设置java.lang.String
//	 *@param: java.lang.String  导师外键
//	 */
//	public void setTeacherId(java.lang.String teacherId){
//		this.teacherId = teacherId;
//	}
}
