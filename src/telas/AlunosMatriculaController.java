package telas;

import java.io.IOException;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.dao.AlunoDao;
import model.dao.DaoFactory;
import model.entities.Aluno;
import utilAlerts.Alerts;
import utilAlerts.CPF;

public class AlunosMatriculaController implements Initializable {


	Aluno aluno = new Aluno();

	@FXML
	private Button idButtonCancelar;

	@FXML
	private Button idButtonDesligar;

	@FXML
	private Button idButtonMatricular;

	@FXML
	private ComboBox<String> idComboTurmaEspecial;

	@FXML
	private ComboBox<String> idComboTurmaRegular;

	@FXML
	private TextField idCpfAluno;

	@FXML
	private Label idDataCadastroValue;

	@FXML
	private Label idDataDeslValue;

	@FXML
	private Label idDataMatriValue;

	@FXML
	private Label idDataNascValue;

	@FXML
	private Label idDataSituacaoValue;

	@FXML
	private GridPane idGridNome;

	@FXML
	private GridPane idGridTurma;

	@FXML
	private Label idNomeValue;

	@FXML
	private Label idTurmaEspecialValue;

	@FXML
	private Label idTurmaRegularValue;

	@FXML
	void OnCancelar(ActionEvent event) throws IOException {
		idGridNome.setVisible(false);
		idGridTurma.setVisible(false);
		idCpfAluno.clear();
	}

	@FXML
	void onButtonDesligar(ActionEvent event) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.now();
		idDataDeslValue.setText(dtf.format(localDate));
		aluno.setDataExclusao(idDataDeslValue.getText());
		aluno.setSituacao("Desligado");
		AlunoDao alunodao = DaoFactory.createAlunoDao();
		alunodao.update(aluno);
		idDataSituacaoValue.setText(aluno.getSituacao());
		idTurmaRegularValue.setText("Nenhuma");
		idTurmaEspecialValue.setText("Nenhuma");
	}

	@FXML
	void onMatricular(ActionEvent event) {
		String msg = lecampo(idCpfAluno, "CPF do Aluno");
		if (msg == null) {
			return;
		}
		// verificando se houve mudança na situaão do matricula em turma regular

		if (!idComboTurmaRegular.getValue().equals(aluno.getTurmaRegular())) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate localDate = LocalDate.now();
			idDataMatriValue.setText(dtf.format(localDate));
		}
		aluno.setDataMatricula(idDataMatriValue.getText());
		aluno.setSituacao("Matriculado");
		aluno.setTurmaRegular(idComboTurmaRegular.getValue());
		aluno.setTurmaEspecial(idComboTurmaEspecial.getValue());
		AlunoDao alunodao = DaoFactory.createAlunoDao();
		alunodao.update(aluno);
		idDataSituacaoValue.setText(aluno.getSituacao());
		idDataDeslValue.setText("");
		idTurmaRegularValue.setText(aluno.getTurmaRegular());
		idTurmaEspecialValue.setText(aluno.getTurmaEspecial());

	}

	@FXML
	void onCpfAlunoAction(ActionEvent event) {
		idGridNome.setVisible(false);
		idGridTurma.setVisible(false);

		String msg = lecampo(idCpfAluno, "CPF do Aluno");
		if (msg == null) {
			return;
		} else {
			idCpfAluno.setText(CPF.formartCpf(msg));
			String cpf = idCpfAluno.getText();
			AlunoDao alunodao = DaoFactory.createAlunoDao();
			if (alunodao.findByCpf(cpf) == null) {
				Alerts.showAlert("Atenção !", "", "CPF não cadastrado", AlertType.WARNING);
			} else {
				idGridNome.setVisible(true);
				idGridTurma.setVisible(true);
				aluno = alunodao.findByCpf(cpf);
				idNomeValue.setText(aluno.getNomeAluno());

				idDataDeslValue.setText(aluno.getDataExclusao());
				idDataMatriValue.setText(aluno.getDataMatricula());
				idDataCadastroValue.setText(aluno.getDataCadastro());
				idDataNascValue.setText(aluno.getDataNascimentoAluno());
				idDataSituacaoValue.setText(aluno.getSituacao());
				idTurmaRegularValue.setText(aluno.getTurmaRegular());
				idTurmaEspecialValue.setText(aluno.getTurmaEspecial());
			}
		}
	}

	private String lecampo(TextField id, String msg) {
		if (id.getText() == null || id.getText().trim().equals("")) {
			Alerts.showAlert(null, "CAMPO VAZIO", "Entre com o valor do " + msg, AlertType.ERROR);
			return null;
		} else {
			return id.getText();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		idComboTurmaRegular.getItems().addAll("Nenhuma", "Manhã(M1)", "Manhã(M2)", "Manhã(M3)", "Manhã(M4)",
				"Tarde(T1)", "Tarde(T2)", "Tarde(T3)", "Tarde(T4)");
		idComboTurmaEspecial.getItems().addAll("Nenhuma", "Manhã(ME1)", "Manhã(ME2)", "Manhã(ME3)", "Manhã(ME4)",
				"Tarde(TE1)", "Tarde(TE2)", "Tarde(TE3)", "Tarde(TE4)");
		idComboTurmaEspecial.setValue("Nenhuma");
		idComboTurmaRegular.setValue("Nenhuma");
		idGridNome.setVisible(false);
		idGridTurma.setVisible(false);
	}

}
