package src;

import java.util.ArrayList;

public class Papagaio {

    private  ArrayList<Usuario> usuarios = new ArrayList<>();

    public void criarUsuario(String nome){

        //mesma coisa que for(int i = 0; i<usuarios.getSize(); i++){
        //Usuario usuario = usuarios.get(i);
        //if(usuario.getNome()...
        for(Usuario usuario : usuarios){
            if(usuario.getNome().equals(nome)) {
                System.out.println("Já existe um usuario com o mesmo nome, tente novamente");
                return;
            }
        }

        usuarios.add(new Usuario(nome));
        System.out.println("Usuário adicionado com sucesso");

    }

    public Usuario getUsuario(String nome){
        for(Usuario usuario : usuarios){
            if(usuario.getNome().equals(nome)){
                return usuario;
            }
        }

        System.out.println("Não foi encontrado um usuario com este nome");
        return null;
    }

    public void verMural(String nomeUsuario){
        for(Usuario usuario : usuarios){
            if(usuario.getNome().equals(nomeUsuario)){
                usuario.lerMural();
                return;
            }
        }

        System.out.println("Nenhum usuario encontrado com este nome");
    }

}
