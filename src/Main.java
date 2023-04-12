package src;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Papagaio papa = new Papagaio(); //papa = abreviação de papagaio
        Scanner sc = new Scanner(System.in);

        final int LOGIN = 1;
        final int REGISTRAR = 2;

        System.out.print("1 - LOGIN\n2 - REGISTRAR\n>");

        //recebe String como input e converte para int
        //evita colocar um nextInt e um nextLine feio embaixo
        //acho menos confuso
        int escolha = Integer.parseInt(sc.nextLine());
        Usuario usuario = null;
        do {
            switch (escolha) {
                case 1:
                    System.out.print("DIGITE SEU NOME DE USUARIO: ");
                    String nomeUsuario = sc.nextLine();
                    usuario = papa.getUsuario(nomeUsuario);
                    break;
                case 2:
                    System.out.print("DIGITE SEU NOME DE USUARIO: ");
                    nomeUsuario = sc.nextLine();
                    papa.criarUsuario(nomeUsuario);
                    papa.getUsuario(nomeUsuario);
                    break;
                default:
                    break;
            }
        } while(usuario == null);
        System.out.println("Usuario "+usuario.getNome()+" te damos as boas vindas!");

        boolean sair  = false;
        

    }
}
