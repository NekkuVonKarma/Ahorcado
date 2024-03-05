package es.neesis.ahorcado;

import es.neesis.ahorcado.applications.AhorcadoApp;
import es.neesis.ahorcado.configuration.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationRunner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        AhorcadoApp ahorcadoApp = context.getBean(AhorcadoApp.class);

        ahorcadoApp.run();
    }
}