package com.rv.tour.repository;

import com.rv.tour.domain.User;
import com.rv.tour.domain.Visit;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {
    List<Visit> findByUser(User user);
}
