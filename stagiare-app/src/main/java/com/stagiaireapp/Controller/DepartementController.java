package com.stagiaireapp.Controller;

import com.stagiaireapp.Model.Departement;
import com.stagiaireapp.Repository.DepartementRepository;
import com.stagiaireapp.service.Classes.Departementlmp;
import com.stagiaireapp.service.Interfaces.IDepartement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/Departement")
public class DepartementController {
    @Autowired
    private DepartementRepository departementRepository;

    @Autowired
    private IDepartement iDepartement;
    @Autowired
    private Departementlmp departementlmp;

    /**
     * endpoint: pour lister les Departement
     * @return
     */
    @GetMapping
    public List<Departement> getAllDepartement() {
        return  iDepartement.getAllDepartements();
    }

    /**
     * endpoint: pour Lister les Departement par Id
     * @return
     */

    @GetMapping("{id}")
    public Departement getDepartementById(@PathVariable Long id) {
        Departement departement = departementlmp.getDepartementById(id);
        return departement;
    }
    /**
     * endpoint: pour cree les Departement
     * @return
     */
    @PostMapping
    public Departement CreateDepartement(@RequestBody Departement departement){
        Departement departement1 = departementlmp.saveDepartement(departement);
        return departement1;

    }

    /**
     * endpoint: pour Modifiier les Departement par Id
     * @return
     */
    @PutMapping
    public ResponseEntity<Departement> updateDepartement(@PathVariable Long id,@RequestBody Departement departement) {
        Departement updateDepartement = departementlmp.updateDepartement(id, departement);
                return new ResponseEntity<>(updateDepartement, HttpStatus.OK);

    }
    @DeleteMapping("{id}")
    public void deleteDepartement(@PathVariable Long id ){ departementlmp.deleteDepartement(id);}
}

