package entities.machines;

import java.util.UUID;

public class Machine {

    private final UUID id;
    private final String name;

    public Machine(String name) {
        this.name = name;
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
