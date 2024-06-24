package com.manaCoulby.gestionTicket.service;


import com.manaCoulby.gestionTicket.Entity.Categorie;
import com.manaCoulby.gestionTicket.Entity.Prioriter;
import com.manaCoulby.gestionTicket.Entity.Statut;
import com.manaCoulby.gestionTicket.Entity.Ticket;
import com.manaCoulby.gestionTicket.Repository.TicketRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private CategorieService categorieService;
    @Autowired
    private PrioriterService prioriterService;
    @Autowired
    private StatutService statutService;

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> getTicketById(int id) {
        return ticketRepository.findAllById(id);
    }

    public Ticket createTicket(Ticket ticket) {
        // Récupérer et vérifier la catégorie
        Categorie category = this.categorieService.recupererParNom(ticket.getCategorie().getNomCategorie());
        if (category == null) {
            throw new IllegalArgumentException("La catégorie spécifiée n'existe pas.");
        }
        ticket.setCategorie(category);

        // Récupérer et vérifier la priorité
        Prioriter prioriter = this.prioriterService.recupererParNom(ticket.getPrioriter().getNomPrioriter());
        if (prioriter == null) {
            throw new IllegalArgumentException("La priorité spécifiée n'existe pas.");
        }
        ticket.setPrioriter(prioriter);

        // Récupérer et vérifier le statut
        Statut statut = this.statutService.recupererParTitre(ticket.getStatut().getTitre());
        if (statut == null) {
            throw new IllegalArgumentException("Le statut spécifié n'existe pas.");
        }
        ticket.setStatut(statut);

        // Sauvegarder le ticket
        return ticketRepository.save(ticket);
    }



//    public Ticket createTicket(Ticket ticket) {
//        Categorie category = this.categorieService.recupererParNom(ticket.getCategorie().getNomCategorie());
//        ticket.setCategorie(category);
//        Prioriter prioriter = this.prioriterService.recupererParNom(ticket.getPrioriter().getNomPrioriter());
//        ticket.setPrioriter(prioriter);
//        Statut statut = this.statutService.recupererParTitre(ticket.getStatut().getTitre());
//        ticket.setStatut(statut);
//        return ticketRepository.save(ticket);
//    }

    public Ticket updateTicket(int id, Ticket ticket) {
       ticket.setId(id);
       return ticketRepository.save(ticket);
    }

    public void deleteTicket(int id) {
        ticketRepository.deleteById(id);
    }

    public Optional<Ticket> findAllById(int id) {
        return ticketRepository.findAllById(id);
    }
}
