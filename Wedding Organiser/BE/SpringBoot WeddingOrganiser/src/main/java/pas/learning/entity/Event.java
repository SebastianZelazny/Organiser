package pas.learning.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "Event")
public class Event {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "event_id")
   private int eventId;

   @Column(name = "event_date")
   private Date eventDate;

   @Column(name = "event_name")
   private String eventName;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "address_id", referencedColumnName = "address_id")
   private Address address;

   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "account_id", referencedColumnName = "account_id")
   private Account account;
}
