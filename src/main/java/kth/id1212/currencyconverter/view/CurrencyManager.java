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
package kth.id1212.currencyconverter.view;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import kth.id1212.currencyconverter.controller.CurrencyFacade;

@Named(value= "currencyManager")
@ConversationScoped
public class CurrencyManager implements Serializable {

    @EJB
    private CurrencyFacade currencyFacade;
    @Inject
    private Conversation conversation;
    
    private double value;
    
    private double rate;
    
    private static String CurrChoice;
    
    public double getValue(){
        return value;
    }
    
    public void setValue(double message){
        this.value = message;
    }
    
    public double getRate(){
        return rate;
    }
    
    public void setRate(double rate){
        this.rate = rate;
    }
    
    public String getCurrChoice(){
        return CurrChoice;
    }
    
    public void setCurrChoice(String CurrChoice){
        this.CurrChoice = CurrChoice;
    }
    
    public void convert(){
        rate = value * 0.100431745;
    }

    public void startConversation() {
        if (!FacesContext.getCurrentInstance().isPostback() && conversation.isTransient()) {
            conversation.begin();
        }
        currencyFacade.createCurr();
    }

    public void stopConversation() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
    }
    
    
}
