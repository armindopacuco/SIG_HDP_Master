/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessao;

import entidade.AdmsClassificacaoServicoSolicitado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mauro
 */
@Stateless
public class AdmsClassificacaoServicoSolicitadoFacade extends AbstractFacade<AdmsClassificacaoServicoSolicitado> {
    @PersistenceContext(unitName = "SIG_HDP_Master-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdmsClassificacaoServicoSolicitadoFacade() {
        super(AdmsClassificacaoServicoSolicitado.class);
    }
    
}
