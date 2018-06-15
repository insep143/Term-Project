package kr.ac.springboot.term.Question;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import kr.ac.springboot.term.resume.Resume;

@Entity
public class Question {
	public Question() {
		
	}
	
	public Question(String question, String name, Resume resume) {
		this.question=question;
		this.name=name;
		this.resume=resume;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long QnAno;
	
	private String question;
	private String name;
	
	public Long getQnAno() {
		return QnAno;
	}

	public void setQnAno(Long qnAno) {
		QnAno = qnAno;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	private Resume resume;
	//answer도 똑같이 만들어서 OneToMany로 여기다가 패치.
}
