package controller;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Endereco;
import model.Servico;

public class CadastroServicoController {
  @FXML
  private TextField txtTitulo, txtEstado, txtCidade, txtCep, txtBairro;

  @FXML
  private TextArea txtDescricao;

  @FXML
  private void initialize() {
    App.adcListenerTrocarTela(new App.AoTrocarTela() {
      @Override
      public void AoMudarTela(String novaTela, Object dadosUsuario) {
        if (novaTela.equals("cadastroServico")) {
        }
      }
    });
  }

  private void resetarCampos() {
    txtTitulo.clear();
    txtEstado.clear();
    txtCidade.clear();
    txtCep.clear();
    txtBairro.clear();
    txtDescricao.clear();
  }

  @FXML
  private void cadastrarServico() {
    Endereco endereco = new Endereco(txtEstado.getText(), txtCidade.getText(), txtCep.getText(), txtBairro.getText());
    Servico servico = new Servico(txtTitulo.getText(), endereco, txtDescricao.getText());

    App.contratanteLogado.setServico(servico);
    App.servicos.add(servico);

    App.mudarTela("servicosContratante");
    resetarCampos();
  }

  @FXML
  private void cancelar() {
    App.mudarTela("servicosContratante");
    resetarCampos();
  }
}
