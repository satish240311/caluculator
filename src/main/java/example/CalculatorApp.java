package example;

import io.swagger.jaxrs.config.BeanConfig;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class CalculatorApp extends ResourceConfig {

    public CalculatorApp() {

        packages("example.resources", "io.swagger.jaxrs.listing");

        registerClasses(MultiPartFeature.class);

        // Swagger config
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/api");
        beanConfig.setResourcePackage("example.resources");
        beanConfig.setScan(true);
    }
}
