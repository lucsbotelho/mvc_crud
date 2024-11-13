package com.fafram.produtos_crud.controller;
import com.fafram.produtos_crud.service.ServiceProduto;
import com.fafram.produtos_crud.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/produto")
public class ControllerProduto {

    @Autowired
    private ServiceProduto service;

    @GetMapping("/register")
    public String mostrarPaginaDeRegistro() {
        return "registerProdutoPage";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Produto produto, Model model) {
        Produto p = service.salvarProduto(produto);
        String mensagem = "Produto " + produto.getDescricao() + " salvo(a).";
        model.addAttribute("list", mensagem);
        return "registerProdutoPage";
    }

    @GetMapping("/getAllProduto")
    public String getAllProduto(Model model) {
        List<Produto> produtos = service.verTodosProdutos();
        model.addAttribute("produtos", produtos);
        return "listProdutoPage";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam Long id) {
        Produto produto = service.procurarPorId(id);
        model.addAttribute("produto", produto);
        return "editProdutoPage";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Produto produto) {
        service.atualizarProdutos(produto);
        return "redirect:/produto/getAllProduto";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id) {
        service.deletarProdutos(id);
        return "redirect:/produto/getAllProduto";
    }
}
