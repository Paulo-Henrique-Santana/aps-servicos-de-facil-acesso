package controller;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import model.Curriculo;

public class CadastroCurriculoPrestador {
  @FXML
  private TextArea txtaObjetivo, txtaExperiencia, txtaFormacao, txtaHabilidades;

  private void resetarCampos() {
    txtaObjetivo.clear();
    txtaExperiencia.clear();
    txtaFormacao.clear();
    txtaHabilidades.clear();
  }

  @FXML
  private void cadastrar() {
    Curriculo curriculo = new Curriculo(txtaObjetivo.getText(), txtaExperiencia.getText(), txtaFormacao.getText(),
        txtaHabilidades.getText());
    App.prestadorLogado.setCurriculo(curriculo);

    for (int i = 0; i < App.prestadoresCadastrados.size(); i++) {
      if (App.prestadoresCadastrados.get(i).getCpf() == App.prestadorLogado.getCpf()) {
        App.prestadoresCadastrados.get(i).setCurriculo(curriculo);
      }
    }

    App.mudarTela("servicosPrestador");
    resetarCampos();
  }

  @FXML
  private void cancelar() {
    for (int i = 0; i < App.prestadoresCadastrados.size(); i++) {
      if (App.prestadoresCadastrados.get(i).getCpf() == App.prestadorLogado.getCpf()) {
        App.prestadoresCadastrados.remove(i);
      }
    }
    App.prestadorLogado = null;

    App.mudarTela("login");
    resetarCampos();
  }
}
