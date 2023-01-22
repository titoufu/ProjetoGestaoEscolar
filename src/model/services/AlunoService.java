package model.services;

import java.util.List;

import model.dao.AlunoDao;
import model.dao.DaoFactory;
import model.entities.Aluno;

public class AlunoService {

	private AlunoDao dao = DaoFactory.createAlunoDao();

	public List<Aluno> findAll() {
		return dao.findAll();
	}
	public void remove(Aluno obj) {
		dao.deleteById(obj.getId());
	}

}
