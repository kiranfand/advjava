package com.app.service;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.AuthRequestDTO;
import com.app.dto.AuthRespDTO;
import com.app.entities.Employee;
import com.app.repository.EmployeeRepository;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired 
	private EmployeeRepository empRepo;
	@Autowired 
	private ModelMapper mapper;
	@Override
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}
	@Override
	public Employee addEmpDetails(Employee transientEmp) {
		return empRepo.save(transientEmp);
	}
	@Override
	public String deleteEmpDetails(Long empId) {
		String mesg = "Emp id invalid , can't delete emp details ";
		if (empRepo.existsById(empId)) {
			empRepo.deleteById(empId);
			mesg = "Emp with ID=" + empId + "  deleted !";
		}
		return mesg;
	}
	@Override
	public Employee getEmpDetails(Long empId) {
		return empRepo.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Emp ID , Can't get emp details!!!!"));
	}
	@Override
	public Employee updateEmpDetails(Employee detachedEmp) {
		return empRepo.save(detachedEmp);
	}
	@Override
	public AuthRespDTO authenticateEmp(AuthRequestDTO request) {
		Employee emp = empRepo.findByEmailAndPassword(request.getEmail(), request.getPassword())
				.orElseThrow(() -> new ResourceNotFoundException("Emp not found : Invalid Email or password"));
		AuthRespDTO authRespDTO = mapper.map(emp, AuthRespDTO.class);
		return authRespDTO;
	}
}
