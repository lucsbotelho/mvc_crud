package com.fafram.produtos_crud.controller;
import com.fafram.produtos_crud.service.ServiceCategoria;
import com.fafram.produtos_crud.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categoria")
public class controllerCategoria {

    @Autowired
    private ServiceCategoria service;

    @GetMapping("/register")
    public String mostrarPaginaDeRegistro(){
        return "registerCategoriaPage";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Categoria c, Model model){
        Categoria categoria = service.salvarCategoria(c);
        String menssagem = "Categoria" + c.getDescricao() + "salva(o).";
        model.addAttribute("list", menssagem);
        return "registerCategoriaPage";
    }

    @GetMapping("/getAllCategories")
    public String getAllCategories(Model model){
        List<Categoria> categoria = service.verTodosCategoria();
        model.addAttribute("categoria", categoria);
        return "listCategoriaPage";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam Integer id) {
        Categoria categoria = service.procurarPorId(id);
        model.addAttribute("categoria", categoria);
        return "editCategoriaPage";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Categoria categoria) {
        service.atualizarCategoria(categoria);
        return "redirect:getAllCategorias";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        service.deletarCategoria(id);
        return "redirect:getAllCategorias";
    }

}
