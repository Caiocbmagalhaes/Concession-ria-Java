package microservice.veiculo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.ApiOperation;
import microservice.veiculo.model.CadastroVeiculoRepository;
import microservice.veiculo.model.Veiculo;

public class CadatraVeiculoController {

	@Autowired
	private CadastroVeiculoRepository cadastroRepository;

	@ApiOperation(value = "Cadastra veículo")
	@PostMapping(path = "automacao/v1/cadastraVeiculo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Veiculo> cadastroVeiculo(@RequestBody Veiculo infoVeiculo) {

		try {
			System.out.println("Dados recebidos para gravar:" + infoVeiculo.toString());
			Veiculo reponse = cadastroRepository.save(infoVeiculo);
			return new ResponseEntity<Veiculo>(HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Erro ao gravar o veiculo: " + e.getMessage());
			return new ResponseEntity<Veiculo>(HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

	@ApiOperation(value = "Busca o veículo")
	@GetMapping(path = "automacao/v1/consultaVeiculos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Veiculo>> findByVeiculo(@PathVariable String marca, @PathVariable String modelo,
			@PathVariable int ano) {
		try {
			System.out.println("Busca o veículo: " + marca + modelo + ano);
			List<Veiculo> response = cadastroRepository.findByVeiculo(marca, modelo, ano);
			if (response != null) {
				return new ResponseEntity<List<Veiculo>>(response, HttpStatus.OK);
			} else {
				System.out.println("Veiculo não localizado");
				return new ResponseEntity<List<Veiculo>>(new ArrayList<Veiculo>(), HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			System.out.println("Erro ao buscar o veículo na base");
			return new ResponseEntity<List<Veiculo>>(new ArrayList<Veiculo>(), HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
}
