package br.ufes.model;

public final class Cliente {

    private String nome;
    private String CNPJOuCPF;

    public Cliente(String nome, String codigo) {
        setNome(nome);
        setCNPJOuCPF(codigo);
    }

    public String getNome() {
        return nome;
    }

    public String getCnpjOuCpf() {
        return CNPJOuCPF;
    }
    
    public void setNome(String nome){
        if (nome == null) {
            throw new IllegalArgumentException("Nome inválido");
        }
        this.nome = nome;
    }
    
    public void setCNPJOuCPF(String codigo){
        if (codigo == null) {
            throw new IllegalArgumentException("CNPJ/CPF inválido");
        }
        this.CNPJOuCPF = codigo;
    }

    @Override
    public String toString() {
        return "Cliente: " + nome + ", CNPJ/CPF = " + CNPJOuCPF;
    }

}
