package in.nit.healthcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.nit.healthcare.entity.Specialization;

public interface SpecializationRepository extends JpaRepository<Specialization, Long> {
//	SELECT COUNT(SPEC_CODE_COL) FROM SPECIALIZATION_TAB WHERE SPEC_CODE_COL="CRDLGST";
	@Query("SELECT COUNT(specCode) FROM Specialization WHERE specCode=:specCode")
	public Integer checkSpecCode(String specCode);
	
	@Query("SELECT COUNT(specName) FROM Specialization WHERE specName=:specName")
	public Integer checkSpecName(String specName);
	@Query("SELECT COUNT(specCode) FROM Specialization WHERE specCode=:specCode AND id!=:specEditId")
	public Integer checkSpecCodeEdit(String specCode, Long specEditId);
	@Query("SELECT COUNT(specName) FROM Specialization WHERE specName=:specName AND id!=:specEditId")
	public Integer checkSpecNameEdit(String specName, Long specEditId);
	@Query("SELECT id,specName FROM Specialization")
	public List<Object[]> getSpecIdAndName();

}
