package br.com.votenorestaurante.repository;

import br.com.votenorestaurante.model.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by andrel on 9/12/16.
 */
@RepositoryRestResource
public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {

}
