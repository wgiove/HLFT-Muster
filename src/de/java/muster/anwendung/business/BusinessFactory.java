package de.java.muster.anwendung.business;

import de.java.muster.anwendung.decorator.RechteDec;
import de.java.muster.anwendung.decorator.ZeitDec;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class BusinessFactory {

    private static BusinessFactory instance;
    private Hashtable<String, Business> services;


    private BusinessFactory() {
        services = new Hashtable<String, Business>();
    }

    public static BusinessFactory getInstance() {
        if (instance == null) {
            instance = new BusinessFactory();

        }
        return instance;
    }

    public ReadKunden createReadKunden() {
        ReadKunden finalReadKunden = null;
        if(!services.containsKey("ReadKunden")) {
            ReadKunden echterReadKunden = new ReadKundeImpl();
            ReadKunden zeitDec = new ZeitDec(echterReadKunden);
            ReadKunden rechtDec = new RechteDec(zeitDec);
            services.put("ReadKunden", rechtDec);
            finalReadKunden = rechtDec;
        }
        else{
            finalReadKunden = (ReadKunden)services.get("ReadKunden");
        }


        return finalReadKunden;
    }

    public NewKunde createNewKunde() {
        NewKunde newKunde = null;
        if(!services.containsKey("NewKunde")) {
            NewKunde echterNewKunde = new NewKundeImpl();
            services.put("NewKunde", echterNewKunde);
            newKunde = echterNewKunde;
        } else
            newKunde = (NewKunde)services.get("NewKunde");
        return newKunde;
    }
}
