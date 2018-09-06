package fr.adaming.service;

import java.util.List;

import fr.adaming.model.ClasseStandard;

public interface IClasseStandardService {
	
	public List<ClasseStandard> getAll();
	
	public ClasseStandard getById(int id);
	
	public ClasseStandard add(ClasseStandard cs);
	
	public ClasseStandard update(ClasseStandard cs);
	
	public void delete(int id);

}
