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
@Table(name = "Gallery")
public class Gallery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gallery_id")
    private int galleryId;

    @Column(name = "gallery_name")
    private String galleryName;

    @Column(name = "description")
    private String description;

    @Column(name = "is_private")
    private boolean isPrivate;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "event_id", referencedColumnName = "event_id")
    private Event event;

    @JsonIgnore
    @OneToMany(mappedBy = "gallery", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<File> files;

    @JsonIgnore
    @OneToMany(mappedBy = "gallery", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<GalleryAccess> galleryAccesses;
}
