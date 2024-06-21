package com.manaCoulby.gestionTicket.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategorie;
    private String nomCategorie;
    @OneToMany
    private List<Ticket> ticket;
}
