import java.util.ArrayList;

public class Laaner {
    private int lNr;
    private String fnavn;
    private String enavn;

    private ArrayList<Bog> laenteBoeger=new ArrayList<>();

    public Laaner() {
    }

    public Laaner(int lNr, String fnavn, String enavn) {
        this.lNr = lNr;
        this.fnavn = fnavn;
        this.enavn = enavn;
    }

    public int getlNr() {
        return lNr;
    }

    public void setlNr(int lNr) {
        this.lNr = lNr;
    }

    public String getFnavn() {
        return fnavn;
    }

    public void setFnavn(String fnavn) {
        this.fnavn = fnavn;
    }

    public String getEnavn() {
        return enavn;
    }

    public void setEnavn(String enavn) {
        this.enavn = enavn;
    }

    public ArrayList<Bog> getLaenteBoeger() {
        return laenteBoeger;
    }

    public void setLaenteBoeger(ArrayList<Bog> laenteBoeger) {
        this.laenteBoeger = laenteBoeger;
    }

    public void laenBog(Bog b){
        this.laenteBoeger.add(b);
    }

    public void afleverBog(Bog b){
        this.laenteBoeger.remove(b);
    }

    @Override
    public String toString() {
        return "Laaner{" +
                "lNr=" + lNr +
                ", fnavn='" + fnavn + '\'' +
                ", enavn='" + enavn + '\'' +
                ", laenteBoeger=" + laenteBoeger +
                '}';
    }
}