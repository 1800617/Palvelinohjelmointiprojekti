package hh.swd20.lopputyo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.lopputyo.domain.Episode;
import hh.swd20.lopputyo.domain.EpisodeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EpisodeRepositoryTest {
	
	@Autowired
	private EpisodeRepository erepo;
	
	@Test
	public void createNewEpisode() {
		Episode episode1 = new Episode();
		erepo.save(episode1);
		assertThat(episode1.getId()).isNotNull();
	}
	
	@Test
	public void deleteEpisode() {
		Episode episode2 = new Episode();
		erepo.save(episode2);
		Long episodeId = episode2.getId();
		erepo.deleteById(episodeId);
		assertThat(erepo.findById(episodeId).equals(null));
	}
	
	@Test
	public void findByEpisodeTitle() {
		
		//lisätään jakso repoon
		Episode episode3 = new Episode();
		episode3.setName("Testing");
		erepo.save(episode3);
		
		//tarkistetaan löytyykö jaksoa reposta
		List<Episode> episodes = erepo.findByName(episode3.getName());
		assertThat(episodes).hasSize(1);
		assertThat(episodes.get(0).getName()).isEqualTo(episode3.getName());
		
	}

}
