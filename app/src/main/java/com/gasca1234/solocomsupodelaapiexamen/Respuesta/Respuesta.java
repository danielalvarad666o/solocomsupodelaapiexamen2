package com.gasca1234.solocomsupodelaapiexamen.Respuesta;

import com.gasca1234.solocomsupodelaapiexamen.ganadores;

import java.util.List;

public class Respuesta {
    private String status;
    private List<ganadores> data;

    public Respuesta(String status, List<ganadores> data) {
        this.status = status;
        this.data = data;
    }

    public List<ganadores> getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setData(List<ganadores> data) {
        this.data = data;
    }
}
