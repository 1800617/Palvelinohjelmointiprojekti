package hh.swd20.lopputyo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.lopputyo.domain.Show;
import hh.swd20.lopputyo.domain.ShowRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ShowRepositoryTest {

	@Autowired
	private ShowRepository srepo;

	@Test
	public void createNewShow() {
		Show show1 = new Show();
		srepo.save(show1);
		assertThat(show1.getId()).isNotNull();
	}
	
	@Test
	public void deleteShow() {
		Show show2 = new Show();
		srepo.save(show2);
		Long showId = show2.getId();
		srepo.deleteById(showId);
		assertThat(srepo.findById(showId).equals(null));
	}
	
	@Test
	public void findByShowTitle() {
		
		//lisätään sarja repoon
		Show show3 = new Show();
		show3.setTitle("Testing");
		srepo.save(show3);
		
		//tarkistetaan löytyykö sarjaa reposta
		List<Show> shows = srepo.findByTitle(show3.getTitle());
		assertThat(shows).hasSize(1);
		assertThat(shows.get(0).getTitle()).isEqualTo(show3.getTitle());
		
	}

}
