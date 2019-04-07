package de.javahippie.playground.configapi.config;

import java.util.Objects;

public class ConfigurationStyles {

    public ConfigurationStyles(String injected, String injectedProvider, String lookup) {
        this.injected = injected;
        this.injectedProvider = injectedProvider;
        this.lookup = lookup;
    }

    private String injected;

    private String injectedProvider;

    private String lookup;

    public String getInjected() {
        return injected;
    }

    public String getInjectedProvider() {
        return injectedProvider;
    }

    public String getLookup() {
        return lookup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConfigurationStyles that = (ConfigurationStyles) o;

        if (!Objects.equals(injected, that.injected)) return false;
        if (!Objects.equals(injectedProvider, that.injectedProvider)) return false;
        return Objects.equals(lookup, that.lookup);

    }

    @Override
    public int hashCode() {
        int result = injected != null ? injected.hashCode() : 0;
        result = 31 * result + (injectedProvider != null ? injectedProvider.hashCode() : 0);
        result = 31 * result + (lookup != null ? lookup.hashCode() : 0);
        return result;
    }
}
