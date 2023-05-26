package model;

import java.util.ArrayList;

public class Servico {
  private String titulo;
  private Endereco endereco;
  private String descricao;
  private ArrayList<Prestador> candidatos = new ArrayList<Prestador>();

  public Servico(String titulo, Endereco endereco, String descricao) {
    this.titulo = titulo;
    this.endereco = endereco;
    this.descricao = descricao;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }

  public String getTitulo() {
    return titulo;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public ArrayList<Prestador> getCandidatos() {
    return candidatos;
  }

  public void setCandidatos(Prestador candidato) {
    candidatos.add(candidato);
  }

  @Override
  public String toString() {
    return "Servico [titulo=" + titulo + ", endereco=" + endereco.toString() + ", descricao=" + descricao
        + ", candidatos="
        + candidatos + "]";
  }
}
