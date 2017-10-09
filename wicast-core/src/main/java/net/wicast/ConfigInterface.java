
package net.wicast;

/**
 * Configuration Interface.
 */
public interface ConfigInterface {

	/**
	 * get configuration value for key.
	 *
	 * @param key as string.
	 * @return the property value.
	 */
	public String getProperty(final String key);

	/**
	 * get configuration value for key, use default if key not found.
	 *
	 * @param key as string.
	 * @param defaultValue the default value
	 * @return the property value.
	 */
	public String getProperty(final String key, final String defaultValue);

}
