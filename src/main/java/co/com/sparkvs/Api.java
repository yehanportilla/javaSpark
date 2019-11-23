package co.com.sparkvs;

import com.google.gson.Gson;

import co.com.sparkvs.controller.BlogController;
import static spark.Spark.*;


public class Api {
	
	
	
	 public static void main(String[] args) {
		 
		
		 Gson gson = new Gson();
			
			path("/api", () -> {
				
				path("/blog", () -> {
					
					 get("",(req,res)->{return BlogController.listar(req, res);},gson ::toJson );
					 get("/:username",(req,res)->{return BlogController.listarUsername(req, res);},gson::toJson);		 
					 post("", (req, res)->{ return BlogController.guardar(req,res); }, gson ::toJson);
					 delete("/:username",(req,res)->{return BlogController.eliminar(req, res);},gson::toJson);
			        
			    });
			});
		 
		 
	 }
}
