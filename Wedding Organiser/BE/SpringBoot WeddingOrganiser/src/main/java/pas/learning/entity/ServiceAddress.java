package pas.learning.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Service_address")
public class ServiceAddress {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "service_address_id")
   private int serviceAddressId;

   @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   @JoinColumn(name = "address_id", referencedColumnName = "address_id")
   private Address address;

   @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   @JoinColumn(name = "service_id", referencedColumnName = "service_id")
   private Service service;
}