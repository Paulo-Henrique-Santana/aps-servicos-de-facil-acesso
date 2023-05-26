package model;

import java.util.ArrayList;

public class Contratante extends Pessoa {
  private String numeroIdentificacao;
  private ArrayList<Servico> servicos = new ArrayList<Servico>();

  public Contratante(String nome, String email, String senha,
      String numeroIdentificacao) {
    super(nome, email, senha);
    this.numeroIdentificacao = numeroIdentificacao;
  }

  public String getNumeroIdentificacao() {
    return numeroIdentificacao;
  }

  public void setNumeroIdentificacao(String numeroIdentificacao) {
    this.numeroIdentificacao = numeroIdentificacao;
  }

  public ArrayList<Servico> getServicos() {
    return servicos;
  }

  public void setServico(Servico servico) {
    this.servicos.add(servico);
  }

  @Override
  public String toString() {
    return "Contratante [nome=" + nome + ", email=" + email + ", senha=" + senha
        + ", identificao=" + numeroIdentificacao + ", servicos=" + servicos + "]";
  }
}
