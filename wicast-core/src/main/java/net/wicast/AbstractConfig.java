
package net.wicast;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;

/**
 * An abstract Configuration class.
 *
 * This class is a thin wrapper around the <code>Properties</code> class, it
 * will load the properties file with the same name as the class from the
 * resources classpath.
 *
 * <code>AppConfig extends AbstractConfig</code>
 *
 * This will load the 'AppConfig.properties' file from the jar.
 * The 'AppConfig.properties' files should be placed in the project folder
 * src/main/resources.
 *
 */
public abstract class AbstractConfig implements ConfigInterface {

    /** provides logging. */
    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
    protected final Properties properties = new Properties();
    protected String propertyFilename;

    /**
     * Instantiates a new abstract configuration.
     */
    public AbstractConfig() {
        super();
        loadPropertyFileFrom(defaultFilename());
    }

    /**
     * Instantiates a new abstract configuration.
     *
     * @param configFilename the Configuration filename
     */
    public AbstractConfig(final String configFilename) {
        propertyFilename = configFilename;
        loadPropertyFileFrom(configFilename);
    }

    /**
     * Default filename.
     *
     * @return the string
     */
    protected String defaultFilename() {
        propertyFilename = this.getClass().getSimpleName();
        return propertyFilename;
    }

    /**
     * configuration from XML filename.
     *
     * configuration filename
     *
     * @param configFilename the Configuration filename
     */
    protected void loadPropertyFileFrom(final String configFilename) {
        final InputStream inputStream = inputStream(toPropertyFilename(configFilename));
        if (inputStream != null) {
            loadPropertyFileFrom(inputStream);
        } else {
            log.warn("Using class default values, property file '{}' not found.", configFilename);
        }
    }

    /**
     * Load from property file.
     *
     * resource as stream
     *
     * @param resourceAsStream the resource as stream
     */
    protected void loadPropertyFileFrom(final InputStream resourceAsStream) {
        assertNotNull(resourceAsStream);
        try {
            properties.load(resourceAsStream);
        } catch (final IOException e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }

    /**
     * Input stream.
     *
     * @param resourceName the resource name
     * @return the input stream
     */
    protected InputStream inputStream(final String resourceName) {
        final ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        return classloader.getResourceAsStream(resourceName);
    }

    /**
     * To property filename.
     *
     * @param configFilename the Configuration filename
     * @return the string
     */
    protected String toPropertyFilename(final String configFilename) {
        return String.format("%s.properties", configFilename);
    }

    /*
     * (non-Javadoc)
     * @see framework.config.ConfigInterface#getProperty(java.lang.String)
     */
    @Override
    public String getProperty(final String key) {
        final String property = System.getProperty(key);
        if (property == null) {
            return properties.getProperty(key);
        } else {
            log.warn("Using system property value '{}' for '{}'", property, key);
            return property;
        }
    }

    /*
     * (non-Javadoc)
     * @see framework.config.ConfigInterface#getProperty(java.lang.String,
     * java.lang.String)
     */
    @Override
    public String getProperty(final String key, final String defaultValue) {
        final String property = System.getProperty(key);
        if (property == null) {
            return properties.getProperty(key, defaultValue);
        } else {
            log.warn("Using system property value '{}' for '{}'", property, key);
            return property;
        }
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final String className = this.getClass().getSimpleName();
        return String.format("%s [properties=%s]", className, prettyProperties(properties));
    }

    /**
     * Pretty properties.
     *
     * @param properties the properties
     * @return the string
     */
    protected String prettyProperties(final Properties properties) {
        if (properties == null) {
            return "{null}";
        } else if (properties.isEmpty()) {
            return "{empty}";
        } else {
            return prettyProperties(properties.toString());
        }
    }

    /**
     * Pretty Format the properties.
     *
     * @param properties the properties as String.
     * @return the properties as a formated String.
     */
    protected String prettyProperties(final String properties) {
        return properties
            .replace("[", "[\n\t")
            .replace("{", "{\n\t")
            .replace(", ", "\n\t")
            .replace("}", "\n\t}")
            .replace("]", "\n\t]}");
    }

}
