import org.junit.Test;
import tddmicroexercises.turnticketdispenser.ITurnNumberSequenceGenerator;
import tddmicroexercises.turnticketdispenser.TicketDispenser;
import tddmicroexercises.turnticketdispenser.TurnNumberSequence;

import static org.junit.Assert.*;

public class TicketDispenserTest {
    @Test
    public void testTicketDispenser() {
        ITurnNumberSequenceGenerator generator = new TurnNumberSequence();

        TicketDispenser dispenserOne = new TicketDispenser(generator);
        TicketDispenser dispenserTwo = new TicketDispenser(generator);
        TicketDispenser dispenserThree = new TicketDispenser(generator);

        assertEquals(0, dispenserTwo.getTurnTicket().getTurnNumber());
        assertEquals(1, dispenserThree.getTurnTicket().getTurnNumber());
        assertEquals(2, dispenserOne.getTurnTicket().getTurnNumber());
    }
}