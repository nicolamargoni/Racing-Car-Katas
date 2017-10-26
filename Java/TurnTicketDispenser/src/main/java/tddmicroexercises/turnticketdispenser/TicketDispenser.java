package tddmicroexercises.turnticketdispenser;

public class TicketDispenser {

    private ITurnNumberSequenceGenerator generator;
    public TicketDispenser(ITurnNumberSequenceGenerator generator){
        this.generator = generator;
    }
    public TurnTicket getTurnTicket() {
        return new TurnTicket(generator.getNextTurnNumber());
    }
}
