package com.autobots.automanager.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.modelo.dto.cliente.ClienteAtualizacaoDTO;
import com.autobots.automanager.modelo.dto.cliente.ClienteCadastroDTO;
import com.autobots.automanager.servicos.cliente.AtualizadorClienteServico;
import com.autobots.automanager.servicos.cliente.CadastradorClienteServico;
import com.autobots.automanager.servicos.cliente.ConsultadorClienteServico;
import com.autobots.automanager.servicos.cliente.RemovedorClienteServico;

@RestController
@RequestMapping("/clientes")
public class ClienteControle {

    @Autowired
    private CadastradorClienteServico cadastrador;

    @Autowired
    private ConsultadorClienteServico consultador;

    @Autowired
    private AtualizadorClienteServico atualizador;

    @Autowired
    private RemovedorClienteServico removedor;

    @GetMapping("/{id}")
    public Cliente obterCliente(@PathVariable Long id) {
        return consultador.buscarPorId(id);
    }

    @GetMapping
    public List<Cliente> obterClientes() {
        return consultador.listar();
    }

    @PostMapping
    public Cliente cadastrarCliente(@RequestBody ClienteCadastroDTO cliente) {
        return cadastrador.cadastrar(cliente);
    }

    @PutMapping
    public Cliente atualizarCliente(@RequestBody ClienteAtualizacaoDTO atualizacao) {
        return atualizador.atualizar(atualizacao);
    }

    @DeleteMapping("/{id}")
    public void excluirCliente(@PathVariable Long id) {
        removedor.removerPorId(id);
    }
}