import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class GeradorDeListaDeFigurinhas {

    public void geraListaFigurinhas (String api_url, ExtratorDeConteudo extrator) {
        ClienteHttp http = new ClienteHttp();
        String json = http.buscaDados(api_url);

        // exibir e manipular os dados
        List<Conteudo> conteudos = extrator.extraiConteudos(json);
        System.out.println(conteudos);

        for (int i = 0; i < conteudos.size(); i++) {
            Conteudo conteudo = conteudos.get(i);
            System.out.println(conteudo);

//            InputStream inputStream = new URL(conteudo.getImagem()).openStream();
//            String nomeDoArquivoDeSaida = "saida/ " + conteudo.getTitulo() + ".png";
//            System.out.println(conteudo.getTitulo());
//
//            GeradorDeFigurinhas geradora = new GeradorDeFigurinhas();
//            geradora.cria(inputStream, nomeDoArquivoDeSaida);
        }
    }

}
