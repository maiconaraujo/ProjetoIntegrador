/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.es.webservice;

import br.senac.es.dao.CriancaDAO;
import br.senac.es.dao.UsuarioDAO;
import br.senac.es.model.Crianca;
import br.senac.es.model.Usuario;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * REST Web Service
 *
 * @author 
 */
@Path("sistema")
public class CriancaResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public CriancaResource() {
    }

    /**
     * Retrieves representation of an instance of ws.CriancaResource
     *
     * @param login
     * @param senha
     * @return an instance of java.lang.String
     */
    @GET
    @Path("login/{login}/{senha}")
    @Produces(MediaType.APPLICATION_JSON)
    public String login(@PathParam("login") String login, @PathParam("senha") String senha) {
        Gson g = new Gson();

        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            senha = DigestUtils.sha512Hex(senha);
            Usuario u = usuarioDAO.loginParaMobile(login, senha);                      

            return g.toJson(u);
        } catch (ClassNotFoundException | SQLException e) {
            String erro = e.getMessage();
            return g.toJson(erro);
        }
    }
    
        /**
     * Retrieves representation of an instance of ws.CriancaResource
     *
     * @param login
     * @param senha
     * @return an instance of java.lang.String
     */
    @GET
    @Path("criancas/{login}/{senha}")
    @Produces(MediaType.APPLICATION_JSON)
    public String listarCriancas(@PathParam("login") String login, @PathParam("senha") String senha) {
        Gson g = new Gson();

        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            senha = DigestUtils.sha512Hex(senha);
            Usuario u = usuarioDAO.loginParaMobile(login, senha);   
            
            if(u != null){
                CriancaDAO criancaDAO = new CriancaDAO();
                ArrayList<Crianca> lista = criancaDAO.getListParaMobile(u);
                return g.toJson(lista);
            }else{
                return g.toJson("Acesso negado");
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            String erro = e.getMessage();
            return g.toJson(erro);
        }
    }       
    
     /**
     * Retrieves representation of an instance of ws.CriancaResource
     *
     * @param codigo
     * @param login
     * @param senha
     * @return an instance of java.lang.String
     */
    @GET
    @Path("crianca/{codigo}/{login}/{senha}")
    @Produces(MediaType.APPLICATION_JSON)
    public String buscarCrianca(@PathParam("codigo") int codigo, @PathParam("login") String login, @PathParam("senha") String senha) {
        Gson g = new Gson();

        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            senha = DigestUtils.sha512Hex(senha);
            Usuario u = usuarioDAO.loginParaMobile(login, senha);   
            
            if(u != null){
                CriancaDAO criancaDAO = new CriancaDAO();
                Crianca c = criancaDAO.buscar(codigo);
                return g.toJson(c);
            }else{
                return g.toJson("Acesso negado");
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            String erro = e.getMessage();
            return g.toJson(erro);
        }
    }   

    /**
     * PUT method for updating or creating an instance of CriancaResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
