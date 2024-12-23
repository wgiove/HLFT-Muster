package de.java.muster.anwendung.decorator;

import de.java.muster.anwendung.business.ReadKunden;
import de.java.muster.anwendung.vo.KundeVo;

import java.util.List;

public abstract class Decorator implements ReadKunden {

    public ReadKunden getReadKunden() {
        return readKunden;
    }

    public void setReadKunden(ReadKunden readKunden) {
        this.readKunden = readKunden;
    }

    private ReadKunden readKunden;
    public Decorator(ReadKunden readKunden) {
        this.readKunden = readKunden;
    }


    public abstract List<KundeVo> readKunden();

}
