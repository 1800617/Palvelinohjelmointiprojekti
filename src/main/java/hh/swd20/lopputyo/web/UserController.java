package hh.swd20.lopputyo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	// Login page
		@RequestMapping(value="/login")
		public String login() {
			return "login";
		}

}
