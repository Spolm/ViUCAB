package edu.ucab.desarrollo.viucab.domainLogicLayer.M11;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.exceptions.MessageException;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import org.slf4j.LoggerFactory;

/**
 * Created by Daniel on 25/11/2017.
 */
public class GetEstadistica1 extends Command {

    final static org.slf4j.Logger logger = LoggerFactory.getLogger(GetEstadistica1.class);

    public GetEstadistica1(Entity est) {
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
