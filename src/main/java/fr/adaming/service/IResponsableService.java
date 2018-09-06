package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Responsable;

public interface IResponsableService {

	public List<Responsable> getAllResponsable();
	public Responsable getResponsableById(int id);
	public Responsable addResponsable(Responsable r);
	public Responsable updateResponsable(Responsable r);
	public void deleteResponsable(int id);

}
