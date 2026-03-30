package io.github.lucas_arcanjo.produtosapi.controller;

import io.github.lucas_arcanjo.produtosapi.model.Produto;
import io.github.lucas_arcanjo.produtosapi.repository.ProdutoRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutosController {

    ProdutoRepository produtoRepository;

    public ProdutosController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {

        var id = UUID.randomUUID().toString();
        produto.setId(id);
        this.produtoRepository.save(produto);
        System.out.println("Produto recebido: " + produto);
        return produto;
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable("id") String id) {
        return this.produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") String id) {
        this.produtoRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable("id") String id,
                          @RequestBody Produto produto) {
        produto.setId(id);
        this.produtoRepository.save(produto);
    }

    @GetMapping
    public List<Produto> buscarPorNome(@RequestParam("nome") String nome) {
        return this.produtoRepository.findByNome(nome);
    }
}
