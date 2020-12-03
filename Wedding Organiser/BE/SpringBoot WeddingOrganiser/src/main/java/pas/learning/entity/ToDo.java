package pas.learning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Data
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

   @JsonIgnore
   @OneToMany(mappedBy = "toDo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   private Set<EventToDo> eventToDo;
}
