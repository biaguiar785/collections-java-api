package org.example.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> itens;

    public CarrinhoDeCompras() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        itens.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        List<Item> itensParaRemover = new ArrayList<>();
        if (!itens.isEmpty()) {
            for (Item i : itens) {
                if (i.getNome().equalsIgnoreCase(nome)) {
                    itensParaRemover.add(i);
                }
            }
            itens.removeAll(itensParaRemover);
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    public double calcularValorTotal() {
        double valorTotal = 0d;
        if (!itens.isEmpty()) {
            for (Item item : itens) {
                double valorItem = item.getPreco() * item.getQuantidade();
                valorTotal += valorItem;
            }
            return valorTotal;
        } else {
            throw new RuntimeException("A lista esta vazia");
        }
    }

    public void exibirItens() {
        if (!itens.isEmpty()) {
            System.out.println(this.itens);
        } else {
            System.out.println("A lista esta vazia");
        }

    }

    @Override
    public String toString() {
        return "CarrinhoDeCompras{" +
                "itens=" + itens +
                '}';
    }

    public static void main(String[] args){
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        carrinhoDeCompras.adicionarItem("Livro", 20d, 5);
        carrinhoDeCompras.adicionarItem("Caderno", 10d, 3);
        carrinhoDeCompras.adicionarItem("Livro de pintar", 10d, 2);

        carrinhoDeCompras.exibirItens();

        carrinhoDeCompras.removerItem("Livro");

        carrinhoDeCompras.exibirItens();

        System.out.println("O valor total da compra é " + carrinhoDeCompras.calcularValorTotal());
    }
}