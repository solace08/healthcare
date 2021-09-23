package in.nit.healthcare.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nit.healthcare.entity.Doctor;
import in.nit.healthcare.exception.DoctorNotFoundException;
import in.nit.healthcare.repository.DoctorRepository;
import in.nit.healthcare.service.IDoctorService;

@Service
public class DoctorServiceImpl implements IDoctorService {
@Autowired
	private DoctorRepository repo;
	@Override
	public Long saveDoctor(Doctor doctor) {
		return repo.save(doctor).getId();
		
	}

	@Override
	public Doctor fetchDoctor(Long id) {
		return repo.findById(id).orElseThrow(()-> new DoctorNotFoundException("Doctor "+id+" not exist"));
	}

	@Override
	public List<Doctor> fetchAllDoctor() {
	
		return repo.findAll();
	}

	@Override
	public void updateDoctor(Doctor doctor) {
		repo.save(doctor);

	}

	@Override
	public void deleteDoctor(Long id) {
	
			repo.deleteById(fetchDoctor(id).getId());
		
	}
@Override
	public boolean isDocNameExist(String docName) {
		return repo.verifyDocName(docName)>0;
	}

@Override
	public boolean isDocAddrExist(String docAddr) {
		return repo.verifyDocAddr(docAddr)>0;
	}
}
