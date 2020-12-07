package pas.learning.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;
import java.util.Set;

@Entity
@Getter
@Setter
@Data
@Table(name = "Table_definition")
public class TableDefinition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_definition_id")
    private int tableDefinitionId;

    @Column(name = "table_name")
    private String tableName;

    @Column(name = "table_type")
    private String tableType;

    @Column(name = "table_size")
    private int tableSize;

    @Column(name = "additional_comment")
    private String additionalComment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id", referencedColumnName = "event_id")
    private Event event;

    @JsonIgnore
    @OneToMany(mappedBy = "tableDefinition",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<GuestTable> guestTables;
}
