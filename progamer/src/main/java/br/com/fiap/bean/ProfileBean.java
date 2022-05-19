package br.com.fiap.bean;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletContext;

import org.primefaces.model.file.UploadedFile;

import br.com.fiap.dao.ProfileDao;
import br.com.fiap.model.Profile;

@Named
@RequestScoped
public class ProfileBean {

	private Profile profile = new Profile();
	private List<Profile> list;
	private UploadedFile image;

	private ProfileDao profileDao = new ProfileDao();

	public ProfileBean() {
		list = this.list();
	}

	public String save() throws IOException {
		System.out.println(this.profile);
		
		System.out.println(image.getFileName());
		
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		String servletPath = servletContext.getRealPath("/");
		
		System.err.println(servletPath);
		
		FileOutputStream out = new FileOutputStream(servletPath + "\\images\\" + image.getFileName());
		out.write(image.getContent());
		out.close();
		
		profile.setImagePath("\\images\\" + image.getFileName());
		
		profileDao.create(profile);
		
		FacesContext
			.getCurrentInstance()
			.addMessage(null, new FacesMessage("Usuário cadastrado com sucesso!"));
		
		return "profiles";
	}

	public List<Profile> list() {
		return profileDao.listAll();
	}

	public List<Profile> getList() {
		return list;
	}

	public void setList(List<Profile> list) {
		this.list = list;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public UploadedFile getImage() {
		return image;
	}

	public void setImage(UploadedFile image) {
		this.image = image;
	}

}
