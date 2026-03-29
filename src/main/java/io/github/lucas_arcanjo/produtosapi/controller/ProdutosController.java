package io.github.lucas_arcanjo.produtosapi.controller;

import io.github.lucas_arcanjo.produtosapi.model.Produto;
import io.github.lucas_arcanjo.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
