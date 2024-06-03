package com.webapp.projeto.domain.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import com.webapp.projeto.domain.enumeration.StatusEvento;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "eventos")
public class Evento {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID id;

    private String descricao;
    private Long latitude;
    private Long longitude;

    @Column(name = "registro", columnDefinition = "TIMESTAMP")
    private LocalDateTime registro;

    @Enumerated(EnumType.STRING)
    private StatusEvento status;
}
