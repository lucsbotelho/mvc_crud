package com.fafram.produtos_crud.utils;

public class ProdutoNaoEncontradoException extends RuntimeException{

    public ProdutoNaoEncontradoException(){
        super();
    }

    public ProdutoNaoEncontradoException(String mensagem){
        super(mensagem);
    }

}
