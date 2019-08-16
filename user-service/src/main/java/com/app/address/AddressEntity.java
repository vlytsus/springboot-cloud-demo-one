package com.app.address;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotEmpty
    private String country;

    @NotEmpty
    private String city;

    @NotEmpty
    private String address;

    @NotEmpty
    private String zipCode;
}
