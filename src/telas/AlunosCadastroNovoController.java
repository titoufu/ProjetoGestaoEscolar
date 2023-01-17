package telas;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import db.DB;
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
import model.entities.Aluno;
import utilAlerts.CPF;

public class AlunosCadastroNovoController implements Initializable {
	Aluno aluno = new Aluno();

    @FXML
    private ToggleGroup Alergia;

    @FXML
    private ToggleGroup Beneficio;

    @FXML
    private ToggleGroup BolsaFamilia;

    @FXML
    private ToggleGroup CadUnico;

    @FXML
    private ToggleGroup Cirurgia;

    @FXML
    private ToggleGroup Deficiencia;

    @FXML
    private ToggleGroup Encaminha;

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
    private ToggleGroup Moradia;

    @FXML
    private ToggleGroup REmedio;

    @FXML
    private ToggleGroup Remedio;

    @FXML
    private ToggleGroup Situacao;

    @FXML
    private ToggleGroup TroggleDoenca;

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
    private TextField idTelFixoAluno;

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
    private TextField idEscolaAluno;

    @FXML
    private TextField idId;

    @FXML
    private Label idLabelAtualiza;

    @FXML
    private RadioButton idMoradiaAlugada;

    @FXML
    private RadioButton idMoradiaCedida;

    @FXML
    private RadioButton idMoradiaFinanciada;

    @FXML
    private RadioButton idMoradiaPropria;
    
    @FXML
    private TextField idMoradiaNumeroPessoas;

    @FXML
    private TextField idNomeAluno;

    @FXML
    private TextField idNomeResponsavel;

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
    private RadioButton idSituacaoCursando;

    @FXML
    private RadioButton idSituacaoDesligado;

    @FXML
    private RadioButton idSituacaoEmEmpera;

    @FXML
    private RadioButton idSituacaoFormado;
    
	private ComboBox<String> idSexoAluno;

	@FXML
	void onToogleAlergia(ActionEvent event) {
		if (idAlergiaSim.isSelected()) {
			aluno.setAlergia(true);
			aluno.setAlergiaQual(idAlergiaQual.getText());
		} else {
			aluno.setAlergia(false);
		}
	}

	@FXML
	void onToogleDeficiencia(ActionEvent event) {
		if (idDeficienciaSim.isSelected()) {
			aluno.setDeficiencia(true);
			aluno.setDeficienciaQual(idDeficienciaQual.getText());
		} else {
			aluno.setDeficiencia(false);
		}
	}

	@FXML
	void onToogleCirurgia(ActionEvent event) {
		if (idCirurgiaSim.isSelected()) {
			aluno.setCirurgia(true);
			aluno.setCirurgiaQual(idCirurgiaQual.getText());
		} else {
			aluno.setCirurgia(false);
		}
	}

	@FXML
	void onToggleDoenca(ActionEvent event) {
		if (idDoencaSim.isSelected()) {
			aluno.setDoenca(true);
			aluno.setDoencaQual(idDoencaQual.getText());
		} else {
			aluno.setDoenca(false);
		}
	}

	@FXML
	void onToogleRemedio(ActionEvent event) {
		if (IdRemedioControladoSim.isSelected()) {
			aluno.setRemedio(true);
			aluno.setRemedioQual(IdRemedioControladoQual.getText());
		} else {
			aluno.setRemedio(false);
		}
	}

	@FXML
	void onToogleBeneficio(ActionEvent event) {
		if (idBeneficioSim.isSelected()) {
			aluno.setBeneficio(true);
		} else {
			aluno.setBeneficio(false);
		}
	}

	@FXML
	void onToogleBolsaFamilia(ActionEvent event) {
		if (idBolsaFamiliaSim.isSelected()) {
			aluno.setBolsaFamilia(true);
		} else {
			aluno.setBolsaFamilia(false);
		}
	}

	@FXML
	void onToogleCadUnico(ActionEvent event) {
		if (idCadastroUnicoSim.isSelected()) {
			aluno.setCadastroUnico(true);
		} else {
			aluno.setCadastroUnico(false);
		}
	}

	@FXML
	void onToogleEncaminha(ActionEvent event) {
		if (idEncaminhaBemSocial.isSelected()) {
			aluno.setEncaminha("Bem Social");
		} else if (idEncaminhaVaraInfancia.isSelected()) {
			aluno.setEncaminha("Vara da Infância");
		} else if (idEncaminhaConselhoTutelar.isSelected()) {
			aluno.setEncaminha("Conselho Tutelar");
		} else if (idEncaminhaCemaia.isSelected()) {
			aluno.setEncaminha("Cemaia");
		} else if (idEncaminhaVontadePropria.isSelected()) {
			aluno.setEncaminha("Vontade Própria");
		} else if (idEncaminhaCaps.isSelected()) {
			aluno.setEncaminha("Caps");
		} else
			aluno.setEncaminha(idEncaminhaOutra.getText());
	}

	@FXML
	void onToogleMoradia(ActionEvent event) {

		if (idMoradiaAlugada.isSelected()) {
			aluno.setMoradia("Alugada");
		} else if (idMoradiaPropria.isSelected()) {
			aluno.setMoradia("Própria");
		} else if (idMoradiaFinanciada.isSelected()) {
			aluno.setMoradia("Financiada");
		} else if (idMoradiaCedida.isSelected()) {
			aluno.setMoradia("Cedida");
		}

	}

