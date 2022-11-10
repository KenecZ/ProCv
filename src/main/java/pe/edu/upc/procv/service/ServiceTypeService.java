package pe.edu.upc.procv.service;

import pe.edu.upc.procv.model.ServiceType;

import java.util.List;

public interface ServiceTypeService {
    List<ServiceType> findAll();
    ServiceType findById(int idServiceType);
    ServiceType create(ServiceType serviceType);
    ServiceType update(ServiceType serviceType);
    void deleteById(int idServiceType);
}
