/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.geocodeproxy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

/**
 *
 * @author grahamfarrell
 * @author dominicdillon
 */
@Path("/geocode")
public class GeocodeProxy {
    
    @GET
    @Path("/json")
    public Response getGeocodeInfoInJsonFormat(@QueryParam("city") String city, @QueryParam("apiId") String apiId) {
        String URL = "http://api.openweathermap.org/data/2.5/forecast?q=" + city + "&mode=json&appid=" + apiId;
        Client client = ClientBuilder.newClient();
        Response response = client.target(URL).request().get();
        return response;
    }
    
    @GET
    @Path("/xml")
    public Response getGeocodeInfoInXmlFormat(@QueryParam("city") String city, @QueryParam("apiId") String apiId) {
        String URL = "http://api.openweathermap.org/data/2.5/forecast?q=" + city + "&mode=xml&appid=" + apiId;
        Client client = ClientBuilder.newClient();
        Response response = client.target(URL).request().get();
        return response;
    }

}