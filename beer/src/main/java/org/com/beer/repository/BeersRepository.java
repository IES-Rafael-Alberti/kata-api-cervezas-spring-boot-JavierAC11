package org.com.beer.repository;

import org.com.beer.entities.Beers;
import org.springframework.data.jpa.repository.JpaRepository;

interface BeersRepository extends JpaRepository<Beers, Long> {

}