package entities.machines;

import java.util.UUID;

public class Machine {

    private final UUID id;
    private final String name;

    public Machine(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
