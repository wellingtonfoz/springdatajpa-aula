package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Carro;
import app.entity.Marca;

public interface CarroRepository extends JpaRepository<Carro, Long> {
	
	public List<Carro> findByMarca(Marca marca);

	public List<Carro> findByNome(String nome);
		
	public List<Carro> findByMarcaNome(String nome);
	
	@Query("FROM Carro c WHERE c.ano > :ano")
	public List<Carro> buscarCarrosAcimaAno(int ano);

}
