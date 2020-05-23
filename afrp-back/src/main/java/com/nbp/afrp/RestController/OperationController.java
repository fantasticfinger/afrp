package com.nbp.afrp.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nbp.afrp.Model.Operation;
import com.nbp.afrp.Repository.OperationRepository;

@RestController
@RequestMapping(path = "/operation")
public class OperationController {
	
	@Autowired
	private OperationRepository operationRepository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Operation> gameGetAll() {
		return operationRepository.findAll();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Operation operAdd(@RequestBody Operation operation) {
		return operationRepository.save(operation);
	}
	
	@RequestMapping(value = "/{num}", method = RequestMethod.DELETE)
	public Boolean operDelete(@PathVariable(value = "num") String num) {
		Optional<Operation> operation = operationRepository.findById(Long.parseLong(num));
    	if(operation == null) {
    		return false;
    	}
    	else {
    		operationRepository.deleteById(Long.parseLong(num));
			return true;
    	}
	}
	
	@RequestMapping(value = "/{num}", method = RequestMethod.PUT)
	public Boolean operUpdate(@PathVariable(value = "num") String num,
							  @RequestBody Operation operation) {
		Optional<Operation> tempOperation = operationRepository.findById(Long.parseLong(num));
    	if(tempOperation == null) {
    		return false;
    	}
    	else {
    		tempOperation.get().setBall_on(operation.getBall_on());
    		tempOperation.get().setDown(operation.getDown());
    		tempOperation.get().setFoul(operation.getFoul());
    		tempOperation.get().setGain_yd(operation.getGain_yd());
    		tempOperation.get().setOffence_team(operation.getOffence_team());
    		tempOperation.get().setPlays(operation.getPlays());
    		tempOperation.get().setTackle_by(operation.getTackle_by());
    		operationRepository.save(operation);
    		return true;
    	}
	}
	
}
