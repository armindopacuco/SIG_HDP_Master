/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBean.rhBean;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Ornela F. Boaventura
 */
@ManagedBean
@SessionScoped
public class funcionarioBean
{

    String estadoCivil;
    
    /**
     * Creates a new instance of funcionarioBean
     */
    public funcionarioBean ()
    {
    }

    public ArrayList<String> pesquisarPessoas ()
    {
        ArrayList<String> arrayTeste = new ArrayList<> ();
        arrayTeste.add("Garcia");
        arrayTeste.add("Ornela");
        arrayTeste.add("Duneth");
        arrayTeste.add("Elizangela");
        
        return arrayTeste;
    }

    public String getEstadoCivil ()
    {
        return estadoCivil;
    }

    public void setEstadoCivil (String estadoCivil)
    {
        this.estadoCivil = estadoCivil;
    }
    
    public ArrayList<SelectItem> getEstadosCivis()
    {
        ArrayList<SelectItem> itens = new ArrayList<>();
        
        itens.add(new SelectItem(null, "Selecione"));
        itens.add(new SelectItem("Solteiro", "Solteiro"));
        itens.add(new SelectItem("Casado", "Casado"));
        
        return itens;
    }
    
    
}
