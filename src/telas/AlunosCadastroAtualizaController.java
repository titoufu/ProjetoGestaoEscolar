package telas;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public class AlunosCadastroAtualizaController implements Initializable {

	@FXML
    private TextField IdEnderecoTrabalho;

    @FXML
    private TextField IdNomeMae;

    @FXML
    private TextField IdNomePai;

    @FXML
    private TextField IdNumeroRuaAluno;

    @FXML
    private RadioButton IdRemedioControladoNao;

    @FXML
    private TextField IdRemedioControladoQual;

    @FXML
    private RadioButton IdRemedioControladoSim;

    @FXML
    private ToggleGroup Status;

    @FXML
    private ToggleGroup ToggleBeneficio;

    @FXML
    private ToggleGroup ToggleBolsaFamilia;

    @FXML
    private ToggleGroup ToggleCadUnico;

    @FXML
    private ToggleGroup ToggleMoradia;

    @FXML
    private ToggleGroup ToggleSociais;

    @FXML
    private ToggleGroup TroggleCirurgia;

    @FXML
    private ToggleGroup TroggleDeficiencia;

    @FXML
    private ToggleGroup TroggleDoenca;

    @FXML
    private ToggleGroup TroggleRemedio;

    @FXML
    private ToggleGroup TroggleSaude;

    @FXML
    private RadioButton idAlergiaNao;

    @FXML
    private TextField idAlergiaQual;

    @FXML
    private RadioButton idAlergiaSim;

    @FXML
    private TextField idAnoEscolarAluno;

    @FXML
    private TextField idBairroAluno;

    @FXML
    private RadioButton idBeneficioNao;

    @FXML
    private RadioButton idBeneficioSim;

    @FXML
    private RadioButton idBolsaFamiliaNao;

    @FXML
    private RadioButton idBolsaFamiliaSim;

    @FXML
    private Button idButtonCancelar;

    @FXML
    private Button idButtonSalvar;

    @FXML
    private RadioButton idCadastroUnicoNao;

    @FXML
    private RadioButton idCadastroUnicoSim;

    @FXML
    private TextField idCelFixoAluno;

    @FXML
    private TextField idCelularAluno;

    @FXML
    private TextField idCelularMae;

    @FXML
    private TextField idCelularPai;

    @FXML
    private TextField idCelularResponsavel;

    @FXML
    private TextField idCepAluno;

    @FXML
    private TextField idCepTrabalho;

    @FXML
    private RadioButton idCirurgiaNao;

    @FXML
    private TextField idCirurgiaQual;

    @FXML
    private RadioButton idCirurgiaSim;

    @FXML
    private TextField idCodigo;

    @FXML
    private TextField idCpfAluno;

    @FXML
    private TextField idCpfMae;

    @FXML
    private TextField idCpfPai;

    @FXML
    private TextField idCpfResponsavel;

    @FXML
    private TextField idDataCadastro;

    @FXML
    private DatePicker idDataNascimentoAluno;

    @FXML
    private RadioButton idDeficienciaNao;

    @FXML
    private TextField idDeficienciaQual;

    @FXML
    private RadioButton idDeficienciaSim;

    @FXML
    private RadioButton idDoencaNao;

    @FXML
    private TextField idDoencaQual;

    @FXML
    private RadioButton idDoencaSim;

    @FXML
    private TextField idEmailAluno;

    @FXML
    private RadioButton idEncaminhaBemSocial;

    @FXML
    private RadioButton idEncaminhaCaps;

    @FXML
    private RadioButton idEncaminhaCemaia;

    @FXML
    private RadioButton idEncaminhaConselhoTutelar;

    @FXML
    private TextField idEncaminhaOutra;

    @FXML
    private RadioButton idEncaminhaVaraInfancia;

    @FXML
    private RadioButton idEncaminhaVontadePropria;

    @FXML
    private GridPane idEscolaAluno;

    @FXML
    private Label idLabelAtualiza;

    @FXML
    private TextField idNomeAluno;

    @FXML
    private TextField idNomeResponsavel;

    @FXML
    private RadioButton idNoradiaAlugada;

    @FXML
    private RadioButton idNoradiaCedida;

    @FXML
    private RadioButton idNoradiaFinanciada;

    @FXML
    private RadioButton idNoradiaPropria;

    @FXML
    private TextField idNumeroCIS;

    @FXML
    private TextField idNumeroTrabalho;

    @FXML
    private TextField idPeriodoAluno;

    @FXML
    private TextField idRgAluno;

    @FXML
    private TextField idRgMae;

    @FXML
    private TextField idRgPai;

    @FXML
    private TextField idRgResponsavel;

    @FXML
    private TextField idRuaAluno;

    @FXML
    private ComboBox<String> idSexoAluno;
   

    @FXML
    void onButtonCancelarAction(ActionEvent event) {
System.out.println("BOTAO ccaacceellaarr NA TELA ATUALIZA .....");
    }

    @FXML
    void onButtonSalvarAction(ActionEvent event) {
    	System.out.println("BOTAO ATUALIZA NA TELA ATUALIZA .....");
    }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		idSexoAluno.getItems().addAll("Masculino","Feminino","Não declarado");
	
	}

}
