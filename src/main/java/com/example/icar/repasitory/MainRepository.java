package com.example.icar.repasitory;

import com.example.icar.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainRepository extends JpaRepository<Item, Long> {

}
