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
@Table(name = "Guest_table")
public class GuestTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guest_table_id")
    private int guestTableId;

    @Column(name = "position")
    private int position;


    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "table_definition_id",referencedColumnName = "table_definition_id")
    private TableDefinition tableDefinition;

    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "guest_id",referencedColumnName = "guest_id")
    private Guest guest;
}
