package kr.ac.springboot.term.Question;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.springboot.term.resume.ResumeRepository;

@Controller
@RequestMapping("/QnA/")
public class QuestionController {
	@Autowired
	QuestionRepository QRepo;
	
	@Autowired
	ResumeRepository resumeRepo;
	
	@GetMapping("/QnAregister")
	public String questionIndex(Model model) {
		model.addAttribute("result", QRepo.findAllByOrderByNameDesc());
		return "QnA/QnAregister";
	}
	
	@GetMapping("/Qregister")
    public void registerGET(@ModelAttribute("Q") Question Q) {
    }

    @PostMapping("/Qregister")
    public String registerPOST(@ModelAttribute("Q") Question Q) {
    	Optional<Question> q = QRepo.findById(Q.getQnAno());
        if (q.isPresent()) {
        	q.get().setQuestion(Q.getQuestion());
        	q.get().setName(Q.getName());
        	QRepo.save(q.get());
        } else {
        	QRepo.save(Q);
        }
        return "redirect:/";
    }
}
