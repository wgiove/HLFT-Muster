package de.java.muster.anwendung.business;

import de.java.muster.anwendung.daten.DatenSingleton;
import de.java.muster.anwendung.vo.KundeVo;

import java.util.List;

public class ReadKundeImpl implements ReadKunden{

    @Override
    public List<KundeVo> readKunden() {
        //Seid Kreativ die müssen evtl. zählen wie viele Kunden in der Liste sind..!!
        DatenSingleton datenSingleton = DatenSingleton.getInstance();

        return datenSingleton.getMeineDaten();
    }
}
