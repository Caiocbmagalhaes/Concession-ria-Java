package microservice.veiculo.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CadastroVeiculoRepository extends CrudRepository<Veiculo, Integer>{
	
List<Veiculo> findByMarcaVeiculo(@Param("marcaVeiculo") String veiculo);
	
	@Query("select t from Veiculo t where t.marca = ?1  and t.modelo = ?2 and t.ano = ?3")
	List<Veiculo> findByVeiculo(String marca, String modelo,int ano);

}
