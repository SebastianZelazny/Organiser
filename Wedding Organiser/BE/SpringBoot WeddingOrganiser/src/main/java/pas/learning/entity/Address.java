package pas.learning.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Address")
public class Address {
    private  int addressId;
    private String address_type;
    private String city;
    private String postal_code;
    private String street;
    private String additional_comment;
}
