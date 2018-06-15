package kr.ac.springboot.term;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import kr.ac.springboot.term.experience.Experience;
import kr.ac.springboot.term.experience.ExperienceRepository;
import kr.ac.springboot.term.resume.Resume;
import kr.ac.springboot.term.resume.ResumeRepository;

@Component
public class DataLoader implements ApplicationRunner {
	
	@Autowired
	private ResumeRepository resumeRepo;
	
	@Autowired
	private ExperienceRepository experienceRepo;
    @Override
    public void run(ApplicationArguments args) {
    	resumeRepo.save(new Resume("윤수운"));
        IntStream.range(2, 101).forEach(i -> experienceRepo.save(new Experience("ExperienceText"+i, "Experiencer"+i, resumeRepo.findById((long)i).orElse(null))));
        }

}