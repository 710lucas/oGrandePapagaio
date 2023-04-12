package src;

import java.io.Serializable;
import java.util.ArrayList;

//so precisa do implements Serializable se for salvar em arquivo, o que não é necessário
public class Usuario implements Serializable {

    private ArrayList<Post> postagens = new ArrayList<>();

    private ArrayList<Usuario> seguindo = new ArrayList<>();

    private String nome;

    public Usuario(String nome){
        super();
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    public void seguir(Usuario usuario){
        if(!usuario.equals(this))
            seguindo.add(usuario);
    }
    public void postar(String texto){
        postagens.add(new Post(texto, this));
    }

    public ArrayList<Post> getPostagens(){
        return postagens;
    }

    public void lerPostagens(){
        //Ver linha 11 do papagaio.java para entender esse for
        for(Post postagem : postagens){
            postagem.lerPostagem();
        }
    }

    public void lerPostagensSeguidores(){
        //Ver linha 11 do papagaio.java para entender esse for
        for(Usuario usuario : seguindo){
            usuario.lerPostagens();
        }
    }

    public void lerMural(){
        lerPostagens();
        lerPostagensSeguidores();
    }

}
