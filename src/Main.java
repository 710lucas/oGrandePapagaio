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
        final int SAIR = 3;
        boolean sair  = false;


        while(!sair) {
            Usuario usuario = null;

           while(usuario == null && !sair) {
                System.out.print("1 - LOGIN\n2 - REGISTRAR\n3 - SAIR\n>");

                int escolha = Integer.parseInt(sc.nextLine());

               String nomeUsuario;

                switch (escolha) {
                    case LOGIN:
                        System.out.print("DIGITE SEU NOME DE USUARIO: ");
                        nomeUsuario = sc.nextLine();
                        usuario = papa.getUsuario(nomeUsuario);
                        break;

                    case REGISTRAR:
                        System.out.print("DIGITE SEU NOME DE USUARIO: ");
                        nomeUsuario = sc.nextLine();
                        if(papa.criarUsuario(nomeUsuario))
                            usuario = papa.getUsuario(nomeUsuario);
                        break;

                    case SAIR:
                        sair = true;
                        System.exit(0);
                        break;

                    default:
                        break;
                }
            }



            System.out.println("Olá " + usuario.getNome() + " te damos as boas vindas!");
            System.out.println("Digite help para ver os comandos");
            usuario.setLogado(true);

            String input = "";




            while (!input.equals("sair")) {
                System.out.print("\n>");
                input = sc.nextLine();

                String[] palavras = input.split(" ");

                if (palavras.length > 2 && palavras[1].equals("->")) {
                    String nomeUsuario = palavras[0];
                    if (papa.getUsuario(nomeUsuario) == null)
                        continue;
                    papa.postar(nomeUsuario, input.replace(palavras[0] + " " + palavras[1] + " ", ""));


                } else if (palavras.length == 2 && palavras[0].equals("mural")) {
                    String nomeUsuario = palavras[1];
                    if (papa.getUsuario(nomeUsuario) == null)
                        continue;
                    papa.verMural(nomeUsuario);


                } else if (palavras.length == 3 && palavras[1].equals("segue")) {
                    String quemVaiSeguir = palavras[0];
                    String quemVaiSerSeguido = palavras[2];
                    papa.seguir(quemVaiSeguir, quemVaiSerSeguido);


                } else if(input.equals("listar")){
                    papa.listarUsuarios();


                } else if(palavras.length == 2 && palavras[0].equals("seguindo")){
                    papa.listarSeguindo(palavras[1]);


                } else if (input.equals("help")) {
                    System.out.println("""
                            COMANDOS:
                            - Postagem: <nome do usuario> -> <messagem>
                            - Leitura: mural <nome do usuário>
                            - Seguir: <nome do usuário> segue <outro usuário>
                            - Listar usuarios: listar
                            - Ver quem um usuario está seguindo: seguindo <nome do usuario>
                            - help
                            - sair
                            """);
                }
                papa.salvar();
            }
            usuario.setLogado(false); //desloga usuario ao sair

        }

        sc.close();

    }
}
