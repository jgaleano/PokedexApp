package test.julio.pokedex.PokemonObjects;

import java.io.Serializable;

/**
 * Created by Julio on 28/02/16.
 */
public class Pokemon implements Serializable {

    private String name;
    private String nationalId;
    private String maleFemaleRatio;
    private String urlImage;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getMaleFemaleRatio() {
        return maleFemaleRatio;
    }

    public void setMaleFemaleRatio(String maleFemaleRatio) {
        this.maleFemaleRatio = maleFemaleRatio;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
