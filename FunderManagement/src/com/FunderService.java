package com;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
//For REST Service
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Funder;

@Path("/Funders")
public class FunderService {
	
	Funder FunderObj = new Funder();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readItems()
	{
		return FunderObj.readItems();
	}
	
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertItem(@FormParam("funderName") String funderName,
	 @FormParam("funderNIC") String funderNIC,
	 @FormParam("funderAddress") String funderAddress,
	 @FormParam("funderEmail") String funderEmail,
	 @FormParam("funderPhone") String funderPhone)

	
	{
	 String output = FunderObj.insertItem(funderName, funderNIC, funderAddress, funderEmail, funderPhone);
	return output;
	}
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateItem(String itemData)
	{
	//Convert the input string to a JSON object
	 JsonObject FunderObject = new JsonParser().parse(itemData).getAsJsonObject();
	//Read the values from the JSON object
	 String funderID = FunderObject.get("funderID").getAsString();
	 String funderName = FunderObject.get("funderName").getAsString();
	 String funderNIC = FunderObject.get("funderNIC").getAsString();
	 String funderAddress = FunderObject.get("funderAddress").getAsString();
	 String funderEmail = FunderObject.get("funderEmail").getAsString();
	 String funderPhone = FunderObject.get("funderPhone").getAsString();
	
	 
	 String output = FunderObj.updateItem(funderID,funderName,funderNIC,funderAddress,funderEmail,funderPhone);
	 return output;
	}
	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteItem(String itemData)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(itemData, " ", Parser.xmlParser());

	//Read the value from the element <itemID>
	 String funderID = doc.select("funderID").text();
	 String output = FunderObj.deleteItem(funderID);
	return output;
	}
	
	
	
	
}
	
