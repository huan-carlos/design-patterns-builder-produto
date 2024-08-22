import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Produto da loja.
 * @author Manoel Campos da Silva Filho
 */
@Builder @Getter @Setter
public class Produto {
    //1 - Os atributos em negrito são obrigatórios.
    //7 - Nenhum dos atributos String pode ser null.
    @NonNull
    private long id;
    @NonNull
    private String codigoEan;
    @NonNull
    private String descricao;
    @NonNull
    private String marca;
    @NonNull
    private String modelo;
    @NonNull
    private double preco;
    @NonNull
    private LocalDate dataCadastro;
    private LocalDate dataUltimaAtualizacao;
    private int estoque;
    @NonNull
    private String categoria;
    @NonNull
    private String urlFoto;

    public Produto(@NonNull long id, @NonNull String codigoEan, @NonNull String descricao, @NonNull String marca, @NonNull String modelo, @NonNull double preco, LocalDate dataUltimaAtualizacao, @NonNull String categoria, @NonNull String urlFoto) {
        this.setId(id);
        this.setCodigoEan(codigoEan);
        this.setDescricao(descricao);
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setPreco(preco);

        //4 - A data de cadastro não pode ser alterada e deve ser definida por padrão com a data atual.
        this.dataCadastro = LocalDate.now();

        this.setDataUltimaAtualizacao(dataUltimaAtualizacao);

        //6 - O estoque padrão deve ser zero ...
        this.estoque = 0;
        this.setCategoria(categoria);
        this.setUrlFoto(urlFoto);
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCodigoEan(String codigoEan) {
        this.codigoEan = codigoEan;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    //2 - Não pode ser informado um modelo se não for informada a marca.
    public void setModelo(@NonNull String modelo) {
        if(this.marca.isBlank()){
            throw new IllegalArgumentException("Marca deve ser Informada Primeiro.");
        }
        this.modelo = modelo;
    }

    //3 - O preço deve ser maior que zero.
    public void setPreco(double preco) {
        if(preco <= 0){
            throw new IllegalArgumentException("Preço deve ser Maior que Zero.");
        }
        this.preco = preco;
    }

    //5 - A data da última atualização não pode ser anterior a data de cadastro.
    public void setDataUltimaAtualizacao(LocalDate dataUltimaAtualizacao) {
        if(dataUltimaAtualizacao.isBefore(dataCadastro)){
            throw new IllegalArgumentException("Data da Ultima Atualização não deve ser anterior a data do cadastro.");
        }
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    //6 - ... e não pode ser atribuído valor negativo.
    public void setEstoque(int estoque) {
        if(estoque < 0){
            throw new IllegalArgumentException("Estoque não pode ser negativo.");
        }
        this.estoque = estoque;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
}