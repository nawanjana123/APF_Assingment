package com.it3030.usermanagements;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Controller.usermanagementController;
import Model.usermanagementModel;

@Path("usermanagementResource")

public class usermanagementResource {
	@GET
	@Path("/usermanagement")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<usermanagementModel> getAllusermanagement() throws Exception {
		return usermanagementController.getInstance().searchAll();
	}

	@GET
	@Path("/usermanagement/{userID}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public usermanagementModel getusermanagement(@PathParam("userID") int userID) throws Exception {
		return usermanagementController.getInstance().search(userID);
	}

	@POST
	@Path("/usermanagement")
	public String saveusermanagement(usermanagementModel obj) throws Exception {
		usermanagementController.getInstance().save(obj);
		return "user Saved";
	}

	@PUT
	@Path("/usermanagement")
	public String updateusermanagement(usermanagementModel obj) throws Exception {
		usermanagementController.getInstance().update(obj);
		return "user Updated";
	}

	@DELETE
	@Path("/usermanagement/{userID}")
	public String deleteusermanagement(@PathParam("userID") int userID) throws Exception {
		usermanagementModel obj = new usermanagementModel();
		obj.setUserID(userID);
		usermanagementController.getInstance().delete(obj);
		return "user Deleted";
	}


}
