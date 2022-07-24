
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main (String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar os conteúdos
        Scanner scanner = new Scanner(System.in);

        int opcao = 0;
        do {
            System.out.println("Você quer gerar figurinhas de qual API?\n1- IMDB API\n2- NASA API\n3- Linguagens de Programação\n4- Sair\n");
            opcao = Integer.parseInt(scanner.nextLine());

            String api_url = "";

            if (opcao == 1) {
                api_url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
                ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

                ClienteHttp http = new ClienteHttp();
                String json = http.buscaDados(api_url);

                // exibir e manipular os dados
                List<Conteudo> conteudos = extrator.extraiConteudos(json);
                System.out.println(conteudos);

                for (int i = 0; i < conteudos.size(); i++) {
                    Conteudo conteudo = conteudos.get(i);
                    System.out.println(conteudo);

                    InputStream inputStream = new URL(conteudo.getImagem()).openStream();
                    String nomeDoArquivoDeSaida = "saida/ " + conteudo.getTitulo() + ".png";
                    System.out.println(conteudo.getTitulo());

                    GeradorDeFigurinhas geradora = new GeradorDeFigurinhas();
                    geradora.cria(inputStream, nomeDoArquivoDeSaida);
                }

//                GeradorDeListaDeFigurinhas gerador = new GeradorDeListaDeFigurinhas();
//                gerador.geraListaFigurinhas(api_url, extrator);
            } else if (opcao == 2) {
                api_url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-07-11&end_date=2022-07-20";
                ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

                ClienteHttp http = new ClienteHttp();
                String json = http.buscaDados(api_url);

                // exibir e manipular os dados
                List<Conteudo> conteudos = extrator.extraiConteudos(json);

                for (int i = 0; i < conteudos.size(); i++) {
                    Conteudo conteudo = conteudos.get(i);

                    InputStream inputStream = new URL(conteudo.getImagem()).openStream();
                    String nomeDoArquivoDeSaida = "saida/ " + conteudo.getTitulo() + ".png";
                    System.out.println(conteudo.getTitulo());

                    GeradorDeFigurinhas geradora = new GeradorDeFigurinhas();
                    geradora.cria(inputStream, nomeDoArquivoDeSaida);
                }

//                GeradorDeListaDeFigurinhas gerador = new GeradorDeListaDeFigurinhas();
//                gerador.geraListaFigurinhas(api_url, extrator);
            }
            else if (opcao == 3) {
                api_url = "http://localhost:8080/linguagens";
                ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

                ClienteHttp http = new ClienteHttp();
                String json = http.buscaDados(api_url);

                // exibir e manipular os dados
                List<Conteudo> conteudos = extrator.extraiConteudos(json);
                System.out.println(conteudos);

                for (int i = 0; i < conteudos.size(); i++) {
                    Conteudo conteudo = conteudos.get(i);
                    System.out.println(conteudo);

                    InputStream inputStream = new URL(conteudo.getImagem()).openStream();
                    String nomeDoArquivoDeSaida = "saida/ " + conteudo.getTitulo() + ".png";
                    System.out.println(conteudo.getTitulo());

                    GeradorDeFigurinhas geradora = new GeradorDeFigurinhas();
                    geradora.cria(inputStream, nomeDoArquivoDeSaida);
                }

            }

        } while (opcao != 3);

    }
}
