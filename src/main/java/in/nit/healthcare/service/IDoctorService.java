package in.nit.healthcare.service;

import java.util.List;

import in.nit.healthcare.entity.Doctor;

public interface IDoctorService {

	// 1. save a doctor
	public Long saveDoctor(Doctor doctor);
	
	// 2. get single doctor
	public Doctor fetchDoctor(Long id);
	
	// 3. get all doctor
	public List<Doctor> fetchAllDoctor();
	
	// 4. update doctor
	public void updateDoctor(Doctor doctor);
	
	// 5. delete a doctor
	public void deleteDoctor(Long id);
	
	public boolean isDocNameExist(String docName);
	
	public boolean isDocAddrExist(String docAddr);
	// 6 doc email ajax validation
}
