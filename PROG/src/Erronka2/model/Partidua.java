package Erronka2.model;

public class Partidua {
    private int partidu_kod;
    private Taldeak etxeko_taldea;
    private Taldeak kanpoko_taldea;
    private String zelaia;
    private String partidudata;
    private String partiduMota;
    private int etxekoTaldekoPuntuazioa;
    private int kanpokoTaldekoPuntuazioa;
    
    public Partidua() {
    }
    
    public Partidua(int partidu_kod, Taldeak etxeko_taldea, Taldeak kanpoko_taldea, 
                    String zelaia, String partidudata, String partiduMota, 
                    int etxekoTaldekoPuntuazioa, int kanpokoTaldekoPuntuazioa) {
        this.partidu_kod = partidu_kod;
        this.etxeko_taldea = etxeko_taldea;
        this.kanpoko_taldea = kanpoko_taldea;
        this.zelaia = zelaia;
        this.partidudata = partidudata;
        this.partiduMota = partiduMota;
        this.etxekoTaldekoPuntuazioa = etxekoTaldekoPuntuazioa;
        this.kanpokoTaldekoPuntuazioa = kanpokoTaldekoPuntuazioa;
    }
    
    public int getPartidu_kod() {
        return partidu_kod;
    }
    
    public void setPartidu_kod(int partidu_kod) {
        this.partidu_kod = partidu_kod;
    }
    
    public Taldeak getEtxeko_taldea() {
        return etxeko_taldea;
    }
    
    public void setEtxeko_taldea(Taldeak etxeko_taldea) {
        this.etxeko_taldea = etxeko_taldea;
    }
    
    public Taldeak getKanpoko_taldea() {
        return kanpoko_taldea;
    }
    
    public void setKanpoko_taldea(Taldeak kanpoko_taldea) {
        this.kanpoko_taldea = kanpoko_taldea;
    }
    
    public String getZelaia() {
        return zelaia;
    }
    
    public void setZelaia(String zelaia) {
        this.zelaia = zelaia;
    }
    
    public String getPartidudata() {
        return partidudata;
    }
    
    public void setPartidudata(String partidudata) {
        this.partidudata = partidudata;
    }
    
    public String getPartiduMota() {
        return partiduMota;
    }
    
    public void setPartiduMota(String partiduMota) {
        this.partiduMota = partiduMota;
    }
    
    public int getEtxekoTaldekoPuntuazioa() {
        return etxekoTaldekoPuntuazioa;
    }
    
    public void setEtxekoTaldekoPuntuazioa(int etxekoTaldekoPuntuazioa) {
        this.etxekoTaldekoPuntuazioa = etxekoTaldekoPuntuazioa;
    }
    
    public int getKanpokoTaldekoPuntuazioa() {
        return kanpokoTaldekoPuntuazioa;
    }
    
    public void setKanpokoTaldekoPuntuazioa(int kanpokoTaldekoPuntuazioa) {
        this.kanpokoTaldekoPuntuazioa = kanpokoTaldekoPuntuazioa;
    }
    
    @Override
    public String toString() {
        return "Partidua{" +
                "partidu_kod=" + partidu_kod +
                ", etxeko_taldea=" + etxeko_taldea +
                ", kanpoko_taldea=" + kanpoko_taldea +
                ", zelaia='" + zelaia + '\'' +
                ", partidudata='" + partidudata + '\'' +
                ", partiduMota='" + partiduMota + '\'' +
                ", etxekoTaldekoPuntuazioa=" + etxekoTaldekoPuntuazioa +
                ", kanpokoTaldekoPuntuazioa=" + kanpokoTaldekoPuntuazioa +
                '}';
    }
}