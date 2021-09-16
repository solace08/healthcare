package in.nit.healthcare.specialization;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import in.nit.healthcare.entity.Specialization;
import in.nit.healthcare.entity.SpecializationRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(value = false)
public class SpecializationRepositoryTest {
@Autowired
	private SpecializationRepository repo;
	//test case
	@Test
	public void testSpecCreate() {
		Specialization spec = new Specialization(null,"CRDL","Cardiology","They are expert on heart and blood vessels..");
		spec=repo.save(spec);
		assertNotNull(spec);
		
	}
	
	public void testSpecFetchAll() {
		List<Specialization> list= repo.findAll();
		assertNotNull(list);
		assertThat(list.size()>0);
	}
}
