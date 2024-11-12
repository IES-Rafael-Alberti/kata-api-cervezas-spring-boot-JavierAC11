package org.com.beer.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Builder
public class Beers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "breweryId")
    @JsonBackReference
    private Brewery brewery;

    @ManyToOne
    @JoinColumn(name = "catId")
    @JsonBackReference
    private Category category;

    @ManyToOne
    @JoinColumn(name = "styleId")
    @JsonBackReference
    private Style style;

    private String name;
    private float abv;
    private float ibu;
    private float srm;
    private Long upc;
    private String filePath;
    private String description;
    private Long addUser;
    private Date lastModified;

}
