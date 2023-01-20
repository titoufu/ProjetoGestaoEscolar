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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.dao.AlunoDao;
import model.dao.DaoFactory;
import model.entities.Aluno;
import utilAlerts.Alerts;
import utilAlerts.CPF;
import utilAlerts.Constraints;

public class AlunosCadastroNovoController implements Initializable {
	public Aluno aluno = new Aluno();
	@FXML
	private ToggleGroup GrupoAlergia;

	@FXML
	private ToggleGroup GrupoBeneficio;

	@FXML
	private ToggleGroup GrupoBolsaFamilia;

	@FXML
	private ToggleGroup GrupoCadUnico;

	@FXML
	private ToggleGroup GrupoCirurgia;

	@FXML
	private ToggleGroup GrupoDeficiencia;

	@FXML
	private ToggleGroup GrupoDoenca;

	@FXML
	private ToggleGroup GrupoEncaminha;

	@FXML
	private ToggleGroup GrupoMoradia;

	@FXML
	private ToggleGroup GrupoRemedio;

	@FXML
	private ToggleGroup GrupoSituacao;

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
	private TextField idNomeAluno;

	@FXML
	private TextField idNomeResponsavel;

	@FXML
	private TextField idNumeroNIS;

	@FXML
	private TextField idNumeroPessoasMoradia;

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
	private RadioButton idSelecaoEmEspera;

	@FXML
	private ComboBox<String> idSexoAluno;

	@FXML
	private TextField idTelFixoAluno;

	@FXML
	void onButtonCancelarAction(ActionEvent event) {

	}

	@FXML
	void onButtonSalvarAction(ActionEvent event) {

		String msg = new String();
		msg = lecampo(idNomeAluno, "Nome do Aluno");
		if (msg == null) {
			return;
		} else {
			aluno.setNomeAluno(msg);
		}

		msg = lecampo(idDataCadastro, "Data do Cadastro");
		if (msg == null) {
			return;
		} else {
			aluno.setDataCadastro(msg);
		}
		msg = lecampo(idRgAluno, "RG do Aluno");
		if (msg == null) {
			return;
		} else {
			aluno.setRgAluno(msg);
		}
		msg = lecampo(idCpfAluno, "CPF do Aluno");
		if (msg == null) {
			return;
		} else {
			idCpfAluno.setText(CPF.formartCpf(msg));
			aluno.setCpfAluno(idCpfAluno.getText());
		}

		LocalDate value = idDataNascimentoAluno.getValue();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		aluno.setDataNascimentoAluno(dtf.format(value));

		aluno.setSexo(idSexoAluno.getValue());
		aluno.setNomeRuaAluno(lecampo(idRuaAluno, "Rua do Aluno"));

		msg = lecampo(IdNumeroRuaAluno, "Numero da Rua do Aluno");
		if (msg == null) {
			return;
		} else {
			aluno.setNumeroRuaAluno(Integer.valueOf(IdNumeroRuaAluno.getText()));
		}
		msg = lecampo(idBairroAluno, "Bairro do Aluno");
		if (msg == null) {
			return;
		} else {
			aluno.setBairroAluno(msg);
		}
		msg = lecampo(idCepAluno, "CEP do Aluno");
		if (msg == null) {
			return;
		} else {
			aluno.setCepAluno(msg);
		}
		msg = lecampo(idCelularAluno, "Celular do Aluno");
		if (msg == null) {
			return;
		} else {
			aluno.setCelularAluno(msg);
		}
		msg = lecampo(idTelFixoAluno, "Telefone Fixo do Aluno");
		if (msg == null) {
			return;
		} else {
			aluno.setTelFixoAluno(msg);
		}
		msg = lecampo(idEmailAluno, "Email do Aluno");
		if (msg == null) {
			return;
		} else {
			aluno.setEmailAluno(msg);
		}
		msg = lecampo(idEscolaAluno, "Nome da Escola do Aluno");
		if (msg == null) {
			return;
		} else {
			aluno.setEscolaAluno(msg);
		}
		msg = lecampo(idPeriodoAluno, "Periodo do Aluno");
		if (msg == null) {
			return;
		} else {
			aluno.setPeriodoAluno(msg);
		}
		msg = lecampo(idAnoEscolarAluno, "Ano Escolar do Aluno");
		if (msg == null) {
			return;
		} else {
			aluno.setAnoEscolarAluno(msg);
		}
		msg = lecampo(IdNomeMae, "Nome da Mãe");
		if (msg == null) {
			return;
		} else {
			aluno.setNomeMae(msg);
		}
		msg = lecampo(idRgMae, "RG da Mãe");
		if (msg == null) {
			return;
		} else {
			aluno.setRgMae(msg);
		}
		msg = lecampo(idCpfMae, "CPF da Mãe");
		if (msg == null) {
			return;
		} else {
			idCpfMae.setText(CPF.formartCpf(msg));
			aluno.setCpfMae(idCpfMae.getText());
		}
		msg = lecampo(idCelularMae, "Celular da Mãe");
		if (msg == null) {
			return;
		} else {
			aluno.setCelularMae(msg);
		}
		msg = lecampo(IdNomePai, "Nome do Pai");
		if (msg == null) {
			return;
		} else {
			aluno.setNomePai(msg);
		}
		msg = lecampo(idRgPai, "RG do Pai");
		if (msg == null) {
			return;
		} else {
			aluno.setRgPai(msg);
		}
		msg = lecampo(idCpfPai, "CPF do Pai");
		if (msg == null) {
			return;
		} else {
			idCpfPai.setText(CPF.formartCpf(msg));
			aluno.setCpfMae(idCpfPai.getText());
		}
		msg = lecampo(idCelularPai, "Celular do Pai");
		if (msg == null) {
			return;
		} else {
			aluno.setCelularPai(msg);
		}
		msg = lecampo(idNomeResponsavel, "Nome do Responsável");
		if (msg == null) {
			return;
		} else {
			aluno.setNomeResponsavel(msg);
		}
		msg = lecampo(idRgResponsavel, "RG do Responsável");
		if (msg == null) {
			return;
		} else {
			aluno.setRgResponsavel(msg);
		}
		msg = lecampo(idCpfResponsavel, "CPF do Responsável");
		if (msg == null) {
			return;
		} else {
			idCpfResponsavel.setText(CPF.formartCpf(msg));
			aluno.setCpfResponsavel(idCpfResponsavel.getText());
		}
		msg = lecampo(idCelularResponsavel, "Celular do Responsável");
		if (msg == null) {
			return;
		} else {
			aluno.setCelularResponsavel(msg);
		}
		msg = lecampo(IdEnderecoTrabalho, "Endereço de Trabalho do Responsável");
		if (msg == null) {
			return;
		} else {
			aluno.setNumeroTrabalho(Integer.valueOf(idNumeroTrabalho.getText()));
		}
		msg = lecampo(idCepTrabalho, "CEP do Responsável de Trabalho");
		if (msg == null) {
			return;
		} else {
			aluno.setCepTrabalho(msg);
		}
		msg = lecampo(idNumeroPessoasMoradia, "Número de Pessoas na Moradia");
		if (msg == null) {
			return;
		} else {
			aluno.setNumeroPessoasNaMoradia(Integer.valueOf(idNumeroPessoasMoradia.getText()));
		}
		aluno.setAlergiaQual(idAlergiaQual.getText());
		aluno.setDeficienciaQual(idDeficienciaQual.getText());
		aluno.setCirurgiaQual(idCirurgiaQual.getText());
		aluno.setDoencaQual(idDoencaQual.getText());
		aluno.setRemedioQual(IdRemedioControladoQual.getText());

		msg = lecampo(idNumeroNIS, "Número NIS");
		if (msg == null) {
			return;
		} else {
			aluno.setNumeroNIS(Integer.valueOf(idNumeroNIS.getText()));
		}
		aluno.setEncaminhaOutra(idEncaminhaOutra.getText());
		System.out.println(aluno.toString());
		conectar_salvar(aluno);
	}

