package fr.adaming.service;

import java.util.List;

import fr.adaming.model.ClasseStandard;

public interface IClasseStandardService {
	
	public List<Class<ClasseStandard>> getAll();
	
	public Class<ClasseStandard> getById(Integer id);
	
	public Class<ClasseStandard> add(ClasseStandard cs);
	
	public Class<ClasseStandard> update(ClasseStandard cs);
	
	public int delete(ClasseStandard cs);

}
