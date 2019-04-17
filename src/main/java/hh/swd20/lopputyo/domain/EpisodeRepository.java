package hh.swd20.lopputyo.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface EpisodeRepository extends CrudRepository<Episode, Long>{
	
	List <Episode> findByName(String name);

}