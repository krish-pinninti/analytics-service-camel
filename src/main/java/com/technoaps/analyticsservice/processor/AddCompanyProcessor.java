package com.technoaps.analyticsservice.processor;

import org.apache.camel.Exchange;

import com.technoaps.analyticsservice.model.CompanyResult;

public class AddCompanyProcessor {

	public void populateAddCompanyResponse(Exchange exchange) {
		CompanyResult res = new CompanyResult(5);
		exchange.getOut().setBody(res);
	}
}
