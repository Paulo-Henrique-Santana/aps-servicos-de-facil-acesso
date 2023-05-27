package controller;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Prestador;

public class CandidatosController {
  @FXML
  private TableView<Prestador> tvCandidatos;

  @FXML
  private void initialize() {
    App.adcListenerTrocarTela(new App.AoTrocarTela() {
      @Override
      public void AoMudarTela(String novaTela, Object dadosUsuario) {
        if (novaTela.equals("candidatos")) {
          tvCandidatos.getItems().clear();
          TableColumn<Prestador, String> colNome = new TableColumn<Prestador, String>("Nome");
          colNome.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNome()));

          TableColumn<Prestador, String> colEmail = new TableColumn<Prestador, String>("Email");
          colEmail.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getEmail()));

          TableColumn<Prestador, String> colTelefone = new TableColumn<Prestador, String>("Telefone");
          colTelefone.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTelefone()));

          TableColumn<Prestador, String> colEstado = new TableColumn<Prestador, String>("Estado");
          colEstado.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getEndereco().getEstado()));

          TableColumn<Prestador, String> colCidade = new TableColumn<Prestador, String>("Cidade");
          colCidade.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getEndereco().getCidade()));

          TableColumn<Prestador, String> colCep = new TableColumn<Prestador, String>("CEP");
          colCep.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getEndereco().getEstado()));

          TableColumn<Prestador, String> colBairro = new TableColumn<Prestador, String>("Bairro");
          colBairro.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getEndereco().getCidade()));

          TableColumn<Prestador, String> colObjetivo = new TableColumn<Prestador, String>("Objetivo");
          colObjetivo
              .setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCurriculo().getObjetivo()));

          TableColumn<Prestador, String> colExperiências = new TableColumn<Prestador, String>("Experiências");
          colExperiências
              .setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCurriculo().getExperiencia()));

          TableColumn<Prestador, String> colFormacao = new TableColumn<Prestador, String>("Formação");
          colFormacao
              .setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCurriculo().getFormacao()));

          TableColumn<Prestador, String> colHabilidades = new TableColumn<Prestador, String>("Habilidades");
          colHabilidades
              .setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCurriculo().getHabilidades()));

          tvCandidatos.getColumns().addAll(colNome, colEmail, colTelefone, colEstado, colCidade, colCep, colBairro,
              colObjetivo,
              colExperiências, colFormacao, colHabilidades);

          tvCandidatos.getItems().addAll(App.servicoSelecionado.getCandidatos());
        }
      }
    });
  }

  @FXML
  private void voltar() {
    App.mudarTela("servicosContratante");
  }
}
