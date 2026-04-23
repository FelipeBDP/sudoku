package br.com.dio.model;

/**
 * Record que representa a configuração inicial de um espaço no tabuleiro.
 * @param expected O valor esperado para a posição.
 * @param fixed Se o valor é fixo (inicial do jogo) ou não.
 */
public record SpaceConfig(int expected, boolean fixed) {

    /**
     * Cria um SpaceConfig a partir de uma string formatada (ex: "5,true").
     * @param config String de configuração.
     * @return Uma instância de SpaceConfig.
     */
    public static SpaceConfig parse(String config) {
        if (config == null || config.isBlank()) {
            return new SpaceConfig(0, false); // Valor padrão para evitar crash
        }
        var parts = config.split(",");
        return new SpaceConfig(
                Integer.parseInt(parts[0]),
                Boolean.parseBoolean(parts[1])
        );
    }
}