	@FXML
	void onToogleSituacao(ActionEvent event) {
		if (idSituacaoCursando.isScaleShape()) {
			aluno.setSituacao("Cursando");
		}
		if (idSituacaoDesligado.isScaleShape()) {
			aluno.setSituacao("Desligado");
		}
		if (idSituacaoEmEmpera.isScaleShape()) {
			aluno.setSituacao("Em Espera");
		}
		if (idSituacaoFormado.isScaleShape()) {
			aluno.setSituacao("Formado");
		}
	}

	@FXML
	void onButtonCancelarAction(ActionEvent event) {
		System.out.println("BOTAO ccaacceellaarr NA TELA ATUALIZA .....");
	}

	@FXML
	void onButtonSalvarAction(ActionEvent event) {
		System.out.println("BOTAO Salvar NA TELA Novo .....");
		System.out.println(idNomeAluno.getText());
		idCpfAluno.setText(CPF.formartCpf(idCpfAluno.getText()));
		Aluno aluno=captura();
		aluno.toString();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		idSexoAluno.getItems().addAll("Masculino", "Feminino", "Não declarado");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.now();
		System.out.println(dtf.format(localDate));
		idDataCadastro.setText(dtf.format(localDate));
		/*	Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();

			// EXAMPLE 1:
			st = conn.prepareStatement("INSERT INTO aluno " + "(NomeAluno) " + "VALUES " + "(?)",
					Statement.RETURN_GENERATED_KEYS);

			st.setString(1, "Tito");
			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				while (rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done! Id: " + id);
				}
			} else {
				System.out.println("No rows affected!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} //
			// catch (ParseException e) {
			// e.printStackTrace();
			// }
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		*/
	}

	public Aluno captura() {
		aluno.setNomeAluno(idNomeAluno.getText());
		// aluno.setDataCadastro(dtf.format(localDate));
		aluno.setRgAluno(idRgAluno.getText());
		aluno.setCpfAluno(idCpfAluno.getText());
		//aluno.setDataNascimentoAluno(idDataNascimentoAluno.getText());
		aluno.setRuaAluno(idRuaAluno.getText());
		aluno.setNumeroRuaAluno(Integer.parseInt(IdNumeroRuaAluno.getText()));
		aluno.setBairroAluno(idBairroAluno.getText());
		aluno.setCepAluno(idCepAluno.getText());
		aluno.setCelularAluno(idCelularAluno.getText());
		aluno.setTelFixoAluno(Integer.parseInt(idTelFixoAluno.getText()));
		aluno.setEmailAluno(idEmailAluno.getText());
		aluno.setEscolaAluno(idEscolaAluno.getText());
		aluno.setPeriodoAluno(idPeriodoAluno.getText());
		aluno.setAnoEscolarAluno(idAnoEscolarAluno.getText());
		aluno.setNomeMae(IdNomeMae.getText());
		aluno.setRgMae(idRgMae.getText());
		aluno.setCpfMae(idCpfMae.getText());
		aluno.setCelularMae(idCelularMae.getText());
		aluno.setNomePai(IdNomePai.getText());
		aluno.setRgPai(idRgPai.getText());
		aluno.setCpfPai(idCpfPai.getText());
		aluno.setCelularPai(idCelularPai.getText());
		aluno.setNomeResponsavel(idNomeResponsavel.getText());
		aluno.setRgResponsavel(idRgResponsavel.getText());
		aluno.setCpfResponsavel(idCpfResponsavel.getText());
		aluno.setCelularResponsavel(idCelularResponsavel.getText());
		aluno.setEnderecoTrabalho(IdEnderecoTrabalho.getText());
		aluno.setNumeroTrabalho(Integer.parseInt(idNumeroTrabalho.getText()));
		aluno.setCepTrabalho(idCepTrabalho.getText());
		aluno.setNumeroCIS(idNumeroCIS.getText());
		aluno.setNumeroPessoasNaMoradia(Integer.parseInt(idMoradiaNumeroPessoas.getText()));
		//aluno.setMoradia(idMora.getText());
		//aluno.setAlergia(idAlergia.getText());
		//aluno.setAlergiaQual(idAlergiaQual.getText());
		//aluno.setdeficiencia(idDeficiencia.getText());
		//aluno.setDeficienciaQual(idDeficienciaQual.getText());
		//aluno.setCirurgia(idCirurgia.getText());
		//aluno.setCirurgiaQual(idCirurgiaQual.getText());
		//aluno.setDoenca(idDoenca.getText());
		//aluno.setDoencaQual(idDoencaQual.getText());
		//aluno.setRemedio(idRemedio.getText());
		//aluno.setRemedioQual(idRemedioQual.getText());
		//aluno.setBolsaFamilia(idBolsaFamilia.getText());
		//aluno.setBeneficio(idBeneficio.getText());
		//aluno.setCadastroUnico(idCadastroUnico.getText());
		//aluno.setEncaminha(idEncaminha.getText());
		//aluno.setEncaminhaOutra(idEncaminhaOutra.getText());
		return aluno;
		
	}
}
