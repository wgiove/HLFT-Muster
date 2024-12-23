package de.java.muster.anwendung.decorator;

import de.java.muster.anwendung.business.ReadKunden;
import de.java.muster.anwendung.vo.KundeVo;

import java.util.List;

public class ZeitDec extends Decorator {

    public ZeitDec(ReadKunden decorator) {
        super(decorator);
    }

    @Override
    public List<KundeVo> readKunden() {
        System.out.println("ZeitDec readKunden");
        long startZeit = System.nanoTime();
        List<KundeVo> dieKunden = getReadKunden().readKunden();
        long endZeit = System.nanoTime();
        long durationZeit = endZeit - startZeit;
        System.out.println("die Laufzeit: " + durationZeit + "ns");
        return dieKunden;
    }
}
