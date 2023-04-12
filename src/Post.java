package src;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Post {

    private String texto;
    private Usuario autor;
    private Calendar data;

    public Post(String texto, Usuario autor){
        super();
        this.texto = texto;
        this.autor = autor;
        data = Calendar.getInstance();
    }

    public void lerPostagem(){
        System.out.printf("%s --> %s (%d/%d/%d %d:%d)", autor.getNome(), texto, data.get(Calendar.DAY_OF_MONTH), data.get(Calendar.MONTH)+1, data.get(Calendar.YEAR), data.get(Calendar.HOUR_OF_DAY), data.get(Calendar.MINUTE));
    }

    public String getTexto(){
        return texto;
    }

    public Usuario getAutor(){
        return autor;
    }

    public Calendar getData(){
        return data;
    }


}
