package com.manaCoulby.gestionTicket.Repository;


import com.manaCoulby.gestionTicket.Entity.BaseConnaissance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseConnRepository extends JpaRepository<BaseConnaissance, Integer> {
    public BaseConnaissance findByIdBaseConn(int id);
}
