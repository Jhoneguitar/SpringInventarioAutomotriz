package com.nexos.dao;

import com.nexos.domain.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CargoDao extends JpaRepository<Cargo, Long>{
    
}
