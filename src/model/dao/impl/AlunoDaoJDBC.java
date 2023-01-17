package model.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.AlunoDao;
import model.entities.Aluno;
import model.entities.Turma;


public class AlunoDaoJDBC implements AlunoDao {

	private Connection conn;

	public AlunoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Aluno obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO seller "
					+ "(Id,NomeAluno , DataCadastro , Situacao , RgAluno , CpfAluno ,"
					+ " DataNascimentoAluno , RuaAluno , NumeroRuaAluno , BairroAluno ,"
					+ " CepAluno , CelularAluno , TelFixoAluno , EmailAluno ,"
					+ " EscolaAluno , PeriodoAluno , AnoEscolarAluno ," + " NomeMae , RgMae , CpfMae , CelularMae ,"
					+ " NomePai , RgPai , CpfPai , CelularPai , "
					+ "NomeResponsavel , RgResponsavel , CpfResponsavel , CelularResponsavel ,"
					+ " EnderecoTrabalho , NumeroTrabalho , CepTrabalho , "
					+ "Moradia , Alergia , AlergiaQual , Deficiencia , DeficienciaQual ,"
					+ " Cirurgia , CirurgiaQual , Doenca , DoencaQual , Remedio , RemedioQual ,"
					+ " BolsaFamilia , Beneficio , CadastroUnico , NumeroCIS ," + " Encaminha , EncaminhaOutra ) "
					+ "VALUES " + "(?,?,?,?,?,?,?,?,?,?" + "?,?,?,?,?,?,?,?,?,?" + "?,?,?,?,?,?,?,?,?,?"
					+ "?,?,?,?,?,?,?,?,?,?" + "?,?,?,?,?,?,?,?,?,)", Statement.RETURN_GENERATED_KEYS);

			st.setInt(1, obj.getId());
			st.setString(2, obj.getNomeAluno());
			st.setDate(3, (Date) obj.getDataCadastro());
			st.setString(4, obj.getSituacao());
			st.setString(5, obj.getRgAluno());
			st.setString(6, obj.getCpfAluno());
			st.setDate(7, (Date) obj.getDataCadastro());
			st.setString(8, obj.getRuaAluno());
			st.setInt(9, obj.getNumeroRuaAluno());
			st.setString(10, obj.getBairroAluno());
			st.setString(11, obj.getCepAluno());
			st.setString(12, obj.getCelularAluno());
			st.setString(13, obj.getTelFixoAluno());
			st.setString(14, obj.getEmailAluno());
			st.setString(15, obj.getEscolaAluno());
			st.setString(16, obj.getPeriodoAluno());
			st.setString(17, obj.getAnoEscolarAluno());
			st.setString(18, obj.getNomeMae());
			st.setString(19, obj.getRgMae());
			st.setString(20, obj.getCpfMae());
			st.setString(21, obj.getCelularMae());
			st.setString(22, obj.getNomePai());
			st.setString(23, obj.getRgPai());
			st.setString(24, obj.getCpfPai());
			st.setString(25, obj.getCelularPai());
			st.setString(26, obj.getNomeResponsavel());
			st.setString(27, obj.getRgResponsavel());
			st.setString(28, obj.getCpfResponsavel());
			st.setString(29, obj.getCelularResponsavel());
			st.setString(30, obj.getEnderecoTrabalho());
			st.setInt(31, obj.getNumeroTrabalho());
			st.setString(32, obj.getCepTrabalho());
			st.setString(33, obj.getMoradia());
			st.setBoolean(34, obj.getAlergia());
			st.setString(35, obj.getAlergiaQual());
			st.setBoolean(36, obj.getDeficiencia());
			st.setString(37, obj.getDeficienciaQual());
			st.setBoolean(38, obj.getCirurgia());
			st.setString(39, obj.getCirurgiaQual());
			st.setBoolean(40, obj.getDoenca());
			st.setString(41, obj.getDoencaQual());
			st.setBoolean(42, obj.getRemedio());
			st.setString(43, obj.getRemedioQual());
			st.setBoolean(44, obj.getBolsaFamilia());
			st.setBoolean(45, obj.getBeneficio());
			st.setBoolean(46, obj.getCadastroUnico());
			st.setString(47, obj.getNumeroCIS());
			st.setString(48, obj.getEncaminha());
			st.setString(49, obj.getEncaminhaOutra());

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);
			} else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Aluno obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO seller "
					+ "(Id,NomeAluno , DataCadastro , Situacao , RgAluno , CpfAluno ,"
					+ " DataNascimentoAluno , RuaAluno , NumeroRuaAluno , BairroAluno ,"
					+ " CepAluno , CelularAluno , TelFixoAluno , EmailAluno ,"
					+ " EscolaAluno , PeriodoAluno , AnoEscolarAluno ," + " NomeMae , RgMae , CpfMae , CelularMae ,"
					+ " NomePai , RgPai , CpfPai , CelularPai , "
					+ "NomeResponsavel , RgResponsavel , CpfResponsavel , CelularResponsavel ,"
					+ " EnderecoTrabalho , NumeroTrabalho , CepTrabalho , "
					+ "Moradia , Alergia , AlergiaQual , Deficiencia , DeficienciaQual ,"
					+ " Cirurgia , CirurgiaQual , Doenca , DoencaQual , Remedio , RemedioQual ,"
					+ " BolsaFamilia , Beneficio , CadastroUnico , NumeroCIS ," + " Encaminha , EncaminhaOutra ) "
					+ "VALUES " + "(?,?,?,?,?,?,?,?,?,?" + "?,?,?,?,?,?,?,?,?,?" + "?,?,?,?,?,?,?,?,?,?"
					+ "?,?,?,?,?,?,?,?,?,?" + "?,?,?,?,?,?,?,?,?,)", Statement.RETURN_GENERATED_KEYS);

			st.setInt(1, obj.getId());
			st.setString(2, obj.getNomeAluno());
			st.setDate(3,(Date) new java.util.Date(obj.getDataCadastro().getTime()));
			st.setString(4, obj.getSituacao());
			st.setString(5, obj.getRgAluno());
			st.setString(6, obj.getCpfAluno());
			st.setDate(7, (Date) obj.getDataCadastro());
			st.setString(8, obj.getRuaAluno());
			st.setInt(9, obj.getNumeroRuaAluno());
			st.setString(10, obj.getBairroAluno());
			st.setString(11, obj.getCepAluno());
			st.setString(12, obj.getCelularAluno());
			st.setString(13, obj.getTelFixoAluno());
			st.setString(14, obj.getEmailAluno());
			st.setString(15, obj.getEscolaAluno());
			st.setString(16, obj.getPeriodoAluno());
			st.setString(17, obj.getAnoEscolarAluno());
			st.setString(18, obj.getNomeMae());
			st.setString(19, obj.getRgMae());
			st.setString(20, obj.getCpfMae());
			st.setString(21, obj.getCelularMae());
			st.setString(22, obj.getNomePai());
			st.setString(23, obj.getRgPai());
			st.setString(24, obj.getCpfPai());
			st.setString(25, obj.getCelularPai());
			st.setString(26, obj.getNomeResponsavel());
			st.setString(27, obj.getRgResponsavel());
			st.setString(28, obj.getCpfResponsavel());
			st.setString(29, obj.getCelularResponsavel());
			st.setString(30, obj.getEnderecoTrabalho());
			st.setInt(31, obj.getNumeroTrabalho());
			st.setString(32, obj.getCepTrabalho());
			st.setString(33, obj.getMoradia());
			st.setBoolean(34, obj.getAlergia());
			st.setString(35, obj.getAlergiaQual());
			st.setBoolean(36, obj.getDeficiencia());
			st.setString(37, obj.getDeficienciaQual());
			st.setBoolean(38, obj.getCirurgia());
			st.setString(39, obj.getCirurgiaQual());
			st.setBoolean(40, obj.getDoenca());
			st.setString(41, obj.getDoencaQual());
			st.setBoolean(42, obj.getRemedio());
			st.setString(43, obj.getRemedioQual());
			st.setBoolean(44, obj.getBolsaFamilia());
			st.setBoolean(45, obj.getBeneficio());
			st.setBoolean(46, obj.getCadastroUnico());
			st.setString(47, obj.getNumeroCIS());
			st.setString(48, obj.getEncaminha());
			st.setString(49, obj.getEncaminhaOutra());

			st.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}
	/*
	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM seller WHERE Id = ?");

			st.setInt(1, id);

			st.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public Aluno findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT aluno.*,department.Name as DepName " + "FROM seller INNER JOIN department "
							+ "ON seller.TurmaId = department.Id " + "WHERE seller.Id = ?");

			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Turma turma = instantiateTurma(rs);
				Aluno obj = instantiateAluno(rs, turma);
				return obj;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
 */
		private Aluno instantiateAluno(ResultSet rs, Turma turma) throws SQLException {
		Aluno obj = new Aluno();
		obj.setId(rs.getInt("Id"));
		obj.setNomeAluno(rs.getString("NomeAluno"));
		obj.setDataCadastro(new java.util.Date(rs.getDate("DataCadastro").getTime()));
		obj.setSituacao(rs.getString("Situacao"));
		obj.setRgAluno(rs.getString("RgAluno"));
		obj.setCpfAluno(rs.getString("CpfAluno"));
		obj.setDataNascimentoAluno(new java.util.Date(rs.getDate("NascimentoAluno").getTime()));
		obj.setRuaAluno(rs.getString("RuaAluno"));
		obj.setNumeroRuaAluno(rs.getInt("NumeroRuaAluno"));
		obj.setBairroAluno(rs.getString("BairroAluno"));
		obj.setCepAluno(rs.getString("CepAluno"));
		obj.setCelularAluno(rs.getString("CelularAluno"));
		obj.setTelFixoAluno(rs.getString("TelFixoAluno"));
		obj.setEmailAluno(rs.getString("EmailAluno"));
		obj.setEscolaAluno(rs.getString("EscolaAluno"));
		obj.setPeriodoAluno(rs.getString("PeriodoAluno"));
		obj.setAnoEscolarAluno(rs.getString("AnoEscolarAluno"));
		obj.setNomeMae(rs.getString("NomeMae"));
		obj.setRgMae(rs.getString("RgMae"));
		obj.setCpfMae(rs.getString("CpfMae"));
		obj.setCelularMae(rs.getString("CelularMae"));
		obj.setNomePai(rs.getString("NomePai"));
		obj.setRgPai(rs.getString("RgPai"));
		obj.setCpfPai(rs.getString("CpfPai"));
		obj.setCelularPai(rs.getString("CelularPai"));
		obj.setNomeResponsavel(rs.getString("NomeResponsavel"));
		obj.setRgResponsavel(rs.getString("RgResponsavel"));
		obj.setCpfResponsavel(rs.getString("CpfResponsavel"));
		obj.setCelularResponsavel(rs.getString("CelularResponsavel"));
		obj.setEnderecoTrabalho(rs.getString("EnderecoTrabalho"));
		obj.setNumeroTrabalho(rs.getInt("NumeroTrabalho"));
		obj.setCepTrabalho(rs.getString("CepTrabalho"));
		obj.setMoradia(rs.getString("Moradia"));
		obj.setAlergia(rs.getBoolean("Alergia"));
		obj.setAlergiaQual(rs.getString("AlergiaQual"));
		obj.setDeficiencia(rs.getBoolean("deficiencia"));
		obj.setDeficienciaQual(rs.getString("DeficienciaQual"));
		obj.setCirurgia(rs.getBoolean("Cirurgia"));
		obj.setCirurgiaQual(rs.getString("CirurgiaQual"));
		obj.setDoenca(rs.getBoolean("Doenca"));
		obj.setDoencaQual(rs.getString("DoencaQual"));
		obj.setRemedio(rs.getBoolean("Remedio"));
		obj.setRemedioQual(rs.getString("RemedioQual"));
		obj.setBolsaFamilia(rs.getBoolean("BolsaFamilia"));
		obj.setBeneficio(rs.getBoolean("Beneficio"));
		obj.setCadastroUnico(rs.getBoolean("CadastroUnico"));
		obj.setNumeroCIS(rs.getString("NumeroCIS"));
		obj.setEncaminha(rs.getString("Encaminha"));
		obj.setEncaminhaOutra(rs.getString("EncaminhaOutra"));
		return obj;
	}
