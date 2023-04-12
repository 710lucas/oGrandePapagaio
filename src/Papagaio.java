package src;

import java.io.*;
import java.util.ArrayList;
import java.io.Serializable;

//so precisa do implements Serializable se for salvar em arquivo, o que não é necessário
public class Papagaio implements Serializable{


    private final String PAPAGAIO_ARQUIVO = "Papagaiagens.ppg";
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



    //não é necessário mas eu quero salvar em arquivos então pode so ignorar isso
    public Papagaio carregaPapagaios(){
        try {
            FileInputStream arquivoParaCarregar = new FileInputStream(new File(PAPAGAIO_ARQUIVO));
            ObjectInputStream objetoParaCarregar = new ObjectInputStream(arquivoParaCarregar);
            return (Papagaio) objetoParaCarregar.readObject();
        } catch (IOException | ClassNotFoundException e) {
            salvar();
            throw new RuntimeException(e);
        }
    }

    public void salvar(){
        try {
            FileOutputStream arquivoParaSalvar = new FileOutputStream(new File(PAPAGAIO_ARQUIVO));
            ObjectOutputStream objetoParaSalvar = new ObjectOutputStream(arquivoParaSalvar);
            objetoParaSalvar.writeObject(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
