package li.bing.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.jeecgframework.core.common.entity.IdEntity;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelCollection;
import org.jeecgframework.poi.excel.annotation.ExcelTarget;

/**
 * TDriveruser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_driveruser")

@ExcelTarget(id="tdriveruser")
public class TDriveruser extends IdEntity implements java.io.Serializable {

	// Fields
	
	@Excel(exportName="车身颜色",orderNum="11",needMerge=true)
	private String carcolor;
	@Excel(exportName="车辆类型",orderNum="11",needMerge=true)
	private String cartype;
	
//	@Excel(exportName="现场图片",exportFieldWidth=30)
	private String image;
	
	@Excel(exportName="家庭住址",orderNum="4",needMerge=true,exportFieldWidth=30)
	private String driveraddress;
	@Excel(exportName="出生日期",orderNum="6",needMerge=true)
	private Date driverbir;
	@Excel(exportName="驾照号",orderNum="5",needMerge=true,exportFieldWidth=20)
	private String driverlicencenum;
	@Excel(exportName="用户姓名",orderNum="1",needMerge=true,exportFieldWidth=20)
	private String drivername;
	@Excel(exportName="身份证号",orderNum="3",needMerge=true,exportFieldWidth=20)
	private String drivernum;
	@Excel(exportName="车牌号",orderNum="2",needMerge=true,exportFieldWidth=15)
	private String driverpassword;
	@Excel(exportName="性别",orderNum="7",imExConvert=1,needMerge=true)
	private String sex;
	@Excel(exportName="电话号码",orderNum="8",needMerge=true,exportFieldWidth=15)
	private String drivertel;
	@Excel(exportName="号牌颜色",orderNum="9",needMerge=true,exportFieldWidth=10)
	private String driverflapper;
//	@Excel(exportName="违章次数",orderNum="10",needMerge=true)
	private String illegal;
//	@Excel(exportName="备注",orderNum="11",needMerge=true,exportFieldWidth=20)
	private String remark;
	/**状态*/
	private String status;
	

	@ExcelCollection(exportName="违章信息",orderNum="12")
	private List<TIllegal> TIllegals = new ArrayList<TIllegal>(0);

	// Constructors

	/** default constructor */
	public TDriveruser() {
	}

	/** minimal constructor */
	public TDriveruser(String drivername, String driverpassword) {
		
		this.drivername = drivername;
		this.driverpassword = driverpassword;
	}

	/** full constructor */
	public TDriveruser( String driveraddress, Date driverbir,String image,String carcolor,
			String driverlicencenum, String drivername, String drivernum,String cartype,
			String driverpassword, String sex, String drivertel,
			String driverflapper, String illegal, String remark,String status,
			List<TIllegal> TIllegals) {
		
		this.driveraddress = driveraddress;
		this.driverbir = driverbir;
		this.driverlicencenum = driverlicencenum;
		this.drivername = drivername;
		this.drivernum = drivernum;
		this.driverpassword = driverpassword;
		this.sex = sex;
		this.drivertel = drivertel;
		this.driverflapper = driverflapper;
		this.illegal = illegal;
		this.remark = remark;
		this.TIllegals = TIllegals;
		this.status=status;
		this.image=image;
		this.carcolor=carcolor;
		this.cartype=cartype;
	}

	// Property accessors
	

	@Column(name = "image", length = 255)
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	@Column(name = "carcolor", length = 50)
	public String getCarcolor() {
		return this.carcolor;
	}

	public void setCarcolor(String carcolor) {
		this.carcolor = carcolor;
	}
	
	
	@Column(name = "cartype", length = 50)
	public String getCartype() {
		return this.cartype;
	}

	public void setCartype(String cartype) {
		this.cartype = cartype;
	}
	
	
	
	
	
	
	@Column(name = "driveraddress")
	public String getDriveraddress() {
		return this.driveraddress;
	}

	public void setDriveraddress(String driveraddress) {
		this.driveraddress = driveraddress;
	}

	
	public String getStatus() {
		return status;
	}
	@Column(name ="status",nullable=true)
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "driverbir", length = 0)
	public Date getDriverbir() {
		return this.driverbir;
	}

	public void setDriverbir(Date driverbir) {
		this.driverbir = driverbir;
	}

	@Column(name = "driverlicencenum", length = 20)
	public String getDriverlicencenum() {
		return this.driverlicencenum;
	}

	public void setDriverlicencenum(String driverlicencenum) {
		this.driverlicencenum = driverlicencenum;
	}

	@Column(name = "drivername", nullable = false, length = 50)
	public String getDrivername() {
		return this.drivername;
	}

	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}

	@Column(name = "drivernum", length = 20)
	public String getDrivernum() {
		return this.drivernum;
	}

	public void setDrivernum(String drivernum) {
		this.drivernum = drivernum;
	}

	@Column(name = "driverpassword", nullable = false, length = 20)
	public String getDriverpassword() {
		return this.driverpassword;
	}

	public void setDriverpassword(String driverpassword) {
		this.driverpassword = driverpassword;
	}

	@Column(name = "sex")
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	public String convertGetSex(){
		return this.sex.equals("0")?"男性":"女性";
	}
	public void convertSetSex(String sex ){
		this.sex = sex.equals("男性")?"0":"1";
	}
	@Column(name = "drivertel", length = 11)
	public String getDrivertel() {
		return this.drivertel;
	}

	public void setDrivertel(String drivertel) {
		this.drivertel = drivertel;
	}

	@Column(name = "driverflapper")
	public String getDriverflapper() {
		return this.driverflapper;
	}

	public void setDriverflapper(String driverflapper) {
		this.driverflapper = driverflapper;
	}

	@Column(name = "illegal")
	public String getIllegal() {
		return this.illegal;
	}

	public void setIllegal(String illegal) {
		this.illegal = illegal;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "TDriveruser")
	public List<TIllegal> getTIllegals() {
		return TIllegals;
	}

	public void setTIllegals(List<TIllegal> TIllegals) {
		this.TIllegals = TIllegals;
	}

}