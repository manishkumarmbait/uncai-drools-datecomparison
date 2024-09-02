package com.uncia.uncaidroolsdatecomparison.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uncia.uncaidroolsdatecomparison.model.DateComparison;
import com.uncia.uncaidroolsdatecomparison.model.Response;
import com.uncia.uncaidroolsdatecomparison.service.DateComparisonService;

@RestController
@RequestMapping("/ruleservice")
public class DateComparisonController {

	@Autowired
	private DateComparisonService dateComparisonService;

	@PostMapping("/getCompareDate")
	public ResponseEntity<Response> getCompareDate(@RequestBody DateComparison dateComparison) throws ParseException {
		Response date = dateComparisonService.getDate(dateComparison);
		return new ResponseEntity<>(date, HttpStatus.OK);
	}
	
}
