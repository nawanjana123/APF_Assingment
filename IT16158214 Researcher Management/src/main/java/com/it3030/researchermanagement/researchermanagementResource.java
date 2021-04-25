package com.it3030.researchermanagement;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Controller.researchermanagementController;
import Model.researchermanagementModel;

@Path("researchermanagementResource")

public class researchermanagementResource {
	
	@GET
	@Path("/researchermanagement")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<researchermanagementModel> getAllresearchermanagement() throws Exception {
		return researchermanagementController.getInstance().searchAll();
	}

	@GET
	@Path("/researchermanagement/{researcherID}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public researchermanagementModel getresearchermanagement(@PathParam("researcherID") int researcherID) throws Exception {
		return researchermanagementController.getInstance().search(researcherID);
	}

	@POST
	@Path("/researchermanagement")
	public String saveresearchermanagement(researchermanagementModel obj) throws Exception {
		researchermanagementController.getInstance().save(obj);
		return "researcher Saved";
	}

	@PUT
	@Path("/researchermanagement")
	public String updateresearchermanagement(researchermanagementModel obj) throws Exception {
		researchermanagementController.getInstance().update(obj);
		return "researcher Updated";
	}

	@DELETE
	@Path("/researchermanagement/{researcherID}")
	public String deleteresearchermanagement(@PathParam("researcherID") int researcherID) throws Exception {
		researchermanagementModel obj = new researchermanagementModel();
		obj.setResearcherID(researcherID);
		researchermanagementController.getInstance().delete(obj);
		return "researcher Deleted";
	}


}
