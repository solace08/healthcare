package in.nit.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.nit.healthcare.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {


	@Query("SELECT COUNT(docName) FROM Doctor WHERE docName=:docName")
	public Integer verifyDocName(String docName);
	@Query("SELECT COUNT(docAddr) FROM Doctor WHERE docAddr=:docAddr")
	public Integer verifyDocAddr(String docAddr);

}
