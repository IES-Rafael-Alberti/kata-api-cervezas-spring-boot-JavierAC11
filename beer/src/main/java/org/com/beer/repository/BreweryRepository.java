package org.com.beer.repository;

import org.com.beer.entities.Beers;
import org.com.beer.entities.Brewery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreweryRepository extends JpaRepository<Brewery, Long> {

}
