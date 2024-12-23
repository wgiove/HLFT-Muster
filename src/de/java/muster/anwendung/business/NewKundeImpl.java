package de.java.muster.anwendung.business;

import de.java.muster.anwendung.daten.DatenSingleton;
import de.java.muster.anwendung.vo.KundeVo;

public class NewKundeImpl implements NewKunde {
    @Override
    public void newKunde(KundeVo kunde) {
        //Validierung Business Logik!!
        System.out.println("Methode newKundeImpl");
        System.out.println(kunde);
        DatenSingleton daten =DatenSingleton.getInstance();
        daten.addKunde(kunde);
    }
}
