package de.java.muster.anwendung.business;

import de.java.muster.anwendung.vo.KundeVo;

import java.util.List;

public interface ReadKunden extends Business{

    public List<KundeVo> readKunden();

}
