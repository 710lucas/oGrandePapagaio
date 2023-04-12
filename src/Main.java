package src;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Papagaio papa = new Papagaio(); //papa = abreviação de papagaio

        //apenas usar isso se for salvar arquivos, o que não é necessário
        //o mesmo se aplica pro metodo .salvar();
        papa = papa.carregaPapagaios();

        Scanner sc = new Scanner(System.in);

        final int LOGIN = 1;
        final int REGISTRAR = 2;


        Usuario usuario = null;
        do {
            System.out.print("1 - LOGIN\n2 - REGISTRAR\n>");

            //recebe String como input e converte para int
            //evita colocar um nextInt e um nextLine feio embaixo
            //acho menos confuso
            int escolha = Integer.parseInt(sc.nextLine());
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
                    usuario = papa.getUsuario(nomeUsuario);
                    break;
                default:
                    break;
            }
        } while(usuario == null);
        System.out.println("Usuario "+usuario.getNome()+" te damos as boas vindas!");
        System.out.println("Digite help para ver os comandos");

        boolean sair  = false;

        while(!sair){
            System.out.print("\n>");
            String input = sc.nextLine();

            //separa as palavras por espaço
            String[] palavras = input.split(" ");

            //caso a segunda palavra da lista seja ->
            //sabemos que é uma postagem
            if(palavras.length>2 && palavras[1].equals("->")){
                //palavras[0] -> nome
                //palavras[1] -> ->
                //resto = texto da postagem
                Usuario usuario1 =  null;
                usuario1 = papa.getUsuario(palavras[0]);
                if(usuario1 == null)
                    continue;

                //substitui, no comando original, o autor e o comando de postagem por uma string vazia
                //exemplo:
                //Daniel -> java 19 é massa
                //vai virar
                //java 19 é massa
                //após substiruir "Daniel -> " por uma string vazia, basicamente apagando isso
                usuario1.postar(input.replace(palavras[0]+" "+palavras[1]+" ", ""));
            }

            else if(palavras.length == 2 && palavras[0].equals("mural")){
                //palavras[0] -> mural
                //palavras[1] -> nome do usuario
                Usuario usuario1 = null;
                usuario1 = papa.getUsuario(palavras[1]);
                if(usuario1 == null)
                    continue;
                usuario1.lerMural();
            }

            else if(palavras.length == 3 && palavras[1].equals("segue")){
                //palavras[0] -> nome do usuario que vai seguir o outro
                //palavras[1] -> segue
                //palavras[2] -> nome do usuario que vai ser seguido
                Usuario usuarioQueVaiSeguir = null;
                usuarioQueVaiSeguir = papa.getUsuario(palavras[0]);
                if(usuarioQueVaiSeguir == null)
                    continue;
                
                Usuario usuarioQueVaiSerSeguido = null;
                usuarioQueVaiSerSeguido = papa.getUsuario(palavras[2]);
                if(usuarioQueVaiSerSeguido == null)
                    continue;

                usuarioQueVaiSeguir.seguir(usuarioQueVaiSerSeguido);
                
            }

            else if(input.equals("help")){
                System.out.println("""
                        COMANDOS:
                        - Postagem: <nome do usuario> -> <messagem>
                        - Leitura: mural <nome do usuário>
                        - Seguir: <nome do usuário> segue <outro usuário>
                        - help
                        - sair
                        """);
            }

            else if(input.equals("sair")){
                sair = true;
            }
            papa.salvar();
        }


        sc.close();

    }
}
