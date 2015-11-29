package com.rv.tour.repository;

import com.rv.tour.domain.City;
import com.rv.tour.domain.State;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedNativeQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findByState(State state);

    @Query("select c from City c where c.cityName=:cityName and c.state.abbreviation=:stateAbbreviation")
    City findCityByNameAndStateAbbreviation(@Param("cityName") String cityName, @Param("stateAbbreviation") String stateAbbreviation);
}
