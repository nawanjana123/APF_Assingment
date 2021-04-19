package com;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import com.google.gson.*;
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

import model.Payment;

@Path("/Payments")
public class PaymentService {

	Payment paymentObj = new Payment();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readPayments(){
		return paymentObj.readPayment();
	} 
	
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertItem(@FormParam("userID") int userID,
			@FormParam("projectID") int projectID,
			@FormParam("amount") String amount,
			@FormParam("method") String method)
	{
		String output = paymentObj.insertPayment(userID, projectID, amount, method);
	 	return output;
	}
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatePayment(String paymentData){
		
		JsonObject paymentObject = new JsonParser().parse(paymentData).getAsJsonObject();
	 
		int paymentID = paymentObject.get("paymentID").getAsInt();
		int userID = paymentObject.get("userID").getAsInt();
		int projectID = paymentObject.get("projectID").getAsInt();
		String amount = paymentObject.get("amount").getAsString();
		String method = paymentObject.get("method").getAsString();
		String output = paymentObj.updatePayment(paymentID, userID, projectID, amount, method);
	
		return output;
	}
	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteItem(String paymentData){
	 
		Document doc = Jsoup.parse(paymentData, "", Parser.xmlParser());

	 
		String paymentID = doc.select("paymentID").text();
		String output = paymentObj.deletePayment(paymentID);
	
		return output;
	}


}
