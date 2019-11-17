package co.com.sparkvs.service;

import co.com.sparkvs.configuraction.Conection;
import co.com.sparkvs.model.Blog;
import java.util.List;

public class BlogService {

    public Conection conection = new Conection();

    /**
     * Metodo encargado de crear el blog
     * @param blog
     * @return
     */
    public String saveBlog(Blog blog){
        conection.conectionDB().save(blog);
        return "blog creado con Exito...!";
    }

    /**
     * Metodo encargado de listar todos los blog
     * @return
     */
    public List<Blog> listBlog(){
        List<Blog> list = conection.conectionDB().find(Blog.class).asList();
      if (list != null){
          return list;
      }
      return null;
    }
}
