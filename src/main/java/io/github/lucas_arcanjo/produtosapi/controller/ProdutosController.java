package io.github.lucas_arcanjo.produtosapi.controller;

import io.github.lucas_arcanjo.produtosapi.model.Produto;
import io.github.lucas_arcanjo.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

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
        Optional<Produto> produto = this.produtoRepository.findById(id);
        return produto.isPresent() ? produto.get() : null;
    }
}
