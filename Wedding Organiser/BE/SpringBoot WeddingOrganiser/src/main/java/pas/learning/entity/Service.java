package pas.learning.entity;

import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
@Table(name = "Service")
public class Service {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "service_id")
   private int serviceId;

   @Column(name = "service_name")
   private String serviceName;

   @Column(name = "service_type")
   private String serviceType;

   @Column(name = "description")
   private String description;

   @Column(name = "cost_min")
   private float costMin;

   @Column(name = "cost_max")
   private float costMax;

   @Column(name = "currency")
   private String currency;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "contact_id", referencedColumnName = "contact_id")
   private Contact contact;

   @JsonIgnore
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "service",  fetch = FetchType.LAZY)
   private Set<ServiceAddress> serviceAddresses;

   @JsonIgnore
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "service",  fetch = FetchType.LAZY)
   private Set<EventExpense> eventExpenses;
}
