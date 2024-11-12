package com.fafram.produtos_crud.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;

    private String nome;
    private String email;

    @OneToMany(mappedBy = "cliente")
    private List<Venda> venda;

}
