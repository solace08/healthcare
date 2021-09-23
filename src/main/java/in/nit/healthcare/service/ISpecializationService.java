package in.nit.healthcare.service;

import java.util.List;
import java.util.Map;

import in.nit.healthcare.entity.Specialization;

public interface ISpecializationService {

	public Long saveSpecialization(Specialization spec);
	public List<Specialization> getAllSpecialization();
	public Specialization getOneSpecialization(Long id);
	public Map<Long,String> getSpecNameAndCode();
	public void updateSpecialization(Specialization spec);
	public void deleteSpecialization(Specialization specialization);
	public boolean isSpecCodeExist(String specCode);
	public boolean isSpecCodeExistEdit(String specCode, Long id);
	public boolean isSpecNameExist(String specName);
	public boolean isSpecNameExistEdit(String specName, Long id);

}