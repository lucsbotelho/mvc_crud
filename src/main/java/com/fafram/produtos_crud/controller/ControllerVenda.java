package com.fafram.produtos_crud.controller;

import com.fafram.produtos_crud.service.ServiceVenda;
import com.fafram.produtos_crud.model.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/venda")
public class ControllerVenda {

    @Autowired
    private ServiceVenda service;

    @GetMapping("/register")
    public String mostrarPaginaDeRegistro() {
        return "registerVendaPage";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Venda venda, Model model) {
        Venda v = service.salvarVenda(venda);
        String mensagem = "Venda " + venda.getId() + " registrada.";
        model.addAttribute("list", mensagem);
        return "registerVendaPage";
    }

    @GetMapping("/getAll")
    public String getAllVenda(Model model) {
        List<Venda> vendas = service.verTodasVendas();
        model.addAttribute("vendas", vendas);
        return "listVendaPage";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam Long id) {
        Venda venda = service.procurarPorId(id);
        model.addAttribute("venda", venda);
        return "editVendaPage";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Venda venda) {
        service.atualizarVendas(venda);
        return "redirect:/venda/getAll";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id) {
        service.deletarVendas(id);
        return "redirect:/venda/getAll";
    }
}