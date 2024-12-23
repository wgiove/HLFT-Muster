package de.java.muster.anwendung.decorator;

import de.java.muster.anwendung.business.ReadKunden;
import de.java.muster.anwendung.vo.KundeVo;

import java.util.List;

public class RechteDec extends Decorator {

    public RechteDec(ReadKunden readKunden) {
        super(readKunden);
    }

    @Override
    public List<KundeVo> readKunden() {
        System.out.println("RechteDec readKunden");
        List<KundeVo> kundenListe = getReadKunden().readKunden();
        return kundenListe;
    }
}
