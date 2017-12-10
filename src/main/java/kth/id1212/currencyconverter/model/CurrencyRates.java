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
package kth.id1212.currencyconverter.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CurrencyRates implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String rateName;
    @Column(precision=10, scale=2)
    private double rate1;

    public CurrencyRates() {
        rate1 = 0.1234;
        rateName = "this is a string";
    }

    public double getRate1() {
        return rate1;
    }

    public String getRatename() {
        return rateName;
    }
    
    public void setRate(double rate1){
        this.rate1 = rate1;
    }
    
    public void setRatename(String rateName){
        this.rateName = rateName;
    }

    /*   @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CurrencyRates)) {
            return false;
        }
        CurrencyRates other = (CurrencyRates) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kth.id1212.currencyconverter.model.CurrencyRates[ id=" + id + " ]";
    }
     */
}
