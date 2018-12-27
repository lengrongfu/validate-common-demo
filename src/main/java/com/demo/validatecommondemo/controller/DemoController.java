package com.demo.validatecommondemo.controller;


import com.alibaba.fastjson.JSON;
import com.demo.validatecommondemo.entity.Girlfriend;
import com.demo.validatecommondemo.entity.Student;
import com.demo.validatecommondemo.vo.ResponeVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
public class DemoController {

	private static Map<String,Student> studentsMap = new HashMap<>();

	@GetMapping(path = "/students")
	public ResponeVo<List<Student>> getStudents(){
		Iterator<Student> iterator = studentsMap.values().iterator();
		List<Student> students = new ArrayList<>();
		while (iterator.hasNext()){
			students.add(iterator.next());
		}
		return ResponeVo.create(students);
	}

	@PostMapping(path = "/student")
	public ResponeVo<Boolean> addStudent(@RequestBody @Valid Student student){
		studentsMap.put(student.getName(),student);
		return ResponeVo.create(true);
	}

	@PostMapping(path = "/girlFirends")
	public ResponeVo<Boolean> addGirlFirend(@RequestBody @Valid List<Girlfriend> girlfriends){
		System.out.println(JSON.toJSONString(girlfriends));
		return ResponeVo.create(true);
	}

	@GetMapping(path = "/student/{name}")
	public ResponeVo<List<Student>> find(@PathVariable("name")String name){
		List<Student> result = new ArrayList<>();
		for (Map.Entry<String, Student> stringStudentEntry : studentsMap.entrySet()) {
			if (stringStudentEntry.getKey().contains(name)){
				result.add(stringStudentEntry.getValue());
			}
		}
		return ResponeVo.create(result);
	}
}
