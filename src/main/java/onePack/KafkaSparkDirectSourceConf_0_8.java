package onePack;

import com.google.common.collect.ImmutableMap;
import kafka.serializer.Decoder;

public interface KafkaSparkDirectSourceConf_0_8 extends KafkaSparkDirectSourceConfiguration {

	KafkaSparkStreamingConfVersion KAFKA_SPARK_VERSION = KafkaSparkStreamingConfVersion.V_0_8;

	// 0.8 version client doesn't seem to provide these static value
	String CONSUMER_CONFIG_ZK_CONNECT = "zookeeper.connect";

	String CONSUMER_CONFIG_GROUP_ID = "group.id";

	String CONSUMER_CONFIG_AUTO_COMMIT_ENABLE = "auto.commit.enable";

	String CONSUMER_CONFIG_AUTO_OFFSET_RESET = "auto.offset.reset";

	String CONSUMER_CONFIG_CLIENT_ID = "client.id";

	String getZookeeperConnectString();

	Class<? extends Decoder<?>> getKeyDecoder();

	Class<? extends Decoder<?>> getValueDecoder();

	Class<?> getKeyClass();

	Class<?> getValueClass();

	// TODO: topic partition assignment

	@Override
	default boolean hasInvalidParameter() { //TODO: implement

		boolean result = true;

		if (getAutoOffsetResetConf().kafkaSparkStreamingConfVersion
				!= KafkaSparkDirectSourceConf_0_8.KAFKA_SPARK_VERSION) {

			printErrorMessage("TODO..");
			result = true;
		}

		return result;
	}

	default ImmutableMap<String, Object> getSourceKafkaParam() throws WrongParameterSettingException {

		//TODO: implement

		if (hasInvalidParameter()) throw new WrongParameterSettingException("TODO.....");

		return ImmutableMap.<String, Object>builder()
				.put(CONSUMER_CONFIG_ZK_CONNECT, getZookeeperConnectString())
				.put(CONSUMER_CONFIG_GROUP_ID, getGroupId())
				.put(CONSUMER_CONFIG_AUTO_COMMIT_ENABLE, false)
				.put(CONSUMER_CONFIG_AUTO_OFFSET_RESET, getAutoOffsetResetConf().value)
				.put(CONSUMER_CONFIG_CLIENT_ID, getClientId())
				.build();
	}
}
