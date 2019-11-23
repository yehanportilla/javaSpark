package co.com.sparkvs.controller;

import co.com.sparkvs.model.Blog;
import co.com.sparkvs.service.BlogService;
import spark.Request;
import spark.Response;

import com.google.gson.Gson;

import static spark.Spark.*;

public class BlogController {
	
	public static BlogService blogService = new BlogService();
 	public static Gson gson = new Gson();
 	
 	
        /**
         * Metodo encargado de guardar blog
         */
        public static Object guardar(Request req, Response res) {
    		res.type("aplication/json");
    		Blog blog = gson.fromJson(req.body(), Blog.class);
    		return blogService.saveBlog(blog);

    	}

        /**
         * Metodo encargado de listar todos los blog
         */
        public static Object listar(Request req, Response res) {
    		res.type("aplication/json");
    		return blogService.listBlog();

    	}

        /**
         * Metodo encargado de obtener blog por nombre de usuario
         */
        public static Object listarUsername(Request req, Response res) {
    		res.type("aplication/json");
    		Blog blog = blogService.getBlogByUserName(req.params("username"));
    		if (blog != null) {
    			return blog;
    		} else {
    			return "No se encontraron datos.";
    		}
    	}

        /**
         * Metodo encargado de eliminar blog por user name
         */
    	public static Object eliminar(Request req, Response res) {
    		res.type("aplication/json");
    		blogService.deleteBlogById(req.params("username"));
    		return "Blog eliminado con exito...!";
    	}
    	
    
}
