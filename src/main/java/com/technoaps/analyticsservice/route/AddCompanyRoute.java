package com.technoaps.analyticsservice.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import com.technoaps.analyticsservice.model.Company;
import com.technoaps.analyticsservice.model.CompanyResult;
import com.technoaps.analyticsservice.processor.AddCompanyProcessor;

public class AddCompanyRoute extends RouteBuilder {
	
	@Autowired
	AddCompanyProcessor addCompanyProcessor;

	@Override
	public void configure() throws Exception {
		initRestRoutes();
		
		from("direct:addCompany").routeId("addCompanyR1").id("addCompR1")
		.bean(addCompanyProcessor, "populateAddCompanyResponse(*)");

	}
	
	private void initRestRoutes() {
		rest("/rest").description("add company").produces("APPLICATION_JSON").consumes("APPLICATION_JSON")
		.post("/addCompany").type(Company.class)
		.outType(CompanyResult.class).skipBindingOnErrorCode(true)
		.to("direct:addCompany");
	}

}
