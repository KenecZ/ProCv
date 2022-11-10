package pe.edu.upc.procv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.procv.model.ServiceType;
import pe.edu.upc.procv.repository.ServiceTypeRepository;
import pe.edu.upc.procv.service.ServiceTypeService;

import java.util.List;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }

    @Override
    public ServiceType findById(int idServiceType) {
        return serviceTypeRepository.findById(idServiceType).get();
    }

    @Override
    public ServiceType create(ServiceType serviceType) {
        return serviceTypeRepository.save(serviceType);
    }

    @Override
    public ServiceType update(ServiceType serviceType) {
        return serviceTypeRepository.save(serviceType);
    }

    @Override
    public void deleteById(int idServiceType) {
        serviceTypeRepository.deleteById(idServiceType);
    }
}
