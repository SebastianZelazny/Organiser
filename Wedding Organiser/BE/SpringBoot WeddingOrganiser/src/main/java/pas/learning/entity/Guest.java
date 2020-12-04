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
@Table(name = "Guest")
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guest_id")
    private int guestId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "sex")
    private String sex;

    @Column(name = "invited")
    private boolean invited;

    @Column(name = "confirmed")
    private String confirmed;

    @Column(name = "guest_type")
    private String guestType;

    @Column(name = "invited_by")
    private String invitedBy;

    @Column(name = "accommodation")
    private boolean accommodation;

    @Column(name = "transport")
    private boolean transport;

    @Column(name = "diet")
    private String diet;

    @Column(name = "additional_comment")
    private String additionalComment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id", referencedColumnName = "contact_id")
    private Contact contact;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "event_id", referencedColumnName = "event_id")
    private Event event;

    @JsonIgnore
    @OneToMany(mappedBy = "guest", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<FileGuestTag> fileGuestTags;
}
