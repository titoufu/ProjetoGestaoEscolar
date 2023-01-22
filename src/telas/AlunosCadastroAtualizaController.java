package telas;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.dao.AlunoDao;
import model.dao.DaoFactory;
import model.entities.Aluno;
import utilAlerts.Alerts;
import utilAlerts.CPF;
import utilAlerts.Constraints;

public class AlunosCadastroAtualizaController implements Initializable {
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
	private ComboBox<String> idAnoEscolarAluno;

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
	private TextField idCpfAtualiza;
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
	private RadioButton idEncaminhaOutra;

	@FXML
	private Label idEncaminhaOutraLabel;

	@FXML
	private TextField idEncaminhaOutraTxt;

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
	private TextField idNumeroPessoasNaMoradia;

	@FXML
	private TextField idNumeroTrabalho;

	@FXML
	private ComboBox<String> idPeriodoAluno;
	@FXML
	private Label idQualAlergia;

	@FXML
	private Label idQualCirurgia;

	@FXML
	private Label idQualDeficiencia;

	@FXML
	private Label idQualDoenca;

	@FXML
	private Label idQualRemedio;
	@FXML
	private TextField idRgAluno;
	@FXML
	private TextField idRgMae;
	@FXML
	private TextField idRgPai;

	@FXML
	private TextField idRgResponsavel;

	@FXML
	private TextField idNomeRuaAluno;

	@FXML
	private TextField idSituacao;

	@FXML
	private TabPane idTabPane;

	@FXML
	private ComboBox<String> idSexoAluno;

	@FXML
	private TextField idTelFixoAluno;

	@FXML
	void onButtonBuscarAluno(ActionEvent event) {
		String msg = lecampo(idCpfAtualiza, "CPF do Aluno");
		if (msg == null) {
			return;
		} else {
			idCpfAtualiza.setText(CPF.formartCpf(msg));
			conectar_Atualizar(idCpfAtualiza.getText());
		}
	}

	@FXML
	void onButtonCancelarAction(ActionEvent event) {

	}

