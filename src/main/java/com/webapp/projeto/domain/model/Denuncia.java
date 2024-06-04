package com.webapp.projeto.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "denuncias")
public class Denuncia {


    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "evento_id", referencedColumnName = "id")
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserInfo userInfo;

    @Column(name = "registro", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false)
    private LocalDateTime registro = LocalDateTime.now();

    private Boolean permanece;

    public Denuncia(Evento evento, UserInfo userInfo, Boolean permanece) {
        this.evento = evento;
        this.userInfo = userInfo;
        this.permanece = permanece;
    }
}
