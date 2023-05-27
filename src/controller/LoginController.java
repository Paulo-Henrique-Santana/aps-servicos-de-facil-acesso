package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Contratante;
import model.Prestador;

public class LoginController implements Initializable {

  @FXML
  private TextField txtEmail, txtSenha;

  @FXML
  private Button btnLogin;

  @FXML
  private ComboBox<String> cbTipoConta;

  private String[] tiposConta = { "Prestador", "Contratante" };

  @FXML
  public void initialize(URL location, ResourceBundle resources) {
    resetarCampos();
  }

  private void resetarCampos() {
    txtEmail.clear();
    txtSenha.clear();
    cbTipoConta.getItems().clear();
    cbTipoConta.getItems().addAll(tiposConta);
    cbTipoConta.getSelectionModel().selectFirst();
  }

  @FXML
  void fazerLogin() {
    if (cbTipoConta.getValue().equals("Prestador")) {
      ArrayList<Prestador> prestadores = App.prestadoresCadastrados;
      for (int i = 0; i < prestadores.size(); i++) {
        Prestador prestador = prestadores.get(i);
        if (txtEmail.getText().equals(prestadores.get(i).getEmail())
            && txtSenha.getText().equals(prestadores.get(i).getSenha())) {
          App.prestadorLogado = prestador;
          App.mudarTela("servicosPrestador");
        }
      }
    } else {
      ArrayList<Contratante> contratantes = App.contratantesCadastrados;
      for (int i = 0; i < contratantes.size(); i++) {
        Contratante contratante = contratantes.get(i);
        if (txtEmail.getText().equals(contratante.getEmail())
            && txtSenha.getText().equals(contratante.getSenha())) {
          App.contratanteLogado = contratante;
          App.mudarTela("servicosContratante");
        }
      }
    }
    resetarCampos();
  }

  @FXML
  void irParaCadastroPrestador() {
    App.mudarTela("cadastroDadosPrestador");
    resetarCampos();
  }

  @FXML
  void irParaCadastroContratante() {
    App.mudarTela("cadastroContratante");
    resetarCampos();
  }
}
