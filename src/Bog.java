public class Bog {
    private int bogId;
    private String titel,forfatter;

    public Bog() {
    }

    public Bog(int bogId, String titel, String forfatter) {
        this.bogId = bogId;
        this.titel = titel;
        this.forfatter = forfatter;
    }

    public int getBogId() {
        return bogId;
    }

    public void setBogId(int bogId) {
        this.bogId = bogId;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getForfatter() {
        return forfatter;
    }

    public void setForfatter(String forfatter) {
        this.forfatter = forfatter;
    }

    @Override
    public String toString() {
        return "Bog{" +
                "bogId=" + bogId +
                ", titel='" + titel + '\'' +
                ", forfatter='" + forfatter + '\'' +
                '}';
    }
}