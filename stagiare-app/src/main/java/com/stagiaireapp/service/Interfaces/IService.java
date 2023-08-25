package com.stagiaireapp.service.Interfaces;

import com.stagiaireapp.Model.Departement;
import com.stagiaireapp.Model.Service;

import java.util.List;

public interface IService {

    public List<Service> getAllService ();
    public Service saveService(Service service);
    public Service getServiceById(Long id);
    public Service updateService(Long id, Service service);
    public  void deleteService(Long id);


}
