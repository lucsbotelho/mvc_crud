package com.fafram.produtos_crud.controller;

import com.fafram.produtos_crud.service.ServiceVendaProduto;
import com.fafram.produtos_crud.model.VendaProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/vendaProduto")
public class ControllerVendaProduto {

    @Autowired
    private ServiceVendaProduto service;

    @GetMapping("/register")
    public String mostrarPaginaDeRegistro() {
        return "registerVendaProdutoPage";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute VendaProduto vendaProduto, Model model) {
        VendaProduto vp = service.salvarVendaProduto(vendaProduto);
        String mensagem = "VendaProduto " + vendaProduto.getId_venda() + " registrada.";
        model.addAttribute("list", mensagem);
        return "registerVendaProdutoPage";
    }

    @GetMapping("/getAll")
    public String getAllVendaProduto(Model model) {
        List<VendaProduto> vendaProdutos = service.verTodasVendaDoProduto();
        model.addAttribute("vendaProdutos", vendaProdutos);
        return "listVendaProdutoPage";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam Long id) {
        VendaProduto vendaProduto = service.procurarPorId(id);
        model.addAttribute("vendaProduto", vendaProduto);
        return "editVendaProdutoPage";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute VendaProduto vendaProduto) {
        service.atualizarvendaDoProduto(vendaProduto);
        return "redirect:/vendaProduto/getAll";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id) {
        service.deletarvendaDoProduto(id);
        return "redirect:/vendaProduto/getAll";
    }
}
