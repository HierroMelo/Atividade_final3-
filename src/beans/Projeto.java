/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author hierro.melo
 */
public class Projeto {
    private long id;        
    private String titulo;    
    private String ideia;     

    public Projeto(long id, String titulo, String ideia) {
        this.id = id;
        this.titulo = titulo;
        this.ideia = ideia;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdeia() {
        return ideia;
    }

    public void setIdeia(String ideia) {
        this.ideia = ideia;
    }
}
