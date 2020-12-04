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
@Table(name = "File")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private int fileId;

    @Column(name = "file_type")
    private String fileType;

    @Column(name = "file_size")
    private int fileSize;

    @Column(name = "file_description")
    private String fileDescription;

    @Column(name = "upload_date")
    private Date uploadDate;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "gallery_id", referencedColumnName = "gallery_id")
    private Gallery gallery;

    @JsonIgnore
    @OneToMany(mappedBy = "file", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<FileTag> fileTags;

    @JsonIgnore
    @OneToMany(mappedBy = "file", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<FileGuestTag> fileGuestTags;
}
