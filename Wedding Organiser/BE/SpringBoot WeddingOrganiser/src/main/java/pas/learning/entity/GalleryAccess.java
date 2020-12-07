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
@Table(name = "Gallery_access")
public class GalleryAccess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gallery_access_id")
    private int GalleryAccessId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gallery_id", referencedColumnName = "gallery_id")
    private Gallery gallery;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "guest_id", referencedColumnName = "guest_id")
    private Guest guest;
}
