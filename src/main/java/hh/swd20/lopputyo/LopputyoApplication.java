package hh.swd20.lopputyo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.lopputyo.domain.Category;
import hh.swd20.lopputyo.domain.CategoryRepository;
import hh.swd20.lopputyo.domain.Episode;
import hh.swd20.lopputyo.domain.EpisodeRepository;
import hh.swd20.lopputyo.domain.Show;
import hh.swd20.lopputyo.domain.ShowRepository;
import hh.swd20.lopputyo.domain.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class LopputyoApplication {

	private static final Logger log = LoggerFactory.getLogger(LopputyoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LopputyoApplication.class, args);
	}

	@Bean
	public CommandLineRunner applicationDemo(CategoryRepository catrepo, ShowRepository shorepo,
			EpisodeRepository epirepo, hh.swd20.lopputyo.domain.UserRepository urepository) {
		return (args) -> {

			log.info("Save categories");

			// name
			catrepo.save(new Category("Good shows"));
			catrepo.save(new Category("Bad shows"));

			log.info("Save shows");
			// title, description, category
			shorepo.save(new Show("Santa Clarita Diet",
					"Sheila and Joel are married real estate agents in Santa Clarita, California. "
					+ "When Sheila dies, their lives take a dark turn. ",
					catrepo.findByName("Bad shows").get(0)));

			shorepo.save(new Show("Teletubbies",
					"In this television show for babies,"
							+ " the four colourful Teletubbies coo and play in idyllic Teletubbyland. "
							+ "They repeat fun, infant-pleasing activities such as rolling on the ground, "
							+ "laughing, running about, and watching real children on the televisions on "
							+ "their bellies. Mysterious pinwheels and telephones rise out of the meadow to "
							+ "loosely direct the day's activities. The Sun, featuring a baby's face, comments "
							+ "on the proceedings with baby noises, and it rises and sets to begin and end the show.",
					catrepo.findByName("Good shows").get(0)));
			/*
			 * log.info("Save seasons"); //title, show searepo.save(new Season("Season 1",
			 * shorepo.findByTitle("Teletubbies").get(0)));
			 */

			log.info("Save episodes");
			// title, episodenumber, season, description, show
			epirepo.save(new Episode("Ned's Bicycle", 1, "Season 1", "A flag appears in Teletubbyland.",
					shorepo.findByTitle("Teletubbies").get(0)));

			epirepo.save(new Episode("Our Pig Winnie", 2, "Season 1", "Teletubbies love to dance.",
					shorepo.findByTitle("Teletubbies").get(0)));

			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$04$gwAC6CuKCZtKc3PYj8BQIOV0eI3aLRfNhzkkY2V0r4acDWyOQFnUi", "USER");
			User user2 = new User("admin", "$2a$04$3AhynkXH9Uuek6HciGbqDue0Kg6PI2goUMEa2ybZSCLt.uHC8bQYK", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);

		};

	}

}
