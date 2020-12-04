package pas.learning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Map;
import java.util.Set;

@Entity
@Getter
@Setter
@Data
@Table(name = "File_guest_tag")
public class FileGuestTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_guest_tag_id")
    private int fileGuestTagId;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "file_id", referencedColumnName = "file_id")
    private File file;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "guest_id", referencedColumnName = "guest_id")
    private Guest guest;
}
