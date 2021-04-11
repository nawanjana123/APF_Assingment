package com;

import model.Research;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Rsearach")
public class ResearchManagement {
	
Research researchObj = new Research();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String ReadData()
	 {
	 return researchObj.readData();
	 }
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String InsertData(
     @FormParam("R_ResearchID") String ResearchID,
	 @FormParam("R_ResearchName") String ResearchName,
	 @FormParam("R_Author1") String Author1,
	 @FormParam("R_Author2") String Author2,
	 @FormParam("R_Author3") String Author3,
	 @FormParam("R_ResearchField") String ResearchField,
	 @FormParam("R_Publisher") String Publisher,
	@FormParam("R_PublishYear") String PublishYear)
	{
		 String output = researchObj.insertData(ResearchName, Author1, Author2, Author3, ResearchField, Publisher, PublishYear);
		return output;
		}
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String UpdateData(String Data)
	{
	//Convert the input string to a JSON object
	 JsonObject researchObject = new JsonParser().parse(Data).getAsJsonObject();
	 
	//Read the values from the JSON object
	 String ResearchID = researchObject.get("R_ResearchID").getAsString();
	 String ResearchName = researchObject.get("R_ResearchName").getAsString();
	 String Author1 = researchObject.get("R_Author1").getAsString();
	 String Author2 = researchObject.get("R_Author2").getAsString();
	 String Author3 = researchObject.get("R_Author3").getAsString();
	 String ResearchField = researchObject.get("R_ResearchField").getAsString();
	 String Publisher= researchObject.get("R_Publisher").getAsString();
	 String PublishYear = researchObject.get("R_PublishYear").getAsString();
	
	 String output = researchObj.updateData(ResearchID,ResearchName, Author1, Author2, Author3, ResearchField, Publisher, PublishYear);
		return output;
		}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String  DeleteData(String Data)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(Data,"", Parser.xmlParser());

	//Read the value from the element <itemID>
	 String R_ResearchID = doc.select("ResearchID").text();
	 String output = researchObj.deleteData(R_ResearchID);
	return output;
	}
}
