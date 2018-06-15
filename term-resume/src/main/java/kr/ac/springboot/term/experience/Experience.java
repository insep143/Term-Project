package kr.ac.springboot.term.experience;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import kr.ac.springboot.term.resume.Resume;

@Entity
public class Experience {
	public Experience() {
		
	}
	public Experience(String ExperienceText, String Experiencer, Resume resume) {
		this.ExperienceText=ExperienceText;
		this.Experiencer=Experiencer;
		this.resume=resume;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long rno;
	
	private String ExperienceText;
	private String Experiencer;
	
	@CreationTimestamp
	private Timestamp regdate;
	
	@UpdateTimestamp
	private Timestamp updatedate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Resume resume;

	public Long getRno() {
		return rno;
	}
	public void setRno(Long rno) {
		this.rno = rno;
	}
	public String getExperienceText() {
		return ExperienceText;
	}
	public void setExperienceText(String experienceText) {
		ExperienceText = experienceText;
	}
	public String getExperiencer() {
		return Experiencer;
	}
	public void setExperiencer(String experiencer) {
		Experiencer = experiencer;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public Timestamp getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}
	public Resume getResume() {
		return resume;
	}
	public void setResume(Resume resume) {
		this.resume = resume;
	}
	@Override
	public String toString() {
		return "Experience [rno=" + rno + ", ExperienceText=" + ExperienceText + ", Experiencer=" + Experiencer
				+ ", regdate=" + regdate + ", updatedate=" + updatedate + ", resume=" + resume + "]";
	}
		
}
