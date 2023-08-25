package com.stagiaireapp.Repository;

import com.stagiaireapp.Model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    //All Command On Crud
}