package org.sig.sentiment_management.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "CLIENT")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id;
    @Column(unique = true)
    private String email;
    private String telephone;
    private Date creation;
    @Column(name = "mis_a_jour")
    private Date misAjour;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
    private List<Sentiment> sentiments;

}
