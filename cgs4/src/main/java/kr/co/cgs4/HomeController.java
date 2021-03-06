package kr.co.cgs4;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.cgs4.command.Command;
import kr.co.cgs4.command.IndexCommand;
import kr.co.cgs4.dto.FilmDTO;
import kr.co.cgs4.dto.ScreenDTO;
import kr.co.cgs4.util.Constant;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	Command command = null;

	private JdbcTemplate template;

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//
//		String formattedDate = dateFormat.format(date);
//
//		model.addAttribute("serverTime", formattedDate);
//
//		return "home";
//	}
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request, Model model) {
		System.out.println("index()");
		model.addAttribute("request", request);
		command = new IndexCommand();
		command.execute(model);
		return "index";
	}

	// @RequestMapping("/movie")
	// public String movie(HttpServletRequest request, Model model){
	// System.out.println("movie()");
	// TestDAO dao = new TestDAO();
	// FilmDTO fdto = dao.film();
	// model.addAttribute("test", fdto);
	// return "movie";
	// }
	//
	// @RequestMapping("/movie_list")
	// public String movie_list(Model model){
	// System.out.println("movie_list()");
	// TestDAO dao = new TestDAO();
	// FilmDTO fdto = dao.film();
	// model.addAttribute("test", fdto);
	// return "movie_list";
	// }

	@RequestMapping("/contact")
	public String contact(Model model) {
		System.out.println("contact()");
		return "contact";
	}


	// @RequestMapping("/signup")
	// public String signup(Model model){
	// System.out.println("signup()");
	// return "signup";
	// }

}
