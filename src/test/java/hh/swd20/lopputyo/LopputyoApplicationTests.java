package hh.swd20.lopputyo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.lopputyo.web.EpisodeController;
import hh.swd20.lopputyo.web.ShowController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LopputyoApplicationTests {

	@Autowired
	private ShowController controller;
	
	@Autowired
	private EpisodeController controller2;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
	
	@Test
	public void contextLoads2() throws Exception {
		assertThat(controller2).isNotNull();
	}
	
}
