package kr.ac.springboot.term.resume;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ResumeController {
	
	@Autowired
	ResumeRepository resumeRepo;
	
    @GetMapping("/")
    public String resumeIndex(Model model) {
        Resume resume = new Resume();
        resume.setName("윤수운");
        model.addAttribute("resume", resume);
        return "resume";
    }
    


}
