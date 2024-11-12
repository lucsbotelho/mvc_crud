package com.fafram.produtos_crud.model;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private double preco;
    private int quantidadeEstoque;


    // Criando a relação produto-categoria usando muitos-para-um
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
}
