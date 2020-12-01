package pas.learning.entity;

import java.util.Map;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Service")

public class Service {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "service_id")
   private int serviceId;

   @Column(name = "service_name")
   private String serviceName;

   @Column(name = "service_type")
   private Map<String, String> serviceType;

   @Column(name = "description")
   private String description;

   @Column(name = "cost_min")
   private float costMin;

   @Column(name = "cost_max")
   private float costMax;

   @Column(name = "currency")
   private Map<String, String> currency;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "contact_id", referencedColumnName = "contact_id")
   private Contact contact;

   @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
   private ServiceAddress serviceAddress;
}