	public void conectar_salvar(Aluno aluno) {
		
		AlunoDao alunodao=DaoFactory.createAlunoDao();
		alunodao.insert(aluno);
	//	Aluno aluno =alunodao.findById(4);
	 //   System.out.println(aluno.getNomeAluno());
		
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

	public String lecampo(TextField id, String msg) {
		if (id.getText().isBlank() || id.getText() == null || id.getText().trim().equals("")) {
			Alerts.showAlert(null, "CAMPO VAZIO", "Entre com o valor do " + msg, AlertType.ERROR);
			return null;
		} else {
			return id.getText();
		}
	}

	public String radioResult(ToggleGroup rB) {
		RadioButton selectedRadioButton = (RadioButton) rB.getSelectedToggle();
		String toogleGroupValue = selectedRadioButton.getText();
		return toogleGroupValue;
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		idSexoAluno.getItems().addAll("Masculino", "Feminino", "Não declarado");
		idSexoAluno.setValue("Masculino");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.now();
		idDataCadastro.setText(dtf.format(localDate));
		idDataNascimentoAluno.setValue(localDate);
		aluno.setSituacao("Em espera");
		aluno.setMoradia("Própria");
		aluno.setAlergia("NÃo");
		aluno.setDeficiencia("NÃO");
		aluno.setCirurgia("NÃO");
		aluno.setDoenca("NÃO");
		aluno.setRemedio("NÃO");
		aluno.setBolsaFamilia("NÃO");
		aluno.setBeneficio("NÃO");
		aluno.setCadastroUnico("NÃO");
		aluno.setEncaminha("Vontade própria");

		Constraints.setTextFieldInteger(IdNumeroRuaAluno);
		Constraints.setTextFieldInteger(idNumeroPessoasMoradia);
		Constraints.setTextFieldInteger(idNumeroTrabalho);
		Constraints.setTextFieldInteger(idNumeroNIS);

		GrupoSituacao.selectedToggleProperty()
				.addListener((observable, oldVal, newVal) -> aluno.setSituacao(radioResult(GrupoSituacao)));
		GrupoMoradia.selectedToggleProperty()
				.addListener((observable, oldVal, newVal) -> aluno.setMoradia(radioResult(GrupoMoradia)));
		GrupoAlergia.selectedToggleProperty()
				.addListener((observable, oldVal, newVal) -> aluno.setAlergia(radioResult(GrupoAlergia)));
		GrupoDeficiencia.selectedToggleProperty()
				.addListener((observable, oldVal, newVal) -> aluno.setDeficiencia(radioResult(GrupoDeficiencia)));
		GrupoCirurgia.selectedToggleProperty()
				.addListener((observable, oldVal, newVal) -> aluno.setCirurgia(radioResult(GrupoCirurgia)));
		GrupoDoenca.selectedToggleProperty()
				.addListener((observable, oldVal, newVal) -> aluno.setDoenca(radioResult(GrupoDoenca)));
		GrupoRemedio.selectedToggleProperty()
				.addListener((observable, oldVal, newVal) -> aluno.setRemedio(radioResult(GrupoRemedio)));
		GrupoBolsaFamilia.selectedToggleProperty()
				.addListener((observable, oldVal, newVal) -> aluno.setBolsaFamilia(radioResult(GrupoBolsaFamilia)));
		GrupoBeneficio.selectedToggleProperty()
				.addListener((observable, oldVal, newVal) -> aluno.setBeneficio(radioResult(GrupoBeneficio)));
		GrupoCadUnico.selectedToggleProperty()
				.addListener((observable, oldVal, newVal) -> aluno.setCadastroUnico(radioResult(GrupoCadUnico)));
		GrupoEncaminha.selectedToggleProperty()
				.addListener((observable, oldVal, newVal) -> aluno.setEncaminha(radioResult(GrupoEncaminha)));
		
		
		// controlando o tamanho dos campos 
		
		Constraints.setTextFieldMaxLength(idNomeAluno,60);
		Constraints.setTextFieldMaxLength(idDataCadastro,10);
		Constraints.setTextFieldMaxLength(idRgAluno,15);
		Constraints.setTextFieldMaxLength(idCpfAluno,15);
		Constraints.setTextFieldMaxLength(idRuaAluno,10);
		Constraints.setTextFieldMaxLength(IdNumeroRuaAluno,4);
		Constraints.setTextFieldMaxLength(idBairroAluno,60);
		Constraints.setTextFieldMaxLength(idCepAluno,20);
		Constraints.setTextFieldMaxLength(idCelularAluno,15);
		Constraints.setTextFieldMaxLength(idTelFixoAluno,20);
		Constraints.setTextFieldMaxLength(idEmailAluno,60);
		Constraints.setTextFieldMaxLength(idEscolaAluno,60);
		Constraints.setTextFieldMaxLength(idPeriodoAluno,10);
		Constraints.setTextFieldMaxLength(idAnoEscolarAluno,10);
		Constraints.setTextFieldMaxLength(IdNomeMae,60);
		Constraints.setTextFieldMaxLength(idRgMae,15);
		Constraints.setTextFieldMaxLength(idCpfMae,15);
		Constraints.setTextFieldMaxLength(idCelularMae,15);
		Constraints.setTextFieldMaxLength(IdNomePai,60);
		Constraints.setTextFieldMaxLength(idRgPai,15);
		Constraints.setTextFieldMaxLength(idCpfPai,15);
		Constraints.setTextFieldMaxLength(idCelularPai,15);
		Constraints.setTextFieldMaxLength(idNomeResponsavel,60);
		Constraints.setTextFieldMaxLength(idRgResponsavel,20);
		Constraints.setTextFieldMaxLength(idCpfResponsavel,15);
		Constraints.setTextFieldMaxLength(idCelularResponsavel,15);
		Constraints.setTextFieldMaxLength(IdEnderecoTrabalho,60);
		Constraints.setTextFieldMaxLength(idNumeroTrabalho,4);
		Constraints.setTextFieldMaxLength(idCepTrabalho,20);
		Constraints.setTextFieldMaxLength(idNumeroPessoasMoradia,2);
		Constraints.setTextFieldMaxLength(idAlergiaQual,60);
		Constraints.setTextFieldMaxLength(idDeficienciaQual,60);
		Constraints.setTextFieldMaxLength(idCirurgiaQual,60);
		Constraints.setTextFieldMaxLength(idDoencaQual,60);
		Constraints.setTextFieldMaxLength(IdRemedioControladoQual,60);
		Constraints.setTextFieldMaxLength(idNumeroNIS,11);
		Constraints.setTextFieldMaxLength(idEncaminhaOutra,60);


		
	}

}
