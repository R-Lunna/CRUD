
package DTO;

import java.util.List;


public abstract class Table
{
    
    public abstract void insert();
    
    public abstract void update();
    
    public abstract void delete();
    
    public abstract List<?> read();
    
    
}
