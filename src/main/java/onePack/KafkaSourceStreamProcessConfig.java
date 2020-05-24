package onePack;

import com.google.common.collect.ImmutableList;

public interface KafkaSourceStreamProcessConfig {
	ImmutableList<? extends KafkaSparkDirectSourceConfiguration> getKafkaSourceConfiguration();
}
