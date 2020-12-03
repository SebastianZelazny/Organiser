package pas.learning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Map;

@Entity
@Getter
@Setter
@Data
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int addressId;

    @Column(name = "address_type")
    private String addressType;

    @Column(name = "city")
    private String city;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "street")
    private String street;

    @Column(name = "additional_comment")
    private String additionalComment;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "address", fetch = FetchType.LAZY)
    private Event event;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "address", fetch = FetchType.LAZY)
    private ServiceAddress serviceAddress;

    //TODO dopisać  Guest
}
