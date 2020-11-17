package br.ufes.model;

public final class Cliente {

    private String nome;
    private String CnpjOuCpf;

    public Cliente(String nome, String codigo) {
        setNome(nome);
        setCnpjOuCpf(codigo);
    }

    public String getNome() {
        return nome;
    }

    public String getCnpjOuCpf() {
        return CnpjOuCpf;
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
        this.CnpjOuCpf = codigo;
    }

    @Override
    public String toString() {
        return "Cliente: " + nome + ", CNPJ/CPF = " + CnpjOuCpf;
    }

}
