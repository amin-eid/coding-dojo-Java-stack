package com.codingdojo.thecode;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class theCodeController {
	@RequestMapping("/")
    public String code() {

			return "index.jsp";
		}

	@RequestMapping(value="/code", method=RequestMethod.POST)
    public String index(@RequestParam(value="code") String mycode) {
    	if (mycode.equals("bushido")) {
    		return "code.jsp";
		}
		else {

	        return "redirect:/err";
		}
	}
    @RequestMapping("/err")
        public String flashMessages(RedirectAttributes redirectAttributes) {
            redirectAttributes.addFlashAttribute("error", "You must train harder!");
            return "redirect:/";
        }

	}   	

