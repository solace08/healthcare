package in.nit.healthcare.service;

import java.util.List;

import in.nit.healthcare.entity.Specialization;

public interface ISpecializationService {

	public Long saveSpecialization(Specialization spec);
	public List<Specialization> getAllSpecialization();
	public Specialization getOneSpecialization(Long id);
	public void updateSpecialization(Specialization spec);
	public void deleteSpecialization(Long id);
	public boolean isSpecCodeExist(String specCode);
	public boolean isSpecNameExist(String specName);
}