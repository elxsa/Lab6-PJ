package ProgramEvidenta;
import java.time.LocalDate;
import java.lang.String;
import java.time.format.DateTimeFormatter;

public class Angajat {
    private String nume;
    private String post;
    private LocalDate dataAngajarii;
    private float salariu;

    public Angajat() {}

    public Angajat(String nume, String post, LocalDate dataAngajarii, float salariu) {
        this.nume = nume;
        this.post = post;
        this.dataAngajarii = dataAngajarii;
        this.salariu = salariu;
    }

    // Getters and setters
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public LocalDate getDataAngajarii() {
        return dataAngajarii;
    }

    public void setDataAngajarii(LocalDate dataAngajarii) {
        this.dataAngajarii = dataAngajarii;
    }

    public float getSalariu() {
        return salariu;
    }

    public void setSalariu(float salariu) {
        this.salariu = salariu;
    }

    @Override
    public String toString() {
        return "Angajat{" +
                "nume='" + nume + '\'' +
                ", post='" + post + '\'' +
                ", dataAngajarii=" + dataAngajarii.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) +
                ", salariu=" + salariu +
                '}';
    }
}
