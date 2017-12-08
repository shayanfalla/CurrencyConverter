/*
 * Copyright (C) 2017 Shayan Fallahian shayanf@kth.se
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package kth.id1212.currencyconverter.integration;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import kth.id1212.currencyconverter.model.CurrencyRates;

@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Stateless
public class CurrencyDAO {

    @PersistenceContext(unitName = "simple-jpaPU")
    private EntityManager em;

    public CurrencyRates getCurrencyRate(String rate) {
        CurrencyRates currencyRate = em.find(CurrencyRates.class, rate);
        if (currencyRate == null) {
            throw new EntityNotFoundException("No rate");
        }
        return currencyRate;
    }

    public void storeRate(CurrencyRates cr) {
        em.persist(cr);
    }
    
    public boolean contains(String ratename){
        if(em.contains(ratename)){
            return true;
        }
        return false;
    }
}
