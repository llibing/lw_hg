package li.bing.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;

/**
 * MYLesson entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "m_y_lesson")
public class MYLesson extends IdEntity implements java.io.Serializable {

	// Fields

	
	private String lessonname;
	private Set<Studentlesson> studentlessons = new HashSet<Studentlesson>(0);

	// Constructors

	/** default constructor */
	public MYLesson() {
	}

	
	/** full constructor */
	public MYLesson( String lessonname,
			Set<Studentlesson> studentlessons) {
		
		this.lessonname = lessonname;
		this.studentlessons = studentlessons;
	}

	// Property accessors
	

	@Column(name = "lessonname")
	public String getLessonname() {
		return this.lessonname;
	}

	public void setLessonname(String lessonname) {
		this.lessonname = lessonname;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "MYLesson")
	public Set<Studentlesson> getStudentlessons() {
		return this.studentlessons;
	}

	public void setStudentlessons(Set<Studentlesson> studentlessons) {
		this.studentlessons = studentlessons;
	}

}