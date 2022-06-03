package br.com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public List<Produto> listaProdutos(){ // O método "listaProdutos" vai retornar uma lista de produtos quando for feita a requisição 
        return produtoRepository.findAll();
    }

    @GetMapping("/produtos/{id}") //usado para selecionar um produto específico pelo "id" deste produto
    public Produto listaProdutoUnico(@PathVariable(value = "id") long id){ 
        return produtoRepository.findById(id);
    }
    
    @PostMapping("/produto") //usado para salvar um novo produto
    public Produto salvaProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);

    }

    @DeleteMapping("/produto") //usado para salvar um novo produto
    public void deletaProduto(@RequestBody Produto produto){
        produtoRepository.delete(produto);

    }

}
