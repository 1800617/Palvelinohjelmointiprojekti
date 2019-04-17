package hh.swd20.lopputyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ShowRepository extends CrudRepository<Show, Long>{
	
	List <Show> findByTitle(String title);

}
