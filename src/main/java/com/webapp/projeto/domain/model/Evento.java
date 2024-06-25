package com.webapp.projeto.domain.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.webapp.projeto.domain.enumeration.StatusEvento;
import jakarta.persistence.*;
import lombok.Builder;
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
    private Double latitude;
    private Double longitude;

    @Column(name = "registro", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false)
    private LocalDateTime registro;

    @Enumerated(EnumType.STRING)
    private StatusEvento status;

    @OneToMany(mappedBy = "evento")
    private List<Denuncia> denuncias = new ArrayList<>();
}
