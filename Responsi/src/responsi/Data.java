
public class Data {
    private String negara;
    private String tanggal;
    private int positif;
    private int sembuh;
    private int meninggal;
    private int id;

    public Data(int id, String negara, int positif, int sembuh, int meninggal, String tanggal){
        this.id = id;
        this.negara = negara;
        this.positif = positif;
        this.sembuh = sembuh;
        this.meninggal = meninggal;
        this.tanggal=tanggal;
    }

    public int getId(){
        return id;
    }
    public String getTanggal() {
        return tanggal;
    }
    public String getNegara() {
        return negara;
    }

    public int getPositif() {
        return positif;
    }

    public int getSembuh() {
        return sembuh;
    }

    public int getMeninggal() {
        return meninggal;
    }

}
