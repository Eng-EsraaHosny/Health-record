package com.example.aw.health_record_2;

import java.util.ArrayList;

/**
 * Created by User on 9/21/2016.
 */
public class record {


    String Dr_name;



    String title;
    String status;
    String specialization;
    String Diseace;
    String cure;

    public record()
    {


    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDr_name(String dr_name) {
        Dr_name = dr_name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setDiseace(String diseace) {
        Diseace = diseace;
    }

    public void setCure(String cure) {
        this.cure = cure;
    }
    public String getDr_name() {
        return Dr_name;
    }

    public String getTitle() {
        return title;
    }

    public String getStatus() {
        return status;
    }

    public String getcure() {
        return cure;
    }
    public String getDiseace() {
        return Diseace;
    }
    public String getspecialization() {
        return specialization;
    }


}
