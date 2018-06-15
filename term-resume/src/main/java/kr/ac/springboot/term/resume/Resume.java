package kr.ac.springboot.term.resume;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import kr.ac.springboot.term.Question.Question;
import kr.ac.springboot.term.experience.Experience;

@Entity
public class Resume {
	
	public Resume() {
		
	}
	
	public Resume(String name) {
		this.name=name;
	}
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rno;

    private String name;

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	@OneToMany(mappedBy="resume", fetch=FetchType.LAZY)
    private List<Experience> experiences;
	
	@OneToMany(mappedBy="question", fetch=FetchType.LAZY)
	private List<Question> question;
	
	public Long getRno() {
        return rno;
    }

    public void setRno(Long rno) {
        this.rno = rno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	
}
