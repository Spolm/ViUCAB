package edu.ucab.desarrollo.viucab.domainLogicLayer.M08;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.exceptions.MessageException;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class Suscripcion extends Command {

    final static org.slf4j.Logger logger = LoggerFactory.getLogger(Suscripcion.class);

    public Suscripcion(Entity est) {
    }

    @Override
    public void execute() {

        try {

        }
        catch (Exception e){

            MessageException error = new MessageException(e, this.getClass().getSimpleName(),
                    Thread.currentThread().getStackTrace()[1].getMethodName());
            logger.debug("Debug: ", error);
            logger.error("Error: ", error);
        }
    }

    @Override
    public Entity Return() {
        return null;
    }
}