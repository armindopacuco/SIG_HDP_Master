/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessao;

import entidade.FarmCategoriaNivel2;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mauro
 */
@Stateless
public class FarmCategoriaNivel2Facade extends AbstractFacade<FarmCategoriaNivel2> {
    @PersistenceContext(unitName = "SIG_HDP_Master-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FarmCategoriaNivel2Facade() {
        super(FarmCategoriaNivel2.class);
    }
    
}
