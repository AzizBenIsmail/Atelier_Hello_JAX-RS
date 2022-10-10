package rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("greetings")

public class HelloResource {
	
	 @GET
	 @Path("0")
	 @Produces(MediaType.TEXT_PLAIN)
	 public String sayhello()
	 {
		 return "hello from jaxrs ";
	 }
	 
	 @GET
	 @Path("1/{FirstName}/{LastName}")
	 @Produces(MediaType.TEXT_PLAIN)
	 public String sayhello1(@PathParam(value="FirstName")String prenom,@PathParam(value="LastName")String nom)
	 {
		 return "hello from jaxrs (@PathParam) je suis : "+prenom+" "+nom;
	 }
	 
	 @Path("2")
	 @GET
	 @Produces(MediaType.TEXT_PLAIN)
	 public String sayhello2(@QueryParam(value="FirstName")String prenom,@QueryParam(value="LastName")String nom)
	 {
		 return "hello from jaxrs (@QueryParam) je suis : "+prenom+" "+nom;
	 }
	 
	 @Path("3")
	 @GET
	 @Produces(MediaType.TEXT_PLAIN)
	 public String sayhello(@QueryParam(value="FirstName")String prenom,@QueryParam(value="LastName")String nom)
	 {	
		 if( prenom==null && nom==null) {
			return "hello from jaxrs je suis Windows " ;
		} 
		 boolean isNumericprenom =  prenom.matches("[+-]?\\d*(\\.\\d+)?");
		 boolean isNumericnom =  nom.matches("[+-]?\\d*(\\.\\d+)?");
		 int n=prenom.length();
		 int m=prenom.length();
		 
		 if(isNumericprenom || isNumericnom) {
			return "errur s'il vous plais il faut saisire votre nom  ";
		} 
		 if(n<=3 || m<=3) {
			return "errur min 3 Char";
		}
		 return "hello from jaxrs (@QueryParam) je suis : "+prenom+" | "+nom;
	 }
}
