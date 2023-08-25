package com.stagiaireapp.Controller;

import com.stagiaireapp.Repository.ServiceRepository;
import com.stagiaireapp.Model.Service;
import com.stagiaireapp.service.Classes.Servicelmp;
import com.stagiaireapp.service.Interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/Service")
public class ServiceController {
    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private IService iService;
    @Autowired
    private Servicelmp servicelmp;


    /**
     * endpoint: pour lister les Services
     * @return
     */
    @GetMapping
    public List<Service> getAllService() {
        return iService.getAllService();
    }

    /**
     * endpoint: pour create les Services
     * @return
     */
    @PostMapping
    public Service createService(@RequestBody Service service){
        Service service1 = servicelmp.saveService(service);
        return service1;
    }

    /**
     * endpoint: pour Lister les Service par Id
     * @return
     */
    @GetMapping("{id}")
    public ResponseEntity<Service> getServiceById(@PathVariable Long id) {
        Service service = serviceRepository.findById(id).orElseThrow(() ->
                new RuntimeException(" Service Not Exist With Id " + id));
        return  ResponseEntity.ok(service);
    }

    /**
     * endpoint: pour Modifiier les Service par Id
     * @return
     */
    @PutMapping("{id}")
    public ResponseEntity<Service> updateService(@PathVariable Long id,@RequestBody Service service) {
        Service updateService = servicelmp.updateService(id , service);
        return new ResponseEntity<>(updateService, HttpStatus.OK);
    }

    @DeleteMapping
    public void  deleteService(@PathVariable Long id ){servicelmp.deleteService(id);}

}

