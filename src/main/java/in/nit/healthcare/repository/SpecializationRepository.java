package in.nit.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.nit.healthcare.entity.Specialization;

public interface SpecializationRepository extends JpaRepository<Specialization, Long> {
//	SELECT COUNT(SPEC_CODE_COL) FROM SPECIALIZATION_TAB WHERE SPEC_CODE_COL="CRDLGST";
	@Query("SELECT COUNT(specCode) FROM Specialization WHERE specCode=:specCode")
	public Integer checkSpecCode(String specCode);
	
	@Query("SELECT COUNT(specName) FROM Specialization WHERE specName=:specName")
	public Integer checkSpecName(String specName);

}
