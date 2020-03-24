package mx.gendra.cpostal.beans;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class ZipCode {
	private String zip_code;
    private String locality;
    private String federal_entity;
    private ArrayList<Settlements> settlements;;

    private String municipality;
    
    public String getZip_code() {
            return zip_code;
    }
    public void setZip_code(String zip_code) {
            this.zip_code = zip_code;
    }
    public String getLocality() {
            return locality;
    }
    public void setLocality(String locality) {
            this.locality = locality;
    }
    public String getFederal_entity() {
            return federal_entity;
    }
    public void setFederal_entity(String federal_entity) {
            this.federal_entity = federal_entity;
    }

    public ArrayList<Settlements> getSettlements() {
        return settlements;
    }

    public void setSettlements(ArrayList<Settlements> settlements) {
        this.settlements = settlements;
    }
    
    
    public String getMunicipality() {
            return municipality;
    }
    public void setMunicipality(String municipality) {
            this.municipality = municipality;
    }

    @Override
    public String toString() {
        return "ZipCode{" + "zip_code=" + zip_code + ", locality=" + locality + ", federal_entity=" + federal_entity + ", settlements=" + settlements + ", municipality=" + municipality + '}';
    }
}
