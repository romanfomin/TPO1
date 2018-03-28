package task3;

import java.util.List;

public class Controller {
    private List<Handle> handles;

    public Controller(List<Handle> handles){
        this.handles = handles;
    }

    public List<Handle> getHandles() {
        return handles;
    }
}
