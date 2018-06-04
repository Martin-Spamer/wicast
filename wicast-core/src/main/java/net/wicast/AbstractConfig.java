
package net.wicast;

import java.io.*;
import java.util.Properties;

import org.slf4j.*;

/**
 * Abstract Configuration Class.
 */
public abstract class AbstractConfig implements ConfigInterface {

	protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
	protected final Properties properties = new Properties();
	protected final String propertyFilename;

	/**
	 * Instantiates a new abstract configuration.
	 */
	public AbstractConfig() {
		this.propertyFilename = this.getClass().getSimpleName();
		loadFromPropertyFile(this.propertyFilename);
	}

	/**
	 * Instantiates a new abstract configuration.
	 *
	 * @param configFilename the Configuration filename
	 */
	AbstractConfig(final String configFilename) {
		this.propertyFilename = configFilename;
		loadFromPropertyFile(configFilename);
	}

	/**
	 * configuration from XML filename.
	 *
	 * configuration filename
	 *
	 * @param configFilename the Configuration filename
	 */
	private void loadFromPropertyFile(final String configFilename) {
		loadFromPropertyFile(inputStream(toPropertyFilename(configFilename)));
	}

	/**
	 * Input stream.
	 *
	 * @param resourceName the resource name
	 * @return the input stream
	 */
	protected InputStream inputStream(final String resourceName) {
		final ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		final InputStream resourceAsStream = classloader.getResourceAsStream(resourceName);
		return resourceAsStream;
	}

	/**
	 * Load from property file.
	 *
	 * resource as stream
	 *
	 * @param resourceAsStream the resource as stream
	 */
	public void loadFromPropertyFile(final InputStream resourceAsStream) {
		if (resourceAsStream != null) {
			try {
				this.properties.load(resourceAsStream);
			} catch (final IOException exception) {
				this.log.error(exception.toString());
			}
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see framework.config.ConfigInterface#getProperty(java.lang.String)
	 */
	@Override
	public String getProperty(final String key) {
		String property = System.getProperty(key);
		if (property == null) {
			property = this.properties.getProperty(key);
		}
		return property;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see framework.config.ConfigInterface#getProperty(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public String getProperty(final String key, final String defaultValue) {
		String property = System.getProperty(key);
		if (property == null) {
			property = this.properties.getProperty(key, defaultValue);
		}
		return property;
	}

	/**
	 * To property filename.
	 *
	 *
	 * @param configFilename the Configuration filename
	 * @return the string
	 */
	protected String toPropertyFilename(final String configFilename) {
		return String.format("%s.properties", configFilename);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final String prettyProperties = prettyProperties(this.properties);
		return String.format("properties = %s", prettyProperties);
	}

	/**
	 * Pretty properties.
	 *
	 * @param properties the properties
	 * @return the string
	 */
	private String prettyProperties(final Properties properties) {
		return properties.toString().replace("{", "{\n\t").replace(", ", "\n\t").replace("}", "\n\t}");
	}

}
