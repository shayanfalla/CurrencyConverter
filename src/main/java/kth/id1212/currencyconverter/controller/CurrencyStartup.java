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
package kth.id1212.currencyconverter.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import kth.id1212.currencyconverter.integration.CurrencyDAO;
import kth.id1212.currencyconverter.model.CurrencyRates;

@Startup
@Singleton
public class CurrencyStartup {

    @EJB
    CurrencyDAO currDB;

    @PostConstruct
    private void startup() {
        CurrencyRates EURO = new CurrencyRates();
        EURO.setRates(1, 0.8794, 9.94, 1.1773);
        EURO.setRatename("EURO");
        currDB.storeRate(EURO);

        CurrencyRates GBP = new CurrencyRates();
        GBP.setRates(1.1371, 1, 11.3062, 1.3387);
        GBP.setRatename("GBP");
        currDB.storeRate(GBP);

        CurrencyRates SEK = new CurrencyRates();
        SEK.setRates(0.1006, 0.0884, 1, 0.1184);
        SEK.setRatename("SEK");
        currDB.storeRate(SEK);

        CurrencyRates USD = new CurrencyRates();
        USD.setRates(0.8494, 0.747, 8.4457, 1);
        USD.setRatename("USD");
        currDB.storeRate(USD);
    }
}
