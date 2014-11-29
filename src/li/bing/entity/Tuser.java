package li.bing.entity;

import java.math.BigDecimal;


import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;

/**
 * Tuser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tuser")
public class Tuser extends IdEntity implements java.io.Serializable {

	
	/**手机号码*/
	private String mobilePhone;
	/**办公电话*/
	private String officePhone;
	/**电子邮箱*/
	private String email;

	/**工资*/
	private BigDecimal salary;
	/**生日*/
	private Date birthday;
	private Integer age;
	
	/**创建时间*/
	private Date createDate;
	/**性别*/
	private String sex;
	/**部门ID*/
	private String depId;
	
	/**状态*/
	private String status;
	/**备注*/
	private String content;
	
	@Column(name ="content",nullable=true)
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getStatus() {
		return status;
	}
	@Column(name ="status",nullable=true)
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 *方法: 取得String
	 *@return: String  手机号码
	 */
	@Column(name ="MOBILE_PHONE",nullable=true)
	public String getMobilePhone(){
		return this.mobilePhone;
	}

	/**
	 *方法: 设置String
	 *@param: String  手机号码
	 */
	public void setMobilePhone(String mobilePhone){
		this.mobilePhone = mobilePhone;
	}
	/**
	 *方法: 取得String
	 *@return: String  办公电话
	 */
	@Column(name ="OFFICE_PHONE",nullable=true)
	public String getOfficePhone(){
		return this.officePhone;
	}

	/**
	 *方法: 设置String
	 *@param: String  办公电话
	 */
	public void setOfficePhone(String officePhone){
		this.officePhone = officePhone;
	}
	/**
	 *方法: 取得String
	 *@return: String  电子邮箱
	 */
	@Column(name ="EMAIL",nullable=true)
	public String getEmail(){
		return this.email;
	}

	/**
	 *方法: 设置String
	 *@param: String  电子邮箱
	 */
	public void setEmail(String email){
		this.email = email;
	}
	

	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  工资
	 */
	@Column(name ="SALARY",nullable=true)
	public BigDecimal getSalary(){
		return this.salary;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  工资
	 */
	public void setSalary(BigDecimal salary){
		this.salary = salary;
	}
	/**
	 *方法: 取得Date
	 *@return: Date  生日
	 */
	
	@Column(name = "age")
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "birthday", length = 0)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	/**
	 *方法: 取得java.sql.Timestamp
	 *@return: java.sql.Timestamp  创建时间
	 */
	@Column(name ="create_date",nullable=true)
	public Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置Date
	 *@param: Date  创建时间
	 */
	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  性别
	 */
	@Column(name ="SEX",nullable=true)
	public String getSex(){
		return this.sex;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  性别
	 */
	public void setSex(String sex){
		this.sex = sex;
	}
	/**
	 *方法: 取得String
	 *@return: String  部门ID
	 */
	@Column(name ="DEP_ID",nullable=true)
	public String getDepId(){
		return this.depId;
	}

	/**
	 *方法: 设置String
	 *@param: String  部门ID
	 */
	public void setDepId(String depId){
		this.depId = depId;
	}
	
	
	
	
	
	
	private String name;
	private String pwd;
	

	private Set<MYAward> MYAwards = new HashSet<MYAward>(0);
	private Set<Studentlesson> studentlessons = new HashSet<Studentlesson>(0);

	// Constructors

	/** default constructor */
	public Tuser() {
	}

	/** minimal constructor */
	public Tuser(String name, String pwd) {

		this.name = name;
		this.pwd = pwd;

	}

	/** full constructor */
	public Tuser(String mobilePhone,
			String officePhone, String email, BigDecimal salary,
			Integer age, Date birthday, Date createDate, String sex, String depId,
			String status, String content, String name, String pwd, Set<MYAward> MYAwards,
			Set<Studentlesson> studentlessons) {
		this.mobilePhone = mobilePhone;
		this.officePhone = officePhone;
		this.email = email;
		this.age = age;
		this.salary = salary;
		this.birthday = birthday;
		this.createDate = createDate;
		this.sex = sex;
		this.depId = depId;
		this.status = status;
		this.content = content;
		this.name = name;
		this.pwd = pwd;
		this.MYAwards = MYAwards;
		this.studentlessons = studentlessons;
	}

	// Property accessors
	@Column(name = "name",unique = true,  nullable = false, length = 50)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "pwd", nullable = false, length = 20)
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tuser")
	public Set<MYAward> getMYAwards() {
		return this.MYAwards;
	}

	public void setMYAwards(Set<MYAward> MYAwards) {
		this.MYAwards = MYAwards;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tuser")
	public Set<Studentlesson> getStudentlessons() {
		return this.studentlessons;
	}

	public void setStudentlessons(Set<Studentlesson> studentlessons) {
		this.studentlessons = studentlessons;
	}

}