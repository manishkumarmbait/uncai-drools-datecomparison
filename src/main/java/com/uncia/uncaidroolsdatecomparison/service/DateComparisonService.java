package com.uncia.uncaidroolsdatecomparison.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uncia.uncaidroolsdatecomparison.model.DateComparison;
import com.uncia.uncaidroolsdatecomparison.model.Response;

@Service
public class DateComparisonService {


	@Autowired
	private KieContainer kieContainer;

	public Response getDate(DateComparison dateComparison) {
		Response response = new Response();
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.setGlobal("response", response);
		kieSession.insert(dateComparison);
		kieSession.fireAllRules();
		kieSession.dispose();
		return response;
	}
}
