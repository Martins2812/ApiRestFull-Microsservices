package com.teste.apiexemplo.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import com.teste.apiexemplo.model.Produto;
import org.springframework.stereotype.Repository;


@Repository
public class ProdutoRepository {
    
    private List<Produto> produtos = new ArrayList<Produto>();
    private Integer ultimoId = 0;

    /**
     * 
     * Método para retornar uma lista de Produtos
     * @return Lista de Produtos.
     */
    public List<Produto> obterTodos(){
        return produtos;
    }

    /**
     * 
     * Método para retornar um produto pelo seu ID.
     * @param id do Produto que será localizado.
     * @return retorna um Produto caso seja encontrado.
     */
    public Optional<Produto> obterPorId(Integer id){
        return produtos
        .stream()
        .filter(produto -> produto.getId() == id)
        .findFirst();
    }

    /**
     * Método para adicionar produto na lista.
     * @param produto que será adicionado.
     * @return Retorna o produto que foi adicionado na lista.
     */
    public Produto adicionar (Produto produto){
        //Vai ser encrementado de 1 em 1.
        ultimoId ++;
        produto.setId(ultimoId);
        produtos.add(produto);
        return produto;
    }

    /**
     * Método para deletar o produto por ID.
     * @param id do produto a ser deletado.
     */
    //O método deletar não devolve nada.
    public void deletar(Integer id){
        produtos.removeIf(produto -> produto.getId() == id);
    }

    /**
     * Método para atualizar o produto na lista.
     * @param produto que será atualizado.
     * @return Retorna o produto atualizado da lista.
     */
    public Produto atualizar(Produto produto){

        //Encontrar o produto na lista
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());
        
        if(produtoEncontrado.isEmpty()){
            throw new InputMismatchException("Produto não encontrado");
        }
        
        //Preciso remover o produto antigo da lista e
        deletar(produto.getId());

        //Depois adiciono o  produto atualizado na lista
        produtos.add(produto);

        return produto;
    }
}