	private void conectar_Atualizar(String cpf) {
		AlunoDao alunodao = DaoFactory.createAlunoDao();
		Aluno aluno = alunodao.findByCpf(cpf);
		if (aluno != null) {
			idTabPane.getSelectionModel().select(1); /// mudando para o outro formulario ( outro ABA);
			idId.setText(aluno.getId().toString());
			idId.setEditable(false);
			idNomeAluno.setText(aluno.getNomeAluno());
			idDataCadastro.setText(aluno.getDataCadastro());
			idSituacao.setText(aluno.getSituacao());
			idSituacao.setEditable(false); // impedindo alteração aqui da situação do aluno.
			idRgAluno.setText(aluno.getRgAluno());
			idCpfAluno.setText(aluno.getCpfAluno());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String date = aluno.getDataNascimentoAluno();
			idDataNascimentoAluno.setValue(LocalDate.parse(date, formatter));
			idSexoAluno.setValue(aluno.getSexo());
			idNomeRuaAluno.setText(aluno.getNomeRuaAluno());
			IdNumeroRuaAluno.setText(aluno.getNumeroRuaAluno().toString());
			idBairroAluno.setText(aluno.getBairroAluno());
			idCepAluno.setText(aluno.getCepAluno());
			idCelularAluno.setText(aluno.getCelularAluno());
			idTelFixoAluno.setText(aluno.getTelFixoAluno());
			idEmailAluno.setText(aluno.getEmailAluno());
			idEscolaAluno.setText(aluno.getEscolaAluno());
			idPeriodoAluno.setValue(aluno.getPeriodoAluno());
			idAnoEscolarAluno.setValue(aluno.getAnoEscolarAluno());
			IdNomeMae.setText(aluno.getNomeMae());
			idRgMae.setText(aluno.getRgMae());
			idCpfMae.setText(aluno.getCpfMae());
			idCelularMae.setText(aluno.getCelularMae());
			IdNomePai.setText(aluno.getNomePai());
			idRgPai.setText(aluno.getRgPai());
			idCpfPai.setText(aluno.getCpfPai());
			idCelularPai.setText(aluno.getCelularPai());
			idNomeResponsavel.setText(aluno.getNomeResponsavel());
			idRgResponsavel.setText(aluno.getRgResponsavel());
			idCpfResponsavel.setText(aluno.getCpfResponsavel());
			idCelularResponsavel.setText(aluno.getCelularResponsavel());
			IdEnderecoTrabalho.setText(aluno.getEnderecoTrabalho());
			idNumeroTrabalho.setText(aluno.getNumeroTrabalho().toString());
			idCepTrabalho.setText(aluno.getCepTrabalho());

			switch (aluno.getMoradia()) {
			case "Própria": {
				idMoradiaPropria.setSelected(true);
				break;
			}
			case "Alugada": {
				idMoradiaAlugada.setSelected(true);
				break;
			}
			case "Financiada": {
				idMoradiaFinanciada.setSelected(true);
				break;
			}
			default:
				idMoradiaCedida.setSelected(true);
			}

			GrupoMoradia.setUserData(aluno.getMoradia());
			idNumeroPessoasNaMoradia.setText(aluno.getNumeroPessoasNaMoradia().toString());

			if (aluno.getAlergia().equals("SIM"))
				idAlergiaSim.setSelected(true);
			if (aluno.getDeficiencia().equals("SIM"))
				idDeficienciaSim.setSelected(true);
			if (aluno.getCirurgia().equals("SIM"))
				idCirurgiaSim.setSelected(true);
			if (aluno.getDoenca().equals("SIM"))
				idDoencaSim.setSelected(true);
			if (aluno.getRemedio().equals("SIM"))
				IdRemedioControladoSim.setSelected(true);

			idAlergiaQual.setText(aluno.getAlergiaQual());
			idDeficienciaQual.setText(aluno.getDeficienciaQual());
			idCirurgiaQual.setText(aluno.getCirurgiaQual());
			idDoencaQual.setText(aluno.getDoencaQual());
			IdRemedioControladoQual.setText(aluno.getRemedioQual());

			if (aluno.getBolsaFamilia().equals("SIM"))
				idBolsaFamiliaSim.setSelected(true);
			if (aluno.getBeneficio().equals("SIM"))
				idBeneficioSim.setSelected(true);
			if (aluno.getCadastroUnico().equals("SIM"))
				idCadastroUnicoSim.setSelected(true);

			idNumeroNIS.setText(aluno.getNumeroNIS().toString());

			switch (aluno.getEncaminha()) {
			case "Vara da Infância": {
				idEncaminhaVaraInfancia.setSelected(true);
				break;
			}
			case "Conselho Tutelar": {
				idEncaminhaConselhoTutelar.setSelected(true);
				break;
			}
			case "Cemaia": {
				idEncaminhaCemaia.setSelected(true);
				break;
			}
			case "Bem social": {
				idEncaminhaBemSocial.setSelected(true);
				break;
			}
			case "Vontade própria": {
				idEncaminhaVontadePropria.setSelected(true);
				break;
			}
			case "Caps": {
				idEncaminhaCaps.setSelected(true);
				break;
			}
			default:
				idEncaminhaOutra.setSelected(true);
				break;
			}
			idEncaminhaOutraTxt.setText(aluno.getEncaminhaOutra());

		} else

		{
			// String title, String header, String content, AlertType type
			Alerts.showAlert("Alerta de Erro", "CPF INEXISTENTE", cpf, AlertType.ERROR);
		}
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

		msg = lecampo(idId, "Id do Aluno");
		if (msg == null) {
			return;
		} else {
			aluno.setId(Integer.valueOf(msg));
		}

		msg = lecampo(idSituacao, "Data do Cadastro");
		if (msg == null) {
			return;
		} else {
			aluno.setSituacao(msg);
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

		aluno.setNomeRuaAluno(lecampo(idNomeRuaAluno, "Rua do Aluno"));

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

		aluno.setPeriodoAluno(idPeriodoAluno.getValue());
		aluno.setAnoEscolarAluno(idAnoEscolarAluno.getValue());

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
			aluno.setCpfPai(idCpfPai.getText());
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
			aluno.setEnderecoTrabalho(IdEnderecoTrabalho.getText());
		}

		msg = lecampo(idNumeroTrabalho, "Número da Residência do Responsável");
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
		msg = lecampo(idNumeroPessoasNaMoradia, "Número de Pessoas na Moradia");
		if (msg == null) {
			return;
		} else {
			aluno.setNumeroPessoasNaMoradia(Integer.valueOf(idNumeroPessoasNaMoradia.getText()));

		}
		if (radioResult(GrupoAlergia).equals("SIM")) {
			msg = lecampo(idAlergiaQual, "Tipo de Alergia");
			if (msg == null) {
				return;
			} else {
				aluno.setAlergiaQual(msg);
			}
		}
		if (radioResult(GrupoDeficiencia).equals("SIM")) {
			msg = lecampo(idDeficienciaQual, "Tipo de Deficiência");
			if (msg == null) {
				return;
			} else {
				aluno.setDeficienciaQual(msg);
			}
		}
		if (radioResult(GrupoCirurgia).equals("SIM")) {
			msg = lecampo(idDeficienciaQual, "Tipo de Cirurgia");
			if (msg == null) {
				return;
			} else {
				aluno.setCirurgiaQual(msg);
			}
		}
		if (radioResult(GrupoDoenca).equals("SIM")) {
			msg = lecampo(idDoencaQual, "Tipo de Doença");
			if (msg == null) {
				return;
			} else {
				aluno.setDoencaQual(msg);
			}
		}
		if (radioResult(GrupoRemedio).equals("SIM")) {
			msg = lecampo(IdRemedioControladoQual, "Tipo de Remédio");
			if (msg == null) {
				return;
			} else {
				aluno.setRemedioQual(msg);
			}
		}
		msg = lecampo(idNumeroNIS, "Número NIS");
		if (msg == null) {
			return;
		} else {
			aluno.setNumeroNIS(Integer.valueOf(idNumeroNIS.getText()));
		}

		aluno.setEncaminhaOutra(idEncaminhaOutraTxt.getText());

		if (radioResult(GrupoEncaminha).equals("Outra")) {
			msg = lecampo(idEncaminhaOutraTxt, "Outra Forma de Encaminhamento");
			if (msg == null) {
				return;
			} else {
				aluno.setEncaminhaOutra(msg);
			}
		}
		conectar_salvar(aluno);
	}

