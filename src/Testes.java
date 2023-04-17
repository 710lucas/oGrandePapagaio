package src;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Testes {

    Post post;
    Usuario usuario;
    Papagaio papag;

    @BeforeEach
    public void init(){
        usuario = new Usuario("teste");
        post = new Post("teste", usuario);
        papag = new Papagaio();
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

    @Test
    public void testeLogar(){
        Assertions.assertFalse(usuario.isLogado());
        usuario.setLogado(true);
        Assertions.assertTrue(usuario.isLogado());
    }

    @Test
    public void testPapagaio(){

        Assertions.assertTrue(papag.criarUsuario("teste"));
        Assertions.assertEquals(papag.getUsuario("teste").getNome(), "teste");
        papag.getUsuario("teste").setLogado(true);
        papag.postar("teste", "teste texto");
        Assertions.assertEquals(1, papag.getUsuario("teste").getPostagens().size());
    }


}
