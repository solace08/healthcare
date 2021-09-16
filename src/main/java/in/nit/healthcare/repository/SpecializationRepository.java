package in.nit.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nit.healthcare.entity.Specialization;

public interface SpecializationRepository extends JpaRepository<Specialization, Long> {

}
