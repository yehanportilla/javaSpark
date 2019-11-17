package co.com.sparkvs.controller;

import co.com.sparkvs.model.Blog;
import co.com.sparkvs.service.BlogService;
import com.google.gson.Gson;

import static spark.Spark.get;
import static spark.Spark.post;

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

    }
}
