import java.time.LocalDate;

public class Principal {
    public static void main(String[] args) {
        Produto produto = Produto
                .builder()
                .id(1)
                .categoria("Talher")
                .codigoEan("78900000000")
                .dataCadastro(LocalDate.now())
                .dataUltimaAtualizacao(LocalDate.now())
                .descricao("Colher")
                .estoque(1)
                .marca("Tramontina")
                .modelo("INOX")
                .preco(10)
                .urlFoto("http://foto.com")
                .build();
    }
}
