package model.dao;

import db.DB;
import model.dao.impl.AlunoDaoJDBC;

public class DaoFactory {

	public static AlunoDao createSellerDao() {
		return new AlunoDaoJDBC(DB.getConnection());
	}
	
//	public static TurmaDao createDepartmentDao() {
//		return new TurmaDaoJDBC(DB.getConnection());
//	}
}
