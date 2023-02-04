package telas;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import utilAlerts.Alerts;

public class MainViewController implements Initializable {

	@FXML
	private MenuItem menuItemAlunoMatricula;
	@FXML
	private MenuItem menuItemAlunoNovo;
	@FXML
	private MenuItem menuItemAlunoAtualiza;
	@FXML
	private MenuItem menuItemAlunoRemove;
	@FXML
	private MenuItem menuItemProfessorNovo;
	@FXML
	private MenuItem menuItemProfessorAtualiza;
	@FXML
	private MenuItem menuItemProfessorRemove;
	@FXML
	private MenuItem menuItemTurmaNova;
	@FXML
	private MenuItem menuItemTurmaAtualiza;
	@FXML
	private MenuItem menuItemTurmaRemove;
	@FXML
	private MenuItem menuItemRelatoriosAlunosMatriculados;
	@FXML
	private MenuItem menuItemRelatoriosAlunosEmEspera;
	@FXML
	private MenuItem menuItemRelatoriosExAlunos;
	@FXML
	private MenuItem menuItemRelatorioDiario;
	@FXML
	private MenuItem menuItemRelatoriosMatrizProfessor;
	@FXML
	private MenuItem menuItemRelatoriosMatrizAluno;
	@FXML
	private MenuItem menuItemSobre;

	@FXML
	public void onMenuItemAlunoNovo() {
		loadView("/telas/AlunosCadastroNovo.fxml");
	}

	@FXML
	public void onMenuItemAlunoAtualiza() {
		loadView("/telas/AlunosCadastroAtualiza.fxml");
	}

	@FXML
	public void onMenuItemAlunoRemove() {
		System.out.println("Aluno Remove");
		loadView("/telas/AlunosCadastroRemove.fxml");
	}

	@FXML
	void onMenuItemAlunoMatricula(ActionEvent event) {
		System.out.println("Aluno Matricula");
		loadView("/telas/AlunosMatricula.fxml");
	}

	public void onMenuItemProfessorNovo() {
		System.out.println("Professor Novo");
		loadView("/telas/ProfessoresCadastroNovo.fxml");
	}

	@FXML
	public void onMenuItemProfessorAtualiza() {
		System.out.println("Professor Atualiza");
	}

	@FXML
	public void onMenuItemProfessorRemove() {
		System.out.println("Professor Remove");
	}

	public void onMenuItemTurmaNova() {
		System.out.println("Turma Nova");
	}

	@FXML
	public void onMenuItemTurmaAtualiza() {
		System.out.println("Turma Atualiza");
	}

	@FXML
	public void onMenuItemTurmaRemove() {
		System.out.println("Turma Remove");
	}

	@FXML
	public void onMenuItemRelatoriosAlunosMatriculados() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("JDBC:MYSQL://localhost:3306/gestaoescolar", "root",
					"1234567");

			String sql = "SELECT * FROM aluno  WHERE Situacao = 'Matriculado' ORDER BY NomeAluno";
			JasperDesign jdesign = JRXmlLoader.load(
					"C:\\Users\\jribe\\eclipse-workspace\\MariaLobatoGenteJovem\\src\\JasperReports\\ReportAluno.jrxml");
			JRDesignQuery updateQuery = new JRDesignQuery();
			updateQuery.setText(sql);
			jdesign.setQuery(updateQuery);

			JasperReport jreport = JasperCompileManager.compileReport(jdesign);
			JasperPrint jprint = JasperFillManager.fillReport(jreport, null, con);
			JasperViewer.viewReport(jprint, false);

			System.out.println(sql);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	@FXML
	public void onMenuItemRelatoriosAlunosEmEspera() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("JDBC:MYSQL://localhost:3306/gestaoescolar", "root",
					"1234567");
			String sql = "SELECT * FROM aluno  WHERE Situacao = 'Em espera' ORDER BY NomeAluno";
			JasperDesign jdesign = JRXmlLoader.load(
					"C:\\Users\\jribe\\eclipse-workspace\\MariaLobatoGenteJovem\\src\\JasperReports\\ReportAluno.jrxml");
			JRDesignQuery updateQuery = new JRDesignQuery();
			updateQuery.setText(sql);
			jdesign.setQuery(updateQuery);

			JasperReport jreport = JasperCompileManager.compileReport(jdesign);
			JasperPrint jprint = JasperFillManager.fillReport(jreport, null, con);
			JasperViewer.viewReport(jprint, false);

			System.out.println(sql);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	@FXML
	public void onMenuItemRelatoriosExAlunos() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("JDBC:MYSQL://localhost:3306/gestaoescolar", "root",
					"1234567");

			String sql = "SELECT * FROM aluno  WHERE Situacao = 'Desligado' ORDER BY NomeAluno";
			JasperDesign jdesign = JRXmlLoader.load(
					"C:\\Users\\jribe\\eclipse-workspace\\MariaLobatoGenteJovem\\src\\JasperReports\\ReportAluno.jrxml");
			JRDesignQuery updateQuery = new JRDesignQuery();
			updateQuery.setText(sql);
			jdesign.setQuery(updateQuery);

			JasperReport jreport = JasperCompileManager.compileReport(jdesign);
			JasperPrint jprint = JasperFillManager.fillReport(jreport, null, con);
			JasperViewer.viewReport(jprint, false);

			System.out.println(sql);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	@FXML
	public void onMenuItemSobre() {
		System.out.println("Sobre ...");
	}

	@FXML
	public void onMenuItemRelatorioDiario() {
		System.out.println("Diario");
				loadView("/telas/RelatoriosTurmas.fxml");
	}

	@FXML
	public void onMenuItemRelatoriosMatrizAluno() {
		System.out.println("Matriz Aluno");
	}

	@FXML
	public void onMenuItemRelatoriosPMU() {
		loadView("/telas/RelatorioPrefeitura.fxml");

	}

	public synchronized void loadView(String absoluteName) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
		try {
			VBox newVBox = loader.load();
			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) (((ScrollPane) (mainScene.getRoot())).getContent());
			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());

		} catch (IOException e) {
			Alerts.showAlert("IO Exception", "Errore loading view", e.getMessage(), AlertType.ERROR);
		}
	}
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

}
