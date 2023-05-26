import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Contratante;

public class CadastroContratanteController {
  @FXML
  private TextField txtNome, txtIdentificacao, txtEmail, txtSenha;

  @FXML
  private Button btnCadastrar;

  private void resetarCampos() {
    txtNome.clear();
    txtIdentificacao.clear();
    txtEmail.clear();
    txtSenha.clear();
  }

  @FXML
  private void cadastrar() {
    Contratante contratante = new Contratante(txtNome.getText(), txtEmail.getText(),
        txtSenha.getText(), txtIdentificacao.getText());

    App.contratanteLogado = contratante;
    App.contratantesCadastrados.add(contratante);

    App.mudarTela("servicosContratante");
    resetarCampos();
  }

  @FXML
  private void voltarParaLogin() {
    App.mudarTela("login");
    resetarCampos();
  }
}
