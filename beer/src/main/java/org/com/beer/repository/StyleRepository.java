package org.com.beer.repository;

import org.com.beer.entities.Beers;
import org.com.beer.entities.Style;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StyleRepository extends JpaRepository<Style, Long> {

}
