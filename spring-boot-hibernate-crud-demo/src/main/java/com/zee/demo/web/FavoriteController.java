package com.zee.demo.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.demo.exception.RecordNotFoundException;
import com.zee.demo.service.FavoriteService;
import com.zee.ro.FavoriteRO;

@RestController
@RequestMapping("/favorite")
public class FavoriteController {
	@Autowired
	FavoriteService service;

	@GetMapping
	public ResponseEntity<Object> getAllFavorites(@RequestHeader Map<String, String> headers) {
		headers.forEach((key, value) -> {
			System.out.println("Header Name: " + key + " Header Value: " + value);
		});
		if(!headers.keySet().contains(1)) {
			Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("code", "401");
		    errorResponse.put("message", "Headers Expected");
		    errorResponse.put("status", HttpStatus.UNAUTHORIZED.name());
		    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
		}

		List<FavoriteRO> list = service.getAllFavorites();
		System.out.println(list);
		return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<FavoriteRO> getEmployeeById(@RequestHeader Map<String, String> headers,@PathVariable("id") Long id) throws RecordNotFoundException {
		headers.forEach((key, value) -> {
			System.out.println("Header Name: " + key + " Header Value: " + value);
		});
		if(!headers.keySet().contains(1)) {
			ResponseEntity res =  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Headers Expected");
			return res;
		}
		FavoriteRO entity = service.getEmployeeById(id);

		return new ResponseEntity<FavoriteRO>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<FavoriteRO> createEmployee(@RequestHeader Map<String, String> headers,FavoriteRO employee) throws RecordNotFoundException {
		headers.forEach((key, value) -> {
			System.out.println("Header Name: " + key + " Header Value: " + value);
		});
		if(!headers.keySet().contains(1)) {
			ResponseEntity res =  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Headers Expected");
			return res;
		}
		FavoriteRO updated = service.createEmployee(employee);
		return new ResponseEntity<FavoriteRO>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<FavoriteRO> createOrUpdateEmployee(@RequestHeader Map<String, String> headers,FavoriteRO employee) throws RecordNotFoundException {
		FavoriteRO updated = service.updateEmployee(employee);
		return new ResponseEntity<FavoriteRO>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteEmployeeById(@RequestHeader Map<String, String> headers,@PathVariable("id") Long id) throws RecordNotFoundException {
		headers.forEach((key, value) -> {
			System.out.println("Header Name: " + key + " Header Value: " + value);
		});
		if(!headers.keySet().contains(1)) {
			return HttpStatus.UNAUTHORIZED;
		}
		service.deleteEmployeeById(id);
		return HttpStatus.FORBIDDEN;
	}

	@GetMapping("/listHeaders")
	public ResponseEntity<String> listAllHeaders(@RequestHeader Map<String, String> headers) {
		headers.forEach((key, value) -> {
			System.out.println(key + ":" + value);
		});

		return new ResponseEntity<String>(String.format("Listed %d headers", headers.size()), HttpStatus.OK);
	}

}