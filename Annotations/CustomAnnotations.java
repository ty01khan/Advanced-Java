package Practice;

import java.lang.annotation.*;
import java.lang.reflect.Method;

/**
 * Marker Annotations : Annotation having no variable inside it
 * Single Value Annotation : Annotation having one variable inside it
 * Multi Value Annotation : Annotation having multiple variables inside it
 */

@Inherited
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface Vaccinated{}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface ProgrammingLanguage {
    String name() default "Java";
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface SmartPhone {
    String os() default "Android";
    int version() default 1;
}

@Vaccinated
class CheckVaccinationStatus {
    public void canTravel() {
        System.out.printf("You can Travel..%n%n");
    }

    public void getMeTicket() throws NoSuchMethodException, SecurityException {
        Class cls = this.getClass();
        Method mt = cls.getMethod("canTravel");
        if(mt.isAnnotationPresent(Vaccinated.class)) {
            canTravel();
        }
        else {
            System.out.printf("Ticket cannot be provided to you.. First go and get yourself vaccinated.%n%n");
        }
    }
}

class USEmbassy extends CheckVaccinationStatus {
    @Vaccinated
    public void visaApplication() {
        System.out.println("Visa Granted..");
    }

    public void getMeVisa() throws NoSuchMethodException, SecurityException {
        Class cls = this.getClass();
        Method mtd = cls.getMethod("visaApplication");
        if(mtd.isAnnotationPresent(Vaccinated.class)) {
            visaApplication();
        }
        else {
            System.out.println("Visa cannot be provided to you unless you are fully vaccinated.");
        }
    }
}

@ProgrammingLanguage(name = "C++")
class CPQuestion {
    String difficulty;
    int marks;
    int time;

    public CPQuestion(String difficulty, int marks, int time) {
        this.difficulty = difficulty;
        this.marks = marks;
        this.time = time;
    }
}

@SmartPhone(os = "Android", version = 6)
class NokiaASeries {
    String model;
    int size;

    public NokiaASeries(String model, int size) {
        this.model = model;
        this.size = size;
    }
}

public class CustomAnnotations {
    public static void main(String[] args) throws SecurityException, NoSuchMethodException {
        USEmbassy usObj = new USEmbassy();
        usObj.getMeVisa();

        CheckVaccinationStatus obj = new CheckVaccinationStatus();
        obj.getMeTicket();

        CPQuestion cpObj = new CPQuestion("hard", 100, 2);
        Class c1 = cpObj.getClass();
        Annotation cpAn = c1.getAnnotation(ProgrammingLanguage.class);
        ProgrammingLanguage lang = (ProgrammingLanguage) cpAn;
        System.out.printf("Language chosen: %s%nDifficulty: %s%nMarks: %d%nTime given: %d hr%n%n", lang.name(), cpObj.difficulty, cpObj.marks, cpObj.time);
        NokiaASeries phoneObj = new NokiaASeries("Fire", 5);
        Class c = phoneObj.getClass();
        Annotation an = c.getAnnotation(SmartPhone.class);
        SmartPhone sp = (SmartPhone) an;
        System.out.println("OS for Smart Phones: " + sp.os());
    }
}

