package in.nit.healthcare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nit.healthcare.entity.Specialization;
import in.nit.healthcare.exceptions.SpecializationNotFoundException;
import in.nit.healthcare.repository.SpecializationRepository;
import in.nit.healthcare.service.ISpecializationService;

@Service
public class SpecializationServiceImpl implements ISpecializationService {

	@Autowired
	private SpecializationRepository repo;
	@Override
	public Long saveSpecialization(Specialization spec) {
		Specialization specialization=repo.save(spec);
		return specialization.getId();
	}

	@Override
	public List<Specialization> getAllSpecialization() {
		List<Specialization> splList= repo.findAll();
		return splList;
	}

	@Override
	public Specialization getOneSpecialization(Long id) {
		/*
		 * Optional<Specialization> opt=repo.findById(id); Specialization spec=null;
		 * if(opt.isPresent()) { spec=opt.get(); } return spec;
		 */
		
	return	repo.findById(id).orElseThrow(()->new SpecializationNotFoundException("Spec with id: "+id+" not found"));
	}

	@Override
	public void updateSpecialization(Specialization spec) {
		//Long id=spec.getId();
		repo.save(spec); //if id(PK) already present then performs update operation

	}

	@Override
	public void deleteSpecialization(Specialization specialization) {

		repo.deleteById(specialization.getId()); //deletes one specialization having matching id

	}

	//	Check specCode for Asynchronous validation
	@Override
	public boolean isSpecCodeExist(String specCode) {
		return repo.checkSpecCode(specCode)>0;
	}
	
	//	Check specName for Asynchronous validation
	@Override
	public boolean isSpecNameExist(String specName) {
		return repo.checkSpecName(specName)>0;
	
	}
	@Override
	public boolean isSpecCodeExistEdit(String specCode, Long id) {
		return repo.checkSpecCodeEdit(specCode, id)>0;
	}
	
	@Override
	public boolean isSpecNameExistEdit(String specName, Long id) {
		return repo.checkSpecCodeEdit(specName, id)>0;
	}
}
