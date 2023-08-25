package com.stagiaireapp.Repository;
import com.stagiaireapp.Model.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepository extends JpaRepository<Departement, Long> {
    //all Command on Crud
}
