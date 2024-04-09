package ProgramEvidenta;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;
public class Main {
    private static final ObjectMapper mapper = new ObjectMapper();
    static{
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }
    public static void main(String[] args) throws IOException{
        List<Angajat> angajati = citesteAngajatiDinJSON("src/main/resources/angajati.json");
        afiseazaAngajati(angajati);
        afiseazaAngajatiCuSalariuPeste(angajati,2500);
        afiseazaAngajatiConducereLunaPrecedenta(angajati);
        afiseazaAngajatiFaraConducere(angajati);
        afiseazaSalariiMaiMici(angajati, 3000);
        afiseazaPrimulAngajat(angajati);
        afiseazaStatisticiSalarii(angajati);
        afiseazaMesajIon(angajati);
        afiseazaNumarAngajatiVaraPrecedenta(angajati);
    }
    private static List<Angajat> citesteAngajatiDinJSON(String fileName) throws IOException {
        return mapper.readValue(new File(fileName), new TypeReference<List<Angajat>>() {});
    }
    private static void afiseazaAngajati(List<Angajat> angajati){
        System.out.println("Lista de angajati: ");
        angajati.forEach(System.out::println);
    }
    private static void afiseazaAngajatiCuSalariuPeste(List<Angajat> angajati, float salariuMinim){
        System.out.println("\n Angajati cu salariul peste " + salariuMinim + " RON: ");
        angajati.stream()
                .filter(angajat -> angajat.getSalariu() > salariuMinim)
                .forEach(System.out::println);
    }
    public static void afiseazaAngajatiConducereLunaPrecedenta(List<Angajat> angajati){
        int anCurent = LocalDate.now().getYear();
        int anulTrecut = anCurent - 1;
        List<Angajat> angajatiConducereLunaPrecedenta = angajati.stream()
                .filter(angajat -> angajat.getDataAngajarii().getMonthValue() == 4 && (angajat.getPost().toLowerCase().contains("sef") || angajat.getPost().toLowerCase().contains("director")))
                .collect(Collectors.toList());
        System.out.println("\nAngajati cu functie de conducere in luna aprilie, anul trecut: ");
        angajatiConducereLunaPrecedenta.forEach(System.out::println);
    }
    private static void afiseazaAngajatiFaraConducere(List<Angajat> angajati){
        System.out.println("\nAngajatii fara functie de conducere, in ordine descrescatoare a salariilor: ");
        angajati.stream()
                .filter(angajat -> !angajat.getPost().toLowerCase().contains("director") && !angajat.getPost().toLowerCase().contains("sef"))
                .sorted((a1, a2) -> Float.compare(a2.getSalariu(), a1.getSalariu()))
                .forEach(System.out::println);
    }
    private static void afiseazaNumeAngajatiCuMajuscule(List<Angajat> angajati){
        System.out.println("\nNumele angajatilor cu majuscule: ");
        angajati.stream()
                .map(angajat -> angajat.getNume().toUpperCase())
                .forEach(System.out::println);
    }
    private static void afiseazaSalariiMaiMici(List <Angajat> angajati, float salariuMaxim){
        System.out.println("\nSalarii mai mici de " + salariuMaxim + " RON:");
        angajati.stream()
                .map(Angajat::getSalariu)
                .filter(salariu -> salariu < salariuMaxim)
                .forEach(System.out::println);
    }
    private static void afiseazaPrimulAngajat(List<Angajat> angajati){
        System.out.println("\nDatele primului angajat al firmei: ");
        angajati.stream()
                .min((a1, a2) -> a1.getDataAngajarii().compareTo(a2.getDataAngajarii()))
                .ifPresentOrElse(System.out::println, () -> System.out.println("NU exista angajati!"));
    }
    private static void afiseazaStatisticiSalarii(List<Angajat> angajati){
        DoubleSummaryStatistics stats = angajati.stream()
                .collect(Collectors.summarizingDouble(Angajat::getSalariu));
        System.out.println("Statistici despre salarii: ");
        System.out.println("Salariul mediu: " + stats.getAverage());
        System.out.println("Salariul minim: " + stats.getMin());
        System.out.println("Salariul maxim: " + stats.getMax());
        System.out.println("Suma salariilor: " + stats.getSum());
        System.out.println("Nr. total de angajati: " + stats.getCount());
    }
    private static void afiseazaMesajIon(List<Angajat> angajati){
        Optional<Angajat> angajatIon = angajati.stream()
                .filter(angajat -> angajat.getNume().equalsIgnoreCase("Ion"))
                .findAny();

        angajatIon.ifPresentOrElse(
                angajat -> System.out.println("Firma are cel puțin un Ion angajat."),
                () -> System.out.println("Firma nu are niciun Ion angajat.")
        );
    }
    private static void afiseazaNumarAngajatiVaraPrecedenta(List<Angajat> angajati){
        int anCurent = LocalDate.now().getYear();
        int anulTrecut= anCurent - 1;
        long nrAngajatiVaraPrecedenta = angajati.stream()
                .filter(angajat -> angajat.getDataAngajarii().getYear() == anulTrecut && (angajat.getDataAngajarii().getMonthValue() >= 6 && angajat.getDataAngajarii().getMonthValue() <=8))
                .count();
        System.out.println("\nNr. de angajati care s-au angajat vara precedenta: " + nrAngajatiVaraPrecedenta);
    }
}
