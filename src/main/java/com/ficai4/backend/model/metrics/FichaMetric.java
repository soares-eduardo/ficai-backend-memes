package com.ficai4.backend.model.metrics;

public class FichaMetric {
    private Integer openFichas;
    private Integer closedFichas;

    public FichaMetric(){}

    public FichaMetric(Integer openFichas, Integer closedFichas) {
        this.openFichas = openFichas;
        this.closedFichas = closedFichas;
    }

    public Integer getOpenFichas() {
        return openFichas;
    }

    public void setOpenFichas(Integer openFichas) {
        this.openFichas = openFichas;
    }

    public Integer getClosedFichas() {
        return closedFichas;
    }

    public void setClosedFichas(Integer closedFichas) {
        this.closedFichas = closedFichas;
    }
}
