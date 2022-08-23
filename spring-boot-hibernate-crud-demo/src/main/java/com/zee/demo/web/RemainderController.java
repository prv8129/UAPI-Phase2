package com.zee.demo.web;

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
import com.zee.demo.service.RemainderService;
import com.zee.ro.RemainderRO;
 
@RestController
@RequestMapping("/remainder")
public class RemainderController
{
    @Autowired
    RemainderService service;
 
    @GetMapping
    public ResponseEntity<List<RemainderRO>> getAllFavorites(@RequestHeader Map<String, String> headers) {
    	headers.forEach((key, value) -> {
			System.out.println("Header Name: " + key + " Header Value: " + value);
		});
		if(!headers.keySet().contains(1)) {
			//Error error = new Error(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
			ResponseEntity res =  ResponseEntity.status(HttpStatus.UNAUTHORIZED	).body("Headers Expected");
			return res;
		}
        List<RemainderRO> list = service.getAllRemainders();
 
        return new ResponseEntity<List<RemainderRO>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<RemainderRO> getRemainderById(@RequestHeader Map<String, String> headers,@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
    	headers.forEach((key, value) -> {
			System.out.println("Header Name: " + key + " Header Value: " + value);
		});
		if(!headers.keySet().contains(1)) {
			ResponseEntity res =  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Headers Expected");
			return res;
		}
        RemainderRO entity = service.getRemainderById(id);
 
        return new ResponseEntity<RemainderRO>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<RemainderRO> createRemainder(@RequestHeader Map<String, String> headers,RemainderRO Remainder)
                                                    throws RecordNotFoundException {
    	headers.forEach((key, value) -> {
			System.out.println("Header Name: " + key + " Header Value: " + value);
		});
		if(!headers.keySet().contains(1)) {
			ResponseEntity res =  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Headers Expected");
			return res;
		}
        RemainderRO updated = service.createRemainder(Remainder);
        return new ResponseEntity<RemainderRO>(updated, new HttpHeaders(), HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<RemainderRO> updateRemainder(@RequestHeader Map<String, String> headers,RemainderRO Remainder)
    		throws RecordNotFoundException {
    	headers.forEach((key, value) -> {
			System.out.println("Header Name: " + key + " Header Value: " + value);
		});
		if(!headers.keySet().contains(1)) {
			ResponseEntity res =  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Headers Expected");
			return res;
		}
    	RemainderRO updated = service.updateRemainder(Remainder);
    	return new ResponseEntity<RemainderRO>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteRemainderById(@RequestHeader Map<String, String> headers,@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
    	headers.forEach((key, value) -> {
			System.out.println("Header Name: " + key + " Header Value: " + value);
		});
		if(!headers.keySet().contains(1)) {
			return HttpStatus.UNAUTHORIZED;
		}
        service.deleteRemainderById(id);
        return HttpStatus.FORBIDDEN;
    }
 
}