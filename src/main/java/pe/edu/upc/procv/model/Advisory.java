package pe.edu.upc.procv.model;

import javax.persistence.*;

@Entity
@Table(name="advisories")
public class Advisory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_advisory")
    private int idAdvisory;

    @Column(name="date")
    private String date;

    @ManyToOne
    @JoinColumn(name="id_service_type")
    private ServiceType serviceType;

    @ManyToOne
    @JoinColumn(name="id_teacher")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name="id_student")
    private Student student;

    public Advisory() {
    }

    public Advisory(int idAdvisory, String date, ServiceType serviceType, Teacher teacher, Student student) {
        this.idAdvisory = idAdvisory;
        this.date = date;
        this.serviceType = serviceType;
        this.teacher = teacher;
        this.student = student;
    }

    public int getIdAdvisory() {
        return idAdvisory;
    }

    public void setIdAdvisory(int idAdvisory) {
        this.idAdvisory = idAdvisory;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
