package com.company;

//import com.company.Controller.ControllerAutor;
import com.company.ConnectionBD.ClientDB;
import com.company.ConnectionBD.DataBase;
import com.company.Controller.ControllerAutor;
import com.company.DAO.AuthorDAO;
//import com.company.DAO.AuthorDAOFactory;
import com.company.DAOException.DAOException;
import com.company.Model.Author;
import com.company.View.ViewAutor;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;


public class Main {
    private static DataBase db;
    public static void main(String[] args) throws DAOException {
        db = new ClientDB();
        String password = "000000";//l.22, l23, l24 singleton
        String usuario = "postgres";
        db.initialise(usuario,password);



        System.out.println(db.getConnection());
        //DataBase.initialise(usuario,password);
        //Connection con = db.getConnection();
        //Patron creacionales Factory Method
        Author author = new Author("man", "do",ParseDate("01/02/1990"),ParseDate("01/04/2020"),"Femenino","españa","todos","none");

        // controlador
        ControllerAutor controller = new ControllerAutor();

        //guarda un autor a través del controlador
        controller.createAuthor(author);
        //System.out.println(author.getCodautor());

        //author.setCodautor(114);
        //controller.deleteAuthor(author);

        //editar un autor por medio del cod autor
        //author.setCodautor(114);
        //author.setNombre("lenovo");
        //author.setApellidos("pepa");
        //author.setGenero("masculino");
        //controller.updateAuthor(author);

        db.Close();



        //AuthorDAOFactory factoria = new AuthorDAOFactory();
        //AuthorDAO product = factoria.createAuthorDAO();

        //Author author = new Author("Miriam", "Lagratjola",ParseDate("01/02/1990"),ParseDate("01/04/2020"),"Femenino","españa","todos","none");


        boolean updated;



        //todo Enseñar a toni
        //product.create(author);
        //author.setEstudios("Ingenieria");

        //System.out.println(product.update(author));


        //author.setCodautor(70);
        //author.setApellidos("pepa");
        //author.setGenero("masculino");
        //product.update(author);

        //author.setCodautor(79);
        //product.delete(author);


        //ViewAutor vista = new ViewAutor();
        //vista.verautores(product.read());
        //o
        //System.out.println(product.read());









        //System.out.println(author.getCodautor()); //el id es 0 solo cuando se mete en la bd se le asigna un id
        //controller.deleteAuthor(author);//no borra el author que se le mete ahora borra una author por id
        //if (!controller.updateAuthor(author))
        //{
        //    System.out.println(author + " No existe");
        //}

        //Asi  es como se le provoca el error
        //controller.createAuthor(author);
        //author.setCodautor(80);
        //controller.deleteAuthor(author);//no borra el author que se le mete ahora borra una author por id
        //author.setNombre("lenovo");
        //author.setApellidos("pepa");
        //author.setGenero("masculino");
        //controller.updateAuthor(author);

        // eliminar un cliente por medio del id
        //author.setCodautor(61);
        //controller.deleteAuthor(author);


        // editar un autor por medio del cod autor
        //author.setCodautor(41);
        //author.setNombre("lenovo");
        //author.setApellidos("pepa");
        //author.setGenero("masculino");
        //Utilizar boolean o una excepcion ??? Mirarlo con bool tiene otros errores como l.28
        //if (!controller.updateAuthor(author))
        //{
        //    todo: hacer algo  Pensar!!!!!!!,

        //    //Por ejemplo
        //    author = null;
        //

        //    //Esto es interesante para gestionar los parametros raros ejem que no exista, otro si tenemos la edad y esta no coincide con la fecha de nacimiento etc...
//
        //}

        // ver autores
        //controller.readAuthor();


        //https://www.ecodeup.com/crud-java-manual-completo/
    }

    //** Pasa de String a date
    public static Date ParseDate(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;

        try {
            fechaDate = formato.parse(fecha);

        }
        catch (ParseException ex)
        {
            System.out.println(ex);
        }
        java.sql.Date sqlStartDate = new java.sql.Date(fechaDate.getTime());
        return sqlStartDate;
    }
    //** Pasa de Date de until a date de SQL
    public static java.sql.Date convertStringToSQLDate(String strDate) {
        java.sql.Date fecha = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date parsed = format.parse(strDate);
            fecha = new java.sql.Date(parsed.getTime());
        } catch (ParseException e) {
            System.out.println("Exception :" + e);
        }
        return fecha;
    }

}