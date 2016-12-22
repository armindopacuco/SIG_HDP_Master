/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBean.rhBean;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Ornela F. Boaventura
 */
@ManagedBean
@SessionScoped
public class contratoBean
{

    private ArrayList<String> subsidiosArray;
    
    /**
     * Creates a new instance of contratoBean
     */
    public contratoBean ()
    {
        subsidiosArray = new ArrayList<>();
        
        subsidiosArray.add("Alimentação");
        subsidiosArray.add("Transporte");
        subsidiosArray.add("Férias");
        subsidiosArray.add("Risco");
        subsidiosArray.add("IRSS");
        subsidiosArray.add("Outros");
    }

    public ArrayList<String> getSubsidiosArray ()
    {
        return subsidiosArray;
    }

    public void setSubsidiosArray (ArrayList<String> subsidiosArray)
    {
        this.subsidiosArray = subsidiosArray;
    }
    
    
    
}