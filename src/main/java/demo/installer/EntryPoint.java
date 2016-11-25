package demo.installer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.net.URL;

/**
 * Created by ubu on 25.11.16.
 */
@SpringBootApplication
public class EntryPoint   extends Application  {

    private ConfigurableApplicationContext context;
    private static String[] savedArgs;
    private static final String rootNodePath = "basepanelview.fxml";


    @Override
    public void init() throws Exception {
        context = SpringApplication.run(getClass(), savedArgs);
        context.getAutowireCapableBeanFactory().autowireBean(this);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        context.close();
    }

    @Override
    public void start(Stage stage) throws Exception {
        System.setProperty("glass.accessible.force", "false");
        Resource res = new ClassPathResource(rootNodePath);
        stage.setTitle("demo app");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(res.getURL());
        loader.load();
        Scene scene = new Scene(loader.getRoot(), 600, 400);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.centerOnScreen();
        stage.show();

    }

    public static void main(String[] args) {
        java.awt.Toolkit.getDefaultToolkit();
        savedArgs = args;
        launch(EntryPoint.class, args);
    }
}
