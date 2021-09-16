package in.nit.healthcare.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nit.healthcare.entity.Specialization;
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
	Optional<Specialization> opt=	repo.findById(id);
	Specialization spec=null;
	if(opt.isPresent()) {
		spec=opt.get();
	}
		return spec;
	}

	@Override
	public void updateSpecialization(Specialization spec) {
		//Long id=spec.getId();
		repo.save(spec); //if id(PK) already present then performs update operation

	}

	@Override
	public void deleteSpecialization(Long id) {
	
		repo.deleteById(id); //deletes one specialization having matching id

	}

}
