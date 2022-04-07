package br.com.fiap.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.fiap.dao.SetupDao;
import br.com.fiap.model.Setup;

//CDI
@Named
@RequestScoped
public class SetupBean {
	private Setup setup = new Setup();
	private List<Setup> list;
	
	public SetupBean () {
		list = this.list;
	}

	public void save() {
		System.out.println(this.setup);
		SetupDao setupDao = new SetupDao();
		setupDao.create(setup);
	}

	public List<Setup> list() {
		SetupDao setupDao = new SetupDao();
		return setupDao.listAll();
	}

	
	public List<Setup> getList() {
		return list;
	}

	public void setList(List<Setup> list) {
		this.list = list;
	}

	public Setup getSetup() {
		return setup;
	}

	public void setSetup(Setup setup) {
		this.setup = setup;
	}

}
