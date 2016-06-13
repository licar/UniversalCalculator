/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universalcalculator.structure;

/**
 *
 * @author user
 */
public final class TokenPriority {
    private String value = new String();
    private Integer priority = 0;
    
    public TokenPriority(){
    }
    
    public TokenPriority(String value){
        this.value = value;
    }
    
    public void setValue(String value){
        this.value = value;
    }
    
    public String getValue(){
        return this.value;
    }
    
    public void setPriority(Integer prioriry){
        this.priority = prioriry;
    }
    
    public Integer getPriority(){
        return this.priority;
    }
    
}
