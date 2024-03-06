package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Carro;
import app.entity.Marca;
import app.repository.CarroRepository;

@Service
public class CarroService {

	@Autowired
	private CarroRepository carroRepository;

	public String save(Carro carro) {
		this.carroRepository.save(carro);
		return carro.getNome()+ " salvo com sucesso";
	}

	public String update(long id, Carro carro) {
		carro.setId(id);
		this.carroRepository.save(carro);
		return carro.getNome()+ " atualizado com sucesso";
	}

	public List<Carro> listAll(){
		return this.carroRepository.findAll();
	}

	public Carro findById(long idCarro) {

		Carro carro = this.carroRepository.findById(idCarro).get();
		return carro;

	}

	public String delete(long idCarro) {
		this.carroRepository.deleteById(idCarro);
		return "Carro deletado com sucesso!";

	}
	
	public List<Carro> findByNome(String nome){
		return this.carroRepository.findByNome(nome);
	}
	
	public List<Carro> findByMarcaNome(String nome){
		return this.carroRepository.findByMarcaNome(nome);
	}
	
	public List<Carro> buscarCarrosAcimaAno(int ano){
		return this.carroRepository.buscarCarrosAcimaAno(ano);
	}

	
	public List<Carro> findByMarca(long id){
		Marca marca = new Marca();
		marca.setId(id);
		return this.carroRepository.findByMarca(marca);
	}


}
