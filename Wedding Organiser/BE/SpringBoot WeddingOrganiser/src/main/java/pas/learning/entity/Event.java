package pas.learning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Data
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

   @JsonIgnore
   @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   private Set<EventToDo> eventToDos;

   @JsonIgnore
   @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   private Set<Gallery> galleries;

   @JsonIgnore
   @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   private Set<Guest> guests;

   @JsonIgnore
   @OneToOne(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   private Budget budget;
}
