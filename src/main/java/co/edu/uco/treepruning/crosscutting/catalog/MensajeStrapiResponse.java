package co.edu.uco.treepruning.crosscutting.catalog;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * DTO que mapea la respuesta de Strapi 5 para el endpoint /api/mensajes.
 * Estructura: { "data": [ { "codigo": "...", "texto": "...", ... } ], "meta": {...} }
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MensajeStrapiResponse {

    private List<MensajeData> data;

    public List<MensajeData> getData() {
        return data;
    }

    public void setData(List<MensajeData> data) {
        this.data = data;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MensajeData {

        private String codigo;
        private String texto;
        private String categoria;
        private Boolean activo;

        public String getCodigo() {
            return codigo;
        }

        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }

        public String getTexto() {
            return texto;
        }

        public void setTexto(String texto) {
            this.texto = texto;
        }

        public String getCategoria() {
            return categoria;
        }

        public void setCategoria(String categoria) {
            this.categoria = categoria;
        }

        public Boolean getActivo() {
            return activo;
        }

        public void setActivo(Boolean activo) {
            this.activo = activo;
        }
    }
}
