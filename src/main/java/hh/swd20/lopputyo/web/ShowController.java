package hh.swd20.lopputyo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.lopputyo.domain.Category;
import hh.swd20.lopputyo.domain.CategoryRepository;
import hh.swd20.lopputyo.domain.Show;
import hh.swd20.lopputyo.domain.ShowRepository;

@Controller
public class ShowController {

	@Autowired
	private ShowRepository shorepo;

	@Autowired
	private CategoryRepository catrepo;

	// REST return all shows
	@GetMapping("/shows")
	public @ResponseBody List<Show> showListRest() {
		return (List<Show>) shorepo.findAll();
	}

	// REST return show by id
	@GetMapping("/show/{id}")
	public @ResponseBody Optional<Show> findShowRest(@PathVariable("id") Long showId) {
		return shorepo.findById(showId);
	}

	// list of shows
	@GetMapping("/showlist")
	public String getShows(Model model) {
		List<Show> shows = (List<Show>) shorepo.findAll();
		model.addAttribute("shows", shows);
		return "showlist";
	}

	// Empty form to add a new show
	@GetMapping("/addshow")
	public String addshow(Model model) {
		model.addAttribute("show", new Show());
		model.addAttribute("categories", catrepo.findAll());
		return "addshow";
	}

	// Recieve new show from the form and save it
	@PostMapping("/addshow")
	public String saveshow(@ModelAttribute Show show) {
		shorepo.save(show);
		return "redirect:/showlist";
	}
	
	// Delete show
	@GetMapping("/deleteshow/{id}")
	public String deleteShow(@PathVariable("id") Long showId) {
		shorepo.deleteById(showId);
		return "redirect:../showlist";
	}
	
	// Edit show
	@RequestMapping(value= "/editshow/{id}")
	public String editShow(@PathVariable("id") Long showId, Model model){
		model.addAttribute("show", shorepo.findById(showId));
		model.addAttribute("categories", catrepo.findAll());
		return"editshow";
	}
}
