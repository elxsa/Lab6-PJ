 RO: Programare Java - laborator 6, cerință de rezolvat: 



Să se realizeze un program de evidentă a angajaților unei firme. Se va crea un proiect Maven, care va conţine clasa Angajat cu următoarele variabile membre:  "numele" (String), "postul" (String), "data_angajarii" (LocalDate), "salariul" (float). 

Clasa va avea constructor cu parametri, constructor fără parametri, gettere şi settere pentru accesul variabilelor membre şi va redefini metoda toString din clasa Object astfel încât să returneze un String cu valorile variabilelor membre separate prin virgule.

În directorul src/main/recouces se va crea fişierul angajati.json în care se vor introduce datele a minim 5 angajaţi. Programul va utiliza API-ul jackson-databind pentru a prelua datele din fişierul angajati.json într-o colecţie de tip List.

Funcțiile de citire şi de scriere din JSON trebuie completate cu codul de înregistrare a modulului JavaTimeModule:

- ObjectMapper mapper=new ObjectMapper();

- mapper.registerModule(new JavaTimeModule()); 

Funcţia de scriere în JSON va scrie obiectele de tip LocalDate sub forma unui vector [an,luna,zi]. Scrierea obiectului de tip LocalDate sub forma unui sir de caractere poate fi asigurată prin completarea funcției de scriere cu următoarea instrucţiune:

- mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

Cerințele de mai jos vor fi implementate utilizând facilitățile lui Java 8 (stream-uri, expresii lambda, interfețe funcționale, referințe la metode, clasa Optional, etc) şi inferența tipului pentru variabilele locale, facilitate introdusă în Java 10. Programul va implementa următoarele cerințe:  
 

- afișarea listei de angajați folosind referințe la metode;

- afișarea angajaților care au salariul peste 2500 RON. Rezolvarea va utiliza stream-uri. Interfața funcțională Predicate, care este parametrul metodei de filtrare va fi implementată printr-o expresie Lambda;

- crearea unei liste cu angajații din luna aprilie, a anului trecut, care au funcție de conducere (postul conține unul din cuvintele sef sau director), pentru crearea unei liste dintr-un stream se va utiliza operația terminală collect (Collectors.toList()), se vor utiliza stream-uri şi expresii lambda, iar noua listă va fi apoi afișată, anul curent se va citi din sistem;

- afișarea angajaților care nu au funcție de conducere (postul lor nu conține cuvintele director sau șef), în ordine descrescătoare a salariilor, folosind stream-uri şi expresii Lambda;

- extragerea din lista de angajați a unei liste de String-uri care conține numele angajaților scrise cu majuscule, eezolvarea va utiliza stream-uri, metoda map() şi operația terminală collect(), lista de String-uri va fi afișată;

- afișarea salariilor mai mici de 3000 de RON (doar salariile, fără alte informații) folosind stream-uri, expresii lambda, referințe la metode şi metoda map();

- afișarea datelor primului angajat al firmei, se va determina minimul din stream furnizând comparatorul adecvat printr-o expresie Lambda: dacă containerul Optional returnat de funcția min() conține o valoare, atunci se va afișa acea valoare, altfel se va afișa un mesaj corespunzător;

- afișarea de statistici referitoare la salariul angajaților, se va afișa salariul mediu, salariul minim şi salariul maxim, rezolvarea va utiliza stream-uri şi operația terminală collect(Collectors. summarizingDouble());

- afișarea unor mesaje care indică dacă printre angajați există cel puțin un “Ion”, se vor afișa mesaje precum: „Firma are cel puțin un Ion angajat”, „Firma nu are nici un Ion angajat”, în funcție de situație, iar rezolvarea va utiliza stream-uri şi metoda findAny() care va returna un container Optional care poate să conțină un element sau nu, metoda ifPresentOeElse din clasa Optional se va utiliza pentru afișarea mesajelor corespunzătoare;

- afișarea numărului de persoane care s-au angajat în vara anului precedent, se va utiliza metoda count() din interfaţa Stream.
  Here's the English translation of your request:

EN: Java Programming - Lab 6, task to be solved:

Create a program to track the employees of a company. Create a Maven project, which will contain the Employee class with the following member variables: "name" (String), "position" (String), "date_of_hiring" (LocalDate), and "salary" (float).

The class will have a parameterized constructor, a no-argument constructor, getters and setters for accessing the member variables, and will override the toString method from the Object class to return a String with the member variable values separated by commas.

In the src/main/resources directory, create the file angajati.json in which data for at least 5 employees will be entered. The program will use the jackson-databind API to fetch the data from the angajati.json file into a List collection.

The JSON read and write functions must be completed with the code to register the JavaTimeModule:

- ObjectMapper mapper = new ObjectMapper();
mapper.registerModule(new JavaTimeModule());

The JSON write function will write LocalDate objects in the form of an array [year, month, day]. Writing the LocalDate object as a string can be ensured by completing the write function with the following instruction:

- mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

The following requirements will be implemented using Java 8 features (streams, lambda expressions, functional interfaces, method references, the Optional class, etc.) and type inference for local variables introduced in Java 10. The program will implement the following requirements:

- Display the list of employees using method references;
  
- Display employees who have a salary over 2500 RON. The solution will use streams. The functional interface Predicate, which is the parameter of the filtering method, will be implemented through a Lambda expression;
  
- Create a list of employees from April of last year who hold managerial positions (the position contains one of the words "chief" or "director"), for creating a list from a stream the terminal operation collect(Collectors.toList()) will be used, using streams and lambda expressions, and the new list will then be displayed, the current year will be read from the system;
  
- Display employees who do not hold managerial positions (their position does not contain the words "director" or "chief"), in descending order of salaries, using streams and Lambda expressions;
  
- Extract from the list of employees a list of Strings containing the names of the employees written in uppercase, the solution will use streams, the map() method and the terminal operation collect(), the list of Strings will be displayed;
  
- Display salaries less than 3000 RON (only the salaries, without other information) using streams, lambda expressions, method references, and the map() method;
  
- Display the data of the first employee of the company, the minimum will be determined from the stream providing the appropriate comparator through a Lambda expression: if the Optional container returned by the min() function contains a value, then that value will be displayed, otherwise an appropriate message will be displayed;
  
- Display statistics relating to the employees' salaries, the average salary, minimum salary, and maximum salary will be displayed, the solution will use streams and the terminal operation collect(Collectors.summarizingDouble());
  
- Display messages indicating whether among the employees there is at least one "Ion", messages such as: "The company employs at least one Ion", "The company does not employ any Ion", depending on the situation, and the solution will use streams and the findAny() method which will return an Optional container that may contain an element or not, the ifPresentOrElse method from the Optional class will be used for displaying appropriate messages;
  
- Display the number of people who were hired in the summer of the previous year, using the count() method from the Stream interface.
