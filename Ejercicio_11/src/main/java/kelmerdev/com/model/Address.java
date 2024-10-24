package kelmerdev.com.model;

import lombok.Data;

@Data
class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;
}