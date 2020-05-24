package onePack;

import com.google.common.collect.ImmutableList;

public class SimpleManagerConfig implements ManagerConfiguration {

	@Override
	public String getProcessName() {
		return "simpleManager";
	}

	@Override
	public Notifier getNotifier() {
		return System.out::println;
	}

	@Override
	public ImmutableList<? extends KafkaSparkDirectSourceConfiguration> getKafkaSourceConfiguration() {
		//TODO builder usage here
		return null;
	}

	@Override
	public void IgniteClientProcessMockFunc() {
		//stub
	}

	@Override
	public ImmutableList<KafkaTargetConfiguration> getKafkaTargetConfList() {
		return null;
	}
}
