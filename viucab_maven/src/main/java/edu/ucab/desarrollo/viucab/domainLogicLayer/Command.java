package edu.ucab.desarrollo.viucab.domainLogicLayer;



import edu.ucab.desarrollo.viucab.common.entities.Entity;

import java.util.List;

/**
 * Patron Comando
 */
public abstract class Command
{



    public abstract void execute() ;

    public List<Entity> getFriendships(){
        return null;
    }

    public Entity getFriendship(){
        return null;
    }

    public abstract Entity Return() ;

    public Boolean ReturnUpdate() {
        return null;
    }
}