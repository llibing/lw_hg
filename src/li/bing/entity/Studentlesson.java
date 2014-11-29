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
 * Studentlesson entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "studentlesson")
public class Studentlesson extends IdEntity implements java.io.Serializable {

	// Fields

	
	private MYLesson MYLesson;
	private Tuser tuser;

	// Constructors

	/** default constructor */
	public Studentlesson() {
	}

	

	/** full constructor */
	public Studentlesson( MYLesson MYLesson, Tuser tuser) {
		
		this.MYLesson = MYLesson;
		this.tuser = tuser;
	}

	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lessonid")
	public MYLesson getMYLesson() {
		return this.MYLesson;
	}

	public void setMYLesson(MYLesson MYLesson) {
		this.MYLesson = MYLesson;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "studentid")
	public Tuser getTuser() {
		return this.tuser;
	}

	public void setTuser(Tuser tuser) {
		this.tuser = tuser;
	}

}