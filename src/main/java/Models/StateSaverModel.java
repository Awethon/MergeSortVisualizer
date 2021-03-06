package Models;

import java.util.ArrayList;

public class StateSaverModel {

    private volatile ArrayList<SortState> sortStates;

    public int size(){
        return sortStates.size();
    }

    public StateSaverModel() {
        sortStates = new ArrayList<>();
    }

    public SortState getState(int index) {
        return sortStates.get(index);
    }

    public void saveState(SortState sortState) {
        this.sortStates.add(sortState);
    }

    public void clear() {
        if(sortStates != null) sortStates.clear();
    }
}
