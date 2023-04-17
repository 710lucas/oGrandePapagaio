package src;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Testes {

    Post post;
    Usuario usuario;

    @BeforeEach
    public void init(){
        usuario = new Usuario("teste");
        post = new Post("teste", usuario);
    }

    @Test
    public void testPost(){
        Assertions.assertEquals("teste", post.getTexto());
        post.setTexto("ola!");
        Assertions.assertEquals("ola!", post.getTexto());
        Assertions.assertEquals(usuario, post.getAutor());
    }

    @Test
    public void testSeguir(){
        Usuario teste = new Usuario("teste2");
        usuario.setLogado(true);
        usuario.seguir(teste);
        Assertions.assertTrue(post.getAutor().getSeguindo().contains(teste));
    }

}
