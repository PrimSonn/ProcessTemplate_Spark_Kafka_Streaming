package onePack;

import java.util.Optional;
import java.util.stream.Stream;


public class SimpleManagerConfigBootstrapper implements ConfigurationBootstrapper<ManagerConfiguration> {

	private static final String ARGUMENT_QUERY_MSG = "\nthis is stub. no arguments will be actually used here.";

	@Override
	public ManagerConfiguration loadProcessConfiguration(String[] args) throws Exception { //TODO: implement





		return null;
	}

	@Override
	public void cmdArgumentChecker(String[] args) throws IllegalArgumentException {

		System.out.println(SimpleManagerConfigBootstrapper.ARGUMENT_QUERY_MSG + "\n\tprovided arguments:");

		final String[] emptyStringArr = {};

		Stream.of(Optional.ofNullable(args).orElse(emptyStringArr))
				.map(s -> "\targs: " + s)
				.forEach(System.out::println);
	}

	@Override
	public void printArgumentGuide() {
		System.out.println(SimpleManagerConfigBootstrapper.ARGUMENT_QUERY_MSG);
	}
}
