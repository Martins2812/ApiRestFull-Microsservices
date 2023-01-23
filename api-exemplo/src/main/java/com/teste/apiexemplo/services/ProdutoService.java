package com.teste.apiexemplo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.teste.apiexemplo.model.Produto;
import com.teste.apiexemplo.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    //Instanciou uma dependência para você
    @Autowired
    private ProdutoRepository produtoRepository;

     /**
     * Método para retornar uma lista de Produtos
     * @return Lista de Produtos.
     */
    public List<Produto> obterTodos(){
        return produtoRepository.obterTodos();

    }

     /**
     * 
     * Método para retornar um produto pelo seu ID.
     * @param id do Produto que será localizado.
     * @return retorna um Produto caso seja encontrado.
     */
    public Optional<Produto> obterPorId(Integer id){
        return produtoRepository.obterPorId(id);
    }

    /**
     * Método para adicionar produto na lista.
     * @param produto que será adicionado.
     * @return Retorna o produto que foi adicionado na lista.
     */
    public Produto adicionar (Produto produto){
        //Poderia ter uma regra de negócio aqui para validar o produto.
        return produtoRepository.adicionar(produto);
    }

    /**
     * Método para deletar o produto por ID.
     * @param id do produto a ser deletado.
     */
    //O método deletar não devolve nada.
    public void deletar(Integer id){
        //Aqui poderia ter uma lógica de validação.
        produtoRepository.deletar(id);
    }

    /**
     * Método para atualizar o produto na lista.
     * @param produto que será atualizado.
     * @param id do produto.
     * @return Retorna o produto atualizado da lista.
     */
    public Produto atualizar(Integer id, Produto produto){
        //Ter uma validação no ID.
        produto.setId(id);

        return produtoRepository.atualizar(produto);
    }
}
