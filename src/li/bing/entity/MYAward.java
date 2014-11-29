package li.bing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;

/**
 * MYAward entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "m_y_award")
public class MYAward extends IdEntity implements java.io.Serializable {

	// Fields

	
	private Tuser tuser;
	private String awardname;
	private String dengji;

	// Constructors

	/** default constructor */
	public MYAward() {
	}

	

	/** full constructor */
	public MYAward( Tuser tuser, String awardname, String dengji) {
		
		this.tuser = tuser;
		this.awardname = awardname;
		this.dengji = dengji;
	}

	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "studentid")
	public Tuser getTuser() {
		return this.tuser;
	}

	public void setTuser(Tuser tuser) {
		this.tuser = tuser;
	}

	@Column(name = "awardname")
	public String getAwardname() {
		return this.awardname;
	}

	public void setAwardname(String awardname) {
		this.awardname = awardname;
	}

	@Column(name = "dengji")
	public String getDengji() {
		return this.dengji;
	}

	public void setDengji(String dengji) {
		this.dengji = dengji;
	}

}