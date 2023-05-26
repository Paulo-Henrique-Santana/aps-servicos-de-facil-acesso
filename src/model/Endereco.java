package model;

public class Endereco {

  private String estado;
  private String cidade;
  private String cep;
  private String bairro;

  public Endereco(String estado, String cidade, String cep, String bairro) {
    this.estado = estado;
    this.cidade = cidade;
    this.cep = cep;
    this.bairro = bairro;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  @Override
  public String toString() {
    return "Endereco [estado=" + estado + ", cidade=" + cidade + ", cep=" + cep + ", bairro=" + bairro + "]";
  }
}
