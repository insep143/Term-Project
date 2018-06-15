package kr.ac.springboot.term.experience;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.springboot.term.resume.ResumeRepository;

@Controller
@RequestMapping("/experience/")
public class ExperienceController {
	
	@Autowired
	ExperienceRepository experienceRepo;
	
	@Autowired
	ResumeRepository resumeRepo;

	@GetMapping("/")
	public String experienceIndex(Model model) {
		model.addAttribute("result", experienceRepo.findAllByOrderByRegdateDesc());
		return "experience";
	}
	
	@GetMapping("/register")
    public void registerGET(@ModelAttribute("vo") Experience vo) {
    }

    @PostMapping("/register")
    public String registerPOST(@ModelAttribute("vo") Experience vo) {
    	vo.setResume(resumeRepo.findById((long)1).get());
        experienceRepo.save(vo);
        return "redirect:/experience/";
    }
	@GetMapping("/{rno}")
    public String view(@PathVariable("rno") long rno, Model model) {
        if (experienceRepo.findById(rno).isPresent()) {
            model.addAttribute("result", experienceRepo.findById(rno).get());
        } else if(HttpStatus.INTERNAL_SERVER_ERROR != null){
            return "errors/500";
        }
        else {
        	return "errors/404";
        }
        return "experience/item";
    }
	@GetMapping("/{rno}/update")
    public String updateGet(@PathVariable("rno") long rno, @ModelAttribute("vo") Experience vo, Model model) {
        if (experienceRepo.findById(rno).isPresent()) {
            model.addAttribute("vo", experienceRepo.findById(rno).get());
        } else if(HttpStatus.INTERNAL_SERVER_ERROR != null) {
        	return "errors/500";
        }
        else {
            return "errors/404";
        }
        return "experience/update";
    }

    @PostMapping("/update")
    public String updatePost(@ModelAttribute("vo") Experience vo) {
        Optional<Experience> experience = experienceRepo.findById(vo.getRno());
        if (experience.isPresent()) {
        	experience.get().setExperienceText(vo.getExperienceText());
        	experience.get().setExperiencer(vo.getExperiencer());
        	experienceRepo.save(experience.get());
        } else {
        	experienceRepo.save(vo);
        }
        return "redirect:/experience/";
    }
    
	@GetMapping("/{rno}/delete")
    public String delete(@PathVariable("rno") long rno) {
        if (experienceRepo.findById(rno).isPresent()) {
        	experienceRepo.deleteById(rno);
        } else if(HttpStatus.INTERNAL_SERVER_ERROR != null) {
        	return "errors/500";
        }
        
        else {
            return "errors/404";
        }
        return "redirect:/experience/";
    }
}
