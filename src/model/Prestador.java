package model;

public class Prestador extends Pessoa {
  private String cpf;
  private String telefone;
  private Endereco endereco;
  private Curriculo curriculo;

  public Prestador(String nome, String email, String senha, String cpf, String telefone,
      Endereco endereco,
      Curriculo curriculo) {
    super(nome, email, senha);
    this.cpf = cpf;
    this.telefone = telefone;
    this.endereco = endereco;
    this.curriculo = curriculo;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }

  public Curriculo getCurriculo() {
    return curriculo;
  }

  public void setCurriculo(Curriculo curriculo) {
    this.curriculo = curriculo;
  }

  @Override
  public String toString() {
    return "Prestador [nome=" + nome + ", email=" + email + ", senha=" + senha
        + ", cpf=" + cpf + ", Endereco=" + endereco.toString() + ", Curriculo=" + curriculo.toString() + "]";
  }
}
