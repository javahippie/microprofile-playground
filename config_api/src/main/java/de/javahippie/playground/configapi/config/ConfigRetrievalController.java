package de.javahippie.playground.configapi.config;

import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/config")
@RequestScoped
public class ConfigRetrievalController {

    private final static String CONFIG_PROPERTY = "config.value";
    private final static String DEFAULT_VALUE = "<unknown>";

    @Inject
    @ConfigProperty(name = CONFIG_PROPERTY, defaultValue = DEFAULT_VALUE)
    private String injectedValue;

    @Inject
    @ConfigProperty(name = CONFIG_PROPERTY, defaultValue = DEFAULT_VALUE)
    private Provider<String> injectedProvider;

    @GET
    @Path("/")
    public Response getInjectedConfigValue() {
        String injectValue = injectedValue;
        String providerValue = injectedProvider.get();
        String lookupValue = ConfigProvider.getConfig().getOptionalValue(CONFIG_PROPERTY, String.class).orElse(DEFAULT_VALUE);

        ConfigurationStyles result = new ConfigurationStyles(injectValue, providerValue, lookupValue);

        return Response.ok(result).build();
    }

}