	public void conectar_salvar(Aluno aluno) {

		AlunoDao alunodao = DaoFactory.createAlunoDao();
		alunodao.update(aluno);
	}

	public String lecampo(TextField id, String msg) {
		if (id.getText() == null || id.getText().trim().equals("")) {
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

		idPeriodoAluno.getItems().addAll("Matutino", "Vespertino");
		idPeriodoAluno.setValue("Período ...");

		idAnoEscolarAluno.getItems().addAll("Nenhuma", "Primeira", "Segunda", "Terceira", "Quarta", "Quinta", "Sexta",
				"Oitava");
		idAnoEscolarAluno.setValue("Série ...");

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
		Constraints.setTextFieldInteger(idNumeroPessoasNaMoradia);
		Constraints.setTextFieldInteger(idNumeroTrabalho);
		Constraints.setTextFieldInteger(idNumeroNIS);

		GrupoMoradia.selectedToggleProperty()
				.addListener((observable, oldVal, newVal) -> aluno.setMoradia(radioResult(GrupoMoradia)));

		GrupoAlergia.selectedToggleProperty().addListener((observable, oldVal, newVal) -> {
			aluno.setAlergia(radioResult(GrupoAlergia));
			if (radioResult(GrupoAlergia).equals("SIM")) {
				idQualAlergia.setVisible(true);
				idAlergiaQual.setVisible(true);
			} else {
				idQualAlergia.setVisible(false);
				idAlergiaQual.setVisible(false);
				aluno.setAlergiaQual(null);
				idAlergiaQual.setText(null);
			}
		});

		GrupoDeficiencia.selectedToggleProperty().addListener((observable, oldVal, newVal) -> {
			aluno.setDeficiencia(radioResult(GrupoDeficiencia));
			if (radioResult(GrupoDeficiencia).equals("SIM")) {
				idQualDeficiencia.setVisible(true);
				idDeficienciaQual.setVisible(true);
			} else {
				idQualDeficiencia.setVisible(false);
				idDeficienciaQual.setVisible(false);
				aluno.setDeficienciaQual(null);
				idDeficienciaQual.setText(null);
			}
		});

		GrupoCirurgia.selectedToggleProperty().addListener((observable, oldVal, newVal) -> {
			aluno.setCirurgia(radioResult(GrupoCirurgia));
			if (radioResult(GrupoCirurgia).equals("SIM")) {
				idQualCirurgia.setVisible(true);
				idCirurgiaQual.setVisible(true);
			} else {
				idQualCirurgia.setVisible(false);
				idCirurgiaQual.setVisible(false);
				aluno.setCirurgiaQual(null);
				idCirurgiaQual.setText(null);
			}
		});

		GrupoDoenca.selectedToggleProperty().addListener((observable, oldVal, newVal) -> {
			aluno.setDoenca(radioResult(GrupoDoenca));
			if (radioResult(GrupoDoenca).equals("SIM")) {
				idQualDoenca.setVisible(true);
				idDoencaQual.setVisible(true);
			} else {
				idQualDoenca.setVisible(false);
				idDoencaQual.setVisible(false);
				aluno.setDoencaQual(null);
				idDoencaQual.setText(null);

			}
		});

		GrupoRemedio.selectedToggleProperty().addListener((observable, oldVal, newVal) -> {
			aluno.setRemedio(radioResult(GrupoRemedio));
			if (radioResult(GrupoRemedio).equals("SIM")) {
				idQualRemedio.setVisible(true);
				IdRemedioControladoQual.setVisible(true);
			} else {
				idQualRemedio.setVisible(false);
				IdRemedioControladoQual.setVisible(false);
				aluno.setRemedioQual(null);
				IdRemedioControladoQual.setText(null);
			}
		});

		GrupoBolsaFamilia.selectedToggleProperty()
				.addListener((observable, oldVal, newVal) -> aluno.setBolsaFamilia(radioResult(GrupoBolsaFamilia)));
		GrupoBeneficio.selectedToggleProperty()
				.addListener((observable, oldVal, newVal) -> aluno.setBeneficio(radioResult(GrupoBeneficio)));
		GrupoCadUnico.selectedToggleProperty()
				.addListener((observable, oldVal, newVal) -> aluno.setCadastroUnico(radioResult(GrupoCadUnico)));

		GrupoEncaminha.selectedToggleProperty().addListener((observable, oldVal, newVal) -> {
			aluno.setEncaminha(radioResult(GrupoEncaminha));
			if (radioResult(GrupoEncaminha).equals("Outra")) {
				idEncaminhaOutraLabel.setVisible(true);
				idEncaminhaOutraTxt.setVisible(true);
			} else {
				idEncaminhaOutraLabel.setVisible(false);
				idEncaminhaOutraTxt.setVisible(false);
				idEncaminhaOutraTxt.setText(null);
				aluno.setEncaminhaOutra(null);
			}
		}

		);

		// controlando o tamanho dos campos

		Constraints.setTextFieldMaxLength(idNomeAluno, 60);
		Constraints.setTextFieldMaxLength(idDataCadastro, 10);
		Constraints.setTextFieldMaxLength(idRgAluno, 15);
		Constraints.setTextFieldMaxLength(idCpfAluno, 15);
		Constraints.setTextFieldMaxLength(IdNumeroRuaAluno, 4);
		Constraints.setTextFieldMaxLength(idBairroAluno, 60);
		Constraints.setTextFieldMaxLength(idCepAluno, 20);
		Constraints.setTextFieldMaxLength(idCelularAluno, 15);
		Constraints.setTextFieldMaxLength(idTelFixoAluno, 20);
		Constraints.setTextFieldMaxLength(idEmailAluno, 60);
		Constraints.setTextFieldMaxLength(idEscolaAluno, 60);
		Constraints.setTextFieldMaxLength(IdNomeMae, 60);
		Constraints.setTextFieldMaxLength(idRgMae, 15);
		Constraints.setTextFieldMaxLength(idCpfMae, 15);
		Constraints.setTextFieldMaxLength(idCelularMae, 15);
		Constraints.setTextFieldMaxLength(IdNomePai, 60);
		Constraints.setTextFieldMaxLength(idRgPai, 15);
		Constraints.setTextFieldMaxLength(idCpfPai, 15);
		Constraints.setTextFieldMaxLength(idCelularPai, 15);
		Constraints.setTextFieldMaxLength(idNomeResponsavel, 60);
		Constraints.setTextFieldMaxLength(idRgResponsavel, 20);
		Constraints.setTextFieldMaxLength(idCpfResponsavel, 15);
		Constraints.setTextFieldMaxLength(idCelularResponsavel, 15);
		Constraints.setTextFieldMaxLength(IdEnderecoTrabalho, 60);
		Constraints.setTextFieldMaxLength(idCepTrabalho, 20);
		Constraints.setTextFieldMaxLength(idAlergiaQual, 60);
		Constraints.setTextFieldMaxLength(idDeficienciaQual, 60);
		Constraints.setTextFieldMaxLength(idCirurgiaQual, 60);
		Constraints.setTextFieldMaxLength(idDoencaQual, 60);
		Constraints.setTextFieldMaxLength(IdRemedioControladoQual, 60);
		Constraints.setTextFieldMaxLength(idNumeroNIS, 11);
		Constraints.setTextFieldMaxLength(idEncaminhaOutraTxt, 60);

	}

}
