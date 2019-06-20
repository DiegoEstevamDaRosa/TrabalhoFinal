package br.unisul.pweb.diego.trabalho.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.unisul.pweb.diego.trabalho.domain.Empresa;
import br.unisul.pweb.diego.trabalho.services.EmpresaService;

@RestController
@RequestMapping(value="/empresas")
public class EmpresaResource {

	@Autowired
	private EmpresaService empService;
	
	//BUSCAR POR ID
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Empresa> find(@PathVariable Integer id){
		Empresa emp = empService.find(id);
		return ResponseEntity.ok().body(emp);
	}
	//INSERE
		
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void>insert(@RequestBody Empresa emp){
		emp = empService.insert(emp);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(emp.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	//EXCLUIR
	
		@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<Void> delete(@PathVariable Integer id) {
			empService.delete(id);
			return ResponseEntity.noContent().build();
		}	
}
	
