package br.unisul.pweb.diego.trabalho.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.unisul.pweb.diego.trabalho.domain.Departamento;
import br.unisul.pweb.diego.trabalho.domain.Empresa;
import br.unisul.pweb.diego.trabalho.dtos.DepartamentoDTO;
import br.unisul.pweb.diego.trabalho.dtos.EmpresaDTO;
import br.unisul.pweb.diego.trabalho.services.DepartamentoService;
import br.unisul.pweb.diego.trabalho.services.EmpresaService;

@RestController
@RequestMapping(value="/empresas")
public class EmpresaResource {

	@Autowired
	private EmpresaService empService;
	@Autowired
	private DepartamentoService dptService;
	
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
	//DELETAR
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		empService.delete(id);
		return ResponseEntity.noContent().build();
	}
	//ATUALIZA
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Empresa obj, @PathVariable Integer id){
		obj.setId(id);
		obj = empService.update(obj);
		return ResponseEntity.noContent().build();
	}
	//LISTAR TODAS
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<EmpresaDTO>> findAll() {
		List<Empresa> lista = empService.findAll();
		List<EmpresaDTO> listaDTO = lista.stream().map(obj -> new EmpresaDTO(obj)).collect(Collectors.toList()); 
		return ResponseEntity.ok().body(listaDTO);
	}
	//LISTAR DEPARTAMENTOS
	@RequestMapping(value="/{empresaId}/departamentos", method=RequestMethod.GET)
	public ResponseEntity<List<DepartamentoDTO>> findDepartamentos(@PathVariable Integer empresaId) {
		List<Departamento> list = dptService.findByEmpresa(empresaId);
		List<DepartamentoDTO> listDto = list.stream().map(obj -> new DepartamentoDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	
}
	
