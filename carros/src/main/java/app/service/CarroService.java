package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Carro;
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
		return "carro não encontrado para alterar";
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
		return "Não encontrado para deletar";

	}

}
