package entities;

import java.io.Serializable;
import java.util.Date;

public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nomeAluno;
	private Date dataCadastro;
	private String codigo;
	private String situacao;
	private String rgAluno;
	private String cpfAluno;
	private Date dataNascimentoAluno;
	private String ruaAluno;
	private Integer numeroRuaAluno;
	private String bairroAluno;
	private String cepAluno;
	private String celularAluno;
	private String telFixoAluno;
	private String emailAluno;
	private String escolaAluno;
	private String periodoAluno;
	private String anoEscolarAluno;
	private String nomeMae;
	private String rgMae;
	private String cpfMae;
	private String celularMae;
	private String nomePai;
	private String rgPai;
	private String cpfPai;
	private String celularPai;
	private String nomeResponsavel;
	private String rgResponsavel;
	private String cpfResponsavel;
	private String celularResponsavel;
	private String enderecoTrabalho;
	private Integer numeroTrabalho;
	private String cepTrabalho;
	private String moradia;
	private Boolean alergia;
	private String alergiaQual;
	private Boolean deficiencia;
	private String deficienciaQual;
	private Boolean cirurgia;
	private String cirurgiaQual;
	private Boolean doenca;
	private String doencaQual;
	private Boolean remedio;
	private String remedioQual;
	private Boolean bolsaFamilia;
	private Boolean beneficio;
	private Boolean cadastroUnico;
	private String numeroCIS;
	private String encaminha;
	private String encaminhaOutra;

	public Aluno() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getRgAluno() {
		return rgAluno;
	}

	public void setRgAluno(String rgAluno) {
		this.rgAluno = rgAluno;
	}

	public String getCpfAluno() {
		return cpfAluno;
	}

	public void setCpfAluno(String cpfAluno) {
		this.cpfAluno = cpfAluno;
	}

	public Date getDataNascimentoAluno() {
		return dataNascimentoAluno;
	}

	public void setDataNascimentoAluno(Date dataNascimentoAluno) {
		this.dataNascimentoAluno = dataNascimentoAluno;
	}

	public String getRuaAluno() {
		return ruaAluno;
	}

	public void setRuaAluno(String ruaAluno) {
		this.ruaAluno = ruaAluno;
	}

	public Integer getNumeroRuaAluno() {
		return numeroRuaAluno;
	}

	public void setNumeroRuaAluno(Integer numeroRuaAluno) {
		this.numeroRuaAluno = numeroRuaAluno;
	}

	public String getBairroAluno() {
		return bairroAluno;
	}

	public void setBairroAluno(String bairroAluno) {
		this.bairroAluno = bairroAluno;
	}

	public String getCepAluno() {
		return cepAluno;
	}

	public void setCepAluno(String cepAluno) {
		this.cepAluno = cepAluno;
	}

	public String getCelularAluno() {
		return celularAluno;
	}

	public void setCelularAluno(String celularAluno) {
		this.celularAluno = celularAluno;
	}

	public String getTelFixoAluno() {
		return telFixoAluno;
	}

	public void setTelFixoAluno(String telFixoAluno) {
		this.telFixoAluno = telFixoAluno;
	}

	public String getEmailAluno() {
		return emailAluno;
	}

	public void setEmailAluno(String emailAluno) {
		this.emailAluno = emailAluno;
	}

	public String getEscolaAluno() {
		return escolaAluno;
	}

	public void setEscolaAluno(String escolaAluno) {
		this.escolaAluno = escolaAluno;
	}

	public String getPeriodoAluno() {
		return periodoAluno;
	}

	public void setPeriodoAluno(String periodoAluno) {
		this.periodoAluno = periodoAluno;
	}

	public String getAnoEscolarAluno() {
		return anoEscolarAluno;
	}

	public void setAnoEscolarAluno(String anoEscolarAluno) {
		this.anoEscolarAluno = anoEscolarAluno;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getRgMae() {
		return rgMae;
	}

	public void setRgMae(String rgMae) {
		this.rgMae = rgMae;
	}

	public String getCpfMae() {
		return cpfMae;
	}

	public void setCpfMae(String cpfMae) {
		this.cpfMae = cpfMae;
	}

	public String getCelularMae() {
		return celularMae;
	}

	public void setCelularMae(String celularMae) {
		this.celularMae = celularMae;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getRgPai() {
		return rgPai;
	}

	public void setRgPai(String rgPai) {
		this.rgPai = rgPai;
	}

	public String getCpfPai() {
		return cpfPai;
	}

	public void setCpfPai(String cpfPai) {
		this.cpfPai = cpfPai;
	}

	public String getCelularPai() {
		return celularPai;
	}

	public void setCelularPai(String celularPai) {
		this.celularPai = celularPai;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public String getRgResponsavel() {
		return rgResponsavel;
	}

	public void setRgResponsavel(String rgResponsavel) {
		this.rgResponsavel = rgResponsavel;
	}

	public String getCpfResponsavel() {
		return cpfResponsavel;
	}

	public void setCpfResponsavel(String cpfResponsavel) {
		this.cpfResponsavel = cpfResponsavel;
	}

	public String getCelularResponsavel() {
		return celularResponsavel;
	}

	public void setCelularResponsavel(String celularResponsavel) {
		this.celularResponsavel = celularResponsavel;
	}

	public String getEnderecoTrabalho() {
		return enderecoTrabalho;
	}

	public void setEnderecoTrabalho(String enderecoTrabalho) {
		this.enderecoTrabalho = enderecoTrabalho;
	}

	public Integer getNumeroTrabalho() {
		return numeroTrabalho;
	}

	public void setNumeroTrabalho(Integer numeroTrabalho) {
		this.numeroTrabalho = numeroTrabalho;
	}

	public String getCepTrabalho() {
		return cepTrabalho;
	}

	public void setCepTrabalho(String cepTrabalho) {
		this.cepTrabalho = cepTrabalho;
	}

	public String getMoradia() {
		return moradia;
	}

	public void setMoradia(String moradia) {
		this.moradia = moradia;
	}

	public Boolean getAlergia() {
		return alergia;
	}

	public void setAlergia(Boolean alergia) {
		this.alergia = alergia;
	}

	public String getAlergiaQual() {
		return alergiaQual;
	}

	public void setAlergiaQual(String alergiaQual) {
		this.alergiaQual = alergiaQual;
	}

	public Boolean getDeficiencia() {
		return deficiencia;
	}

	public void setDeficiencia(Boolean deficiencia) {
		this.deficiencia = deficiencia;
	}

	public String getDeficienciaQual() {
		return deficienciaQual;
	}

	public void setDeficienciaQual(String deficienciaQual) {
		this.deficienciaQual = deficienciaQual;
	}

	public Boolean getCirurgia() {
		return cirurgia;
	}

	public void setCirurgia(Boolean cirurgia) {
		this.cirurgia = cirurgia;
	}

	public String getCirurgiaQual() {
		return cirurgiaQual;
	}

	public void setCirurgiaQual(String cirurgiaQual) {
		this.cirurgiaQual = cirurgiaQual;
	}

	public Boolean getDoenca() {
		return doenca;
	}

	public void setDoenca(Boolean doenca) {
		this.doenca = doenca;
	}

	public String getDoencaQual() {
		return doencaQual;
	}

	public void setDoencaQual(String doencaQual) {
		this.doencaQual = doencaQual;
	}

	public Boolean getRemedio() {
		return remedio;
	}

	public void setRemedio(Boolean remedio) {
		this.remedio = remedio;
	}

	public String getRemedioQual() {
		return remedioQual;
	}

	public void setRemedioQual(String remedioQual) {
		this.remedioQual = remedioQual;
	}

	public Boolean getBolsaFamilia() {
		return bolsaFamilia;
	}

	public void setBolsaFamilia(Boolean bolsaFamilia) {
		this.bolsaFamilia = bolsaFamilia;
	}

	public Boolean getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(Boolean beneficio) {
		this.beneficio = beneficio;
	}

	public Boolean getCadastroUnico() {
		return cadastroUnico;
	}

	public void setCadastroUnico(Boolean cadastroUnico) {
		this.cadastroUnico = cadastroUnico;
	}

	public String getNumeroCIS() {
		return numeroCIS;
	}

	public void setNumeroCIS(String numeroCIS) {
		this.numeroCIS = numeroCIS;
	}

	public String getEncaminha() {
		return encaminha;
	}

	public void setEncaminha(String encaminha) {
		this.encaminha = encaminha;
	}

	public String getEncaminhaOutra() {
		return encaminhaOutra;
	}

	public void setEncaminhaOutra(String encaminhaOutra) {
		this.encaminhaOutra = encaminhaOutra;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