/*
	private Turma instantiateTurma(ResultSet rs) throws SQLException {
		Turma turma = new Turma();
		turma.setId(rs.getInt("TurmaId"));
		turma.setName(rs.getString("DepName"));
		return turma;
	}

	@Override
	public List<Aluno> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department " + "ON seller.TurmaId = department.Id " + "ORDER BY Name");

			rs = st.executeQuery();

			List<Aluno> list = new ArrayList<>();
			Map<Integer, Turma> map = new HashMap<>();

			while (rs.next()) {

				Turma turma = map.get(rs.getInt("TurmaId"));

				if (turma == null) {
					turma = instantiateTurma(rs);
					map.put(rs.getInt("TurmaId"), turma);
				}

				Aluno obj = instantiateAluno(rs, turma);
				list.add(obj);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Aluno> findByTurma(Turma department) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName " + "FROM seller INNER JOIN department "
							+ "ON seller.TurmaId = department.Id " + "WHERE TurmaId = ? " + "ORDER BY Name");

			st.setInt(1, department.getId());

			rs = st.executeQuery();

			List<Aluno> list = new ArrayList<>();
			Map<Integer, Turma> map = new HashMap<>();

			while (rs.next()) {

				Turma turma = map.get(rs.getInt("TurmaId"));

				if (turma == null) {
					turma = instantiateTurma(rs);
					map.put(rs.getInt("TurmaId"), turma);
				}

				Aluno obj = instantiateAluno(rs, turma);
				list.add(obj);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
	*/

		@Override
		public void deleteById(Integer id) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Aluno findById(Integer id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Aluno> findAll() {
			// TODO Auto-generated method stub
			return null;
		}
}
