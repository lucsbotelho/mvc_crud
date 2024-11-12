package com.fafram.produtos_crud.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class VendaProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_venda;

    private int id_produto;
    private int quantidade;
}
