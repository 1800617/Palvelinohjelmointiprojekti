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

import hh.swd20.lopputyo.domain.Episode;
import hh.swd20.lopputyo.domain.EpisodeRepository;
import hh.swd20.lopputyo.domain.Show;
import hh.swd20.lopputyo.domain.ShowRepository;

@Controller
public class EpisodeController {

	@Autowired
	private ShowRepository shorepo;

	@Autowired
	private EpisodeRepository epirepo;

	// REST return all episode
	@GetMapping("episodes")
	public @ResponseBody List<Episode> episodeListRest() {
		return (List<Episode>) epirepo.findAll();
	}

	// REST return episode by id
	@GetMapping("/episode/{id}")
	public @ResponseBody Optional<Episode> findEpisodeRest(@PathVariable("id") Long episodeId) {
		return epirepo.findById(episodeId);
	}

	// Empty form to add a new episode
	@GetMapping("/addepisode")
	public String addEpisode(Model model) {
		model.addAttribute("episode", new Episode());
		model.addAttribute("shows", shorepo.findAll());
		return "addepisode";
	}

	// Recieve new episode from the form and save it
	@PostMapping("/addepisode")
	public String saveEpisode(@ModelAttribute Episode episode) {
		epirepo.save(episode);
		return "redirect:/showlist";
	}

	// Delete episode
	@GetMapping("/deleteepisode/{id}")
	public String deleteEpisode(@PathVariable("id") Long episodeId) {
		epirepo.deleteById(episodeId);
		return "redirect:../showlist";
	}

	// Edit episode
	@RequestMapping(value = "/editepisode/{id}")
	public String editEpisode(@PathVariable("id") Long episodeId, Model model) {
		model.addAttribute("episode", epirepo.findById(episodeId));
		model.addAttribute("shows", shorepo.findAll());
		return "editepisode";
	}

}
