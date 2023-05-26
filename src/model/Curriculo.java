package model;

public class Curriculo {
  private String objetivo;
  private String experiencia;
  private String formacao;
  private String habilidades;

  public Curriculo(String objetivo, String experiencia, String formacao, String habilidades) {
    this.objetivo = objetivo;
    this.experiencia = experiencia;
    this.formacao = formacao;
    this.habilidades = habilidades;
  }

  public String getObjetivo() {
    return objetivo;
  }

  public void setObjetivo(String objetivo) {
    this.objetivo = objetivo;
  }

  public String getExperiencia() {
    return experiencia;
  }

  public void setExperiencia(String experiencia) {
    this.experiencia = experiencia;
  }

  public String getFormacao() {
    return formacao;
  }

  public void setFormacao(String formacao) {
    this.formacao = formacao;
  }

  public String getHabilidades() {
    return habilidades;
  }

  public void setHabilidades(String habilidades) {
    this.habilidades = habilidades;
  }

  @Override
  public String toString() {
    return "Curriculo [objetivo=" + objetivo + ", experiencia=" + experiencia + ", formacao=" + formacao
        + ", habilidades=" + habilidades + "]";
  }
}
