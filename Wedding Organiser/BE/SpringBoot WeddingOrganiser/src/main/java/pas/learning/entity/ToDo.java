package pas.learning.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "ToDo")
public class ToDo {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "todo_id")
   private int toDoId;

   @Column(name = "todo_name")
   private String toDoName;

   @Column(name = "description")
   private String description;

   @Column(name = "priority")
   private int priority;

   @OneToOne(mappedBy = "toDo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   private EventToDo eventToDo;
}
