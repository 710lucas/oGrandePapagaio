package src;

public class Main {

    public static void main(String[] args){
        Usuario us =  new Usuario("Lucas");
        Post p = new Post("Teste", us);
        p.lerPostagem();
    }
}
