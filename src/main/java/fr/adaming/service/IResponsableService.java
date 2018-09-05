package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Responsable;

public interface IResponsableService {

	public List<Class<Responsable>> getAllResponsables();

	public Class<Responsable> getResponsableById(Integer id);

	public Class<Responsable> addResponsable(Responsable r);

	public Class<Responsable> updateResponsable(Responsable r);

	public int deleteResponsable(Responsable r);

}
