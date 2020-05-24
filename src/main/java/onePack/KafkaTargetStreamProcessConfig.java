package onePack;

import com.google.common.collect.ImmutableList;

public interface KafkaTargetStreamProcessConfig {
	ImmutableList<KafkaTargetConfiguration> getKafkaTargetConfList();
}
