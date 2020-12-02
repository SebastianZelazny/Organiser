package pas.learning.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Data
@Table(name = "Event_todo")
public class EventToDo {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "event_todo_id")
   private int eventToDoId;

   @Column(name = "todo_name")
   private String toDoName;

   @Column(name = "description")
   private String description;

   @Column(name = "event_todo_date")
   private Date eventTodoDate;

   @Column(name = "priority")
   private int priority;

   @Column(name = "notes")
   private String notes;

   @OneToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH})
   @JoinColumn(name = "todo_id", referencedColumnName = "todo_id")
   private ToDo toDo;

   @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH}, fetch = FetchType.LAZY)
   @JoinColumn(name = "event_id", referencedColumnName = "event_id")
   private Event event;
}
