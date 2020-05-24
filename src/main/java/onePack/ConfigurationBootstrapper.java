package onePack;

/**
 * Bootstrap interface for a process.
 * load configuration from command arguments and possibly from environment variable
 *
 * @param <ProcessConfig> extends BaseProcessConfig
 */
public interface ConfigurationBootstrapper<ProcessConfig extends BaseProcessConfig> {

	ProcessConfig loadProcessConfiguration(String[] args) throws Exception;

	void cmdArgumentChecker(String[] args) throws IllegalArgumentException;

	void printArgumentGuide();

	default ProcessConfig getProcessConfiguration(String[] args) throws Exception { // TODO: last check

		try {
			this.cmdArgumentChecker(args);
		} catch (IllegalArgumentException e) {
			this.printArgumentGuide();
			throw e;
		}

		return this.loadProcessConfiguration(args);
	}
}