package javaposse.jobdsl.dsl;

/**
 * Interface to manage jobs, which the DSL needs to do.
 *
 * @author jryan
 * @author aharmel-law
 */
public interface JobManagement {
    /**
     * Gets (loads) the job configuration for the Jenkins job with the specified name.  If no name is supplied, an empty
     * configuration is returned.
     * @param jobName the name of the job to look up
     * @return the job configuration as XML
     * @throws JobConfigurationNotFoundException
     */
    String getConfig(String jobName) throws JobConfigurationNotFoundException;

    /**
     * Creates or updates the job config for the named Jenkins job with the config provided.
     * @param jobName the name of the new / updated job
     * @param config the new / updated job config
     * @throws JobNameNotProvidedException if the jobName is null or blank
     * @throws JobConfigurationMissingException if the config xml is null or blank
     */
    boolean createOrUpdateConfig(String jobName, String config) throws JobNameNotProvidedException, JobConfigurationMissingException;

    /**
     * Stream to write to, for stdout.
     * @return PrintWriter
     */
    PrintStream getOutputStream();

}
