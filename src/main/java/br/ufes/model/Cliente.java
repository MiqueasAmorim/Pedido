package br.ufes.model;

public final class Cliente {

    private String nome;
    private String cnpjOuCpf;

    public Cliente(String nome, String codigo) {
        setNome(nome);
        setCnpjOuCpf(codigo);
    }

    public String getNome() {
        return nome;
    }

    public String getCnpjOuCpf() {
        return cnpjOuCpf;
    }
    
    public void setNome(String nome){
        if (nome == null) {
            throw new IllegalArgumentException("Nome inválido");
        }
        this.nome = nome;
    }
    
    public void setCnpjOuCpf(String codigo){
        if (codigo == null) {
            throw new IllegalArgumentException("CNPJ/CPF inválido");
        }
        this.cnpjOuCpf = codigo;
    }

    @Override
    public String toString() {
        return "Cliente: " + nome + ", CNPJ/CPF = " + cnpjOuCpf;
    }

}
