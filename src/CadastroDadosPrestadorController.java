import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Endereco;
import model.Prestador;

public class CadastroDadosPrestadorController {
  @FXML
  private TextField txtNome, txtCpf, txtTelefone, txtEstado, txtCidade, txtCep, txtBairro, txtEmail, txtSenha;

  private void resetarCampos() {
    txtNome.clear();
    txtCpf.clear();
    txtTelefone.clear();
    txtEstado.clear();
    txtCidade.clear();
    txtCep.clear();
    txtBairro.clear();
    txtEmail.clear();
    txtSenha.clear();
  }

  @FXML
  private void cadastrarDadosPrestador() {
    Endereco endereco = new Endereco(txtEstado.getText(), txtCidade.getText(), txtCep.getText(), txtBairro.getText());
    Prestador prestador = new Prestador(txtNome.getText(), txtEmail.getText(),
        txtSenha.getText(), txtCpf.getText(), txtTelefone.getText(), endereco, null);

    App.prestadoresCadastrados.add(prestador);
    App.prestadorLogado = prestador;

    App.mudarTela("cadastroCurriculoPrestador");
    resetarCampos();

  }

  @FXML
  private void voltarParaLogin() {
    App.mudarTela("login");
    resetarCampos();
  }
}
