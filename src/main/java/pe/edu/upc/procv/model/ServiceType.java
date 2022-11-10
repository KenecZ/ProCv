package pe.edu.upc.procv.model;

import javax.persistence.*;

@Entity
@Table(name="service_types")
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_service_type")
    private int idServiceType;

    @Column(name="description")
    private String description;

    public ServiceType() {
    }

    public ServiceType(int idServiceType, String description) {
        this.idServiceType = idServiceType;
        this.description = description;
    }

    public int getIdServiceType() {
        return idServiceType;
    }

    public void setIdServiceType(int idServiceType) {
        this.idServiceType = idServiceType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
