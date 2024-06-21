package com.manaCoulby.gestionTicket.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Prioriter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPrioriter;
    private String nomPrioriter;
    @OneToMany
    private List<Ticket> ticket;
}
