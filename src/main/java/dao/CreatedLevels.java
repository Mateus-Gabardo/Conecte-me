package dao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 09062732933
 */
public class CreatedLevels {
    
    private List<String> levels;

    public CreatedLevels() {
        this.levels = new ArrayList<>();
    }

    public void addLevel(String level) {
        levels.add(level);
    }

    public List<String> getLevels() {
        return levels;
    }
    
    public void printLevels() {
        for (int i = 0; i < levels.size(); i++) {
            System.out.println(levels.get(i));
        }
    }
    
}
