package br.com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.produtos.apirest.models.Produto;
import br.com.produtos.apirest.repository.ProdutoRepository;

@RestController
@RequestMapping(value = "/api") //endpoint "/api"
public class ProdutoResource {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/produtos") //Método "Get", lista todos os produtos salvos no banco de dados
    public List<Produto> listaProdutos(){ // O método "listaProdutos" vai retornar uma lista de produtos, 
        return produtoRepository.findAll();
    }

    @GetMapping("/produtos/{id}") 
    public Produto listaProdutoUnico(@PathVariable(value = "id") long id){ //usado para selecionar um produto específico pelo "id" deste produto
        return produtoRepository.findById(id);
    }
    
}
