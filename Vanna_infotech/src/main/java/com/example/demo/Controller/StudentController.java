package com.example.demo.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Student;
import com.example.demo.Repository.StdRepository;



@RestController
public class StudentController {
	
	@Autowired
	private StdRepository rep;
	
	
	
	@GetMapping("/get")
	public List<Student> findall(){
		return rep.findAll();
	}
	
	@PostMapping("/send")
	public String save(@RequestBody Student obj) {
		float f= (float)(((obj.getMaths()+obj.getPhysics()+obj.getChemistry())/300.0)*100);
		obj.setPercentage(f);
		rep.save(obj);
		return "entered";
	}
	
	@PutMapping("/update/{id}")
	public String update(@PathVariable Integer id, @RequestBody Student obj) {
		Student tempobj=rep.findById(id).get();
		tempobj.setName(obj.getName());
		tempobj.setRoll(obj.getRoll());
		tempobj.setMaths(obj.getMaths());
		tempobj.setPhysics(obj.getPhysics());
		tempobj.setChemistry(obj.getChemistry());
		float f= (float)(((tempobj.getMaths()+tempobj.getPhysics()+tempobj.getChemistry())/300.0)*100);
		tempobj.setPercentage(f);
		rep.save(tempobj);
		
		return "updated";
		
	}
	
	
	@DeleteMapping("/delete")
	public String remove() {
		rep.deleteAll();
		return "Removed all rows in DB";
	}
	
}
