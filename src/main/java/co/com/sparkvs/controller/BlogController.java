package co.com.sparkvs.controller;

import co.com.sparkvs.model.Blog;
import co.com.sparkvs.service.BlogService;
import com.google.gson.Gson;

import static spark.Spark.*;

public class BlogController {
    public  static BlogService blogService = new BlogService();

    public static void main(String[] args) {
        Gson gson = new Gson();
        /**
         * Metodo encargado de guardar blog
         */
        post("/guardar", (req, res)->{
            res.type("aplication/json");
            Blog blog = gson.fromJson(req.body(), Blog.class);
            return blogService.saveBlog(blog);
        }, gson ::toJson);

        /**
         * Metodo encargado de listar todos los blog
         */
        get("/listar",(req, res) ->{
            res.type("aplication/json");
            return blogService.listBlog();
        }, gson ::toJson);

        /**
         * Metodo encargado de obtener blog por nombre de usuario
         */
        get("/listar/:username",(req, res)->{
            res.type("aplication/json");
            Blog blog = blogService.getBlogByUserName(req.params("username"));
            if(blog != null){
                return blog;
            }
             else{
                 return "No se encontraron datos.";
            }
        }, gson ::toJson);

        /**
         * Metodo encargado de eliminar blog por user name
         */
        delete("/eliminar/:username",(req, res)->{
            res.type("aplication/json");
             blogService.deleteBlogById(req.params("username"));
            return "Eliminado";
        });
    }
}
