package co.com.sparkvs.service;

        import co.com.sparkvs.configuraction.Conection;
        import co.com.sparkvs.model.Blog;


        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

public class BlogService {

    public Conection conection = new Conection();
    private static final String OTH = "oth";

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

    /**
     * Metodo encargado de obtener blog por nombre de usuario
     */
    public Blog getBlogByUserName(String username){
        Blog blog = conection.conectionDB().find(Blog.class,"oth",username).get();
        if(blog != null){
            return blog;
        }
        else{
            return null;
        }
    }

    /**
     * Metodo encargado de eliminar blog por username
     */
    public String deleteBlogById(String name){
        String query = "DELETE FROM Blog where oth = :name";
        Map params = new HashMap();
        params.put(OTH, name);
        conection.conectionDB().delete(Blog.class, query);
        return "Blog eliminado con exito";
    }
}
