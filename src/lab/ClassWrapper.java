package lab;

import lab.classes.MusicBand;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

//Существует, для сохранения коллекции в xml
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ClassWrapper {

    private ArrayList<MusicBand> theCollection;

    public ClassWrapper(){
        theCollection = new ArrayList<MusicBand>();
    }

    public ArrayList<MusicBand> getTheCollection(){
        return theCollection;
    }
    public void setTheCollection(ArrayList<MusicBand> theCollection){
        this.theCollection=theCollection;
    }
}