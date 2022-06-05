package br.com.produtos.apirest.resources;

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

import br.com.produtos.apirest.models.Produto;
import br.com.produtos.apirest.repository.ProdutoRepository;

@RestController
@RequestMapping(value = "/api") //endpoint "/api"
public class ProdutoResource {

    @Autowired //Indica para o Spring Boot que este é um ponto de injeção, ou seja, utilizará o "@Bean" usado para dizer que o Spring irá gerenciar as instâncias       
    ProdutoRepository produtoRepository;

    @GetMapping("/produtos") //Método "Get", lista todos os produtos salvos no banco de dados
    public List<Produto> listaProdutos(){ // O método "listaProdutos" vai retornar uma lista de produtos quando for feita a requisição 
        return produtoRepository.findAll(); // O "return" indica que a função retornará o produto que foi buscado.
                                            // É usado nos métodos "GET", "POST" e "PUT" (no "DELETE" não é usado pois o item será deletado e não retornará nenhum Produto)
    }

    @GetMapping("/produtos/{id}") //usado para buscar/selecionar um produto específico pelo "id" deste produto
    public Produto listaProdutoUnico(@PathVariable(value = "id") long id){ //@PathVariable neste caso está sendo usado para encontrar o caminho estipulado, no caso
        return produtoRepository.findById(id);                             //o Id que deseja-se encontrar, além da requisição "findById" com o argumento sendo o (id) 
    }
    
    @PostMapping("/produto") //usado para salvar um novo produto
    public Produto salvaProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto); //recebe o produto que será salva como um formato "json", no corpo da requisição, por isso usamos @RequestBody

    }

    @PutMapping("/produto") //usado para atualizar um novo produto 
    public Produto atualizaProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);

    }

    @DeleteMapping("/produto/{id}") //usado para deletar um novo produto (como não retornará nada, utiliza-se o método "void")
    public void deletaProduto(@PathVariable(value = "id") long id){ //Deleta o item desejado pelo id do mesmo
        produtoRepository.deleteById(id);

    }

    
    

}
