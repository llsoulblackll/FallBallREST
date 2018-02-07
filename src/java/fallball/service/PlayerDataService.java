/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fallball.service;

import fallball.dao.PlayerDao;
import fallball.dao.impl.DaoFactory;
import fallball.entity.PlayerData;
import fallball.service.model.FallBallRSResult;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Alumno-CT
 */
@Path("")//playerDataService
public class PlayerDataService {

    @Context
    private UriInfo context;
    
    //DI SPECIFIED IN APPLICATIONCONFIG
    @Inject
    private PlayerDao playerDao;
    /**
     * Creates a new instance of PlayerDataService
     */
    
    //WITHOUT DI
    /*public PlayerDataService() {
    playerDao = DaoFactory.getInstance().getPlayerDao();
    }*/

    /**
     * Retrieves representation of an instance of fallball.service.PlayerDataService
     * @param playerId Id of the requested player
     * @return an instance of java.lang.String
     */
    @GET
    @Path("getPlayer/{playerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public PlayerData.Player getPlayer(@PathParam("playerId") int playerId){
        return this.playerDao.find(playerId);
    }
    
    @GET
    @Path("getAllPlayers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PlayerData.Player> getAllPlayers(){
        return playerDao.findAll();
    }
    
    
    @POST
    @Path("newPlayer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)//IT SEEMS THAT WHEN TO DO REST WE ALWAYS NEED TO SPECIFY THE PRODUCES ANNOTATION ALONG WITH ITS MEDIA TYPE
    //ALSO A MESSAGEBODY WRITE FOR JSON IS IMPLCITLY USED IDK WHICH BUT WHEN NOT SPECIFYING THE PRODUCED OBJECT TEXT/XML IS USED WHICH NEEDS AN EXPLICIT BODY WRITER
    public FallBallRSResult newPlayer(PlayerData.Player player){
        System.out.printf("%s - %f - %d", player.playerName, player.playerScore, player.level);
        playerDao.create(player);
        return new FallBallRSResult(0, "Insertion Succesful", null);
    }
    
    
    
    
    /*@GET
    @Path("getPlayer/{playerId}")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public PlayerData.Player getPlayer(@PathParam(value = "playerId") String playerId) {
        //TODO return proper representation object
        return playerDao.find(playerId);
    }*/
    
    
    /**
     * PUT method for updating or creating an instance of PlayerDataService
     * @param content representation for the resource
     */
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.TEXT_HTML)
    public void putHtml(String content) {
    }
}
