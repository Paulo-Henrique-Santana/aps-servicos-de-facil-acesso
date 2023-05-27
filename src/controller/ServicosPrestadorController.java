package controller;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Servico;
import util.Alerta;

public class ServicosPrestadorController {
  @FXML
  private ComboBox<String> cbTipoBusca;

  private String[] tiposBusca = { "Título", "Estado", "Cidade" };

  @FXML
  private TextField txtBusca;

  @FXML
  private TableView<Servico> tvServicos;

  @FXML
  private Button btnCandidatar;

  @FXML
  private void initialize() {
    App.adcListenerTrocarTela(new App.AoTrocarTela() {
      @Override
      public void AoMudarTela(String novaTela, Object dadosUsuario) {
        if (novaTela.equals("servicosPrestador")) {
          cbTipoBusca.getItems().clear();
          cbTipoBusca.getItems().addAll(tiposBusca);
          cbTipoBusca.getSelectionModel().selectFirst();

          listarServicos(null, null);
          btnCandidatar.setDisable(false);
          btnCandidatar.setText("Candidatar-se");
        }
      }
    });
  }

  private void listarServicos(String tipoBusca, String busca) {
    tvServicos.getColumns().clear();
    tvServicos.getItems().clear();

    TableColumn<Servico, String> colTitulo = new TableColumn<Servico, String>("Título");
    colTitulo.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTitulo()));

    TableColumn<Servico, String> colDescricao = new TableColumn<Servico, String>("Descrição");
    colDescricao.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDescricao()));

    TableColumn<Servico, String> colEstado = new TableColumn<Servico, String>("Estado");
    colEstado.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getEndereco().getEstado()));

    TableColumn<Servico, String> colCidade = new TableColumn<Servico, String>("Cidade");
    colCidade.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getEndereco().getCidade()));

    TableColumn<Servico, String> colCep = new TableColumn<Servico, String>("CEP");
    colCep.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getEndereco().getCep()));

    TableColumn<Servico, String> colBairro = new TableColumn<Servico, String>("Bairro");
    colBairro.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getEndereco().getBairro()));

    tvServicos.getColumns().addAll(colTitulo, colDescricao, colEstado, colCidade, colCep, colBairro);

    if (tipoBusca == null && busca == null) {
      tvServicos.getItems().addAll(App.servicos);
    } else {
      busca = busca.toUpperCase();

      for (int i = 0; i < App.servicos.size(); i++) {
        Servico servico = App.servicos.get(i);
        if (tipoBusca == "Título") {
          if (servico.getTitulo().toUpperCase().contains(busca)) {
            tvServicos.getItems().add(servico);
          }
        }
        if (tipoBusca == "Estado") {
          if (servico.getEndereco().getEstado().toUpperCase().contains(busca)) {
            tvServicos.getItems().add(servico);
          }
        }
        if (tipoBusca == "Cidade") {
          if (servico.getEndereco().getCidade().toUpperCase().contains(busca)) {
            tvServicos.getItems().add(servico);
          }
        }
      }
    }
  }

  @FXML
  private void buscar() {
    String tipoBusca = cbTipoBusca.getSelectionModel().getSelectedItem();
    listarServicos(tipoBusca, txtBusca.getText());
  }

  @FXML
  private void sair() {
    App.mudarTela("login");
  }

  @FXML
  private void verificarCandidatura() {
    if (tvServicos.getSelectionModel().getSelectedItem() != null) {
      if (tvServicos.getSelectionModel().getSelectedItem().getCandidatos().contains(App.prestadorLogado)) {
        btnCandidatar.setText("Candidatado");
        btnCandidatar.setDisable(true);
      } else {
        btnCandidatar.setText("Candidatar-se");
        btnCandidatar.setDisable(false);
      }
    }
  }

  @FXML
  private void candidatar() {
    try {
      tvServicos.getSelectionModel().getSelectedItem().setCandidatos(App.prestadorLogado);
    } catch (NullPointerException e) {
      Alerta.mostrarAlerta("Erro", "Selecione uma vaga para se candidatar", AlertType.ERROR);
    }
    verificarCandidatura();
  }

}
