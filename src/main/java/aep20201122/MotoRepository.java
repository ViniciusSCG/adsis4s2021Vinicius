package aep20201122;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MotoRepository extends JpaRepository<Moto, String> {

	@Query(value = "select MAX(cilindradas) from moto",nativeQuery = true)
	int obterMaiorCilindrada();
	
}
