package com.fafram.produtos_crud.controller;
import com.fafram.produtos_crud.service.ServiceCliente;
import com.fafram.produtos_crud.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/cliente")
public class controllerClient {

    @Autowired
    private ServiceCliente service;

    @GetMapping("/register")
    public String mostrarPaginaDeRegistro(){
        return "registerClientePage";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Cliente cl, Model model){
        Cliente cliente = service.salvarCliente(cl);
        String menssagem = "Cliente" + cl.getNome() + "salva(o).";
        model.addAttribute("list", menssagem);
        return "registerClientePage";
    }

    @GetMapping("/getAllCliente")
    public String getAllCliente(Model model){
        List<Cliente> cliente = service.verTodosClientes();
        model.addAttribute("cliente", cliente);
        return "listClientePage";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam Long id) {
        Cliente cliente = service.procurarPorId(id);
        model.addAttribute("categoria", cliente);
        return "editClientePage";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Cliente cliente) {
        service.atualizarCliente(cliente);
        return "redirect:getAllCliente";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id) {
        service.deletarCliente(id);
        return "redirect:getAllCliente";
    }

}
