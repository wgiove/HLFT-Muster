import de.java.muster.anwendung.business.*;
import de.java.muster.anwendung.vo.KundeVo;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        KundeVo kundeVo = new KundeVo();
        kundeVo.setName("Giove");
        kundeVo.setVorname("Werner");
        //für V1 gut sonst nicht!
        //NewKunde newKunde = new NewKundeImpl();
        BusinessFactory businessFactory = BusinessFactory.getInstance();
        NewKunde newKunde = businessFactory.createNewKunde();
        newKunde.newKunde(kundeVo);

        //für V1 gut sonst nicht!
        //ReadKunden readKunden = new ReadKundeImpl();

        ReadKunden readKunden = BusinessFactory.getInstance().createReadKunden();
        List<KundeVo> kunden = readKunden.readKunden();

        for (KundeVo einKunde : kunden) {
            System.out.println(einKunde);
        }

        NewKunde newKunde1 = businessFactory.createNewKunde();
        KundeVo vo = new KundeVo();
        vo.setName("Giove 2");
        vo.setVorname("Werner2");
        newKunde.newKunde(vo);


    }
}