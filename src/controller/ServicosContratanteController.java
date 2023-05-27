package controller;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import model.Servico;
import util.Alerta;

public class ServicosContratanteController {
  @FXML
  private TableView<Servico> tvServicos;

  @FXML
  private Button btnNovoServico;

  @FXML
  private void initialize() {
    App.adcListenerTrocarTela(new App.AoTrocarTela() {
      @Override
      public void AoMudarTela(String novaTela, Object dadosUsuario) {
        if (novaTela.equals("servicosContratante")) {
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

          tvServicos.getItems().addAll(App.contratanteLogado.getServicos());
        }
      }
    });
  }

  @FXML
  private void irParaCadastroServico(ActionEvent event) {
    App.mudarTela("cadastroServico");
  }

  @FXML
  private void sair(ActionEvent event) {
    App.mudarTela("login");
  }

  @FXML
  private void verCandidatos() {
    try {
      App.servicoSelecionado = tvServicos.getSelectionModel().getSelectedItem();
      App.mudarTela("candidatos");
    } catch (NullPointerException e) {
      Alerta.mostrarAlerta("Erro", "Selecione uma vaga para ver os candidatos", AlertType.ERROR);
    }
  }
}
