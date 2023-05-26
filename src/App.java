
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Contratante;
import model.Prestador;
import model.Servico;

public class App extends Application {

    private static Stage stage;
    private static Scene loginScene;
    private static Scene cadastroDadosPrestadorScene;
    private static Scene cadastroCurriculoPrestadorScene;
    private static Scene cadastroContratanteScene;
    private static Scene servicosContratanteScene;
    private static Scene cadastroServicoScene;
    private static Scene servicosPrestadorScene;
    private static Scene candidatosScene;

    public static ArrayList<Contratante> contratantesCadastrados = new ArrayList<Contratante>();
    public static ArrayList<Prestador> prestadoresCadastrados = new ArrayList<Prestador>();

    public static Contratante contratanteLogado;
    public static Prestador prestadorLogado;

    public static ArrayList<Servico> servicos = new ArrayList<Servico>();

    public static Servico servicoSelecionado;

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        Parent fxmlLogin = FXMLLoader.load(getClass().getResource("login.fxml"));
        loginScene = new Scene(fxmlLogin);

        Parent fxmlCadastroDadosPrestador = FXMLLoader.load(getClass().getResource("cadastroDadosPrestador.fxml"));
        cadastroDadosPrestadorScene = new Scene(fxmlCadastroDadosPrestador);

        Parent fxmlCadastroCurriculoPrestador = FXMLLoader
                .load(getClass().getResource("cadastroCurriculoPrestador.fxml"));
        cadastroCurriculoPrestadorScene = new Scene(fxmlCadastroCurriculoPrestador);

        Parent fxmlCadastroContratante = FXMLLoader.load(getClass().getResource("cadastroContratante.fxml"));
        cadastroContratanteScene = new Scene(fxmlCadastroContratante);

        Parent fxmlServicosContratante = FXMLLoader.load(getClass().getResource("servicosContratante.fxml"));
        servicosContratanteScene = new Scene(fxmlServicosContratante);

        Parent fxmlCadastroServicoScene = FXMLLoader.load(getClass().getResource("cadastroServico.fxml"));
        cadastroServicoScene = new Scene(fxmlCadastroServicoScene);

        Parent fxmlServicosPrestadorScene = FXMLLoader.load(getClass().getResource("servicosPrestador.fxml"));
        servicosPrestadorScene = new Scene(fxmlServicosPrestadorScene);

        Parent fxmlCandidatosScene = FXMLLoader.load(getClass().getResource("candidatos.fxml"));
        candidatosScene = new Scene(fxmlCandidatosScene);

        primaryStage.setScene(loginScene);
        primaryStage.setTitle("Serviços de fácil acesso");
        primaryStage.show();
    }

    public static void mudarTela(String tela, Object dadosUsuario) {
        switch (tela) {
            case "login":
                stage.setScene(loginScene);
                notificarTodosListeners("login", dadosUsuario);
                break;
            case "cadastroDadosPrestador":
                stage.setScene(cadastroDadosPrestadorScene);
                notificarTodosListeners("cadastroDadosPrestador", dadosUsuario);
                break;
            case "cadastroCurriculoPrestador":
                stage.setScene(cadastroCurriculoPrestadorScene);
                notificarTodosListeners("cadastroCurriculoPrestador", dadosUsuario);
                break;
            case "cadastroContratante":
                stage.setScene(cadastroContratanteScene);
                notificarTodosListeners("cadastroContratante", dadosUsuario);
                break;
            case "servicosContratante":
                stage.setScene(servicosContratanteScene);
                notificarTodosListeners("servicosContratante", dadosUsuario);
                break;
            case "cadastroServico":
                stage.setScene(cadastroServicoScene);
                notificarTodosListeners("cadastroServico", dadosUsuario);
                break;
            case "servicosPrestador":
                stage.setScene(servicosPrestadorScene);
                notificarTodosListeners("servicosPrestador", dadosUsuario);
                break;
            case "candidatos":
                stage.setScene(candidatosScene);
                notificarTodosListeners("candidatos", dadosUsuario);
                break;
        }
    }

    public static void mudarTela(String tela) {
        mudarTela(tela, null);
    }

    private static ArrayList<AoTrocarTela> listeners = new ArrayList<>();

    public static interface AoTrocarTela {
        void AoMudarTela(String novaTela, Object dadosUsuario);
    }

    public static void adcListenerTrocarTela(AoTrocarTela aoTrocarTela) {
        listeners.add(aoTrocarTela);
    }

    private static void notificarTodosListeners(String novaTela, Object dadosUsuario) {
        for (AoTrocarTela l : listeners)
            l.AoMudarTela(novaTela, dadosUsuario);
    }
}
