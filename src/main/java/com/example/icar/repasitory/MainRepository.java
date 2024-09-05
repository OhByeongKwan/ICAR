package com.example.icar.repasitory;

import com.example.icar.domain.Icar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainRepository extends JpaRepository<Icar, Long> {

}
